package com.skylark.swap_checker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText textField1;
    private EditText textField2;
    private Button swapButton;
    private Button checkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textField1 = findViewById(R.id.textField1);
        textField2 = findViewById(R.id.textField2);
        swapButton = findViewById(R.id.swapButton);
        checkButton = findViewById(R.id.checkButton);

        swapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = textField1.getText().toString();
                textField1.setText(textField2.getText().toString());
                textField2.setText(temp);
            }
        });

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textField1.getText().toString().equals(textField2.getText().toString())) {
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("result", "SAME");
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("result", "NOT THE SAME");
                    startActivity(intent);
                }
            }
        });
    }
}