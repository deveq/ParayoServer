package com.example.parayo.fcm

import com.example.parayo.User
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential
import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import com.google.firebase.messaging.Notification
import org.springframework.core.io.ClassPathResource

object NotificationService {
    val firebaseApp by lazy {
        val inputStream = ClassPathResource(
            "mychatting-80c61-firebase-adminsdk-wskta-a7f8d368c7.json"
//        "mychatting-80c61-25e6fe90b4da.json"
        ).inputStream


        val options = FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.fromStream(inputStream))
            .setDatabaseUrl("https://mychatting-80c61.firebaseio.com")
            .build()

        FirebaseApp.initializeApp(options)
    }

    fun sendToUser(user: User, title: String, content: String) =
        user.token?.let {token ->
            val message = Message.builder()
                .setToken(token)
                .putData("title",title)
                .putData("content",content)
                .build()

            FirebaseMessaging.getInstance(firebaseApp).send(message)

        }
    fun sendToUser2(token: String, title: String, content: String): String {
        val message = Message.builder()
            .setToken(token)
            .putData("title", title)
            .putData("content", content)
            .build()
        println("끵..")

        return FirebaseMessaging.getInstance(firebaseApp).send(message)
    }


}

fun main() {

    val long1: Any = 1
    val long2: Any = 2

    println((long1.toString().toLong()).compareTo((long2.toString().toLong())))




}