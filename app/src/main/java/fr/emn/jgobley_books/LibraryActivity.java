package fr.emn.jgobley_books;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class LibraryActivity extends AppCompatActivity {

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }*/

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
        for (int i = 0; i < 1; i++) {
            books.add(new Book(null, String.format("Garry Potier Tome %d", i), "J.K. Rowling", 10, "http://henri-potier.xebia.fr/hp0.jpg"));
        }
        return books;
    }
}
