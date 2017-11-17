package io.pivotal.rye.data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Who {
    @Value("${INSTANCE:AZUL}")
    private String status;

    public String getStatus() {
        return status;
    }
}
