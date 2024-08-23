package com.amzur.notificationconsumer

import com.amzur.userentities.User
import io.micronaut.configuration.kafka.annotation.KafkaListener
import io.micronaut.configuration.kafka.annotation.OffsetReset
import io.micronaut.configuration.kafka.annotation.Topic
import io.micronaut.http.annotation.Body
import io.micronaut.scheduling.annotation.Async

@KafkaListener(offsetReset = OffsetReset.EARLIEST)
class NotificationListener {
   @Topic("notifications")
    void receive(@Body User user){
       processNotification(user)
   }

   void processNotification(User user){
        println "Sending Notifications to ${user.email}"
    }
}
