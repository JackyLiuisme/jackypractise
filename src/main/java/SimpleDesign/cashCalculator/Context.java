package SimpleDesign.cashCalculator;

public class Context {
    cashSuper cash = null;

    public Context(String type){
        switch (type){
            case "normal" : cash = new cashNormal();
            break;
            case "discount" : cash = new cashRebate(0.8);
            break;
        }
    }
    public double count(double money){
        double cash = this.cash.getCash(money);
        return cash;
    }

    public static void main(String[] args) {
        Context discount = new Context("discount");
        double money = discount.count(20);

    }
}
