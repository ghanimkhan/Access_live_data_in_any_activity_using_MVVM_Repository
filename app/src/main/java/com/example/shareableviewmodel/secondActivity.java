package com.example.shareableviewmodel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class secondActivity extends AppCompatActivity {
    private sharedViewModel viewModel;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        editText = findViewById(R.id.edit_text);
        Button button = findViewById(R.id.button_ok);
        TextView textView2=findViewById(R.id.textView2);

        viewModel = new ViewModelProvider(this).get(sharedViewModel.class);
        viewModel.init();

        //when oncreate is called changes reflect (not live)
        textView2.setText(""+viewModel.getProgress().getValue());


        //observe change data love due to  Observer(continous change)
        viewModel.getText().observe(this, new Observer<CharSequence>() {
            @Override
            public void onChanged(@Nullable CharSequence charSequence) {
                editText.setText(charSequence);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                viewModel.setText(editText.getText());
                viewModel.setText(editText.getText());


            }
        });
    }
}