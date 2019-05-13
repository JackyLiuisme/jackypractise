package SimpleDesign.calculator;

public class AddFactory extends Factory {
    @Override
    public Operation operation() {
        return new OperationAdd();
    }

    public static void main(String[] args) {
        Factory add =  new AddFactory();
        Operation operation = add.operation();
        operation.numberA = 3;
        operation.numberB = 3;
        int operator = operation.Operator();
        System.out.println(operator);
    }
}
