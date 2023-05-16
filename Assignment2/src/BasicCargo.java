public class BasicCargo extends Cargo{

    public BasicCargo(int id, int weight){
        super(id, weight);
    }
    @Override
    double consumption() {
        return 1.5*this.getWeight();
    }
}
