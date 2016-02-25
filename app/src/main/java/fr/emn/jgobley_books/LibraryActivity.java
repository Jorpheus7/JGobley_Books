package fr.emn.jgobley_books;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class LibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        List<Book> books = getBooks();

        ListView listView = (ListView) findViewById(R.id.bookListView);
        listView.setAdapter(new BookAdapter(LibraryActivity.this, books));
    }

    @Override
    protected void onSaveInstanceState(Bundle outstate){
        // TODO save state with outstate.put...
        super.onSaveInstanceState(outstate);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        // TODO restore state with savedInstanceState.get...
    }

    private List<Book> getBooks() {
        ArrayList<Book> books = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            books.add(new Book(null, String.format("Garry Potier Tome %d", i), "J.K. Rowling", 10, "http://henri-potier.xebia.fr/hp0.jpg"));
        }
        return books;
    }
}
