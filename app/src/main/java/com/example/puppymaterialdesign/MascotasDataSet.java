package com.example.puppymaterialdesign;

import java.util.ArrayList;
import java.util.List;

/** Dataset hardcodeado para la actividad del módulo 3. */
public final class MascotasDataSet {
    private MascotasDataSet() { }

    public static List<Mascota> todas() {
        List<Mascota> mascotas = new ArrayList<>();
        mascotas.add(new Mascota(1, "Milo", "Golden retriever", "🐕", 28));
        mascotas.add(new Mascota(2, "Luna", "Gatita mestiza", "🐈", 17));
        mascotas.add(new Mascota(3, "Rocky", "Bulldog francés", "🐶", 35));
        mascotas.add(new Mascota(4, "Nala", "Gatita persa", "🐱", 22));
        mascotas.add(new Mascota(5, "Toby", "Beagle", "🐕", 31));
        mascotas.add(new Mascota(6, "Kira", "Husky siberiano", "🐺", 14));
        mascotas.add(new Mascota(7, "Coco", "Conejito", "🐰", 12));
        return mascotas;
    }

    /** La segunda pantalla tiene cinco elementos de prueba, no votos reales aún. */
    public static List<Mascota> cincoFavoritasDummy() {
        List<Mascota> lista = todas();
        return new ArrayList<>(lista.subList(0, 5));
    }
}
