package edu.school_21.cinema.repositories;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class UpdatableBCrypt {
    private static int workload = 12;

    public static String hashPassword(String password_plaintext) {
        String salt = BCrypt.gensalt(workload);
        String hashed_password = BCrypt.hashpw(password_plaintext, salt);

        return(hashed_password);
    }


    public static boolean checkPassword(String password_plaintext, String stored_hash) {
        boolean password_verified = false;
        if(null == stored_hash || !stored_hash.startsWith("$2a$"))
            throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");

        password_verified = BCrypt.checkpw(password_plaintext, stored_hash);
//        System.out.println();
        return(password_verified);
    }
    }
