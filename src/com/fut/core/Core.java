package com.fut.core;
import com.fut.hash.Hash;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.http.*;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
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
import org.apache.http.protocol.*;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HTTP.*;
import org.apache.http.util.EntityUtils;
import org.json.simple.*;
import org.json.simple.JSONObject;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Core {
    private String email;
    private String passwd;
    private String secretAnswer;
    private String platform;
    private String code;
    private String emulate;
    private ArrayList<Pair> headers = new ArrayList<Pair>();




    public Core(String email, String passwd, String secretAnswer){
        this.email = email;
        this.passwd = passwd;
        this.secretAnswer = secretAnswer;
        this.platform = "pc";
        this.code = null;

    }





    public void login(String email, String passwd, String secretAnswer, String code, String emulate){
        Hash hashMethod = new Hash();
        String secretAnswerHash = hashMethod.eaHash(secretAnswer);

        CloseableHttpClient httpClient = HttpClients.createDefault();


        // Cookie for saving login information
        CookieStore cookieStore = new BasicCookieStore();



        // Emulate
    }


    public static void main(String[] args) throws IOException, URISyntaxException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        URI uri = new URI("https://www.easports.com/fifa/ultimate-team/web-app");

        HttpContext hc = new BasicHttpContext();

        HttpGet hg = new HttpGet(uri);
        HttpResponse response = httpClient.execute(hg,hc);
        //uri.getHost()

        HttpUriRequest currentReq = (HttpUriRequest)hc.getAttribute(HttpCoreContext.HTTP_REQUEST);
        HttpHost currentHost = (HttpHost)  hc.getAttribute(HttpCoreContext.HTTP_TARGET_HOST);

        String currentUrl = (currentReq.getURI().isAbsolute()) ? currentReq.getURI().toString() : (currentHost.toURI() + currentReq.getURI());
        System.out.println(currentUrl);

        String email = "leonwu127@icloud.com";
        String password = "13655197351Wzq";
        String secretAnswer = "weiwei";
        Core core = new Core(email, password, secretAnswer);
        String url = core.getRedirectUrl(email, password, secretAnswer, currentUrl, httpClient);

        //String email = "17fifa.com@gmail.com";
        //String password = "17FIFAcom";


        //String url = "https://signin.ea.com/p/web/login?execution=e1857465993s2&initref=https%3A%2F%2Faccounts.ea.com%3A443%2Fconnect%2Fauth%3Fscope%3Dbasic.identity%2Bbasic.persona%2Bsignin%2Boffline%2Bsecurity.challenge%26redirect_uri%3Dhttp%253A%252F%252Fwww.easports.com%252Ffifa%252Flogin_check%26locale%3Den_GB%26state%3DeaD2c456XsUoTJR745VdMj_QcGizYTsUaEcY9IXSuKA%26response_type%3Dcode%26client_id%3DEASFC-web";
        //System.out.println(url);
        //String code = "000000";
        //core.getWebApp(url,httpClient,code);
        //HttpResponse loginResponse2 = httpClient.execute(hp2);
        //getStringFromInputStream(loginResponse2.getEntity().getContent());

    }

    /**
     *
     * @param email user's email.
     * @param password user's password.
     * @param secretAnswer user's secretAnswer.
     * @param currentUrl currentUrl.
     * @param httpClient
     * @return redirect url
     * @throws IOException
     */
    public String getRedirectUrl(String email, String password,String secretAnswer, String currentUrl, CloseableHttpClient httpClient) throws IOException {
        String redirectUrl = "";
        ArrayList<NameValuePair> nvp = new ArrayList<>();

        // Prepare data.
        nvp.add(new BasicNameValuePair("_eventId","submit"));
        nvp.add(new BasicNameValuePair("country","US"));
        nvp.add(new BasicNameValuePair("rememberMe","on"));
        nvp.add(new BasicNameValuePair("email",email));
        nvp.add(new BasicNameValuePair("password",password));
        nvp.add(new BasicNameValuePair("phoneNumber",""));
        nvp.add(new BasicNameValuePair("passwordForPhone",""));
        nvp.add(new BasicNameValuePair("gCaptchaResponse",""));
        nvp.add(new BasicNameValuePair("isPhoneNumberLogin","false"));
        nvp.add(new BasicNameValuePair("isIncompletePhone",""));
        nvp.add(new BasicNameValuePair("_rememberMe","on"));

        // Construct a http post request.
        HttpPost hp = new HttpPost(currentUrl);
        HttpContext hc = new BasicHttpContext();
        hp.setEntity(new UrlEncodedFormEntity(nvp));
        HttpResponse hr = httpClient.execute(hp,hc);

        if (hr.getStatusLine().toString().equals("HTTP/1.1 302 Found")){
            redirectUrl = hr.getFirstHeader("Location").getValue();
            redirectUrl = "https://signin.ea.com" + redirectUrl + "&_eventId=end";
            System.out.println(redirectUrl);
        }
        HttpContext nhc = new BasicHttpContext();
        HttpGet hg = new HttpGet(redirectUrl);
        HttpResponse hr2 = httpClient.execute(hg,nhc);

        return redirectUrl;
        //redirectUrl = m.group(1)+"&_eventId=end";
        //System.out.println(m.group(1)+"&_eventId=end");

        //HttpGet hg = new HttpGet(redirectUrl);
        //HttpResponse hr2 = httpClient.execute(hg,nhc);

        //hp.addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.122 Safari/537.36");
        //hp.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        /*
        hp.addHeader("Accept-Encoding","gzip,deflate,sdch");
        hp.addHeader("Accept-Language","en-US,en;q=0.8");
        hp.addHeader("Connection","keep-alive");
        hp.addHeader("DNT","1");
        hp.addHeader("Referer",currentUrl);

        hp.setEntity(new UrlEncodedFormEntity(nvp));
        HttpContext hcResponse = new BasicHttpContext();
        HttpResponse loginResponse = httpClient.execute(hp,hcResponse);
        // Code get, now try to find the new url

        // url redirection
        String url = loginResponse.getHeaders("Location")[0].getValue().toString();
        */
        //HttpPost hp2 = new HttpPost(url);
        //hp2.addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.122 Safari/537.36");
        //hp2.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        //hp2.addHeader("Accept-Encoding","gzip,deflate,sdch");
        //hp2.addHeader("Accept-Language","en-US,en;q=0.8");
        //hp2.addHeader("Connection","keep-alive");
        //hp2.addHeader("DNT","1");
        //hp2.addHeader("Referer",currentUrl);

        //hp2.setEntity(new UrlEncodedFormEntity(nvp));
        //HttpContext hcResponse2 = new BasicHttpContext();
        //HttpResponse loginResponse2 = httpClient.execute(hp,hcResponse2);
    }



    public String getWebAppUrl(String url, CloseableHttpClient httpClient ,String code) throws IOException {
        ArrayList<NameValuePair> nvp2 = new ArrayList<>();
        nvp2.add(new BasicNameValuePair("_trustThisDevice","on"));
        nvp2.add(new BasicNameValuePair("trustThisDevice","on"));
        nvp2.add(new BasicNameValuePair("twofactorCode",code));
        nvp2.add(new BasicNameValuePair("_eventId","submit"));


        HttpPost hp2 = new HttpPost(url);
        hp2.addHeader("User-Agent","Mozilla/5.0 (Windows NT 10;0. Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.122 Safari/537.36");
        hp2.addHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        hp2.addHeader("Accept-Encoding","gzip,deflate,sdch");
        hp2.addHeader("Accept-Language","en-US,en;q=0.8");
        hp2.addHeader("Connection","keep-alive");
        hp2.addHeader("DNT","1");
        hp2.setHeader("Referer",url);
        hp2.setEntity(new UrlEncodedFormEntity(nvp2));

        HttpResponse loginResponse2 = httpClient.execute(hp2);
        String redirectUrl = getStringFromInputStream(loginResponse2.getEntity().getContent());

        return redirectUrl;
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
