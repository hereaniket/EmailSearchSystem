package com.emailsystem.service;

import com.emailsystem.app.bean.Email;
import com.emailsystem.service.bean.EmailOptoutBean;

import java.util.List;

public interface EmailSearchService {

    List<EmailOptoutBean> filterMatched(List<Email> emails, List<String> keywords);
}
