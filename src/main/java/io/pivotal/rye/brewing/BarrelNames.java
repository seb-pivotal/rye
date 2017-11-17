package io.pivotal.rye.brewing;

import io.pivotal.rye.data.RedisStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class BarrelNames {
    public static final String KEY = "name";

    private List<String> names;

    @Autowired
    private RedisStore redisStore;

    public BarrelNames() {
        this.names = new ArrayList<>();
        names.add("Hibiki");
        names.add("Suntory");
        names.add("Statesman");
    }

    public List<String> getNames() {
        return names;
    }

    @PostConstruct
    public void populateNames() {
        Random r = new Random();
        String randomName = names.get(r.nextInt(names.size()));
        redisStore.set(KEY, randomName);
    }

    public String getActiveName() {
        return redisStore.get(KEY);
    }
}
