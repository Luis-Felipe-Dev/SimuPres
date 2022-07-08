package simuladorprestamos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.simupres.R;

public class Login extends AppCompatActivity {
    EditText usuario, contrasenia;
    Button ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usuario = (EditText) findViewById(R.id.edtUsuario);
        contrasenia = (EditText) findViewById(R.id.edtConstraseña);
        ingresar = findViewById(R.id.btnIngresar);
    }

    public void ingresar(View view) {
        if (usuario.getText().toString().equals("isil") && contrasenia.getText().toString().equals("123456")) {
            Toast.makeText(Login.this, "Datos Correctos", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("Usuario", usuario.getText().toString());
            intent.putExtra("Constraseña", contrasenia.getText().toString());
            startActivity(intent);
        } else {
            Toast.makeText(Login.this, "Datos erroneos", Toast.LENGTH_SHORT).show();
        }
    }
}