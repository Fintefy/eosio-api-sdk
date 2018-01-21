package one.eosio.api.sdk.util;

import one.eosio.api.sdk.base.domain.HTTPMethod;
import one.eosio.api.sdk.base.exception.EosException;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;

/**
 * <p> EOS HTTP 工具类  </p>
 *
 * @author wangwei
 * @date 2018/01/21
 */
public class EOSHttpUtil {

    private final static String DEFAULT_CHARACTER_SET = "UTF-8";

    /**
     * get 请求
     *
     * @param url
     * @return
     * @throws EosException
     */
    public static String doGet(String url) throws EosException {
        HttpRequestMessage httpRequestMessage = new HttpRequestMessage(HTTPMethod.GET, url, "");
         httpRequestMessage.send();

        CloseableHttpClient client = null;
        CloseableHttpResponse response = null;
        try {
            client = HttpClients.createDefault();
            HttpGet req = new HttpGet(url);
            response = client.execute(req);
            HttpEntity resEntity = response.getEntity();
            return EntityUtils.toString(resEntity, DEFAULT_CHARACTER_SET);
        } catch (IOException e) {
            throw new EosException(e.getMessage());
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (client != null) {
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * POST 请求
     *
     * @param url  请求地址
     * @param body 请求参数
     * @return
     * @throws EosException
     */
    public static String doDelete(String url, String body) throws EosException {

        return "";
    }


    /**
     * POST 请求
     *
     * @param URL  请求地址
     * @param body 请求参数
     * @return
     * @throws EosException
     */
    public static String doPost(String URL, String body) throws EosException {
        CloseableHttpClient client = null;
        CloseableHttpResponse response = null;
        try {
            client = HttpClients.createDefault();
            HttpPost req = new HttpPost(URL);
            req.setEntity(new StringEntity(body, DEFAULT_CHARACTER_SET));
            response = client.execute(req);
            HttpEntity resEntity = response.getEntity();
            return EntityUtils.toString(resEntity, DEFAULT_CHARACTER_SET);
        } catch (IOException e) {
            throw new EosException(e.getMessage());
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (client != null) {
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static String doUpload(String URL, String file) throws EosException {
        CloseableHttpClient client = null;
        CloseableHttpResponse response = null;
        try {
            client = HttpClients.createDefault();
            HttpPost req = new HttpPost(URL);
            FileBody fileBody = new FileBody(new File(file));
            HttpEntity reqEntity = MultipartEntityBuilder.create()
                    .addPart("media", fileBody)
                    .build();
            req.setEntity(reqEntity);
            response = client.execute(req);
            HttpEntity resEntity = response.getEntity();
            return EntityUtils.toString(resEntity, DEFAULT_CHARACTER_SET);
        } catch (IOException e) {
            throw new EosException(e.getMessage());
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (client != null) {
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
