package org.example.adventuregame;

public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(player, "Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Welcome to store!\n");
        boolean showMenu = true;
        while (showMenu){
        System.out.println("--------------------------------");
        System.out.println("1 - Weaponry");
        System.out.println("2 - Armors");
        System.out.println("3 - Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose the item! ");

        int selectCase = input.nextInt();

        while (selectCase < 1 || selectCase > 3) {
            System.out.println("Invalid value, please choose again!");
            selectCase = input.nextInt();


        }
        switch (selectCase) {
            case 1:
                printWeapon();
                buyWeapon();
                break;
            case 2:
                printArmors();
                buyArmor();
                break;
            case 3:
                System.out.println("Thank you ");
                showMenu = false;
                break;
        }
    }
        return true;


    }

    public void printWeapon() {
        System.out.println("\n\t\t--------WEAPONS---------");
        System.out.println("--------------------------------");
        for (Weapon weapon : Weapon.weapons()) {
            System.out.println(weapon.getId() + " - " + weapon.getName() + " <Price: " + weapon.getPrice() + " Demage: " + weapon.getDemage() + ">");
        }
        System.out.println("--------------------------------");


    }

    public void buyWeapon() {
        System.out.println("Please select a weapon (Press 0 for exit) : ");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
            System.out.println("Invalid value, please select again!");
            selectWeaponID = input.nextInt();
        }

        if (selectWeaponID != 0) {

            Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);

            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("You don't have enough money");
                } else {
                    System.out.println("You bought " + selectedWeapon.getName());

                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Your money: " + this.getPlayer().getMoney());

                    System.out.print("The " + this.getPlayer().getInventory().getWeapon().getName() + " was replaced with ");
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println(this.getPlayer().getInventory().getWeapon().getName());
                }

            }

        }


    }

    public void printArmors() {
        System.out.println("\n\t\t--------ARMORS---------");
        System.out.println("--------------------------------");
        for (Armor armor : Armor.armors()) {
            System.out.println(armor.getId() + " - " + armor.getName() + " <Block: " + armor.getBlock() + " Price: " + armor.getPrice() + ">");
        }
        System.out.println("--------------------------------");
    }

    public void buyArmor() {
        System.out.println("Please select an armor (Press 0 for exit) :");

        int selectArmorID = input.nextInt();
        if  (selectArmorID < 0 || selectArmorID > Armor.armors().length) {
            System.out.println("Invalid value, please select again!");
            selectArmorID = input.nextInt();
        }

        if (selectArmorID != 0) {
            Armor selectedArmor = Armor.getArmorObjByID(selectArmorID);
            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("You don't have enough money");
                } else {
                    System.out.println("You bought " + selectedArmor.getName());
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Your money: " + this.getPlayer().getMoney());

                    System.out.print(this.getPlayer().getInventory().getArmor().getName() + "was replaced with ");
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println(this.getPlayer().getInventory().getArmor().getName());

                }
            }
        }


    }
}
