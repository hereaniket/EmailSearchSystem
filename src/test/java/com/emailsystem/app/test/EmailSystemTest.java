package com.emailsystem.app.test;

import com.emailsystem.app.search.SimpleSearch;
import com.emailsystem.app.search.impl.TextSearchImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class EmailSystemTest {
    private SimpleSearch emailsearch;

    private List<String> keywords;
    private StringBuffer fullText;

    @Before
    public void init(){
        emailsearch = new TextSearchImpl();
        fullText = new StringBuffer("I am getting these marketing emails. I am not-interested to receive these emails. remove me from the list.");
    }

    @Test
    public void testEmailSearch_Positive(){
        keywords = Arrays.asList("Remove1", "not interested1", "not-interested", "delete");
        boolean flg = emailsearch.find(keywords, fullText);
        Assert.assertEquals(true, flg);
    }

    @Test
    public void testEmailSearch_Negative(){
        keywords = Arrays.asList("Remove1", "not interested1", "not-interested1", "delete");
        boolean flg = emailsearch.find(keywords, fullText);
        Assert.assertEquals(false, flg);
    }
}
