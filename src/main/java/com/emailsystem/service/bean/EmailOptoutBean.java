package com.emailsystem.service.bean;

import com.emailsystem.app.bean.Email;

public class EmailOptoutBean {

    Email email;
    Boolean optOut;
    String serviceUpdateTs;
    String validity;

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Boolean getOptOut() {
        return optOut;
    }

    public void setOptOut(Boolean optOut) {
        this.optOut = optOut;
    }

    public String getServiceUpdateTs() {
        return serviceUpdateTs;
    }

    public void setServiceUpdateTs(String serviceUpdateTs) {
        this.serviceUpdateTs = serviceUpdateTs;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }
}
