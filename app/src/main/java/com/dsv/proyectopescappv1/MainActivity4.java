package com.dsv.proyectopescappv1;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class MainActivity4 extends AppCompatActivity {
    EditText etPescado, etFecha, etLugarPesca;
    Button btGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        etPescado = findViewById(R.id.etPescado);
        etLugarPesca = findViewById(R.id.etLugarPesca);
        etFecha = findViewById(R.id.etFecha);
        btGuardar = findViewById(R.id.bt_guardar);

        btGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombrepez = etPescado.getText().toString();
                String lugarpesca = etLugarPesca.getText().toString();
                String fecha = etFecha.getText().toString();

                if (nombrepez.isEmpty() || lugarpesca.isEmpty() || fecha.isEmpty() ){
                    Toast.makeText(MainActivity4.this, "Ingrese Datos", Toast.LENGTH_SHORT).show();
                } else {
                    // Create a new user with a first and last name
                    Map<String, Object> pesca = new HashMap<>();
                    pesca.put("Pez", nombrepez);
                    pesca.put("Lugar", lugarpesca);
                    pesca.put("Fecha", fecha);

// Add a new document with a generated ID
                    db.collection("Pescas")
                            .add(pesca)
                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Toast.makeText(MainActivity4.this, "Datos Agregados :)!", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(MainActivity4.this, "Error al agregar datos :(!", Toast.LENGTH_SHORT).show();
                                }

                            });
                    db.collection("Pescas")
                            .get()
                            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                    if (task.isSuccessful()) {
                                        for (QueryDocumentSnapshot document : task.getResult()) {
                                            Log.d(TAG, document.getId() + " => " + document.getData());
                                        }
                                    } else {
                                        Log.d(TAG, "Error getting documents: ", task.getException());
                                    }
                                }
                            });
                }

            }
        });


    }
}