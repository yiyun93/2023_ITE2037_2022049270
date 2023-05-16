import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        // Generate a new Scanner object to access data from the input file in the directory indicated by "args[0]".
        Scanner in = new Scanner(new File(args[0]));


        // Your Implementation
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Warehouse> warehouses = new ArrayList<>();
        ArrayList<Truck> trucks = new ArrayList<>();
        ArrayList<Cargo> cargos = new ArrayList<>();

        keyboard = in;

        int N = keyboard.nextInt();
        keyboard.nextLine();

        for(int i=0; i<N; i++){
            int input = keyboard.nextInt();

            switch (input){
                case 1: { // create a cargo
                    System.out.println("    action (1) " + (i+1));
                    String temp = keyboard.nextLine().substring(1);
                    String[] sequence = temp.split(" ");

                    int houseID = Integer.parseInt(sequence[0]);
                    int weight = Integer.parseInt(sequence[1]);

                    if (sequence.length == 2) {
                        Cargo cargo;
                        if (weight <= 1000) {
                            cargo = new BasicCargo(Cargo.getCounts(), weight);
                        } else {
                            cargo = new HeavyCargo(Cargo.getCounts(), weight);
                        }
                        cargos.add(cargo);
                        warehouses.get(houseID).putCargo(cargo);
                    } else if (sequence.length == 3) {
                        if (sequence[2].equals("L")) {
                            Cargo cargo = new LiquidCargo(Cargo.getCounts(), weight);
                            cargos.add(cargo);
                            warehouses.get(houseID).putCargo(cargo);
                        } else if (sequence[2].equals("D")) {
                            Cargo cargo = new DangerousCargo(Cargo.getCounts(), weight);
                            cargos.add(cargo);
                            warehouses.get(houseID).putCargo(cargo);
                        }
                    }
                    System.out.println(cargos.size()-1 +" cargo created in house " + houseID);
                }
                    break;

                case 2: { // create a truck
                    System.out.println("    action (2) "+ (i+1));
                    int houseID = keyboard.nextInt();
                    int maxWeight = keyboard.nextInt();
                    int maxCargoes = keyboard.nextInt();
                    int maxHeavy = keyboard.nextInt();
                    int maxDangerous = keyboard.nextInt();
                    int maxLiquid = keyboard.nextInt();
                    double fuelCon = keyboard.nextDouble();

                    if(keyboard.hasNextLine())
                        keyboard.nextLine();

                    trucks.add(new Truck(Truck.getCounts(), warehouses.get(houseID), maxWeight, maxCargoes,
                            maxHeavy, maxDangerous, maxLiquid, fuelCon));
                    System.out.println(trucks.size()-1 +" truck created created in house " + houseID);
                }
                    break;

                case 3: { // create a warehouse
                    System.out.println("    action (3) "+ (i+1));
                    double X = keyboard.nextDouble();
                    double Y = keyboard.nextDouble();

                    if(keyboard.hasNextLine())
                        keyboard.nextLine();

                    warehouses.add(new Warehouse(Warehouse.getCounts(), X, Y));
                    System.out.println(warehouses.size()-1 +" warehouse created");
                }
                    break;

                case 4: { // load a cargo to a truck
                    System.out.println("    action (4) "+ (i+1));
                    int truckID = keyboard.nextInt();
                    int cargoID = keyboard.nextInt();

                    if(keyboard.hasNextLine())
                        keyboard.nextLine();

                    Truck truck = trucks.get(truckID);
                    Cargo cargo = cargos.get(cargoID);

                    if(truck.load(cargo)){
                        System.out.println("warehouse " +truck.getCurrentWarehouse().getID()+" truck " + truck.getID() +
                                " cargo " + cargo.getID() + " loaded");
                    }
                    else System.out.println("fail!");
                }
                    break;

                case 5: { // unload a cargo from a truck
                    System.out.println("    action (5) "+ (i+1));
                    int truckID = keyboard.nextInt();
                    int cargoID = keyboard.nextInt();

                    if(keyboard.hasNextLine())
                        keyboard.nextLine();

                    Truck truck = trucks.get(truckID);
                    Cargo cargo = cargos.get(cargoID);

                    if(truck.unload(cargo)) {
                        System.out.println("warehouse " + truck.getCurrentWarehouse().getID() + " truck " + truck.getID() +
                                " cargo " + cargo.getID() + " unloaded");
                    }
                    else System.out.println("fail!");
                }
                break;

                case 6: { // truck moves to another warehouse
                    System.out.println("    action (6) "+ (i+1));
                    int truckID = keyboard.nextInt();
                    int houseID = keyboard.nextInt();

                    Truck truck = trucks.get(truckID);
                    Warehouse house = warehouses.get(houseID);

                    if(keyboard.hasNextLine())
                        keyboard.nextLine();

                    if(truck.sailTo(house)){
                        System.out.println("Truck " + truck.getID() + " moved to " + house.getID());
                    }
                    else System.out.println("fail!");
                }
                    break;

                case 7: { // refuel a truck
                    System.out.println("    action (7) "+ (i+1));
                    int truckID = keyboard.nextInt();
                    double amount = keyboard.nextDouble();

                    if(keyboard.hasNextLine())
                        keyboard.nextLine();

                    trucks.get(truckID).reFuel(amount);
                    System.out.println("Truck " + truckID + " has refueled " + amount);
                }
                    break;
            }
            System.out.println();
        }


        // Close the Scanner object.
        in.close();

        // Generate a new PrintStream object to output data to the file in the directory indicated by "args[1]"
        PrintStream out = new PrintStream(new File(args[1]));
        String result = "";

        Iterator<Warehouse> it = warehouses.iterator();
        while(it.hasNext()){
            Warehouse house = it.next();
            String content = String.format("Warehouse %d: (%.1f, %.1f)\n", house.getID(), house.getX(), house.getY());
            ArrayList<Integer>[] arr = Cargo.sortCargoes(house.getCargoes());
            for(int i = 0; i<4; i++){
                if(arr[i].size()>0){
                    switch (i){
                        case 0:
                            content+="  BasicCargo: ";
                            break;
                        case 1:
                            content+="  HeavyCargo: ";
                            break;
                        case 2:
                            content+="  DangerousCargo: ";
                            break;
                        case 3:
                            content+="  LiquidCargo: ";
                    }

                    for(int j=0; j<arr[i].size(); j++){
                        content+=arr[i].get(j) + " ";
                    }

                    content+="\n";
                }
            }
            ArrayList<Truck> truckArr = house.getCurrent();
            Iterator<Truck> it2 = truckArr.iterator();
            while(it2.hasNext()){
                Truck truck = it2.next();
                content += String.format("  Truck %d: %.1f\n", truck.getID(), truck.getFuel());

                ArrayList<Integer>[] arr2 = Cargo.sortCargoes(truck.getCurrentCargoes());
                for(int i = 0; i<4; i++){
                    if(arr2[i].size()>0){
                        switch (i){
                            case 0:
                                content+="    BasicCargo: ";
                                break;
                            case 1:
                                content+="    HeavyCargo: ";
                                break;
                            case 2:
                                content+="    DangerousCargo: ";
                                break;
                            case 3:
                                content+="    LiquidCargo: ";
                        }

                        for(int j=0; j<arr2[i].size(); j++){
                            content+=arr2[i].get(j) + " ";
                        }

                        content+="\n";
                    }
                }
            }

            result+=content + "\n";
        }



        // Print the string to the output file.
        out.print(result);

        // Close the PrintStream object.
        out.close();
    }
}

