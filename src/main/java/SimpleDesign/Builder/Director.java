package SimpleDesign.Builder;

public class Director {
    Builder builder;
    Director(Builder builder){
        builder.BuildPartA();
        builder.BuildPartB();
        this.builder = builder;
    }

    public static void main(String[] args) {

        ConcreteBuilder a = new ConcreteBuilder();
        ConcreteBuilderB b = new ConcreteBuilderB();
        Director director = new Director(a);
        Product result = a.getResult();
        result.show();
    }
}
