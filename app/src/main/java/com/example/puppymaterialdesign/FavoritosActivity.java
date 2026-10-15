package com.example.puppymaterialdesign;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.MaterialToolbar;

/** Pantalla de demostración: muestra exactamente cinco mascotas de prueba. */
public class FavoritosActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);
        MaterialToolbar toolbar = findViewById(R.id.toolbarFavoritos);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        RecyclerView lista = findViewById(R.id.recyclerFavoritos);
        lista.setLayoutManager(new LinearLayoutManager(this));
        lista.setAdapter(new MascotaAdapter(MascotasDataSet.cincoFavoritasDummy(), false));
    }

    @Override public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
