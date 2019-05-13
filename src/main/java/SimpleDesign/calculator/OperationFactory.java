package SimpleDesign.calculator;

public class OperationFactory {
    public static Operation getInstance(String str){
        Operation operation = null;
        switch (str){
            case  "+" : operation = new OperationAdd() ; break;
            case "-" : operation = new OperationMinus(); break;
        }
        return operation;
    }

    public static void main(String[] args) {
        Operation operation = OperationFactory.getInstance("+");
        operation.numberA = 1;
        operation.numberB = 2;
        int operator = operation.Operator();
        System.out.println(operator);
    }
}
