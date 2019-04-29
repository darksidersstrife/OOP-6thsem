public class Fraction implements Comparable<Fraction> {
    private int numerator;
    private int denominator;

    Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException();
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public int compareTo(Fraction o) {
        return Double.compare((double) numerator / denominator, (double) o.numerator / o.denominator);
    }

    public Fraction plus(Fraction other) {
        return new Fraction(numerator * other.denominator + other.numerator * denominator, denominator * other.denominator);
    }
}
