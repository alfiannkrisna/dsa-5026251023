//package lw02.unguided;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        LinkedList<String[]> transactions = new LinkedList<>();
	    LinkedList<String[]> sideDishes = new LinkedList<>();
        LinkedList<String[]> drinks = new LinkedList<>();
	    LinkedList<String[]> orders = new LinkedList<>();

        Queue<String[]> queue = new LinkedList<>();
        Stack<String[]> failed = new Stack<>();

        Scanner sc = new Scanner(Main.class.getResourceAsStream("order.txt"));

        while(sc.hasNext()){
	        String[] transaction = new String[4];
	        transaction[0] = sc.next();
	        transaction[1] = sc.next();
	        transaction[2] = sc.next();
	        transaction[3] = sc.next();
	        transactions.add(transaction);
        }

        queue.addAll(transactions);

        int[] stockFood = new int[3];
        sideDishes.add(new String[]{"Bakso", "2"});
        sideDishes.add(new String[]{"Sate", "1"});
        sideDishes.add(new String[]{"Soto", "2"});
        stockFood[0] = Integer.parseInt(sideDishes.get(0)[1]);
        stockFood[1] = Integer.parseInt(sideDishes.get(1)[1]);
        stockFood[2] = Integer.parseInt(sideDishes.get(2)[1]);

        int[] stockDrink = new int[2];
        drinks.add(new String[]{"EsTeh", "4"});
        drinks.add(new String[]{"EsJeruk", "2"});
        stockDrink[0] = Integer.parseInt(drinks.get(0)[1]);
        stockDrink[1] = Integer.parseInt(drinks.get(1)[1]);

        while(!queue.isEmpty()){
            String[] order = queue.poll();
            String name = order[0];
            String food = order[1];
            String drink = order[2];
            String table = order[3];

            boolean foodAvailable = false;
            boolean drinkAvailable = false;

            if(food.equals("Bakso") && stockFood[0] > 0){
                stockFood[0]--;
                foodAvailable = true;
            } else if (food.equals("Sate") && stockFood[1] > 0){
                stockFood[1]--;
                foodAvailable = true;
            } else if (food.equals("Soto") && stockFood[2] > 0){
                stockFood[2]--;
                foodAvailable = true;
            } else if(food.equals("-")){
                foodAvailable = true;
            } else {
                foodAvailable = false;
                // failed.push(order);
                // continue;
            }

            if(drink.equals("EsTeh") && stockDrink[0] > 0){
                stockDrink[0]--;
                drinkAvailable = true;
            } else if (drink.equals("EsJeruk") && stockDrink[1] > 0){
                stockDrink[1]--;
                drinkAvailable = true;
            } else if(drink.equals("-")){
                drinkAvailable = true;
            } else {
                drinkAvailable = false;
                // failed.push(order);
                // continue;
            }

            if(foodAvailable && drinkAvailable){
                orders.add(order);
            } else {
                failed.push(order);
            }
        }

        System.out.println("=== Successfully Processed Orders ===");
        for(String[] order : transactions){
            if(!failed.contains(order)){
                System.out.println(order[0] + " " + order[1] + " " + order[2] + " " + order[3]);
            }
        }

        System.out.println("=== Remaining Food Stock ===");
        for(String[] food : sideDishes){
            System.out.println(food[0] + " " + stockFood[Arrays.asList("Bakso", "Sate", "Soto").indexOf(food[0])]);
        }

        System.out.println("=== Remaining Drink Stock ===");
        for(String[] drink : drinks){
            System.out.println(drink[0] + " " + stockDrink[Arrays.asList("EsTeh", "EsJeruk").indexOf(drink[0])]);
        }

        System.out.println("=== Failed Orders ===");
        while(!failed.isEmpty()){
            String[] order = failed.pop();
            System.out.println(order[0] + " " + order[1] + " " + order[2] + " " + order[3]);
        }
    }
}
