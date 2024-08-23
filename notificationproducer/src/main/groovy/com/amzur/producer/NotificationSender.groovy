package com.amzur.producer

import com.amzur.userentities.User
import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.Topic
import io.micronaut.http.annotation.Body

@KafkaClient
interface NotificationSender {
    @Topic("notifications")
    void sendNotificationAsync(@Body User user)
}