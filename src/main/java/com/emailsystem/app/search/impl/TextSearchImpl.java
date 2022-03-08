package com.emailsystem.app.search.impl;

import com.emailsystem.app.search.SimpleSearch;
import java.util.List;

public class TextSearchImpl implements SimpleSearch {

    @Override
    public boolean find(List<String> keywords, StringBuffer fullText) {
        if (keywords == null || keywords.isEmpty() || fullText == null || fullText.toString().isEmpty()) return false;

        else return keywords.stream()
                .map(String::toLowerCase)
                .anyMatch(fullText.toString().toLowerCase()::contains);
    }
}
