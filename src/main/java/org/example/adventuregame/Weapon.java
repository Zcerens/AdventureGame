package org.example.adventuregame;

public class Weapon {
    private int id;
    private String name;
    private int demage;
    private int price;

    public Weapon(int id, String name, int demage, int price) {
        this.id = id;
        this.name = name;
        this.demage = demage;
        this.price = price;
    }

    public static Weapon[] weapons() {
        Weapon[] weaponList = new Weapon[3];
        weaponList[0] = new Weapon(1, "Gun", 2, 5);
        weaponList[1] = new Weapon(2, "Sword", 3, 35);
        weaponList[2] = new Weapon(3, "Rifle", 7, 45);

        return weaponList;

    }

    public static Weapon getWeaponObjByID(int id){

        for(Weapon w: Weapon.weapons()){
            if(w.getId() == id){
                return w;
            }
        }
        return null;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDemage() {
        return demage;
    }

    public void setDemage(int demage) {
        this.demage = demage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
