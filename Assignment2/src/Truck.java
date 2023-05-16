import java.util.ArrayList;
import java.util.Iterator;

public class Truck {
    static private int counts = 0;
    private final int ID;
    private double fuel;
    private Warehouse currentWarehouse;
    private final int weight;
    private final int maxWeight;
    private final int maxNumOfAllCargoes;
    private final int maxNumOfHeavyCargoes;
    private int NumOfHeavyCargoes;
    private final int maxNumOfDangerousCargoes;
    private int NumOfDangerousCargoes;
    private final int maxNumOfLiquidCargoes;
    private int NumOfLiquidCargoes;
    private final double fuelPerKm;
    private ArrayList<Cargo> currentCargoes;

    public Truck(int ID, Warehouse w, int totalWeight, int maxNumOfAllCargoes,
                 int maxNumOfHeavyCargoes, int maxNumOfDangerousCargoes,
                 int maxNumOfLiquidCargoes, double fuelPerKm){
        this.fuel = 0;
        this.ID = ID;
        this.currentWarehouse = w;
        w.incomingTruck(this);
        this.weight = 0;
        this.maxWeight = totalWeight;
        this.maxNumOfAllCargoes = maxNumOfAllCargoes;
        this.maxNumOfHeavyCargoes = maxNumOfHeavyCargoes;
        this.maxNumOfDangerousCargoes = maxNumOfDangerousCargoes;
        this.maxNumOfLiquidCargoes = maxNumOfLiquidCargoes;
        this.fuelPerKm = fuelPerKm;
        this.currentCargoes = new ArrayList<>();
        NumOfDangerousCargoes = 0;
        NumOfHeavyCargoes = 0;
        NumOfLiquidCargoes = 0;
        counts++;
    }

    public Warehouse getCurrentWarehouse() {
        return currentWarehouse;
    }

    public ArrayList<Cargo> getCurrentCargoes(){
        return new ArrayList<>(currentCargoes);
    }

    public boolean sailTo(Warehouse w){
        double fuelCon;
        fuelCon = fuelPerKm;

        Iterator<Cargo> it = currentCargoes.iterator();
        while(it.hasNext()){
            fuelCon += it.next().consumption();
        }

        double needFuel = currentWarehouse.getDistance(w)*fuelCon;
        if(needFuel > fuel){
            return false;
        }
        else{
            currentWarehouse.outgoingTruck(this);
            fuel -= needFuel;
            currentWarehouse = w;
            currentWarehouse.incomingTruck(this);
            return true;
        }
    }

    public void reFuel(double amount){
        this.fuel += amount;
    }

    public boolean load(Cargo c){
        if(!currentWarehouse.getCargoes().contains(c))
            return false;

        if(weight+c.getWeight()<maxWeight && currentCargoes.size()<maxNumOfAllCargoes) {
            if(c instanceof HeavyCargo){
                if(NumOfHeavyCargoes < maxNumOfHeavyCargoes){
                    if(c instanceof LiquidCargo){
                        if(NumOfLiquidCargoes<maxNumOfLiquidCargoes){
                            currentCargoes.add(c);
                            NumOfHeavyCargoes++;
                            NumOfLiquidCargoes++;
                            currentWarehouse.putOffCargo(c);
                            return true;
                        }
                        else return false;
                    }
                    else if(c instanceof DangerousCargo){
                        if(NumOfDangerousCargoes<maxNumOfDangerousCargoes){
                            currentCargoes.add(c);
                            NumOfHeavyCargoes++;
                            NumOfDangerousCargoes++;
                            currentWarehouse.putOffCargo(c);
                            return true;
                        }
                        else return false;
                    }
                    else{
                        currentCargoes.add(c);
                        NumOfHeavyCargoes++;
                        currentWarehouse.putOffCargo(c);
                        return true;
                    }
                } else return false;
            }
            currentCargoes.add(c);
            currentWarehouse.putOffCargo(c);
            return true;
        }
        else return false;
    }

    public boolean unload(Cargo c){
        if(currentCargoes.contains(c)){
            currentCargoes.remove(c);
            if(c instanceof HeavyCargo){
                NumOfHeavyCargoes--;
                if(c instanceof LiquidCargo)
                    NumOfLiquidCargoes--;
                else if(c instanceof  DangerousCargo)
                    NumOfDangerousCargoes--;
            }
            currentWarehouse.putCargo(c);
            return true;
        }
        else return false;
    }

    public int getID(){
        return ID;
    }

    public static int getCounts(){
        return counts;
    }

    public double getFuel(){
        return fuel;
    }
}
