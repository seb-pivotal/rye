package io.pivotal.rye.brewing;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Barrel {

    private String inscription;

    public Barrel(@Value("${barrel.inscription}") String inscription) {
        this.inscription = inscription;
    }

    public String getInscription() {
        return inscription;
    }
}
