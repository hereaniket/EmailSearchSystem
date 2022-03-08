package com.emailsystem.app.search;

import java.util.List;

public interface SimpleSearch {
    boolean find(List<String> keywords, StringBuffer fullText);
}
