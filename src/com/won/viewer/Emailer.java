package com.won.viewer;



import com.mailersend.sdk.emails.Email;
import com.mailersend.sdk.MailerSend;
import com.mailersend.sdk.MailerSendResponse;
import com.mailersend.sdk.exceptions.MailerSendException;




public class Emailer{
    public static void sendEmail() {

        Email email = new Email();
        email.setFrom("Joshua Richardson", "joshua.richardson@tlgcohort.com");
        email.addRecipient("Caleb", "caleb.wise@tlgcohort.com");

        // you can also add multiple recipients by calling addRecipient again
//        email.addRecipient("name 2", "your@recipient2.com");

        // there's also a recipient object you can use
//        Recipient recipient = new Recipient("name", "your@recipient3.com");
//        email.addRecipient(recipient);

        email.setSubject("Email subject");

        email.setPlain("This is the text content");
        email.setHtml("<p>This is the HTML content</p>");

        MailerSend ms = new MailerSend();

        ms.setToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiOTcxMTQzNTRjZTE0YzFkYzBjNmI4OWE4OTQxZTEzMTNhYThiYTQyM2YyYjMxMzExZTMyMjJkOWE1YjFlOTM3MWZhODdmYWY2ZWZmOThlNTkiLCJpYXQiOjE2Nzg4Mzg1ODMuOTIxNzksIm5iZiI6MTY3ODgzODU4My45MjE3OTIsImV4cCI6NDgzNDUxMjE4My45MTgxNDUsInN1YiI6IjYyODc2Iiwic2NvcGVzIjpbImVtYWlsX2Z1bGwiLCJkb21haW5zX2Z1bGwiLCJhY3Rpdml0eV9mdWxsIiwiYW5hbHl0aWNzX2Z1bGwiLCJ0b2tlbnNfZnVsbCIsIndlYmhvb2tzX2Z1bGwiLCJ0ZW1wbGF0ZXNfZnVsbCIsInN1cHByZXNzaW9uc19mdWxsIiwic21zX2Z1bGwiLCJlbWFpbF92ZXJpZmljYXRpb25fZnVsbCIsImluYm91bmRzX2Z1bGwiLCJyZWNpcGllbnRzX2Z1bGwiLCJzZW5kZXJfaWRlbnRpdHlfZnVsbCJdfQ.FZOgemf0tWNQy3skUzaq928mptg1juJdAaG6PPYAY2xuK-DV11v8IsTOQ9muzt9WhGw8vribHWHnZV45x7-UGpyocCFdGvKgUztB9V1VYYGujIK3eGr26dAli98us9ApLuOicK6-_9KA11FpQoya9jSilEYBeCtEUwt8ZNuQpKWy3xMq15cLXT-23oQOvRhqVqXYSfB4S2foFYkvSxXEYoQKDdzd7TP97A1KNPbpkZTC0vTPLAbQVKIJHBMQYcRLL7-WriFjFcqY6gFTjzVB7RaEb0yi1SvU-Gx1oXwJpXP1A4sGh6_MkEqxFCqXwiB05wS5bkR85NZyJyKXoiQ-2_49cGUpgSqaDOrlYpoAhcA0xKtaF1J8cR0aJppCnMf8AiHA-RPwgAcSUWcVmrQ3c1ku_QCiGAEfGAIMii-FhC1czYVuRSTx8jVNrd0PjTqodyHt7iYypohgvFO_VVE3zfwXCYIGicryrTfUDu3kTPUZJ44AZlsun43fvODxYs68YgnPO4MMCgYkhyTaFfJ8Kar-KxPAkpyNA4N3-HMO86hp1z2Pq1iSthNyN5zrnjwVaAD82ueLUUjXLecjg9BNhSQMY97yqYTT622p3lhaRKakHft3M2woLmP2stmCSUXS9MLVDtA95IlbF7zBl6Htg9gNgOndrM9TneNd4zvLEOI");

        try {
            MailerSendResponse response = ms.emails().send(email);
            System.out.println(response.messageId);
        } catch (MailerSendException e) {

            e.printStackTrace();
        }
    }


}

