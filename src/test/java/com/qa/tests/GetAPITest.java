package com.qa.tests;

import com.qa.base.TestBase;
import com.qa.client.RestClient;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetAPITest extends TestBase {
    TestBase testBase;
    String serviceURL;
    String apiURL;
    String url;
    RestClient restClient;

    @BeforeMethod
    public void setUp() {
        testBase = new TestBase();
        serviceURL = prop.getProperty("url");
        apiURL = prop.getProperty("serviceURL");
        url = serviceURL + apiURL;
    }

    @Test
    public void getAPITest() throws IOException {
        restClient = new RestClient();
        restClient.get(url);
    }
}
