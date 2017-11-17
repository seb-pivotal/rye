package io.pivotal.rye.integration;

import io.pivotal.rye.RyeApplicationBaseTest;
import io.pivotal.rye.brewing.BarrelNames;
import io.pivotal.rye.data.RedisStore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class RedisBarrelTest extends RyeApplicationBaseTest {

    @Autowired
    BarrelNames barrelNames;

    @Autowired
    RedisStore store;

    @Test
    public void barrelActiveNameShouldComeFromRedis() {
        String nameFromBarrelNames = barrelNames.getActiveName();
        String nameFromRedis = store.get(BarrelNames.KEY);
        assertThat(nameFromRedis, is(equalTo(nameFromBarrelNames)));
    }
}
