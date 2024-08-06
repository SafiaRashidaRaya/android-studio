package com.synx.konversisuhu;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    EditText etNilai;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        load();
    }

    public void load(){
        spinner = findViewById(R.id.spinner);
        etNilai = findViewById(R.id.etNilai);
        tvHasil = findViewById(R.id.tvHasil);
    }
/*
    public void  isiSpinner(){
        String[] isi= {"Celcius to Reamur", "Celcius to Fahrenheit", "Celcius to Kelvin"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, isi);
        spinner.setAdapter(adapter);
    }
*/
    public void btnKonversi(View view) {
        String pilihan = spinner.getSelectedItem().toString();

        if (etNilai.getText().toString().equals("")){
            Toast.makeText(this, "Nilai tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }else {
            if (pilihan.equals("Celsius to Reamur")){
                cToR();
            }
            if (pilihan.equals("Celsius to Fahrenheit")){
                cToF();
            }
            if (pilihan.equals("Celsius to Kelvin")){
                cToK();
            }
            if (pilihan.equals("Reamur to Celsius")){
                rToC();
            }
            if (pilihan.equals("Reamur to Fahrenheit")){
                rToF();
            }
        }
    }

    public void cToR(){
        double suhu = Double.parseDouble(etNilai.getText().toString());
        double hasil =(4.0/5.0)*suhu;
        tvHasil.setText(hasil+"");
    }

    public void cToF(){
        double suhu = Double.parseDouble(etNilai.getText().toString());
        double hasil = suhu * (9.0/5.0) + 32;
        tvHasil.setText(hasil+"");
    }

    public void cToK(){
        double suhu = Double.parseDouble(etNilai.getText().toString());
        double hasil = suhu + 273.15;
        tvHasil.setText(hasil+"");
    }

    public void rToC(){
        double suhu = Double.parseDouble(etNilai.getText().toString());
        double hasil = suhu / 0.8;
        tvHasil.setText(hasil+"");
    }

    public void rToF(){
        double suhu = Double.parseDouble(etNilai.getText().toString());
        double hasil = suhu * (9.0/4.0) + 32;
        tvHasil.setText(hasil+"");
    }

}