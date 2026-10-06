import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(Main.class.getResourceAsStream("registrations.txt"));
        Set<String> peserta = new LinkedHashSet<>();

        while(sc1.hasNextLine()){
            peserta.add(sc1.nextLine());
        }

        sc1.close();

        Scanner sc2 = new Scanner(Main.class.getResourceAsStream("checkins.txt"));
        Set<String> hadir = new LinkedHashSet<>();

        int reject = 0;
        System.out.println("===== Event Check-In Results =====");
        while(sc2.hasNextLine()){
            String checkInId = sc2.nextLine();
            if(peserta.contains(checkInId)){
                if(hadir.add(checkInId)){
                    System.out.println(checkInId + ": Checked in");
                } else {
                    System.out.println(checkInId + ": Rejected (already checked in)");
                    reject++;
                }
            } else if(!peserta.contains(checkInId)){
                System.out.println(checkInId + ": Rejected (not registered)");
                reject++;
            }
        }

        sc2.close();

        System.out.println();
        System.out.println("===== Final Event Summary =====");
        System.out.println("Registered students: " + peserta.size());
        System.out.println("Successful check-ins: " + hadir.size());
        System.out.println("Absent students: " + (peserta.size() - hadir.size()));
        System.out.println("Rejected attempts: " + reject);
    }
}
