package br.com.filipe.nac_simulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class AvatarActivity extends AppCompatActivity {

    private TextView tvLogin;
    private TextView tvNome;
    private TextView tvTipo;
    private EditText etNome;
    private EditText etTipo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar);

        tvLogin = (TextView) findViewById(R.id.tvLogin);
        tvNome = (TextView) findViewById(R.id.tvNome);
        tvTipo = (TextView) findViewById(R.id.tvTipo);
        etNome = (EditText) findViewById(R.id.etNome);
        etTipo = (EditText) findViewById(R.id.etTipo);
    }

    public void salvar(){

    }
}
