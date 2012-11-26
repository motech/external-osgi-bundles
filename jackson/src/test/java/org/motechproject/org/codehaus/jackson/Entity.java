package org.motechproject.org.codehaus.jackson;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

public class Entity {

    @JsonProperty
    private String name;

    private Entity() {
    }

    public Entity(String name) {
        this.name = name;
    }

    @JsonIgnore
    public String getName() {
        return name;
    }
}
