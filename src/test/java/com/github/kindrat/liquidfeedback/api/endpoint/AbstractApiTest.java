package com.github.kindrat.liquidfeedback.api.endpoint;

import com.github.kindrat.liquidfeedback.api.context.AppContext;
import com.github.kindrat.liquidfeedback.api.util.JacksonUtils;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;
import com.sun.jersey.spi.spring.container.servlet.SpringServlet;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.NetworkListener;
import org.glassfish.grizzly.servlet.ServletRegistration;
import org.glassfish.grizzly.servlet.WebappContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.net.URI;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.mockito.MockitoAnnotations.initMocks;

public abstract class AbstractApiTest {
    public static final int HTTP_200_OK = 200;
    public static final int HTTP_201_CREATED = 201;
    public static final int HTTP_400_BAD_REQUEST = 400;
    public static final int HTTP_404_NOT_FOUND = 404;
    public static final int HTTP_405_NOT_ALLOWED = 405;

    public String apiRootUri;
    private HttpServer server;
    protected AnnotationConfigApplicationContext context;
    protected URI serverUri;

    @BeforeClass
    public void init() {
        initMocks(this);
        context = new AnnotationConfigApplicationContext();
        context.register(AppContext.class);
        context.refresh();

        // Initialize Grizzly HttpServer
        server = new HttpServer();
        NetworkListener listener = new NetworkListener("grizzly2", "localhost", 3388);
        server.addListener(listener);

        // Initialize and add Spring-aware Jersey resource
        WebappContext ctx = new WebappContext("ctx", "");
        final ServletRegistration reg = ctx.addServlet("spring", new SpringServlet());
        reg.addMapping("/*");
        ctx.addContextInitParameter("contextClass", "com.github.kindrat.liquidfeedback.api.context.AnnotationBasedContext");
        ctx.addListener("org.springframework.web.context.ContextLoaderListener");
        ctx.addListener("org.springframework.web.context.request.RequestContextListener");
        ctx.deploy(server);

        apiRootUri = serverUri.toString();
    }

    @AfterClass
    public void cleanUp() {
        server.shutdownNow();
    }

    protected ApplicationContext createContext()
    {
        return new AnnotationConfigApplicationContext(AppContext.class);
    }

    protected HttpServer getServer() {
        return server;
    }

    protected String getServerUri() {
        return serverUri.toString();
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
