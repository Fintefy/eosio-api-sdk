package one.eosio.api.sdk.util;

import one.eosio.api.sdk.base.constants.EosConstant;
import one.eosio.api.sdk.base.domain.HTTPMethod;
import one.eosio.api.sdk.base.exception.EosException;
import org.apache.http.HttpEntity;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class HttpRequestMessage {

    private static final Logger logger = LoggerFactory.getLogger(HttpRequestMessage.class);

    private String method;
    private String url;
    private String body;

    private int responseStatus;
    private String responseContent;

    public HttpRequestMessage(HTTPMethod method, String url, String body) {
        super();
        this.method = method.getName();
        this.url = url;
        this.body = body;
    }

    public String send() {
        HttpClientBuilder httpClientBuilder = HttpClients.custom();

        try (CloseableHttpClient httpClient = httpClientBuilder.build()) {
            HttpRequestBase http;
            if (HTTPMethod.GET.getName().equalsIgnoreCase(method)) {
                http = new HttpGet(url);
            } else if (HTTPMethod.POST.getName().equalsIgnoreCase(method)) {
                http = new HttpPost(url);
                ((HttpPost) http).setEntity(new StringEntity(body, EosConstant.CHAR_SET));
            } else if (HTTPMethod.PUT.getName().equalsIgnoreCase(method)) {
                http = new HttpPut(url);
                ((HttpPut) http).setEntity(new StringEntity(body, EosConstant.CHAR_SET));
            } else if (HTTPMethod.DELETE.getName().equalsIgnoreCase(method)) {
                http = new HttpDelete(url);
            } else if (HTTPMethod.PATCH.getName().equalsIgnoreCase(method)) {
                http = new HttpPatch(url);
                ((HttpPatch) http).setEntity(new StringEntity(body, EosConstant.CHAR_SET));
            } else {
                logger.error("Fail to send request , Unsupported HTTP method exception : " + method);
                throw new EosException("Unsupported HTTP method exception : " + method);
            }

            // Create a custom response handler
            ResponseHandler<String> responseHandler = response -> {
                responseStatus = response.getStatusLine().getStatusCode();
                HttpEntity entity = response.getEntity();
                return entity != null ? EntityUtils.toString(entity) : null;
            };

            responseContent = httpClient.execute(http, responseHandler);

        } catch (IOException e) {
            logger.error("Fail to send request", e);
            throw new EosException(e);
        }
        return responseContent;
    }
}
