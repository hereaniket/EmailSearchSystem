package com.emailsystem.app.search.special.impl;

import com.emailsystem.app.search.special.ElasticSearch;

import java.util.List;

/**
 * This is just stub class, implementation is not added
 */
public class ElasticTextSearch implements ElasticSearch {

    @Override
    public boolean findByKeyword(String keyword, StringBuffer text) {
        //Elastic search implementation goes here

        return false;
    }

    @Override
    public boolean findAny(List<String> keywords, StringBuffer text) {
        //Elastic search implementation goes here
        return false;
    }
}
