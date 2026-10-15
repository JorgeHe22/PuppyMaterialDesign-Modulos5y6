package com.example.puppymaterialdesign;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
public class FotosAdapter extends RecyclerView.Adapter<FotosAdapter.FotoViewHolder>{
 private final List<FotoMascota> datos;
 public FotosAdapter(List<FotoMascota> datos){this.datos=datos;}
 @NonNull @Override public FotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType){
  return new FotoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_foto_mascota,parent,false));
 }
 @Override public void onBindViewHolder(@NonNull FotoViewHolder holder,int position){
  FotoMascota foto=datos.get(position);
  holder.imagen.setImageResource(foto.getImagen());
  holder.votos.setText(foto.getVotos()+" huesos");
 }
 @Override public int getItemCount(){return datos.size();}
 static class FotoViewHolder extends RecyclerView.ViewHolder{
  ImageView imagen;TextView votos;
  FotoViewHolder(View item){super(item);imagen=item.findViewById(R.id.imagenFotoMascota);votos=item.findViewById(R.id.textoRatingFoto);}
 }
}
