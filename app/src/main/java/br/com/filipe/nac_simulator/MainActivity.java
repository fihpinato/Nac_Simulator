package br.com.filipe.nac_simulator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText etLogin;
    private EditText etSenha;
    private TextView tvTeste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLogin = (EditText) findViewById(R.id.etLogin);
        etSenha = (EditText) findViewById(R.id.etSenha);
        tvTeste = (TextView) findViewById(R.id.tvTeste);
    }

    public void login(View v){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://fiapgameapi.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FiapGameAPI service = retrofit.create(FiapGameAPI.class);

        service.buscarUsuario(etLogin.getText().toString(), etSenha.getText().toString())
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if(response.isSuccessful()) {
                            Intent i = new Intent(MainActivity.this, AvatarActivity.class);
                            i.putExtra("USUARIO", etLogin.getText().toString());
                            startActivity(i);
                        } else {
                            Toast.makeText(MainActivity.this, "Você ainda não tem conta", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Sem Conexão", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void criarConta(View v){

    }
}
