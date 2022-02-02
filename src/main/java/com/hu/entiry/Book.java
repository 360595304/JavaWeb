package com.hu.entiry;

/**
 * @author suhu
 * @createDate 2021/11/21
 */
public class Book {
    private int id;
    private String name;
    private String author;
    private double price;
    private String press;
    private String isbn;
    private String intro;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", press='" + press + '\'' +
                ", isbn='" + isbn + '\'' +
                ", intro='" + intro + '\'' +
                '}';
    }

    public Book(int id, String name, String author, double price, String press, String isbn, String intro) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.press = press;
        this.isbn = isbn;
        this.intro = intro;
    }
}
