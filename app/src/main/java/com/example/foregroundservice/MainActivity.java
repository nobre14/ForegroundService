package com.example.foregroundservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editInput = findViewById(R.id.edt_input);
    }

    public void iniciarServico(View view) {
        String input = editInput.getText().toString();
        Intent serviceIntent = new Intent(this, ExemploService.class);
        serviceIntent.putExtra("input", input);
        startService(serviceIntent);
    }

    public void pararServico(View view) {
        Intent serviceIntent = new Intent(this, ExemploService.class);
        stopService(serviceIntent);
    }
}
