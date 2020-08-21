

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Machine {
    private final Scanner scanner = new Scanner(System.in);
    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int cash;
    Coffee espresso = new Coffee(250, 16, 4);
    Coffee latte = new Coffee(350, 75, 20, 7);
    Coffee cappuccino = new Coffee(200, 100, 12, 6);

    void start() {
        System.out.println("The coffee machine has: ");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println("$" + cash + " of money \n");
    }

    void action() {
        boolean flag = true;

        do {
            System.out.println("Write action (buy, fill, take, remaining, exit)");
            String string = scanner.nextLine();
            switch (string) {
                case "buy": {
                    buy();

                    break;
                }

                case "fill": {
                    fill();
                    break;
                }

                case "take": {
                    take();
                    break;
                }

                case "remaining": {
                    start();
                    break;
                }
                case "exit": {
                    flag = false;
                    break;
                }
            }
        }

        while (flag);
    }

    private void fill() {
        System.out.println("Write how many ml of water do you want to add:");
        water += Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many ml of milk do you want to add:");
        milk += Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many grams of coffee beans do you want to add:");
        beans += Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cups += Integer.parseInt(scanner.nextLine());
    }

    private void take() {
        System.out.println("i gave you $" + cash);
        cash = 0;
    }

    private void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        switch (scanner.nextLine()) {
            case "1": {
                if (resources(espresso)) {
                    water = water - espresso.getWater();
                    beans = beans - espresso.getBeans();
                    cups = cups - espresso.getCup();
                    cash = cash + espresso.getCost();
                }
                break;

            }
            case "2": {
                if (resources(latte)) {
                    water = water - latte.getWater();
                    milk = milk - latte.getMilk();
                    beans = beans - latte.getBeans();
                    cups = cups - latte.getCup();
                    cash = cash + latte.getCost();
                }
                break;
            }
            case "3": {
                if (resources(cappuccino)) {
                    water = water - cappuccino.getWater();
                    milk = milk - cappuccino.getMilk();
                    beans = beans - cappuccino.getBeans();
                    cups = cups - cappuccino.getCup();
                    cash = cash + cappuccino.getCost();
                }
                break;
            }
            case "back": {
                break;
            }
        }
    }

    boolean resources(Coffee coffee) {
        if (coffee.getWater() > water) {
            System.out.println("Sorry, not enough water!\n");
            return false;
        } else if (coffee.getMilk() > milk) {
            System.out.println("Sorry, not enough milk!\n");
            return false;
        } else if (coffee.getBeans() > beans) {
            System.out.println("Sorry, not enough coffee beans!\n");
            return false;
        } else if (coffee.getCup() > cups) {
            System.out.println("Sorry, not enough disposable cups!\n");
            return false;
        } else {
            System.out.println("I have enough resources, making you a coffee!\n");
            return true;
        }
    }


    public Machine(int cash, int water, int milk, int beans, int cups) {
        this.cash = cash;
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;

    }

    public Machine() {
    }
}
