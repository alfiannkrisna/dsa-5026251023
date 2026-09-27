import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        LinkedList<String[]> transactionList = new LinkedList<>();

        Scanner sc = new Scanner(Main.class.getResourceAsStream("transactions.txt"));
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+");
            transactionList.add(parts);
        }

        LinkedList<String[]> customerList = new LinkedList<>();

        for (String[] transaction : transactionList) {
            String name = transaction[0];

            boolean alreadyExists = false;
            for (String[] customer : customerList) {
                if (customer[0].equals(name)) {
                    alreadyExists = true;
                    break;
                }
            }

            if (!alreadyExists) {
                customerList.add(new String[]{name, "0"});
            }
        }

        Queue<String[]> transactionQueue = new LinkedList<>(transactionList);

        Stack<String[]> failedTransactions = new Stack<>();

        while (!transactionQueue.isEmpty()) {
            String[] transaction = transactionQueue.poll();
            String name = transaction[0];
            String type = transaction[1];
            int amount = Integer.parseInt(transaction[2]);

            String[] customer = null;
            for (String[] c : customerList) {
                if (c[0].equals(name)) {
                    customer = c;
                    break;
                }
            }

            int balance = Integer.parseInt(customer[1]);

            if (type.equals("DEPOSIT")) {
                balance += amount;
                customer[1] = String.valueOf(balance);

            } else if (type.equals("WITHDRAW")) {
                if (amount > balance) {
                    failedTransactions.push(transaction);
                } else {
                    balance -= amount;
                    customer[1] = String.valueOf(balance);
                }
            }
        }

        System.out.println("=== Final Balances ===");
        for (String[] customer : customerList) {
            System.out.println(customer[0] + " : " + customer[1]);
        }

        System.out.println();
        System.out.println("=== Failed Transactions ===");
        while (!failedTransactions.isEmpty()) {
            String[] failed = failedTransactions.pop();
            System.out.println(failed[0] + " " + failed[1] + " " + failed[2]);
        }
    }
}
