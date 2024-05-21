package org.example.adventuregame;

public class SafeHouse extends NormalLoc {
    public SafeHouse(Player player) {
        super(player, "Safe house");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in safe house!");
        System.out.println("Your health is full!");
        this.getPlayer().setHealth(this.getPlayer().getDefHealth());
        return true;
    }
}
