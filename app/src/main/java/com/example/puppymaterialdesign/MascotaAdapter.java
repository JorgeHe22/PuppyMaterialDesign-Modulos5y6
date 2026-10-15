package com.example.puppymaterialdesign;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder> {
    private final List<Mascota> mascotas;
    private final boolean permitirVotos;

    public MascotaAdapter(List<Mascota> mascotas, boolean permitirVotos) {
        this.mascotas = mascotas;
        this.permitirVotos = permitirVotos;
    }

    @NonNull @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View fila = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_mascota, parent, false);
        return new MascotaViewHolder(fila);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder holder, int position) {
        Mascota mascota = mascotas.get(position);
        holder.nombre.setText(mascota.getNombre());
        holder.raza.setText(mascota.getRaza());
        holder.emoji.setText(mascota.getEmoji());
        holder.puntos.setText(String.valueOf(mascota.getCalificacion()));
        holder.botonVotar.setVisibility(permitirVotos ? View.VISIBLE : View.GONE);
        holder.botonVotar.setEnabled(!mascota.isMeGusta());
        holder.botonVotar.setAlpha(mascota.isMeGusta() ? 0.45f : 1f);
        holder.botonVotar.setContentDescription(mascota.isMeGusta() ? "Ya votaste por " + mascota.getNombre() : "Votar por " + mascota.getNombre());
        holder.botonVotar.setOnClickListener(v -> {
            if (mascota.votar()) {
                notifyItemChanged(holder.getBindingAdapterPosition());
                Toast.makeText(v.getContext(), "¡Te gusta " + mascota.getNombre() + "!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override public int getItemCount() { return mascotas.size(); }

    static class MascotaViewHolder extends RecyclerView.ViewHolder {
        final TextView nombre, raza, emoji, puntos;
        final ImageButton botonVotar;
        MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.txtNombreMascota);
            raza = itemView.findViewById(R.id.txtRazaMascota);
            emoji = itemView.findViewById(R.id.txtEmojiMascota);
            puntos = itemView.findViewById(R.id.txtPuntos);
            botonVotar = itemView.findViewById(R.id.btnHueso);
        }
    }
}
