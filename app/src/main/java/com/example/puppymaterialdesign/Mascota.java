package com.example.puppymaterialdesign;

/** Modelo de datos de una mascota mostrado en el RecyclerView. */
public class Mascota {
    private final int id;
    private final String nombre;
    private final String raza;
    private final String emoji;
    private int calificacion;
    private boolean meGusta;

    public Mascota(int id, String nombre, String raza, String emoji, int calificacion) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.emoji = emoji;
        this.calificacion = calificacion;
        this.meGusta = false;
    }
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getRaza() { return raza; }
    public String getEmoji() { return emoji; }
    public int getCalificacion() { return calificacion; }
    public boolean isMeGusta() { return meGusta; }

    /** Evita que una mascota reciba más de un voto en la misma sesión. */
    public boolean votar() {
        if (meGusta) return false;
        meGusta = true;
        calificacion += 1;
        return true;
    }
}
