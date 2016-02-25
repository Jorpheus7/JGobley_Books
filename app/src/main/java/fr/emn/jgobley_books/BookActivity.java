package fr.emn.jgobley_books;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class BookActivity extends AppCompatActivity {

    private static final String BOOK = "BOOK";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        Intent intent = getIntent();
        Book book = intent.getParcelableExtra(BOOK);

        if(book.title != null && !book.title.equals("")) {
            TextView detailTitleTextView = (TextView) findViewById(R.id.detailTitleTextView);
            detailTitleTextView.setText(book.title);
        }

        if(book.author != null && !book.author.equals("")) {
            TextView detailAuthorTextView = (TextView) findViewById(R.id.detailAuthorTextView);
            detailAuthorTextView.setText(book.author);
        }

        if(book.price != 0) {
            TextView detailPriceTextView = (TextView) findViewById(R.id.detailPriceTextView);
            detailPriceTextView.setText(Float.toString(book.price));
        }

        if(book.isbn != null && !book.isbn.equals("")) {
            TextView detailIsbnTextView = (TextView) findViewById(R.id.detailIsbnTextView);
            detailIsbnTextView.setText(book.isbn);
        }

        if(book.coverURL != null && !book.coverURL.equals("")) {
            ImageView detailCoverImageView = (ImageView) findViewById(R.id.detailCoverImageView);
            Picasso.with(this)
                    .load(book.coverURL)
                    .into(detailCoverImageView);
        }


    }

}
