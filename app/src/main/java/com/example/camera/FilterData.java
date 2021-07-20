package com.example.camera;

import java.io.Serializable;

/**
 * Created by Computer on 2/8/2018.
 */

public class FilterData implements Serializable {

    String name;
    String rule;

    public FilterData(String name, String rule) {
        this.name = name;
        this.rule = rule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

}
