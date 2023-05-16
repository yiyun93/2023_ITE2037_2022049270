public class DangerousCargo extends HeavyCargo{
    public DangerousCargo(int id, int weight) {
        super(id, weight);
    }

    @Override
    double consumption() {
        return 4.0*this.getWeight();
    }
}
