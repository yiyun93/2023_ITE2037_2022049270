import java.util.ArrayList;

public class Warehouse {
    private static int counts = 0;
    private final int ID;
    private final double X;
    private final double Y;
    private ArrayList<Cargo> cargoes;

    // there should not be any duplicates in the current and history lists;
    private ArrayList<Truck> history;
    private ArrayList<Truck> current;

    public Warehouse(int ID_, double X_, double Y_){
        ID = ID_;
        X = X_;
        Y = Y_;
        cargoes = new ArrayList<>();
        history = new ArrayList<>();
        current = new ArrayList<>();
        counts++;
    }

    public ArrayList<Cargo> getCargoes() {
        return new ArrayList<>(cargoes);
    }

    public static int getCounts() {
        return counts;
    }

    public int getID(){
        return ID;
    }
    public double getX(){
        return X;
    }
    public double getY(){
        return Y;
    }

    public double getDistance(Warehouse other){
        double Xdis = X - other.getX();
        double Ydis = Y - other.getY();
        return Math.sqrt(Xdis*Xdis + Ydis*Ydis);
    }

    public void incomingTruck(Truck t){
        current.add(t);
    }

    public void outgoingTruck(Truck t){
        current.remove(t);
        history.add(t);
    }

    public void putCargo(Cargo c){
        cargoes.add(c);
    }

    public void putOffCargo(Cargo c){
        cargoes.remove(c);
    }

    public ArrayList<Truck> getCurrent(){
        return new ArrayList<>(current);
    }

}
