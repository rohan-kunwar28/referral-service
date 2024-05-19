package com.personal.referralservice.controller;


import com.squareup.okhttp.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class WhatsAppController {
    public static ResponseEntity<String> sendWhatsAppMessage(String to, String param1, String param2) {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n    \"messaging_product\": \"whatsapp\",\n    \"to\": \"91" +to+ "\",\n    \"type\": \"template\",\n    \"template\": {\n        \"name\": \"referral_sent\",\n        \"language\": {\n            \"code\": \"en_US\"\n        },\n        \"components\": [\n            {\n                \"type\": \"header\",\n                \"parameters\": [\n                    {\n                        \"type\": \"text\",\n                        \"text\": \"" +param1+ "\"\n                    }\n                ]\n            },\n            {\n                \"type\": \"body\",\n                \"parameters\": [\n                    {\n                        \"type\": \"text\",\n                        \"text\": \"" +param2+ "\"\n                    }\n                ]\n            }\n        ]\n    }\n}");
        Request request = new Request.Builder()
                .url("http://graph.facebook.com/v19.0/262440373629889/messages")
                .method("POST", body)
                .addHeader("Authorization", "Bearer EAF23uH1P8y0BOZCbYrFpXQb0QklXfoeFlaYmBzD5tQd0dEbnj0bYYkkJyrixX6lKBYZCyjEaIiLbN1EFdbFV4hqgkTzXkeoK88O8NF0HQdSJCpnqfXbZCmOPD2KdIGdVajT5VviTpVZCB4rUly9x3isjwJJFCyrGydgc1YHMlNPLifJbK9vEJREEdmQNpNKvXjxKrKjZCpTJn4ZAtyLzAZD")
                .addHeader("Content-Type", "application/json")
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                // Handle unsuccessful response
                return new ResponseEntity<>("Failed to send WhatsApp message", HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return ResponseEntity.ok("WhatsApp message sent successfully");
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
            return new ResponseEntity<>("Failed to send WhatsApp message", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

