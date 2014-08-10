package com.github.kindrat.liquidfeedback.api.endpoint;

import com.github.kindrat.liquidfeedback.api.AppContext;
import com.jayway.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;

import static com.jayway.restassured.RestAssured.expect;

public class MemberApiTest extends AbstractApiTest {

    private String apiMemberCriteriaUri;

    @BeforeClass
    @Override
    public void init()
    {
        super.init();
        apiMemberCriteriaUri = apiRootUri + "member";
    }

    @Test
    public void testGetByCriteria() throws Exception {

        Response response = expect()
                .statusCode(HTTP_200_OK)
                .when()
                .given()
                .parameter("ids", Arrays.asList(1, 2, 3))
                .parameter("active", true)
                .parameter("textSearch", "")
                .parameter("useNameOrder", true)
                .parameter("useCreatedOrder", true)
                .get(apiMemberCriteriaUri);
    }

    @Override
    protected AppContext createContext() {
        return new AppContext();
    }
}
