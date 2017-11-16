package io.pivotal.rye.brewing;

import org.springframework.stereotype.Component;

@Component
public class Barrel {
    private String inscription;

    public Barrel() {
        this("The Default");
    }

    public Barrel(String inscription) {
        this.inscription = inscription;
    }

    public String getInscription() {
        return inscription;
    }
}
