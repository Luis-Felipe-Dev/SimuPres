package simuladorprestamos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.simupres.R;

public class MainActivity extends AppCompatActivity {

    EditText importe, interes, tiempo;
    Button calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String usuario = getIntent().getStringExtra("Usuario");
        String contrasenia = getIntent().getStringExtra("Contraseña");
        Toast.makeText(this, "Usuario " + usuario + "\n"
                + "Contraseña " + contrasenia, Toast.LENGTH_SHORT).show();

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float impor, inter, tiem;
                impor = Float.parseFloat(importe.getText().toString());
                inter = Float.parseFloat(interes.getText().toString());
                tiem = Float.parseFloat(tiempo.getText().toString());

                if ()
            }
        });
    }
}