package com.example.wordcounter;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextInput;
    private Spinner spinnerCountType;
    private Button buttonCount;
    private TextView textViewResult;

    private TextCounter textCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextInput = findViewById(R.id.editTextInput);
        spinnerCountType = findViewById(R.id.spinnerCountType);
        buttonCount = findViewById(R.id.buttonCount);
        textViewResult = findViewById(R.id.textViewResult);

        textCounter = new TextCounter();

        buttonCount.setOnClickListener(view -> {

            String text = editTextInput.getText().toString();

            if (text.trim().isEmpty()) {
                Toast.makeText(
                        MainActivity.this,
                        R.string.empty_text,
                        Toast.LENGTH_SHORT
                ).show();
                return;
            }

            int result;

            if (spinnerCountType.getSelectedItemPosition() == 0) {
                result = textCounter.countWords(text);
            } else {
                result = textCounter.countCharacters(text);
            }

            textViewResult.setText(
                    getString(R.string.result_format, result)
            );
        });
    }
}