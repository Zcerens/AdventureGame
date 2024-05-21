package org.example.adventuregame;

import java.util.Scanner;

public class Game {

    private Scanner input = new Scanner(System.in);

    void start() {
        System.out.println("Welcome to Adventure Game!");
        System.out.println("Enter your username: ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Are u ready for this adventure " + player.getName() + "?");
        System.out.println("\n\t\t--------CHARACTERS---------");
        player.selectChar();

        Location location = null;
        while (true) {

            player.printInfo();
            System.out.println("\n\t\t--------LOCATIONS---------");
            System.out.println("--------------------------------");
            System.out.println("1 - Safe House");
            System.out.println("2 - Tool Store");
            System.out.println("3 - Cave - Be carefull! There may be zombie! Award: Food ");
            System.out.println("4 - River - Be carefull! There may be vampire! Award:Wood ");
            System.out.println("5 - Forest - Be carefull! There may be bear! Award: Water");
            System.out.println("--------------------------------");
            System.out.println("Please choose the location you want to go to! ");

            int selectLoc = input.nextInt();
            switch (selectLoc) {
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new River(player);
                    break;
                case 5:
                    location = new Forest(player);
                    break;
                default:
                    location = new SafeHouse(player);
                    break;
            }
            if (!location.onLocation()) {
                System.out.println("GAME OVER!");
                break;
            }

        }

    }
}
