public class LiquidCargo extends HeavyCargo{
    public LiquidCargo(int id, int weight) {
        super(id, weight);
    }

    @Override
    double consumption() {
        return 3.5*this.getWeight();
    }
}
