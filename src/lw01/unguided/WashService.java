package lw01.unguided;

public abstract class WashService implements Billable {
    private String id;
    private int days;
    private int units;

    protected WashService(String id, int days){
        if(days <= 0){
            throw new IllegalArgumentException("Pages must be greater than zero");
        }
        this.id = id;
        this.days = days;
    }

    public String getId(){
        return id;
    }

    public int getDays(){
        return days;
    }

    public int getUnits(){
        return units;
    }

    @Override
    public abstract int calculateCharge();

    public int calculateCharge(int units){
        if(units <= 0){
            throw new IllegalArgumentException("Copies must be greater than zero");
        }
        return units * calculateCharge();
    }

    public String label(){
        return "Service";
    }

    public String summary(){
        return id + " | " + label() + " | " + calculateCharge();
    }

    public String summary(int units){
        return id + " | " + label() + " | " + calculateCharge(units);
    }

}
