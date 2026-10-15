package com.example.puppymaterialdesign;
import android.os.Bundle;
import android.util.Patterns;
import android.view.MenuItem;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class ContactoActivity extends AppCompatActivity {
 private TextInputLayout nombreLayout,correoLayout,mensajeLayout;
 private TextInputEditText nombre,correo,mensaje;
 private Button enviar;
 @Override protected void onCreate(Bundle state){
  super.onCreate(state);setContentView(R.layout.activity_contacto);
  MaterialToolbar toolbar=findViewById(R.id.toolbarContacto);setSupportActionBar(toolbar);
  if(getSupportActionBar()!=null)getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  nombreLayout=findViewById(R.id.layoutNombre);correoLayout=findViewById(R.id.layoutCorreo);mensajeLayout=findViewById(R.id.layoutMensaje);
  nombre=findViewById(R.id.inputNombre);correo=findViewById(R.id.inputCorreo);mensaje=findViewById(R.id.inputMensaje);
  enviar=findViewById(R.id.btnEnviarComentario);
  enviar.setOnClickListener(v->enviarComentario());
 }
 private String valor(TextInputEditText e){return e.getText()==null?"":e.getText().toString().trim();}
 private void enviarComentario(){
  String n=valor(nombre),c=valor(correo),m=valor(mensaje);
  nombreLayout.setError(null);correoLayout.setError(null);mensajeLayout.setError(null);
  boolean ok=true;
  if(n.isEmpty()){nombreLayout.setError("Escribe tu nombre");ok=false;}
  if(!Patterns.EMAIL_ADDRESS.matcher(c).matches()){correoLayout.setError("Correo no válido");ok=false;}
  if(m.isEmpty()){mensajeLayout.setError("Escribe tu comentario");ok=false;}
  if(!ok)return;
  enviar.setEnabled(false);enviar.setText("Enviando...");
  CorreoHelper.enviar(n,c,m,(exito,detalle)->runOnUiThread(()->{
   enviar.setEnabled(true);enviar.setText("Enviar comentario");
   new com.google.android.material.dialog.MaterialAlertDialogBuilder(this)
     .setTitle(exito?"Comentario enviado":"No se pudo enviar")
     .setMessage(detalle).setPositiveButton("Aceptar",null).show();
   if(exito)mensaje.setText("");
  }));
 }
 @Override public boolean onOptionsItemSelected(@NonNull MenuItem item){
  if(item.getItemId()==android.R.id.home){finish();return true;}return super.onOptionsItemSelected(item);
 }
}
