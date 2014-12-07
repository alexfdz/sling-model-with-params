package org.example.sling.model;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;

public class ModelTest extends ModelTestBase {
    @Test
    public void testSomeConsolePaths() throws Exception {
        getRequestExecutor().execute(
                getRequestBuilder().buildGetRequest("/asdf")
                        .withCredentials(getServerUsername(), getServerPassword())
        ).assertStatus(200);
    }

    @Override
    protected List<String> resources() {
        return asList(
                "/apps/model/modelWithParameters/modelWithParameters.html",
                "/content/model/modelWithParameters/.content.xml");
    }
}
