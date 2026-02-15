package com.practice.dsa.stream.entity;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Book {

    private String title;
    private String author;
    private int year;
    private double price;

    public Book(String title,String author, int year,double price) {
        this.author=author;
        this.title=title;
        this.year=year;
        this.price=price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Pen En adimai aanal","periyar",1954,120),
                new Book("Homo Sapiens","Harari",2001,150),
                new Book("The Secret","Rhonda",1997,499),
                new Book("Thaai","Karki",2002,300));

        //print books published after year 2000;
        books.stream().filter(x->x.getYear()>2000).
                map(Book::getTitle).
                forEach(x-> System.out.println("Books after Published 2000:- "+x));
        System.out.println();

        //total price of books;
        double totalPrice =books.stream().mapToDouble(Book::getPrice).sum();
        System.out.println("Total Price of Books: "+totalPrice);
        System.out.println();

        //Highest price Book;
        Book expensiveBook =books.stream().
                max(Comparator.comparingDouble(Book::getPrice)).
                orElse(null);
        System.out.println("Expensive Book: "+expensiveBook.getPrice());
        System.out.println();

        List<Book> newBooks = books.stream().
                filter(book -> book.getPrice()<300).
                collect(Collectors.toList());
        System.out.println("Price greater than 300 books list: ");
        System.out.println();
        newBooks.forEach(x->System.out.println("Title -"+x.getTitle()+"\nAuthor-"+x.getAuthor()+"\nPrice- "+x.price+"\n"));
    }
}
