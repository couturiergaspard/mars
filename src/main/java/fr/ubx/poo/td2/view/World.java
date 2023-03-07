package fr.ubx.poo.td2.view;

import fr.ubx.poo.td2.model.Position;

public class World {
    public static final int EMPTY = 0;
    public static final int ROCK  = 1;
    public static final int DUST  = 2;
    int [][] tab;
    int percentageRock;
    int percentageDust;

    public World(int width, int height, int percentageRock, int percentageDust) {
        this.tab = new int [width][height];
        this.percentageRock = (int)((height*width) * ((double)percentageRock/100));
        this.percentageDust = (int)((height*width) * ((double)percentageDust/100));
    }

    public int get(Position position) {
        return tab[position.x()][position.y()];
    }

    public void set(Position position, int kind) {
        tab[position.x()][position.y()] = kind;
    }
}