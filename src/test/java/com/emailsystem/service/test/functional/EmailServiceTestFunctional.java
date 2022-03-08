package com.emailsystem.service.test.functional;

import com.emailsystem.app.bean.Email;
import com.emailsystem.app.search.special.impl.ElasticTextSearch;
import com.emailsystem.service.EmailSearchService;
import com.emailsystem.service.bean.EmailOptoutBean;
import com.emailsystem.service.impl.EmailOptOutServiceImpl;
import com.emailsystem.service.test.EmailServiceTest;
import com.emailsystem.util.TemplateFunction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class EmailServiceTestFunctional {

    List<Email> emailList;
    List<String> keywords;

    @Before
    public void init() {
        emailList = EmailServiceTest.getEmails();
    }

    @Test
    public void emailServiceFindMatchByCustomFunction(){

        TemplateFunction function = (a, b) -> (new ElasticTextSearch()).findAny((List<String>) a, (StringBuffer) b);

        EmailSearchService impl = new EmailOptOutServiceImpl(function);

        keywords = Arrays.asList("Remove1", "1not interested", "1not-interested", "delete");

        List<EmailOptoutBean> emailOptOutList = impl.filterMatched(emailList, keywords);

        Assert.assertEquals(emailList.size(), emailOptOutList.size());
    }
}
