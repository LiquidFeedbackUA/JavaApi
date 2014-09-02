package com.github.kindrat.liquidfeedback.api.endpoint;

import com.github.kindrat.liquidfeedback.api.context.ServerWrapper;
import com.github.kindrat.liquidfeedback.api.util.JacksonUtils;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;
import org.glassfish.grizzly.http.server.HttpServer;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.mockito.MockitoAnnotations.initMocks;

public abstract class AbstractApiTest {
    public static final int HTTP_200_OK = 200;
    public static final int HTTP_201_CREATED = 201;
    public static final int HTTP_400_BAD_REQUEST = 400;
    public static final int HTTP_404_NOT_FOUND = 404;
    public static final int HTTP_405_NOT_ALLOWED = 405;

    private ServerWrapper wrapper;

    @BeforeClass
    public void init() throws IOException {
        initMocks(this);
        wrapper = createServer();
        wrapper.getServer().start();
    }

    @AfterClass
    public void cleanUp() {
        wrapper.getServer().shutdownNow();
    }

    protected ServerWrapper createServer()
    {
        return new ServerWrapper();
    }

    protected HttpServer getServer() {
        return wrapper.getServer();
    }

    protected String getServerUri() {
        return wrapper.getServerUri().toString();
    }

    public <T> T getResponseBodyAsObject(Response response, Class<T> clazz) throws IOException {
        if (response.getStatusCode() < 200 || response.getStatusCode() >= 300) {
            return null;
        }
        ResponseBody responseBody = response.getBody();
        String responseBodyString = responseBody.asString();

        return isBlank(responseBodyString) ? null : JacksonUtils.fromJson(responseBodyString, clazz);
    }


}
