package com.projects.oddsPickr.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FireBaseInitialization {

    @Value("${firebase.credential.resource-path}")
    private String keyPath;

    @Bean
    public void firebaseInitiatization() throws IOException {

        FileInputStream serviceAccount = new FileInputStream(keyPath);

        FirebaseOptions.Builder options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount));

        if (FirebaseApp.getApps().isEmpty()) {

            FirebaseApp.initializeApp(options.build());
        }
    }

}
