# Resend Java SDK

[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT)

Resend is the email platform for developers. Learn more on our [docsite](https://resend.com/docs/api-reference/concepts) 

<!-- Start SDK Installation -->
## SDK Installation

### Gradle

```groovy
implementation 'dev.resendapi.javaclientsdk:openapi:1.1.1'
```
<!-- End SDK Installation -->

## SDK Example Usage
<!-- Start SDK Example Usage -->
```java
package hello.world;

import dev.resendapi.javaclientsdk.Resend;
import dev.resendapi.javaclientsdk.models.shared.Security;

public class Application {
    public static void main(String[] args) {
        try {
            Resend.Builder builder = Resend.builder();

            builder.setSecurity(
                new Security() {{
                    bearerAuth = new SchemeBearerAuth() {{
                        authorization = "Bearer YOUR_BEARER_TOKEN_HERE";
                    }};
                }}
            );

            Resend sdk = builder.build();

            SendEmailRequest req = new SendEmailRequest() {{
                request = new Email() {{
                    bcc = "unde";
                    cc = "deserunt";
                    from = "porro";
                    html = "nulla";
                    replyTo = "id";
                    subject = "vero";
                    text = "perspiciatis";
                    to = "nulla";
                }};
            }};

            SendEmailResponse res = sdk.email.sendEmail(req);

            if (res.sendEmailResponse.isPresent()) {
                // handle response
            }
        } catch (Exception e) {
            // handle exception
        }
```
<!-- End SDK Example Usage -->

## Authentication

To authenticate you need to add an Authorization header with the contents of the header being Bearer re_123456789 where re_123456789 is your API Key. First, you need to get an API key, which is available in the [Resend Dashboard](https://resend.com/login).

```bash
Authorization: Bearer re_123
```

<!-- Start SDK Available Operations -->
## SDK Available Operations


### email

* `sendEmail` - Send an email
<!-- End SDK Available Operations -->

## Contributions

While we value open-source contributions to this SDK, this library is generated programmatically. Feel free to open a PR or a Github issue as a proof of concept and we'll do our best to include it in a future release !

### SDK Generated by [Speakeasy](https://docs.speakeasyapi.dev/docs/using-speakeasy/client-sdks)
