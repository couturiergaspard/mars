package fr.ubx.poo.td2.view;

import fr.ubx.poo.td2.model.Position;

public class World {
    public static final int EMPTY = 0;
    public static final int ROCK  = 1;
    public static final int DUST  = 2;
    int [][] tab;

    public World(int width, int height) {
        int [][] tab = new int [width][height];
    }

    public int get(Position position) {
        return tab[position.x()][position.y()];
    }

    public void set(Position position, int kind) {
        tab[position.x()][position.y()] = kind;
    }
}