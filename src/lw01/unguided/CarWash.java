package lw01.unguided;

public class CarWash extends WashService {
    public CarWash(String id, int days){
        super(id, days);
    }

    @Override
    public int calculateCharge(){
        int day = getDays();
        int charge = 0;

        if(day <= 3){
            charge = day * 35000 + 15000;
        } else {
            charge = (day * 35000) + ((day-3) * 25000) + 15000;
        }
        return charge;
    }

    @Override
    public String label(){
        return "Car";
    }
}
