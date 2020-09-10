package com.example.shareableviewmodel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private sharedViewModel viewModel;
    private EditText editText;
    SeekBar seekBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edit_text);
        Button button = findViewById(R.id.button_ok);
        Button button2=findViewById(R.id.button2);


        viewModel = new ViewModelProvider(this).get(sharedViewModel.class);
        viewModel.init();





        seekBar=(SeekBar)findViewById(R.id.seekBar);
        seekBar.setMax(20);
        seekBar.setProgress(viewModel.getProgress().getValue());//get default value
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                viewModel.setProgress(progress);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // myAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, volume_level, 0);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //myAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, volume_level, 0);

            }
        });




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
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,secondActivity.class); //or//  intent.setClass(MainActivity.this,activity2.class);
                startActivity(intent);
            }
        });
    }

}