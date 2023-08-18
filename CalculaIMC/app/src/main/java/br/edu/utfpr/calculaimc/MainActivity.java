package br.edu.utfpr.calculaimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText etPeso;
    private EditText etAltura;
    private TextView tvResultado;
    private Button btCalcular;
    private Button btLimpar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponent();
        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btCalcularOnClick();
            }
        });

        btLimpar.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(MainActivity.this, "Limpar a tela", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }

    private void btCalcularOnClick() {
        if (etPeso.getText().toString().isEmpty()) {
            etPeso.setError("O campo peso deve ser preenchido");
            return;
        }

        if (etAltura.getText().toString().isEmpty()) {
            etAltura.setError("O campo altura deve ser preenchido");
            return;
        }

        double peso = Double.parseDouble(etPeso.getText().toString());
        double altura = Double.parseDouble(etAltura.getText().toString());

        double resultado = peso/ Math.pow(altura, 2);

        DecimalFormat df = new DecimalFormat("0.00");
        tvResultado.setText(df.format(resultado));
    }

    public void btLimparOnClick(View view) {
        etPeso.setText("");
        etAltura.setText("");
        tvResultado.setText("");
        etPeso.requestFocus();
    }

    private void initComponent() {
        etPeso = findViewById(R.id.etPeso);
        etAltura = findViewById(R.id.etAltura);
        tvResultado = findViewById(R.id.tvResultado);
        btCalcular = findViewById(R.id.btCalcular);
        btLimpar = findViewById(R.id.btLimpar);
    }


}