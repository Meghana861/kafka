package com.amzur.controllers

import com.amzur.producer.NotificationSender
import com.amzur.userentities.User
import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import jakarta.inject.Inject

@Controller("/notify")
class NotificationController {
    private final NotificationSender kafkaClient
   @Inject

   NotificationController(NotificationSender kafkaClient) {
       this.kafkaClient = kafkaClient
   }
    @Post
    void sendNotification(@Body User user){
       kafkaClient.sendNotificationAsync(user)
   }
}
