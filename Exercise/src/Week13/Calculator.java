package Week13;

public class Calculator implements ComplexNumberCalculator, RealNumberCalculator{

    @Override
    public ComplexNumber add(ComplexNumber c1, ComplexNumber c2) {
        return new ComplexNumber(add(c1.real, c2.real), add(c1.imaginary, c2.imaginary));
    }

    @Override
    public ComplexNumber sub(ComplexNumber c1, ComplexNumber c2) {
        return new ComplexNumber(sub(c1.real, c2.real), sub(c1.imaginary, c2.imaginary));
    }

    @Override
    public ComplexNumber mul(ComplexNumber c1, ComplexNumber c2) {
        return new ComplexNumber(mul(c1.real, c2.real), mul(c1.imaginary, c2.imaginary));
    }

    @Override
    public ComplexNumber.RealNumber add(ComplexNumber.RealNumber r1, ComplexNumber.RealNumber r2) {
        int dividend = r1.dividend*r2.divisor + r2.dividend* r1.divisor;
        int divisor = r1.divisor*r2.divisor;

        return new ComplexNumber.RealNumber(dividend, divisor);
    }

    @Override
    public ComplexNumber.RealNumber sub(ComplexNumber.RealNumber r1, ComplexNumber.RealNumber r2) {
        int dividend = r1.dividend*r2.divisor - r2.dividend* r1.divisor;
        int divisor = r1.divisor*r2.divisor;

        return new ComplexNumber.RealNumber(dividend, divisor);
    }

    @Override
    public ComplexNumber.RealNumber mul(ComplexNumber.RealNumber r1, ComplexNumber.RealNumber r2) {
        int dividend = r1.dividend * r2.dividend;
        int divisor = r1.divisor * r2.divisor;

        return new ComplexNumber.RealNumber(dividend, divisor);
    }
}
