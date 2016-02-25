package fr.emn.jgobley_books;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable{

    public final String isbn;
    public final String title;
    public final String author;
    public final float price;
    public final String coverURL;

    public Book(String isbn, String title, String author, float price, String coverURL) {
        this.isbn = isbn != null ? isbn : "";
        this.title = title != null ? title : "";
        this.author = author != null ? author : "";
        this.price = price;
        this.coverURL = coverURL != null ? coverURL : "";
    }

    protected Book(Parcel in) {
        isbn = in.readString();
        title = in.readString();
        author = in.readString();
        price = in.readFloat();
        coverURL = in.readString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (Float.compare(book.price, price) != 0) return false;
        return title.equals(book.title) && author.equals(book.author) && isbn.equals(book.isbn);

    }


    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(isbn);
        dest.writeString(title);
        dest.writeString(author);
        dest.writeFloat(price);
        dest.writeString(coverURL);
    }
}
