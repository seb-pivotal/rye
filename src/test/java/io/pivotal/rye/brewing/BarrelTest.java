package io.pivotal.rye.brewing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BarrelTest {

    @Autowired
    Barrel b;

    @Test
    public void valuePropagation() {
        assertThat(b.getInscription(), is(equalTo("blammo")));
    }


}