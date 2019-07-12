package SimpleDesign.Builder;

public class ConcreteBuilderB extends Builder{
    Product product  = new Product();


    @Override
    public void BuildPartA() {
        product.add("C part");
    }

    @Override
    public void BuildPartB() {
        product.add("D part");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
