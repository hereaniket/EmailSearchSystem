package com.emailsystem.service.test;

import com.emailsystem.app.bean.Email;
import com.emailsystem.service.EmailSearchService;
import com.emailsystem.service.bean.EmailOptoutBean;
import com.emailsystem.service.impl.EmailOptOutServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class EmailServiceTest {
    List<Email> emailList;
    List<String> keywords;

    @Before
    public void init() {
        emailList = getEmails();
    }

    @Test
    public void emailServiceFindMatch(){
        keywords = Arrays.asList("Remove", "not interested", "not-interested", "delete");
        EmailSearchService impl = new EmailOptOutServiceImpl();
        List<EmailOptoutBean> emailOptOutList = impl.filterMatched(emailList, keywords);

        Assert.assertEquals(emailList.size(), emailOptOutList.size());
    }

    public static List<Email> getEmails(){
        Email email1 = new Email();
        email1.setEmailBody(new StringBuffer("I am getting these marketing emails. I am not-interested to receive these emails. remove me from the list."));
        email1.setFromAddress("aniketpathak1@gmail.com");
        email1.setReceivedTs(Long.toString(System.currentTimeMillis()));
        email1.setSubject("My subject "+ UUID.randomUUID().toString());

        Email email2 = new Email();
        email2.setEmailBody(new StringBuffer("I am getting these marketing emails. I am ok to receive these emails. Thank you..."));
        email2.setFromAddress("aniketpathak2@gmail.com");
        email2.setReceivedTs(Long.toString(System.currentTimeMillis()));
        email2.setSubject("My subject "+ UUID.randomUUID().toString());

        Email email3 = new Email();
        email3.setEmailBody(new StringBuffer("I am getting these marketing emails. I am not interested to receive these emails. remove me from the list."));
        email3.setFromAddress("aniketpathak3@gmail.com");
        email3.setReceivedTs(Long.toString(System.currentTimeMillis()));
        email3.setSubject("My subject "+ UUID.randomUUID().toString());

        return Arrays.asList(email1, email2, email3);
    }
}
