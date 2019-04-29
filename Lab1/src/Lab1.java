

public class Lab1 {
    public static void main(String[] args) {
        System.out.println(5 / 2);
        Polynom p1 = new Polynom(
                new FractionSet(
                        new Fraction(1, 2),
                        new Fraction(1, 3)
                ));
        Polynom p2 = new Polynom(
                new FractionSet(
                        new Fraction(1, 3),
                        new Fraction(3, 7)
                ));
        Polynom p3 = p1.plus(p2);
    }
}
