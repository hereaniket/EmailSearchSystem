package com.emailsystem.app.search.special;

import java.util.List;

public interface ElasticSearch {

    boolean findByKeyword(String keyword, StringBuffer text);
    boolean findAny(List<String> keywords, StringBuffer text);
}
