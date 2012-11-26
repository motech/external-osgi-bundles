package org.motechproject.org.codehaus.jackson;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(include = JsonTypeInfo.As.PROPERTY, use = JsonTypeInfo.Id.CLASS, property = "@type")
public abstract class AbstractEntity {

    @JsonProperty
    private String name;

    protected AbstractEntity() {
    }

    public AbstractEntity(String name) {
        this.name = name;
    }

    @JsonIgnore
    public String getName() {
        return name;
    }
}
