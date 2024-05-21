package org.example.adventuregame;

public class Cave extends BattleLocation{
    public Cave(Player player) {
        super(player,"Cave", new Zombie(), "Food", 3);
    }
}
