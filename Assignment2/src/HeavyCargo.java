public class HeavyCargo extends Cargo{

    public HeavyCargo(int id, int weight){
        super(id, weight);
    }
    @Override
    double consumption() {
        return 2.5*this.getWeight();
    }
}
