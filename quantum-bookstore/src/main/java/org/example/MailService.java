package org.example;

public class MailService {


    public static void sendEBook(EBook book, String email) {
        System.out.printf("""
                Quantum book store: Sending E-Book '%s' (File type: %s) to email: %s
                %n""", book.getTitle(), book.getFileType(), email
        );
    }


}
