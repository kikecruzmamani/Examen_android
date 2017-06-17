package com.example.pckike.examen_android;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by PCkike on 15/06/2017.
 */

public class LoginActivity extends AppCompatActivity {

    private TextView tvUnifranz;
    private Animation animacion;
    private TextView tvSitio;
    private Button btIngresa;
    private EditText etUsuario;
    private EditText etContraseña;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        tvUnifranz = (TextView) findViewById(R.id.tvUnifranz);
        btIngresa = (Button) findViewById(R.id.btIngresa);
        tvSitio = (TextView) findViewById(R.id.tvSitio);

        etUsuario = (EditText) findViewById(R.id.etUsuario);
        etContraseña = (EditText) findViewById(R.id.etContraseña);


        btIngresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingresa();
            }
        });
        tvSitio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sitio();
            }
        });

        init();
    }
    public void sitio() {
        intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.unifranz.edu.bo"));
        startActivity(intent);
    }

    private void ingresa() {
        intent = new Intent(
                getApplicationContext(),
                MainActivity.class);
        startActivity(intent);
    }

    public void init() {
        etUsuario.setText("");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 2) {
            if (resultCode == RESULT_OK) {
                String resultado = data.getStringExtra("respuesta").toString();
                Toast.makeText(
                        getApplicationContext(),
                        "Respuesta: " + resultado,
                        Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(
                        getApplicationContext(),
                        "Se cancelo la respuesta.",
                        Toast.LENGTH_LONG).show();
            }
        }
    }

}
