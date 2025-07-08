package org.example;

import java.time.Year;

public class EBook extends Book implements Purchasable {
    private String fileType;

    public EBook(
        String isbn,
        String title,
        Year year,
        double price,
        String fileType
    ) {
        super(isbn, title, year, price);
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    @Override
    public void processPurchase(int quantity, String email, String address) {
        MailService.sendEBook(this, email);
    }

    @Override
    public String getBookType() {
        return "E-Book";
    }

    @Override
    public String toString() {
        return String.format("EBook{isbn='%s', title='%s', year=%s, price=%.2f, fileType='%s'}",
                           isbn, title, year, price, fileType);
    }
}
