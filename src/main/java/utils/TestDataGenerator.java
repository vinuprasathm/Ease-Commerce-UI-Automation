package utils;

import java.util.Random;
import java.util.UUID;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDataGenerator {

    public static String generateUniqueUUID() {
        return UUID.randomUUID().toString();
    }

    public static String generateTimestampString() {
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
    }

    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        
        return sb.toString();
    }
}
