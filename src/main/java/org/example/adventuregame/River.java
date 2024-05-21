package org.example.adventuregame;

public class River extends BattleLocation{
    public River(Player player) {
        super(player, "River", new Bear(), "water", 2);
    }
}
