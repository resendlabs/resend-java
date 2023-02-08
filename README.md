# Resend Java SDK

Resend is the email platform for developers. Learn more on our [docsite](https://resend.com/docs/api-reference/concepts) 

<!-- Start SDK Installation -->
## SDK Installation

### Gradle

```groovy
implementation 'dev.resendapi.javaclientsdk::1.0.0'
```
<!-- End SDK Installation -->

## SDK Example Usage
<!-- Start SDK Example Usage -->
```java
package hello.world;

import dev.resendapi.javaclientsdk.SDK;
import dev.resendapi.javaclientsdk.models.shared.Security;

public class Application {
    public static void main(String[] args) {
        try {
            SDK.Builder builder = SDK.builder();

            builder.setSecurity(
                new Security() {{
                    bearerAuth = new SchemeBearerAuth() {{
                        authorization = "Bearer YOUR_BEARER_TOKEN_HERE";
                    }};
                }}
            );

            SDK sdk = builder.build();

            SendEmailRequest req = new SendEmailRequest() {{
                request = new Email() {{
                    bcc = "unde";
                    cc = "deserunt";
                    from = "porro";
                    html = "nulla";
                    react = "id";
                    replyTo = "vero";
                    subject = "perspiciatis";
                    text = "nulla";
                    to = "nihil";
                }};
            }};

            SendEmailResponse res = sdk.emails.sendEmail(req);

            if (res.sendEmailResponse.isPresent()) {
                // handle response
            }
        } catch (Exception e) {
            // handle exception
        }
```
<!-- End SDK Example Usage -->

## Authentication
To authenticate you need to add an Authorization header with the contents of the header being Bearer re_123456789 where re_123456789 is your [API Key](https://resend.com/login?redirectedFrom=%2Fapi-keys).

```bash
Authorization: Bearer re_123
```

<!-- Start SDK Available Operations -->
## SDK Available Operations


### emails

* `sendEmail` - Send an email
<!-- End SDK Available Operations -->

### SDK Generated by [Speakeasy](https://docs.speakeasyapi.dev/docs/using-speakeasy/client-sdks)
