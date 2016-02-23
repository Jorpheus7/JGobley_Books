package fr.emn.jgobley_books;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class BookItemView extends LinearLayout {

    private TextView nameTextView;
    private TextView priceTextView;

    public BookItemView(Context context) {
        this(context, null);
    }

    public BookItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BookItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        // TODO findViewById()
        nameTextView = (TextView) findViewById(R.id.nameTextView);
        priceTextView = (TextView) findViewById(R.id.priceTextView);

        nameTextView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), nameTextView.getText(), Toast.LENGTH_LONG).show();
            }
        });

    }

    public void bindView(Book book) {
        // TODO setText()
        nameTextView.setText(book.name);
        priceTextView.setText(String.valueOf(book.price));
    }
}
