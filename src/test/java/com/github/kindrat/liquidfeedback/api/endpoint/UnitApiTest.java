package com.github.kindrat.liquidfeedback.api.endpoint;

import com.jayway.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;

import static com.jayway.restassured.RestAssured.expect;

public class UnitApiTest extends AbstractApiTest {

    private String unitUrl;

    @BeforeClass
    @Override
    public void init()
    {
        super.init();
        unitUrl = apiRootUri + "unit";
    }

    @Test
    public void testGetUnitsByIds() throws Exception {
        Response response = expect()
                .statusCode(HTTP_200_OK)
                .when()
                .given()
                .parameter("ids", Arrays.asList(1, 2, 3))
                .get(unitUrl);
    }
}
