package Week13;

public interface ComplexNumberCalculator {
    public ComplexNumber add(ComplexNumber c1, ComplexNumber c2);
    public ComplexNumber sub(ComplexNumber c1, ComplexNumber c2);
    public ComplexNumber mul(ComplexNumber c1, ComplexNumber c2);

    default public void printResult(ComplexNumber c){
        System.out.println("Real : " + c.real.toString() + ", Imaginary : " + c.imaginary.toString());
    }
}
