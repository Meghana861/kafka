package com.amzur.service

import com.amzur.userentities.User
import io.micronaut.scheduling.annotation.Async
import jakarta.inject.Singleton


import javax.mail.Message
import javax.mail.PasswordAuthentication
import javax.mail.Session
import javax.mail.Transport
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage



@Singleton
class NotificationServices {

    private final Session mailSession

    NotificationServices() {
        mailSession = createMailSession()
    }

    private Session createMailSession() {
        def props = new Properties()
        props.put("mail.smtp.host", "smtp.example.com")
        props.put("mail.smtp.port", "587")
        props.put("mail.smtp.auth", "true")
        props.put("mail.smtp.starttls.enable", "true")

        return Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("your-email@example.com", "your-email-password")
            }
        })
    }


    void sendNotification(User user) {
        try {
            MimeMessage message = new MimeMessage(mailSession)
            message.setFrom(new InternetAddress("your-email@example.com"))
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(user.email))
            message.setSubject("Notification")
            message.setText("Hello ${user.name}, your event ${user.event} has been processed.")

            Transport.send(message)
            println "Notification email sent to ${user.email}"
        } catch (Exception e) {
            println "Failed to send email: ${e.message}"
        }
    }
}
