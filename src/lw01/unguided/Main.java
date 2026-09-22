import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {

		Scanner sc = new Scanner(
            Main.class.getResourceAsStream("washes.txt")
        );

        int jumlah = sc.nextInt();
        int nilaiUnit[] = new int[jumlah];

        for(int i = 0; i < jumlah;i++){
            String type = sc.next();
            String id = sc.next();
            int day = sc.nextInt();
            int units = sc.nextInt();

            nilaiUnit[i] = units;

            WashService wash;

            if(type.equals("MOTORCYCLE")){
                wash = new MotorcycleWash(id, day);
            } else {
                wash = new CarWash(id, day);
            }
        }
		
		for(int i = 0; i < jumlah; i++){
            System.out.println(wash.summary());
        }
	}
}
