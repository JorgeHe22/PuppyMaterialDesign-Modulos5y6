package com.example.puppymaterialdesign;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.MaterialToolbar;
public class AcercaDeActivity extends AppCompatActivity {
 @Override protected void onCreate(Bundle state){super.onCreate(state);
  setContentView(R.layout.activity_acerca_de);
  MaterialToolbar toolbar=findViewById(R.id.toolbarAcerca);setSupportActionBar(toolbar);
  if(getSupportActionBar()!=null)getSupportActionBar().setDisplayHomeAsUpEnabled(true);
 }
 @Override public boolean onOptionsItemSelected(@NonNull MenuItem item){
  if(item.getItemId()==android.R.id.home){finish();return true;}return super.onOptionsItemSelected(item);
 }
}
