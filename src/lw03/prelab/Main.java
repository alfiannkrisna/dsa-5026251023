import java.util.*;

public class Main {
    public static void main(String args[]){
        problem1();
        problem2();
        problem3();
    }

    static void problem1(){
        List<String> playlist = new ArrayList<>();

        Scanner sc = new Scanner(Main.class.getResourceAsStream("playlist.txt"));

        while(sc.hasNextLine()){
            String aksi = sc.next();
            if(aksi.equals("ADD")){
                String song = sc.nextLine().trim();
                playlist.add(song);
            } else if(aksi.equals("INSERT")){
                int index = sc.nextInt();
                String song = sc.nextLine().trim();
                playlist.add(index, song);
            } else if(aksi.equals("REMOVE")){
                String song = sc.nextLine().trim();
                playlist.remove(song);
            }
        }

        System.out.println("===== Problem 1 =====");
        System.out.println("Total songs: " + playlist.size());
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ": " + playlist.get(i));
        }
        System.out.println();
    }

    static void problem2(){
        Set<String> participants = new LinkedHashSet<>();
        
        Scanner sc = new Scanner(Main.class.getResourceAsStream("participants.txt"));

        int duplikat = 0;
        while(sc.hasNextLine()){
            String name = sc.nextLine();
            boolean isNew = participants.add(name);
            if(!isNew){
                duplikat++;
            }
        }

        System.out.println("===== Problem 2 =====");
        System.out.println("Unique participants: " + participants.size());
 
        int nomor = 1;
        for (String name : participants) {
            System.out.println(nomor + ". " + name);
            nomor++;
        }
        System.out.println("Duplicate registrations: " + duplikat);
        System.out.println();
    }

    static void problem3(){
        Map<String, Integer> stock = new LinkedHashMap<>();

        Scanner sc = new Scanner(Main.class.getResourceAsStream("inventory.txt"));

        int gagal = 0;
        while(sc.hasNextLine()){
            String aksi = sc.next();
            if(aksi.equals("ADD")){
                String name = sc.next();
                int quantity = sc.nextInt();
                stock.put(name, stock.getOrDefault(name, 0) + quantity);
            } else if(aksi.equals("SELL")){
                String name = sc.next();
                int quantity = sc.nextInt();
                if (!stock.containsKey(name) || stock.get(name) < quantity) {
                    gagal++;
                } else {
                    stock.put(name, stock.get(name) - quantity);
                }
            }
        }
        System.out.println("===== Problem 3 =====");
        for (Map.Entry<String, Integer> entry : stock.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Failed sales: " + gagal);
        System.out.println();
    }
}
