package fx.service;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * This class used for build http-request and receiving a http-response
 */
public class HttpBuilder {
    private HttpUriRequest request;
    private String uri;
    /**
     * uri of internet-resource, (for example http://bash.im)
     */
    private String parameters;
    /**
     * parameters of request
     */
    private Map<String, String> headers = new HashMap<String, String>();
    /**
     * list of name-value pairs of request headers
     */
    private RequestType rtype;

    public HttpBuilder(String uri) {
        this.uri = uri;
    }

    public HttpBuilder get() {
        rtype = RequestType.GET;
        return this;
    }

    public HttpBuilder post() {
        rtype = RequestType.POST;
        return this;
    }

    public HttpBuilder header(String name, String value) {
        headers.put(name, value);
        return this;
    }

    public HttpBuilder parameter(String name, String value) {

        StringBuilder parSB = new StringBuilder();
        if (parameters != null) parSB.append(parameters).append('&');
        parSB.append(name).append('=').append(value);

        parameters = parSB.toString();
        return this;
    }

    public HttpBuilder authorization() {
        this.header("Authorization", "Bearer " + System.getenv("oandatoken"));
        return this;
    }

    public Response execute() {
        HttpClient httpClient = HttpClientBuilder.create().build();
        Response response = new Response();

        switch (rtype) {
            case GET:
                request = new HttpGet(uri + '?' + parameters);
                break;
            case POST:
                HttpPost request = new HttpPost(uri);
                HttpEntity entity;
                try {
                    entity = new StringEntity(parameters);
                } catch (UnsupportedEncodingException ex) {
                    ex.printStackTrace();
                    return null;
                }
                request.setEntity(entity);
                this.request = request;
                this.header("Content-Type", "application/x-www-form-urlencoded");
                break;
        }

        for (String name : headers.keySet()) {
            request.addHeader(name, headers.get(name));
        }
        try {
            HttpResponse resp = httpClient.execute(request);
            response.setCode(resp.getStatusLine().getStatusCode());
            response.setMessage(resp.getStatusLine().getReasonPhrase());
            HttpEntity entity = resp.getEntity();
            if (entity != null) {
                InputStream stream = entity.getContent();
                String line;
                StringBuilder body = new StringBuilder();
                BufferedReader br = new BufferedReader(new InputStreamReader(stream));

                while ((line = br.readLine()) != null) {
                    body.append(line);
                }
                response.setBody(body.toString());
            }
        } catch (
                IOException e
                ) {
            e.printStackTrace();
        }
        return response;
    }

    private enum RequestType {
        GET,
        POST
    }
}
