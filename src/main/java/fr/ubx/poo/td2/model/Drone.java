package fr.ubx.poo.td2.model;

import static java.lang.Math.*;

public class Drone extends Vehicule {
    public Drone(String name, Position position, double energy, double cost) {
        super(name,position,energy,cost);
    }
    @Override
    public int distance(Position target) {
        int distX = (int) pow((target.x() - position.x()),2);
        int distY = (int) pow((target.y() - position.y()),2);
        return (int) sqrt(distX + distY);
    }
    @Override
    public Position[] getPathTo(Position target) {
        Position[] monTableau = new Position[1];
        monTableau[0] = new Position(target.x(), target.y());
        return monTableau;
    }

    @Override
    public String toString(){
        return "Move completed: Drone "+ this.name + " : energy=" + this.energy;
    }
}
