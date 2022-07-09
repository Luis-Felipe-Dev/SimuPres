package simuladorprestamos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.simupres.R;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText importe, interes, tiempo;
    TextView salida;
    Button calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        String usuario = getIntent().getStringExtra("Usuario");
//        String contrasenia = getIntent().getStringExtra("Contraseña");
//        Toast.makeText(this, "Usuario " + usuario + "\n"
//                + "Contraseña " + contrasenia, Toast.LENGTH_SHORT).show();
        importe = (EditText) findViewById(R.id.edtImporte);
        interes = (EditText) findViewById(R.id.edtInteres);
        tiempo = (EditText) findViewById(R.id.edtTiempo);
        salida = (TextView) findViewById(R.id.txvSalida);
        calcular = (Button) findViewById(R.id.btnCalcular);
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float importe_total, interes_anual, tiempo_plazos;
                double porcentaje_mensual, cuota;

                importe_total = Float.parseFloat(importe.getText().toString());
                interes_anual = Float.parseFloat(interes.getText().toString()) / 100;
                tiempo_plazos = Float.parseFloat(tiempo.getText().toString());
                porcentaje_mensual = Math.pow(1 + interes_anual, 1d / 12d) - 1;

                cuota = (importe_total * (porcentaje_mensual * Math.pow((1 + porcentaje_mensual), tiempo_plazos))) /
                        ((Math.pow((1 + porcentaje_mensual), tiempo_plazos)) - 1);

                DecimalFormat formato_decimal = new DecimalFormat("#.00");

                salida.setText("Cuota mensual: " + formato_decimal.format(cuota) + "\n" + "\n" +
                        "Interés total: " + formato_decimal.format((cuota * 72) - importe_total) + "\n" + "\n" +
                        "Monto total a pagar: " + formato_decimal.format(cuota * 72));
                limpiarCampos();
            }
        });
    }

    public void limpiarCampos() {
        importe.getText().clear();
        interes.getText().clear();
        tiempo.getText().clear();
    }
}