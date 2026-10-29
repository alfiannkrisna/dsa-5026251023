import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("branches.txt"));
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 1; i < 4; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        
        System.out.println();
        
        int m = sc.nextInt();
        for(int i = 0; i < m; i++){
            int target = sc.nextInt();
            boolean ketemu = false;
            for(int j = 0; j < n; j++){
                if(arr[j] == target){
                    System.out.println(target + ": FOUND at index " + j);
                    ketemu = true;
                    break;
                }
            }
            if(!ketemu) {
                System.out.println(target + ": NOT FOUND");
            }
        }
    }
}