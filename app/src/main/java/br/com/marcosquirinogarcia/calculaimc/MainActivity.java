package br.com.marcosquirinogarcia.calculaimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imageViewBackground;
    Button buttonCalcular;
    Button buttonLimpar;
    EditText editTextPeso;
    EditText editTextAltura;
    TextView textViewResultado;
    TextView textViewImcIdeal;
    Float imc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewBackground = findViewById(R.id.imageView_main);
        buttonCalcular = findViewById(R.id.button_calcular);
        buttonLimpar = findViewById(R.id.button_limpar);
        editTextPeso = findViewById(R.id.editText_peso);
        editTextAltura = findViewById(R.id.editTextText_altura);
        textViewResultado = findViewById(R.id.textView_resultado);
        textViewImcIdeal = findViewById(R.id.textView_imc_ideal);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!editTextAltura.getText().toString().isEmpty() && !editTextPeso.getText().toString().isEmpty()){

                    imageViewBackground.setVisibility(View.INVISIBLE);
                    editTextAltura.setVisibility(View.INVISIBLE);
                    editTextPeso.setVisibility(View.INVISIBLE);
                    buttonCalcular.setVisibility(View.INVISIBLE);
                    buttonLimpar.setVisibility(View.VISIBLE);

                    textViewResultado.setVisibility(View.VISIBLE);
                    textViewImcIdeal.setVisibility(View.VISIBLE);

                    textViewResultado.setText("IMC = " + calculaImc());

                    textViewImcIdeal.setText(classificaImc());


                }
                else {
                    Toast.makeText(MainActivity.this, "Insira o peso e altura!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        buttonLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imageViewBackground.setVisibility(View.VISIBLE);
                editTextAltura.setVisibility(View.VISIBLE);
                editTextPeso.setVisibility(View.VISIBLE);
                buttonCalcular.setVisibility(View.VISIBLE);

                buttonLimpar.setVisibility(View.INVISIBLE);
                textViewResultado.setVisibility(View.INVISIBLE);
                textViewImcIdeal.setVisibility(View.INVISIBLE);

                editTextAltura.setText("");
                editTextPeso.setText("");

            }
        });
    }

    public float calculaImc(){
        float peso = Float.parseFloat(editTextPeso.getText().toString());
        float altura = Float.parseFloat(editTextAltura.getText().toString());
        float imcTemp = peso / (altura * altura);

        String result = String.valueOf(imcTemp).substring(4,6);

        imc = Float.parseFloat(result);
        return imc;

    }

    public String classificaImc(){

        String resultClassificaImc = "";

        if (imc < 18.5){
            resultClassificaImc = "Abaixo do peso";
        }
        if (imc > 18.5 && imc < 24.9){
            resultClassificaImc = "Peso normal";
        }
        if (imc >= 25 && imc <=34.9){
            resultClassificaImc = "Obesidade Grau I";
        }
        if (imc >= 35 && imc <=39.9){
            resultClassificaImc = "Obesidade Grau II";
        }
        if (imc > 40){
            resultClassificaImc = "Obesidade Grau III";
        }

        return resultClassificaImc;
    }

}