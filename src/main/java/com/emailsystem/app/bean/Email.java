package com.emailsystem.app.bean;

public class Email {
    String fromAddress;
    String receivedTs;
    StringBuffer emailBody;
    String subject;

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getReceivedTs() {
        return receivedTs;
    }

    public void setReceivedTs(String receivedTs) {
        this.receivedTs = receivedTs;
    }

    public StringBuffer getEmailBody() {
        return emailBody;
    }

    public void setEmailBody(StringBuffer emailBody) {
        this.emailBody = emailBody;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
