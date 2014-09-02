package com.github.kindrat.liquidfeedback.api.endpoint;

import com.jayway.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;

import static com.jayway.restassured.RestAssured.expect;

public class PolicyApiTest extends AbstractApiTest{

    private String policyUri;

    @BeforeClass
    @Override
    public void init() throws IOException {
        super.init();
        policyUri = getServerUri() + "policy";
    }

    @Test
    public void testGetPoliciesByIds() throws Exception {
        Response response = expect()
                .statusCode(HTTP_200_OK)
                .when()
                .given()
                .parameter("ids", Arrays.asList(1, 2, 3))
                .get(policyUri);
    }
}
