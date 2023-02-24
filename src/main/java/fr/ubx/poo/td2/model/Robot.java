package fr.ubx.poo.td2.model;

import static java.lang.Math.abs;
public class Robot extends Vehicule {
    public Robot(String name, Position position, double energy, double cost) {
        super(name,position,energy,cost);
    }
    @Override
    public int distance(Position target) {
        int distX = abs(target.x() - position.x());
        int distY = abs(target.x() - position.y());
        return distX + distY;
    }
    @Override
    public Position[] getPathTo(Position target) {
        Position[] monTableau = new Position[2];
        monTableau[0] = new Position(target.x(),this.position.y());
        monTableau[1] = new Position(target.x(), target.y());
        return monTableau;
    }

    @Override
    public String toString(){
        return "Move completed: Robot "+ this.name + " : energy=" + this.energy;
    }
}
