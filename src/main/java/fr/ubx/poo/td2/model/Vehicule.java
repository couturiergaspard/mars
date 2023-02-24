package fr.ubx.poo.td2.model;

public abstract class Vehicule {
    private final double cost;
    protected Position position;
    protected double energy;
    protected final String name;

    public Vehicule(String name, Position position, double energy, double cost) {
        this.name = name;
        this.position = position;
        this.energy = energy;
        this.cost = cost;
    }
    public Position getPosition() {
        return position;
    }
    private int range() {
        return (int) (this.energy/this.cost);
    }
    public boolean canMove(Position target) {
        return distance(target) <= range();
    }
    public void move(Position target) {
            this.energy = this.energy - (this.cost * distance(target));
            this.position = new Position(target.x(), target.y());
            System.out.println(toString());
    }
    public abstract int distance(Position target);
    public abstract Position[] getPathTo(Position target);
}