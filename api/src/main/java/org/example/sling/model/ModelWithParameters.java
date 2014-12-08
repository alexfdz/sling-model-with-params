package org.example.sling.model;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class)
public class ModelWithParameters {

    private final Resource resource;

    public ModelWithParameters(final Resource resource) {
        this.resource = resource;
    }

    public String getValue() {
        return resource.getPath();
    }
}
