package com.fut.core;
import com.fut.hash.*;

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

    public Core(){
        email = null;
        passwd = null;
        secretAnswer = null;
        platform = "xbox";
        code = null;
        emulate = "webapp";
    }

    public void login(String email, String passwd, String secretAnswer, String code){
        Hash hashMethod = new Hash();
        String secretAnswerHash = hashMethod.eaHash(secretAnswer);

    }
}
