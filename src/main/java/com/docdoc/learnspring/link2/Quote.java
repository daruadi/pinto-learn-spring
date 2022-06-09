package com.docdoc.learnspring.link2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {
    private String id;
    private String value;

    public String getId(){
        return id;
    }

    public String getValue(){
        return value;
    }

    public void setValue(String value){
        this.value = value;
    }

    @Override
    public String toString(){
        return String.format("Quote{id='%s', value='%s'}", id, value);
    }
}
