package ru.puchkova.homework721;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intent = new Intent(Intent.ACTION_VIEW);

        editText = findViewById(R.id.editText);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String address = "geo:";
                Uri uri;
                String input = editText.getText().toString();
                char text = input.charAt(1);
                if (Character.isLetter(text)) {
                    address = address + "?q=" + input;
                } else {
                    address = address + input;
                }
                uri = Uri.parse(address);
                intent.setData(uri);
                startActivity(intent);
            }
        });


    }
}
