package com.yilmaz.kubit.services;

import org.springframework.stereotype.Service;

@Service
public class ResponseService {
    private Boolean status;
    private Boolean redirect;
    private String redirectUrl;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getRedirect() {
        return redirect;
    }

    public void setRedirect(Boolean redirect) {
        this.redirect = redirect;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public ResponseService redirectTo(String url){
        this.setStatus(true);
        this.setRedirect(true);
        this.setRedirectUrl(url);

        return this;
    }
}
