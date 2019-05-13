package SimpleDesign.cashCalculator;

public class cashRebate extends cashSuper {
    double rate;
    public cashRebate(double rate) {
        this.rate = rate;
    }

    @Override
    public double getCash(double cash) {
        return cash * rate;
    }
}
