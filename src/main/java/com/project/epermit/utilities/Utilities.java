package com.project.epermit.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import java.util.Random;
@Service
public class Utilities {
    @Autowired
    private Environment env;
//    @Value("${ridernamesubstring}")
//    private static String ridersubstring = env.getProperty("ridernamesubstring");
//    @Value("${vehiclenamesubstring}")
//    private static String vehiclesubstring = env.getProperty("vehiclenamesubstring");

    public String generatePassword(){
    Random r = new Random();
    String rand = "";
    String alphabet = "ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz123456789";
    for (int i = 0; i < 7; i++) {
        rand = rand + alphabet.charAt(r.nextInt(alphabet.length()));
    } // prints 50 random characters from alphabet
    System.out.println("new password is " + rand.trim() );
    return rand.trim();
}

    public String generateUniqueUserId(){
        Random r = new Random();
        String rand = "";
        String num = "123456789";
        String alphabet = "ABCDEFGHJKLMNPQRSTUVWXYZS";
        String sep="/";
        String ridersubstring = env.getProperty("ridernamesubstring");
        rand = rand + ridersubstring + sep;
        for (int i = 0; i < 4; i++) {
            rand = rand + alphabet.charAt(r.nextInt(alphabet.length()));
        }
        rand = rand + sep;
        for(int j=0;j<5;j++){
            rand = rand + num.charAt(r.nextInt(num.length()));
        }
        return rand.trim();
    }

    public String generateUniqueVehId() {
        Random r = new Random();
        String rand = "";
        String num = "123456789";
        String alphabet = "ABCDEFGHJKLMNPQRSTUVWXYZS";
        String sep="/";
        String vehiclenamesubstring = env.getProperty("vehiclenamesubstring");
        rand = rand + vehiclenamesubstring + sep;
        for (int i = 0; i < 4; i++) {
            rand = rand + alphabet.charAt(r.nextInt(alphabet.length()));
        }
        rand = rand + sep;
        for(int j=0;j<5;j++){
            rand = rand + num.charAt(r.nextInt(num.length()));
        }
        return rand.trim();
    }
}
