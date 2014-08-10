package com.github.kindrat.liquidfeedback.api.endpoint;

import com.github.kindrat.liquidfeedback.api.AppContext;
import com.github.kindrat.liquidfeedback.api.util.JacksonUtils;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.mockito.MockitoAnnotations.initMocks;

public abstract class AbstractApiTest<A extends AppContext> {
    public static final int HTTP_200_OK = 200;
    public static final int HTTP_201_CREATED = 201;
    public static final int HTTP_400_BAD_REQUEST = 400;
    public static final int HTTP_404_NOT_FOUND = 404;
    public static final int HTTP_405_NOT_ALLOWED = 405;

    public String apiRootUri;


    private HttpServer server;
    protected A context;

    @BeforeClass
    public void init() {
        initMocks(this);

        context = createContext();
        server = GrizzlyHttpServerFactory.createHttpServer(context.serverUri, context.resourceConfig);
        apiRootUri = context.serverUri.toString();
    }

    @AfterClass
    public void cleanUp() {
        server.shutdownNow();
    }

    protected abstract A createContext();

    protected HttpServer getServer() {
        return server;
    }

    protected String getServerUri() {
        return context.serverUri.toString();
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
