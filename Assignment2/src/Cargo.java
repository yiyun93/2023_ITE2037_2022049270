import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

abstract class Cargo implements Comparable<Cargo> {
    private static int counts = 0;
    private final int ID;
    private final int weight;

    public Cargo(int id, int weight) {
        ID = id;
        this.weight = weight;
        counts++;
    }

    @Override
    public int compareTo(Cargo o){
        return Integer.compare(this.ID, o.getID());
    }

    public static int getCounts() {
        return counts;
    }

    public int getID(){
        return ID;
    }
    public int getWeight() {
        return weight;
    }

    abstract double consumption();

    public static ArrayList<Integer>[] sortCargoes(ArrayList<Cargo> cargos){
        Collections.sort(cargos);

        ArrayList<Integer> basicCargo = new ArrayList<>();
        ArrayList<Integer> heavyCargo = new ArrayList<>();
        ArrayList<Integer> dangerousCargo = new ArrayList<>();
        ArrayList<Integer> liquidCargo = new ArrayList<>();

        Iterator<Cargo> it = cargos.iterator();
        while(it.hasNext()){
            Cargo cargo = it.next();

            if(cargo instanceof HeavyCargo){
                if(cargo instanceof LiquidCargo){
                    liquidCargo.add(cargo.getID());
                }
                else if(cargo instanceof DangerousCargo){
                    dangerousCargo.add(cargo.getID());
                }
                else{
                    heavyCargo.add(cargo.getID());
                }
            }
            else{
                basicCargo.add(cargo.getID());
            }
        }

        ArrayList<Integer>[] res = new ArrayList[4];
        res[0] = basicCargo;
        res[1] = heavyCargo;
        res[2] = dangerousCargo;
        res[3] = liquidCargo;


        return res;
    }
}
