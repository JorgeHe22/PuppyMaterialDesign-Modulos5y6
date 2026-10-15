package com.example.puppymaterialdesign;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
public class MascotasFragment extends Fragment {
  @Nullable @Override public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup parent,@Nullable Bundle saved){
    return inflater.inflate(R.layout.fragment_mascotas,parent,false);
  }
  @Override public void onViewCreated(@NonNull View view,@Nullable Bundle saved){
    RecyclerView list=view.findViewById(R.id.recyclerMascotas);
    list.setLayoutManager(new LinearLayoutManager(requireContext()));
    list.setAdapter(new MascotaAdapter(MascotasDataSet.todas(),true));
  }
}
