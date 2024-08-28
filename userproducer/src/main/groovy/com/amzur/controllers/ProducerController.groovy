package com.amzur.controllers

import com.amzur.producer.MessageProducer
import com.amzur.userentities.User
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import jakarta.inject.Inject

@Controller("/send")
class ProducerController {
    @Inject
    MessageProducer messageProducer
    private Map<Integer, User> users=[:]
    private int nextUserId=1
    @Post
    String sendToConsumer(@Body User user){
        int userId=nextUserId++
        users[userId]=user
        messageProducer.sendMessage(users)
        return "Message sent: ${user}"
    }

}
