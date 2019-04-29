import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Polynom {
    private  FractionSet coefficients = new FractionSet();

    Polynom(FractionSet coefficients) {
        this.coefficients.addAll(coefficients);
    }

    Polynom(Collection<Fraction> fractions) {
        coefficients.addAll(fractions);
    }

    Polynom(Fraction... coefficients) {
        this.coefficients.addAll(Arrays.asList(coefficients));
    }

    Polynom plus(Polynom other) {
        Iterator<Fraction> firstPolynom = coefficients.getFractionSet().iterator();
        Iterator<Fraction> secondPolynom = other.coefficients.getFractionSet().iterator();
        FractionSet newCoefficients = new FractionSet();
        while(firstPolynom.hasNext() && secondPolynom.hasNext()) {
            newCoefficients.add(firstPolynom.next().plus(secondPolynom.next()));
        }
        while (firstPolynom.hasNext()) {
            newCoefficients.add(firstPolynom.next());
        }
        while (secondPolynom.hasNext()) {
            newCoefficients.add(secondPolynom.next());
        }
        return new Polynom(newCoefficients);
    }
}
