#!/bin/bash

test_requests() {
    echo "Sending test requests to $1."
    for i in $(seq 1 3600)
    do
        curl -s "https://$1.cfapps.io/who"
        echo
        sleep 0.25
    done
}

echo "Starting monitor."
sleep 1

test_requests rye

echo "Monitor stopped."