package fr.emn.jgobley_books;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class LibraryActivity extends AppCompatActivity {

    public final String BOOKS = "books";
    public final String apiUrl = "http://henri-potier.xebia.fr/";
    private ArrayList<Book> books;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        listView = (ListView) findViewById(R.id.bookListView);

        books = new ArrayList<Book>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(apiUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        HenriPotierService service = retrofit.create(HenriPotierService.class);

        Call<List<Book>> call = service.listBooks();

        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Response<List<Book>> response, Retrofit retrofit) {
                // TODO success
                for (Book book : response.body()) {
                    books.add(book);
                }
                listView.setAdapter(new BookAdapter(LibraryActivity.this, books));
            }

            @Override
            public void onFailure(Throwable t) {
                // TODO error occurred
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outstate){
        outstate.putParcelableArrayList(BOOKS, books);
        super.onSaveInstanceState(outstate);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        books = savedInstanceState.getParcelableArrayList(BOOKS);
    }

    /*private List<Book> getBooks() {
        ArrayList<Book> books = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            books.add(new Book(null, String.format("Garry Potier Tome %d", i), "J.K. Rowling", 10, "http://henri-potier.xebia.fr/hp0.jpg"));
        }
        return books;
    }*/
}
