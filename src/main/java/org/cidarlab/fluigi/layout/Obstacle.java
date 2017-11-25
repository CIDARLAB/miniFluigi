package org.cidarlab.fluigi.layout;

public class Obstacle extends Cell{

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    int cost;

    public Obstacle(String id, int x, int y, int xspan, int yspan) {
        super(id, x, y, xspan, yspan);
    }


}
