package io.pivotal.rye.brewing;

import io.pivotal.rye.RyeApplicationBaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.core.IsEqual.equalTo;

public class BarrelNamesTest extends RyeApplicationBaseTest {

    @Autowired
    BarrelNames bn;

    @Test
    public void barrelNamesAvailable() {
        List<String> names = bn.getNames();
        assertThat(names, contains(
                "Hibiki",
                "Suntory",
                "Statesman"
        ));
    }

    @Test
    public void barrelNameIsRandomlyPopulated() {
        String name = bn.getActiveName();
        assertThat(name, anyOf(
                equalTo("Hibiki"),
                equalTo("Suntory"),
                equalTo("Statesman")
        ));
    }
}
