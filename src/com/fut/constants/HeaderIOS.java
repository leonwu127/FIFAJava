package com.fut.constants;

import org.apache.commons.lang3.tuple.Pair;

/**
 * Created by leonwu127 on 15/11/2016.
 */
enum HeaderIOS {
    UserAgent ("User-Agent", "Mozilla/5.0");

    private final String Header;
    private final String Content;
    HeaderIOS(String Header, String Content) {
        this.Header = Header;
        this.Content = Content;
    }

    

}