import java.util.*;

public class FractionSet {


    private List<Fraction> fractionSet = new ArrayList<>();

    private KeyValueCache<Fraction, Integer> keyValueCacheBelow= new KeyValueCache<>();
    private KeyValueCache<Fraction, Integer> keyValueCacheAbove= new KeyValueCache<>();
    private ValueCache<Fraction> valueCacheMin = new ValueCache<>();
    private ValueCache<Fraction> valueCacheMax = new ValueCache<>();

    FractionSet() { }

    FractionSet(int maxSize) {
        keyValueCacheBelow.setMaxSize(maxSize);
        keyValueCacheAbove.setMaxSize(maxSize);
    }

    FractionSet(Collection<Fraction> fractions) {
        fractionSet.addAll(fractions);
    }

    FractionSet(Collection<Fraction> fractions, int maxSize) {
        fractionSet.addAll(fractions);
        keyValueCacheBelow.setMaxSize(maxSize);
        keyValueCacheAbove.setMaxSize(maxSize);
    }

    FractionSet(Fraction... fractions) {
        fractionSet.addAll(Arrays.asList(fractions));
    }

    FractionSet(int maxSize, Fraction... fractions) {
        fractionSet.addAll(Arrays.asList(fractions));
        keyValueCacheBelow.setMaxSize(maxSize);
        keyValueCacheAbove.setMaxSize(maxSize);
    }

    public List<Fraction> getFractionSet() {
        return fractionSet;
    }

    public void add(Fraction f) {
        fractionSet.add(f);
    }

    public void addAll(Collection<Fraction> fractions) {
        fractionSet.addAll(fractions);
    }

    public void addAll(FractionSet fractions) {
        for (Fraction f : fractions.fractionSet) {
            fractionSet.add(f);
        }
    }

    public Fraction getMax() {
        if (!valueCacheMax.isCached())
            valueCacheMax.set(Collections.max(fractionSet));
        return valueCacheMax.get();
    }

    public Fraction getMin() {
        if (!valueCacheMax.isCached())
            valueCacheMax.set(Collections.min(fractionSet));
        return valueCacheMin.get();
    }

    public int getBelowCount(Fraction f) {
        if (!keyValueCacheBelow.isCached(f))
            keyValueCacheBelow.add(f, (int)fractionSet.stream().filter(it -> it.compareTo(f) < 0).count());
        return keyValueCacheBelow.get(f);
    }

    public int getAboveCount(Fraction f) {
        if (!keyValueCacheAbove.isCached(f))
            keyValueCacheAbove.add(f, (int)fractionSet.stream().filter(it -> it.compareTo(f) > 0).count());
        return keyValueCacheAbove.get(f);
    }
}
