package io.pivotal.rye.integration;

import io.pivotal.rye.RyeApplicationBaseTest;
import io.pivotal.rye.data.RedisStore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RedisStoreTest extends RyeApplicationBaseTest {

    @Autowired
    private RedisStore store;

    @Test
    public void getShouldRetrieveWhatWasPut() {
        store.set("foo", "42");
        String retrieved = store.get("foo");
        assertThat(retrieved, is(equalTo("42")));
    }
}
