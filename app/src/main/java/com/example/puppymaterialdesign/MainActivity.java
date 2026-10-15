package com.example.puppymaterialdesign;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
  @Override protected void onCreate(Bundle state) {
    super.onCreate(state);
    setContentView(R.layout.activity_main);
    MaterialToolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    ViewPager2 pager = findViewById(R.id.pagerMascotas);
    pager.setAdapter(new ViewPagerAdapter(this));
    TabLayout tabs = findViewById(R.id.tabsMascotas);
    new TabLayoutMediator(tabs,pager,(tab,position)->
      tab.setText(position==0?"Mascotas":"Perfil de Milo")
    ).attach();
  }
  @Override public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_principal,menu);return true;
  }
  @Override public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    int id=item.getItemId();
    if(id==R.id.actionFavoritos){startActivity(new Intent(this,FavoritosActivity.class));return true;}
    if(id==R.id.actionContacto){startActivity(new Intent(this,ContactoActivity.class));return true;}
    if(id==R.id.actionAcerca){startActivity(new Intent(this,AcercaDeActivity.class));return true;}
    return super.onOptionsItemSelected(item);
  }
}
