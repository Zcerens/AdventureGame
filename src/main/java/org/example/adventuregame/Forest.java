package org.example.adventuregame;

public class Forest extends BattleLocation {
    public Forest(Player player) {
        super(player, "Forest", new Vampire(), "firewood", 3);
    }
}
