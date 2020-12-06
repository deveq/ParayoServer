package com.example.parayo.fcm

import com.google.auth.oauth2.GoogleCredentials
import org.springframework.core.io.ClassPathResource

class FirebaseCloudMessagService {
    fun getAccessToken(): String {
        val firebaseConfigPath = "firebase/mychatting-80c61-firebase-adminsdk-wskta-a7f8d368c7.json"

        val googleCredentials = GoogleCredentials
            .fromStream(ClassPathResource(firebaseConfigPath).inputStream)
            .createScoped(listOf("https://www.googleapis.com/auth/cloud-platform"))

        googleCredentials.refreshIfExpired()
        return googleCredentials.accessToken.tokenValue
        //List.of()
    }
}