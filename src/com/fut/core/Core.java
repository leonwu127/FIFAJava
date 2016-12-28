package com.fut.core;
import com.fut.hash.Hash;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.http.*;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.json.simple.*;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Created by leonwu127 on 01/11/2016.
 */



public class Core {
    private String email;
    private String passwd;
    private String secretAnswer;
    private String platform;
    private String code;
    private String emulate;
    private ArrayList<Pair> headers = new ArrayList<Pair>();




    public Core(){
        email = null;
        passwd = null;
        secretAnswer = null;
        platform = "xbox";
        code = null;
        emulate = "webapp";
        
    }





    public void login(String email, String passwd, String secretAnswer, String code, String emulate){
        Hash hashMethod = new Hash();
        String secretAnswerHash = hashMethod.eaHash(secretAnswer);

        CloseableHttpClient httpClient = HttpClients.createDefault();


        // Cookie for saving login information
        CookieStore cookieStore = new BasicCookieStore();



        // Emulate
    }


    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //HttpParams params = httpClient.getParams();
        //HttpClientParams.setRedirecting(params, false);

        HttpGet hg = new HttpGet("https://www.easports.com/uk/fifa/football-club/ultimate-team");
        HttpContext hc = new BasicHttpContext();
        //System.out.println(hg.getURI());
        CloseableHttpResponse response = httpClient.execute(hg,hc);
        if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK)
            throw new IOException(response.getStatusLine().toString());

        HttpUriRequest currentReq = (HttpUriRequest)hc.getAttribute(ExecutionContext.HTTP_REQUEST);
        HttpHost currentHost = (HttpHost)  hc.getAttribute(ExecutionContext.HTTP_TARGET_HOST);

        String currentUrl = (currentReq.getURI().isAbsolute()) ? currentReq.getURI().toString() : (currentHost.toURI() + currentReq.getURI());
        System.out.println(currentUrl);

        ArrayList<NameValuePair> nvp = new ArrayList<>();

        String code = "495348";

        nvp.add(new BasicNameValuePair("_eventId","submit"));
        nvp.add(new BasicNameValuePair("rememberMe","on"));
        //nvp.add(new BasicNameValuePair("email","17fifa.com@gmail.com"));
        nvp.add(new BasicNameValuePair("email","leonwu127@gmail.com"));
        //nvp.add(new BasicNameValuePair("password","17FIFAcom"));
        nvp.add(new BasicNameValuePair("password","2013Zhuangyuan"));
        nvp.add(new BasicNameValuePair("_rememberMe","on"));

        HttpPost hp = new HttpPost(currentUrl);
        hp.setEntity(new UrlEncodedFormEntity(nvp));


        hp.addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.122 Safari/537.36");
        hp.addHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        hp.addHeader("Accept-Encoding","gzip,deflate,sdch");
        hp.addHeader("Accept-Language","en-US,en;q=0.8");
        hp.addHeader("Connection","keep-alive");
        hp.addHeader("DNT","1");
        hp.addHeader("Referer",currentUrl);


        HttpContext hcResponse = new BasicHttpContext();

        HttpResponse loginResponse = httpClient.execute(hp,hcResponse);
        // Code get, now try to find the new url



        String newUrl = loginResponse.getHeaders("Location")[0].getValue().toString();
        //String newUrl = "https://signin.ea.com/p/web/login?execution=e1857465993s2&initref=https%3A%2F%2Faccounts.ea.com%3A443%2Fconnect%2Fauth%3Fscope%3Dbasic.identity%2Bbasic.persona%2Bsignin%2Boffline%2Bsecurity.challenge%26redirect_uri%3Dhttp%253A%252F%252Fwww.easports.com%252Ffifa%252Flogin_check%26locale%3Den_GB%26state%3DeaD2c456XsUoTJR745VdMj_QcGizYTsUaEcY9IXSuKA%26response_type%3Dcode%26client_id%3DEASFC-web";
        System.out.println(newUrl);

        ArrayList<NameValuePair> nvp2 = new ArrayList<>();
        nvp2.add(new BasicNameValuePair("_trustThisDevice","on"));
        nvp2.add(new BasicNameValuePair("trustThisDevice","on"));
        nvp2.add(new BasicNameValuePair("twofactorCode","183229"));
        nvp2.add(new BasicNameValuePair("_eventId","submit"));



        //HttpPost hp2 = new HttpPost(newUrl);
        hp.addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.122 Safari/537.36");
        hp.addHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        hp.addHeader("Accept-Encoding","gzip,deflate,sdch");
        hp.addHeader("Accept-Language","en-US,en;q=0.8");
        hp.addHeader("Connection","keep-alive");
        hp.addHeader("DNT","1");
        hp.setHeader("Referer",newUrl);


        //hp2.setEntity(new UrlEncodedFormEntity(nvp2));

        //HttpResponse loginResponse2 = httpClient.execute(hp2);

        //getStringFromInputStream(loginResponse2.getEntity().getContent());

    }

    private static String getStringFromInputStream(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();

    }
}
