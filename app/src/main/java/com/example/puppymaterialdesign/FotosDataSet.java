package com.example.puppymaterialdesign;
import java.util.Arrays;
import java.util.List;
public final class FotosDataSet {
 private FotosDataSet(){}
 public static List<FotoMascota> deMilo(){return Arrays.asList(
  new FotoMascota(R.drawable.milo_01,5),new FotoMascota(R.drawable.milo_02,4),
  new FotoMascota(R.drawable.milo_03,3),new FotoMascota(R.drawable.milo_04,5),
  new FotoMascota(R.drawable.milo_05,2),new FotoMascota(R.drawable.milo_06,4));}
}
