package org.example.adventuregame;

import java.util.Random;

public abstract class BattleLocation extends Location {

    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLocation(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();

        System.out.println("Your location : " + this.getName());
        System.out.println("There are " + obsNumber + " " + this.getObstacle().getName() + "!");

        System.out.println("Do you want <F>ight or <R>un?");
        String selectedCase = input.nextLine().toUpperCase();

        if (selectedCase.equals("F") && combat(obsNumber)) {

            System.out.println(this.getName() + " all monsters died.");
            return true;

        }

        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("-------------------");
            System.out.println("You died!");
            return false;
        }
        return true;
    }

    public boolean combat(int obsNumber) {

        for (int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getDefHealth());
            playerStats();
            obstacleStats(i);
            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.print("<H>it or <R>un: ");
                String selectedCombat = input.nextLine().toUpperCase();
                if (selectedCombat.equals("H")) {

                    System.out.println("You heat!");
                    this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDemage());
                    afterHit();

                    if (this.getObstacle().getHealth() > 0) {
                        System.out.println("Monster heat you");
                        int obstacleDemage = this.getObstacle().getDemage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (obstacleDemage < 0) {
                            obstacleDemage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDemage);
                        afterHit();
                    }
                } else {
                    return false;
                }
            }

            if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
                System.out.println("\n------------------------");
                System.out.println(this.getObstacle().getName() + " died!");
                System.out.println("You $" + this.getObstacle().getAward() + " won.");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println("Your money: " + this.getPlayer().getMoney());
                System.out.println("------------------------\n");
            }
        }


        return false;
    }

    public void playerStats() {
        System.out.println("--------PLAYER INFORMATIN----------");
        System.out.println("Health: " + this.getPlayer().getHealth());
        System.out.println("Money: " + this.getPlayer().getMoney());
        System.out.println("Demage: " + this.getPlayer().getTotalDemage());
        System.out.println("Weapon: " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Weapon Demage: " + this.getPlayer().getInventory().getWeapon().getDemage());
        System.out.println("Armor: " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Block: " + this.getPlayer().getInventory().getArmor().getBlock());
    }

    public void obstacleStats(int i) {
        System.out.println("--------" + i + ". " + this.getObstacle().getName() + " INFORMATION----------");
        System.out.println("Health: " + this.getObstacle().getHealth());
        System.out.println("Demage: " + this.getObstacle().getDemage());
        System.out.println("Award: " + this.getObstacle().getAward());
    }

    public void afterHit() {
        System.out.println("-------------------------------");
        System.out.println("Your health: " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + "'s health: " + this.getObstacle().getHealth());
        System.out.println("-------------------------------");
    }

    public int randomObstacleNumber() {
        Random rand = new Random();
        return rand.nextInt(this.getMaxObstacle()) + 1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
