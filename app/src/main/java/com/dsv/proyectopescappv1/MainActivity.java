package com.dsv.proyectopescappv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btningresar, btomitir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btningresar=(Button)findViewById(R.id.btningresar);
        btomitir=(findViewById(R.id.btomitir));

        btningresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent( MainActivity.this, MainActivity2.class);
                startActivity(i);
            }

        });

        btomitir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent( MainActivity.this, MainActivity2.class);
                startActivity(i);
            }
        });
    }
}