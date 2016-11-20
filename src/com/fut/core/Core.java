package com.fut.core;
import com.fut.hash.Hash;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;



import java.util.ArrayList;

/**
 * Created by leonwu127 on 01/11/2016.
 */
class KeyValuePair extends Pair{
    String key;
    String value;


    @Override
    public String getLeft() {
        return key;
    }

    @Override
    public String getRight() {
        return value;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public Boolean setValue(Object value) {

        return null;
    }
}




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
}
