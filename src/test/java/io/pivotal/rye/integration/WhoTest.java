package io.pivotal.rye.integration;

import io.pivotal.rye.RyeApplicationBaseTest;
import io.pivotal.rye.data.Who;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class WhoTest extends RyeApplicationBaseTest {
    @Autowired
    Who w;

    @Test
    public void whoShouldComeFromEnvironmentOrFallBackToAzul() {
        assertThat(w.getStatus(), is(equalTo("AZUL")));
    }
}
