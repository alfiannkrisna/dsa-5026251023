import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(Main.class.getResourceAsStream("parcels.txt"));
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i < n-1; i++) {
            for(int j = 0; j < n-i-1; j++) {
                if(arr[j] < arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if(i == 1){
                System.out.println("==== After 2 Passes ====");
                for(int k = 0; k < n; k++){
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
	    }
        System.out.println();

        System.out.println("==== Fully Sorted ====");
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        int m = sc.nextInt();
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = sc.nextInt();
        }

        System.out.println();
        System.out.println("==== Search Results ====");
        for (int t = 0; t < targets.length; t++) {
            int target = targets[t];
            int low = 0;
            int high = n - 1;
            int steps = 0;
            int indeks = -1;
 
            while (low <= high) {
                int mid = (low + high) / 2;
                steps++;
                if (arr[mid] == target) {
                    indeks = mid;
                    break;
                } else if (target < arr[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
 
            if (indeks != -1) {
                System.out.println(target + ": FOUND at index " + indeks + " (steps: " + steps + ")");
            } else {
                System.out.println(target + ": NOT FOUND (steps: " + steps + ")");
            }
        }
    }
}