package com.resend.sdk.models.operations;

import java.net.http.HttpResponse;

public class SendEmailResponse {
    public String contentType;
    public SendEmailResponse withContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }
    
    public com.resend.sdk.models.shared.SendEmailResponse sendEmailResponse;
    public SendEmailResponse withSendEmailResponse(com.resend.sdk.models.shared.SendEmailResponse sendEmailResponse) {
        this.sendEmailResponse = sendEmailResponse;
        return this;
    }
    
    public Integer statusCode;
    public SendEmailResponse withStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }
    
    public HttpResponse<byte[]> rawResponse;
    public SendEmailResponse withRawResponse(HttpResponse<byte[]> rawResponse) {
        this.rawResponse = rawResponse;
        return this;
    }
    
}
