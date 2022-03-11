package com.unitbv.lifecycle;

import org.springframework.stereotype.Component;

@Component
public class DepBean {
    private String depAttribute;

    public String getDepAttribute() {
        return depAttribute;
    }

    public void setDepAttribute(String depAttribute) {
        this.depAttribute = depAttribute;
    }
}
