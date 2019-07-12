package SimpleDesign.Builder;

public class ConcreteBuilder extends Builder{
    Product product  = new Product();


    @Override
    public void BuildPartA() {
        product.add("A part");
    }

    @Override
    public void BuildPartB() {
        product.add("B part");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
