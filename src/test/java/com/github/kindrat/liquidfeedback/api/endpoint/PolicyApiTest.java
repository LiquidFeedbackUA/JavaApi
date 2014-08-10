package com.github.kindrat.liquidfeedback.api.endpoint;

import com.github.kindrat.liquidfeedback.api.AppContext;
import com.jayway.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;

import static com.jayway.restassured.RestAssured.expect;

public class PolicyApiTest extends AbstractApiTest{

    private String policyUri;

    @BeforeClass
    @Override
    public void init()
    {
        super.init();
        policyUri = apiRootUri + "policy";
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

    @Override
    protected AppContext createContext() {
        return new AppContext();
    }
}
