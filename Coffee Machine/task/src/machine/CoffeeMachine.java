package machine;

import java.util.Scanner;
import java.util.spi.AbstractResourceBundleProvider;

public class CoffeeMachine {

    private static int mlWater = 400;
    private static int mlMilk = 540;
    private static int gBeans = 120;
    private static int disCups = 9;
    private static int money = 550;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        /*calculatingCoffee();
        makingCoffee();*/
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String input = scanner.nextLine();
            if ("exit".equals(input)) {
                break;
            }
            switch (input) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    remaining();
                    break;
                default:
                    System.out.println("Wrong action");
                    break;
            }
        }
    }

    private static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        switch (scanner.nextLine()) {
            case "1":
                makeEspresso();
                break;
            case "2":
                makeLatte();
                break;
            case "3":
                makeCappuccino();
                break;
            default:
                System.out.println("Wrong input");
                break;
        }
    }

    private static void makeEspresso() {
        if (checkResources(250, 0, 16)) {
            mlWater -= 250;
            gBeans -= 16;
            money += 4;
            disCups--;
        }
    }

    private static void makeLatte() {
        if (checkResources(350, 75, 20)) {
            mlWater -= 350;
            mlMilk -= 75;
            gBeans -= 20;
            money += 7;
            disCups--;
        }
    }
    private static void makeCappuccino() {
        if (checkResources(200, 100, 12)) {
            mlWater -= 200;
            mlMilk -= 100;
            gBeans -= 12;
            money += 6;
            disCups--;
        }
    }

    private static boolean checkResources(int water,int milk, int beans) {
        if (mlWater < water) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (mlMilk < milk) {
            System.out.println("Sorry, not enough milk!");
            return false;
        } else if (gBeans < beans) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        } else if (disCups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
            return false;
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            return true;
        }
    }

    private static void fill() {
        System.out.println("Write how many ml of water do you want to add:");
        mlWater += Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many ml of milk do you want to add:");
        mlMilk += Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many grams of coffee beans do you want to add:");
        gBeans += Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        disCups += Integer.parseInt(scanner.nextLine());
    }

    private static void take() {
        System.out.printf("I gave you $%d\n", money);
        money = 0;
    }

    private static void remaining() {
        System.out.printf("The coffee machine has:\n%d of water\n%d of milk\n%d of coffee beans\n%d of disposable cups\n%d of money\n", mlWater, mlMilk, gBeans, disCups, money);
    }

    /*private static void makingCoffee() {
        System.out.println("Starting to make a coffee\n" +
                "Grinding coffee beans\n" +
                "Boiling water\n" +
                "Mixing boiled water with crushed coffee beans\n" +
                "Pouring coffee into the cup\n" +
                "Pouring some milk into the cup\n" +
                "Coffee is ready!");
    }
    private static void calculatingCoffee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has:");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int beans = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int numOfCups = scanner.nextInt();
        int cupsWater = water / 200;
        int cupsMilk = milk / 50;
        int cupsBeans = beans / 15;
        int realCups = cupsWater < cupsBeans ? (cupsWater < cupsMilk ? cupsWater : cupsMilk) : (cupsBeans < cupsMilk ? cupsBeans : cupsMilk);
        if (realCups < numOfCups) {
            System.out.printf("No, I can make only %d cup(s) of coffee\n", realCups);
        } else if (realCups == numOfCups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)", realCups - numOfCups);
        }
    }*/
}
