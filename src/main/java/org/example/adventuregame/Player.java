package org.example.adventuregame;

import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int money;
    private int block;
    private String name;
    private Scanner input = new Scanner(System.in);
    private Inventory inventory;
    private int defHealth;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar() {

        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};
        System.out.println("--------------------------------");
        for (GameChar gameChar : charList) {
            System.out.println("ID: " + gameChar.getId()
                    + "\tName: " + gameChar.getName()
                    + "\tDemage: " + gameChar.getDemage()
                    + "\tHealth: " + gameChar.getHealth()
                    + "\tMoney: " + gameChar.getMoney());
        }
        System.out.println("--------------------------------");
        System.out.println("Please select a character ID!");


        int selectChar = input.nextInt();
        switch (selectChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
                break;
        }


    }

    public void initPlayer(GameChar gameChar) {
        this.setDamage(gameChar.getDemage());
        this.setHealth(gameChar.getHealth());
        this.setDefHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());

    }

    public void printInfo() {
        System.out.println("Your character: \nName: " + this.getCharName()
                + "\tWeapon: " + this.getInventory().getWeapon().getName()
                + "\tArmor: " + this.getInventory().getArmor().getName()
                + "\tDemage: " + this.getTotalDemage()
                + "\tHealth: " + this.getHealth()
                + "\tBlock: " + this.getBlock()
                + "\tMoney: " + this.getMoney());
    }

    private String charName;

    public int getTotalDemage(){
        return damage + this.getInventory().getWeapon().getDemage();
    }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getBlock() {
        return block + this.getInventory().getArmor().getBlock();
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getDefHealth() {
        return defHealth;
    }

    public void setDefHealth(int defHealth) {
        this.defHealth = defHealth;
    }
}
