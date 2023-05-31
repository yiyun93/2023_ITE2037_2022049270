package Week13;

public class ComplexNumber {
    public static class RealNumber{
        protected int dividend;
        protected int divisor;

        public RealNumber(int dividend, int divisor){
            this.dividend = dividend;
            this.divisor = divisor;
        }
        public String toString(){
            return String.format("%d/%d", dividend, divisor);
        }
    }

    protected RealNumber real;
    protected RealNumber imaginary;

    public ComplexNumber(RealNumber num1, RealNumber num2){
        real = num1;
        imaginary = num2;
    }
}
