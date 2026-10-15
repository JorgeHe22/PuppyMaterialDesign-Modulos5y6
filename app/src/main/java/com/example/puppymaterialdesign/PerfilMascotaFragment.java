package com.example.puppymaterialdesign;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
public class PerfilMascotaFragment extends Fragment {
  @Nullable @Override public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup parent,@Nullable Bundle saved){
    return inflater.inflate(R.layout.fragment_perfil_mascota,parent,false);
  }
  @Override public void onViewCreated(@NonNull View view,@Nullable Bundle saved){
    RecyclerView grid=view.findViewById(R.id.recyclerFotos);
    grid.setLayoutManager(new GridLayoutManager(requireContext(),2));
    grid.setNestedScrollingEnabled(false);
    grid.setAdapter(new FotosAdapter(FotosDataSet.deMilo()));
  }
}
