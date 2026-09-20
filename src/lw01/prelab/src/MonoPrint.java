public class MonoPrint extends PrintJob{
    public MonoPrint(String id, int pages){
        super(id, pages);
    }

    @Override
    public int calculateCharge(){
        return getPages() * 500;
    }

    public String label(){
        return "Mono";
    }
}