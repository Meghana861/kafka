package com.amzur.books

import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable

import java.time.LocalDate
@Introspected
@Serdeable
class Book {
    String title
    String author
    int price
    LocalDate pubDate

    Book(String title, String author, int price, LocalDate pubDate){
        this.title=title
        this.author=author
        this.price=price
        this.pubDate=pubDate
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", pubDate=" + pubDate +
                '}';
    }
}
