package fr.emn.jgobley_books;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class BookItemView extends LinearLayout {

    private ImageView coverImageView;
    private TextView titleTextView;
    private TextView authorTextView;
    private TextView priceTextView;
    private RelativeLayout bookLayout;
    private Context context;

    private static final String BOOK = "BOOK";

    public BookItemView(Context context) {
        this(context, null);
        this.context = context;
    }

    public BookItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        this.context = context;
    }

    public BookItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        // TODO findViewById()
        bookLayout = (RelativeLayout) findViewById(R.id.bookLayout);
        coverImageView = (ImageView) findViewById( R.id.coverImageView);
        titleTextView = (TextView) findViewById(R.id.titleTextView);
        authorTextView = (TextView) findViewById(R.id.authorTextView);
        priceTextView = (TextView) findViewById(R.id.priceTextView);

    }

    public void bindView(final Book book) {
        // TODO setText()
        if(book.coverURL != null && ! book.coverURL.equals("")) {
            Picasso.with(context)
                    .load(book.coverURL)
                    .into(coverImageView);
        }
        titleTextView.setText(book.title);
        if(book.author != null)
            authorTextView.setText(book.author);
        if(book.price != 0)
            priceTextView.setText(String.valueOf(book.price));

        bookLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BookActivity.class);
                intent.putExtra(BOOK, book);
                context.startActivity(intent);
            }
        });
    }
}
