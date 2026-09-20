import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
	    List<PrintJob> jobs = new ArrayList<>();
	    
		Scanner sc = new Scanner(Main.class.getResourceAsStream("jobs.txt"))
		
		while(sc.hasNext()){
		    String type = sc.next();
		    String id = sc.next();
		    int pages = sc.nextInt();
		    
		    if(type.equals("MONO")){
		        jobs.add(new MonoPrint(id, pages))
		    } else if (type.equals("COLOUR")){
		        jobs.add(new ColourPrint(id, pages));
		    }
		}
		
		for(PrintJob job : jobs){
		    System.out.println(job.summary());
		}
	}
}
