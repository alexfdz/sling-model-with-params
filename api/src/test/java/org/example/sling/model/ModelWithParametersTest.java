package org.example.sling.model;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.commons.testing.sling.MockResource;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ModelWithParametersTest {

    private Resource resource = new MockResource(null, "/path", null);

    @Test
    public void returnsTheResourcePath() {
        assertThat(new ModelWithParameters(resource).getValue(), is("/path"));
    }
}