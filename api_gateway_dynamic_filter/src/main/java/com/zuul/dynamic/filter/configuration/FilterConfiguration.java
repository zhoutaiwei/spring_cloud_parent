package com.zuul.dynamic.filter.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("zuul.filter")
public class FilterConfiguration {
    private String root;
    private Integer intervl;

    public String getRoot() {
        return root;
    }

    public Integer getIntervl() {
        return intervl;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public void setIntervl(Integer intervl) {
        this.intervl = intervl;
    }
}
