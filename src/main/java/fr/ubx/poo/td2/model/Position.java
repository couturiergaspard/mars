package fr.ubx.poo.td2.model;

import java.util.Random;

public record Position (int x, int y){

    public static Position random(int width, int height){

        Random random = new Random();
        int r1 = random.nextInt(width);
        int r2 = random.nextInt(height);
        return new Position(r1,r2);
    }
}

