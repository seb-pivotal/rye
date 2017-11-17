#!/bin/bash

# Normally you wouldn't do the set-env and restage steps, but it makes for a better demo.

echo "Ensure we are in a clean state."
cf delete -f rye > /dev/null
cf delete -f rye-green > /dev/null

echo "Building app."
./gradlew clean build > /dev/null

echo "Pushing Blue."
cf push rye -f manifest.yml > /dev/null

echo "Restaging Blue."
cf set-env rye INSTANCE BLUE  > /dev/null
cf restage rye  > /dev/null

echo "First portion of Blue-Green deploy finished."
echo "If you like, you can run the blue_green_monitor.sh script to see things changing."
sleep 5

echo "Pushing Green."
cf push rye-green -f manifest.yml > /dev/null

echo "Restaging Green."
cf set-env rye-green INSTANCE GREEN > /dev/null
cf restage rye-green > /dev/null

echo "Now watch the monitor..."
sleep 1

echo "Set up load balancing."
cf map-route rye-green cfapps.io --hostname rye > /dev/null
sleep 15

echo "Sending all traffic to green."
cf unmap-route rye cfapps.io --hostname rye > /dev/null
sleep 15

echo "Cleaning up."
cf delete -f rye > /dev/null
cf rename rye-green rye  > /dev/null

echo "All done."