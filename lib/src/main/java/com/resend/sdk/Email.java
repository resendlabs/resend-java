package com.resend.sdk;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.resend.sdk.utils.HTTPClient;
import com.resend.sdk.utils.HTTPRequest;
import com.resend.sdk.utils.JSON;
import com.resend.sdk.utils.SerializedBody;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;

public class Email {
	
	private HTTPClient _defaultClient;
	private HTTPClient _securityClient;
	private String _serverUrl;
	private String _language;
	private String _sdkVersion;
	private String _genVersion;

	public Email(HTTPClient defaultClient, HTTPClient securityClient, String serverUrl, String language, String sdkVersion, String genVersion) {
		this._defaultClient = defaultClient;
		this._securityClient = securityClient;
		this._serverUrl = serverUrl;
		this._language = language;
		this._sdkVersion = sdkVersion;
		this._genVersion = genVersion;
	}
	
    
    /**
     * sendEmail - Send an email
    **/
    public com.resend.sdk.models.operations.SendEmailResponse sendEmail(com.resend.sdk.models.operations.SendEmailRequest request) throws Exception {
        String baseUrl = this._serverUrl;
        String url = com.resend.sdk.utils.Utils.generateURL(baseUrl, "/email");
        
        HTTPRequest req = new HTTPRequest();
        req.setMethod("POST");
        req.setURL(url);
        SerializedBody serializedRequestBody = com.resend.sdk.utils.Utils.serializeRequestBody(request);
        if (serializedRequestBody == null) {
            throw new Exception("Request body is required");
        }
        req.setBody(serializedRequestBody);
        
        req.addHeader("user-agent", String.format("speakeasy-sdk/%s %s %s", this._language, this._sdkVersion, this._genVersion));
        
        HTTPClient client = this._securityClient;
        
        HttpResponse<byte[]> httpRes = client.send(req);

        String contentType = httpRes.headers().firstValue("Content-Type").orElse("application/octet-stream");

        com.resend.sdk.models.operations.SendEmailResponse res = new com.resend.sdk.models.operations.SendEmailResponse() {{
            sendEmailResponse = null;
        }};
        res.statusCode = httpRes.statusCode();
        res.contentType = contentType;
        res.rawResponse = httpRes;
        
        if (httpRes.statusCode() == 200) {
            if (com.resend.sdk.utils.Utils.matchContentType(contentType, "application/json")) {
                ObjectMapper mapper = JSON.getMapper();
                com.resend.sdk.models.shared.SendEmailResponse out = mapper.readValue(new String(httpRes.body(), StandardCharsets.UTF_8), com.resend.sdk.models.shared.SendEmailResponse.class);
                res.sendEmailResponse = out;
            }
        }

        return res;
    }
}