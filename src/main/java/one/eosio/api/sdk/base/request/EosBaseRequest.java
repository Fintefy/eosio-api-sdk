package one.eosio.api.sdk.base.request;

import lombok.Getter;
import one.eosio.api.sdk.base.constants.EosConstant;
import one.eosio.api.sdk.base.domain.HTTPMethod;
import one.eosio.api.sdk.base.exception.EosException;
import one.eosio.api.sdk.base.response.EosBaseResponse;
import one.eosio.api.sdk.util.HttpRequestMessage;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * 基础请求
 *
 * @param <T>
 * @author wangwei
 * @date 2018/01/21
 */
public abstract class EosBaseRequest<T extends EosBaseResponse> {

    /**
     * Http request method
     */
    @Getter
    protected HTTPMethod method = HTTPMethod.GET;
    /**
     * 请求路劲
     */
    protected String path;
    /**
     * url parameters
     */
    @Getter
    protected Map<String, String> parameters;
    /**
     * request body
     */
    @Getter
    protected String body;

    /**
     * Get Request Url
     *
     * @return
     */
    public String getRequestUrl() {
        return EosConstant.BASE_URL + this.path;
    }

    /**
     * 执行 request 请求
     *
     * @return
     */
    public String executeRequest() {
        String url = String.format(EosConstant.URL_FORMAT, this.getRequestUrl(), constructQuery(this.getParameters()));
        HttpRequestMessage httpRequestMessage = new HttpRequestMessage(this.getMethod(), url, this.getBody());
        return httpRequestMessage.send();
    }

    private static String constructQuery(Map<String, String> parameters) {
        if (parameters == null || parameters.isEmpty()) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : parameters.entrySet()) {
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(URLEncoder.encode(entry.getValue(), EosConstant.CHAR_SET));
                sb.append("&");
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * convert response json to Bean
     *
     * @return
     * @throws EosException
     */
    public abstract T createResponse() throws EosException;


}
