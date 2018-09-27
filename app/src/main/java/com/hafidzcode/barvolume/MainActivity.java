package com.hafidzcode.barvolume;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//todo 2 implementasi listener untuk melakukan proses event klik pada komponen tombol (button)
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //todo 8
    //setelah menghitung luas dan kemudian terjadi pergantian orientasi pada device maka hasil perhitungan akan hilang, maka tambahkan beberapa baris berikut
    private static final String STATE_HASIL = "state_hasil";
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_HASIL, tvResult.getText().toString());
    }

    //todo 3 deklarasi semua komponen view
    private EditText edtWidth,edtHeight,edtLength;
    private Button btnCalculate;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Maksud baris dibawah adalah bahwa kelas MainActivity akan menampilkan tampilan yang berasal dari layout activity_main.xml
        setContentView(R.layout.activity_main);
        //todo 4 inisialisasi komponen view
        //Maksud dari baris dibawah adalah obyek EditText edtWidth disesuaikan (Cast) dengan komponen EditText ber-ID edt_width di layout xml melalui method findViewById()
        edtWidth = (EditText) findViewById(R.id.edt_width);
        edtLength = (EditText) findViewById(R.id.edt_lengt);
        edtHeight = (EditText) findViewById(R.id.edt_height);
        btnCalculate = (Button) findViewById(R.id.btn_calculate);
        tvResult = (TextView) findViewById(R.id.tv_result);

        //event click
        //Event Click Listener untuk obyek btnCalculate sehingga dapat melakukan sebuah aksi ketika pengguna melakukan Klik
        //Keyword this menekankan pada obyek Activity saat ini yang telah mengimplementasikan listener OnClickListener sebelumnya.
        btnCalculate.setOnClickListener(this);

        //todo 9
        if (savedInstanceState !=null){
            String hasil = savedInstanceState.getString(STATE_HASIL);
            tvResult.setText(hasil);
        }
    }

    //todo 5
    //hasil dari implementasi listener diatas adalah method void onClick(View)
    @Override
    public void onClick(View view) { // <- method void onClick(View)
        if (view.getId() == R.id.btn_calculate){
            String length = edtLength.getText().toString().trim();
            String height = edtWidth.getText().toString().trim();
            String width = edtWidth.getText().toString().trim();
            //todo 6
            boolean isEmptyFields = false;
            if (TextUtils.isEmpty(length)){
                isEmptyFields = true;
                edtLength.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(height)){
                isEmptyFields = true;
                edtHeight.setError("silahkan diisi terlebih dahulu ya ukhti/akhi! ");
            }
            if (TextUtils.isEmpty(width)){
                isEmptyFields = true;
                edtWidth.setError("jangan kosong bro!");

            }
            //todo 7
            if (!isEmptyFields){
                double l = Double.parseDouble(length);
                double w = Double.parseDouble(width);
                double h = Double.parseDouble(height);
                double volume = l*w*h;
                tvResult.setText(String.valueOf(volume));
            }

        }

    }
}
