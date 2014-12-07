package org.example.sling.model;

import org.apache.sling.testing.tools.sling.SlingClient;
import org.apache.sling.testing.tools.sling.SlingTestBase;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public abstract class ModelTestBase extends SlingTestBase {
    private static final String TEST_CONTENT_FOLDER = "/jcr";
    protected SlingClient slingClient;

    @Before
    public void setupContent() throws Exception {
        slingClient = new SlingClient(getServerBaseUrl(), getServerUsername(), getServerPassword());
        cleanupContent();
        uploadContent();
    }

    private void uploadContent() throws IOException {
        for (String resource : resources()) {
            uploadResource(resource);
        }
    }

    private void uploadResource(String resource) throws IOException {
        slingClient.upload(resource, resourceStream(resource), -1, true);
    }

    private InputStream resourceStream(String resource) {
        return getClass().getResourceAsStream(TEST_CONTENT_FOLDER + resource);
    }

    @After
    public void cleanupContent() throws Exception {
        for (String resource : resources()) {
            cleanupContent(resource);
        }
    }

    public void cleanupContent(String resource) throws Exception {
        if (slingClient.exists(resource)) {
            slingClient.delete(resource);
        }
    }

    abstract List<String> resources();

}
