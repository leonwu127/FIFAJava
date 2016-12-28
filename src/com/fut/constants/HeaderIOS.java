package com.fut.constants;

import org.apache.commons.lang3.tuple.Pair;

/**
 * Created by leonwu127 on 15/11/2016.
 */
enum HeaderIOS {
    USER_AGENT ("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.122 Safari/537.36"),
    ACCEPT("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8"),
    ACCEPT_ENCODING("Accept-Encoding","gzip,deflate,sdch"),
    ACCEPT_LANGUAGE("Accept-Language","en-US,en;q=0.8"),
    CONNECTION("Connection","keep-alive"),
    DNT("DNT","1");



    private final String Header;
    private final String Content;

    HeaderIOS(String Header, String Content) {
        this.Header = Header;
        this.Content = Content;
    }

    

}


/**
enum Url{
    "main_site","https://www.easports.com",
            "futweb","https://www.easports.com/iframe/fut17/?baseShowoffUrl=https%3A%2F%2Fwww.easports.com%2Ffifa%2Fultimate-team%2Fweb-app%2Fshow-off&guest_app_uri=http%3A%2F%2Fwww.easports.com%2Ffifa%2Fultimate-team%2Fweb-app&locale=en_US",
            "fut_config","https://www.easports.com/iframe/fut17/bundles/futweb/web/flash/xml/site_config.xml",  # add timestamp
    "fut_home","https://www.easports.com/uk/fifa/football-club/ultimate-team",
            "fut","" //it"s updated dynamicly (based on fut_config)
            "fut_question", "https://www.easports.com/iframe/fut17/p/ut/game/fifa16/phishing/question",  # add timestamp
    "fut_validate","https://www.easports.com/iframe/fut17/p/ut/game/fifa16/phishing/validate",
            "fut_captcha_img","https://www.easports.com/iframe/fut17/p/ut/captcha/img",  # add timestamp
    "fut_captcha_validate","https://www.easports.com/iframe/fut17/p/ut/captcha/validate",

            "fut_host",{"pc":      "https://utas.external.s2.fut.ea.com:443",
            "ps3":     "https://utas.external.s2.fut.ea.com:443",
            "ps4":     "https://utas.external.s2.fut.ea.com:443",
            "xbox":    "https://utas.external.s3.fut.ea.com:443",
            "xbox360": "https://utas.external.s3.fut.ea.com:443",
            "ios":     "https://utas.external.fut.ea.com:443",
            "and":     "https://utas.external.fut.ea.com:443"},

            "shards":                "https://www.easports.com/iframe/fut17/p/ut/shards",  # add timestamp
    "acc_info":              "https://www.easports.com/iframe/fut17/p/ut/game/fifa16/user/accountinfo",
            "card_info":             "https://fifa17.content.easports.com/fifa/fltOnlineAssets/CC8267B6-0817-4842-BB6A-A20F88B05418/2017/fut/items/web/",
            "messages":              "https://www.easports.com/iframe/fut17/bundles/futweb/web/flash/xml/localization/messages.en_US.xml",  # add cl
}
 **/