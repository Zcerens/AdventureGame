package org.example.adventuregame;

public class Inventory {
    private Weapon weapon;
    private Armor armor;
    public Inventory() {
        this.weapon = new Weapon(0,"Hand",0,0);
        this.armor = new Armor(0,"null",0,0);

    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}
