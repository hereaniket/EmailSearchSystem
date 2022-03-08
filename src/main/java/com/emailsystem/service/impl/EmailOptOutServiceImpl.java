package com.emailsystem.service.impl;

import com.emailsystem.app.bean.Email;
import com.emailsystem.app.search.SimpleSearch;
import com.emailsystem.app.search.impl.TextSearchImpl;
import com.emailsystem.service.EmailSearchService;
import com.emailsystem.service.bean.EmailOptoutBean;
import com.emailsystem.util.TemplateFunction;

import java.util.List;
import java.util.stream.Collectors;

public class EmailOptOutServiceImpl implements EmailSearchService {

    private SimpleSearch searchEngine;
    private TemplateFunction templateFunction;

    public EmailOptOutServiceImpl(){
        searchEngine = new TextSearchImpl();
    }

    //For functional usage
    public EmailOptOutServiceImpl(TemplateFunction templateFunction){
        this.templateFunction = templateFunction;
    }

    @Override
    public List<EmailOptoutBean> filterMatched(List<Email> emails, List<String> keywords) {

        return emails.stream().map(email -> {
            Boolean matchFound;

            if (searchEngine != null)
                matchFound = searchEngine.find(keywords, email.getEmailBody());
            else
                matchFound = (Boolean) templateFunction.apply(keywords, email.getEmailBody());

            EmailOptoutBean service = new EmailOptoutBean();
            service.setEmail(email);
            service.setOptOut(matchFound);
            service.setValidity(matchFound?"Y":"N");
            service.setServiceUpdateTs(Long.toString(System.currentTimeMillis()));
            return service;
        }).collect(Collectors.toList());
    }
}
