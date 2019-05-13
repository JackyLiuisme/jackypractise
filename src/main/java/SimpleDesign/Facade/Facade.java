package SimpleDesign.Facade;

public class Facade {
    SubSystem1 subSystem1 = new SubSystem1();
    System2 system2 = new System2();
    SubSystem3 subSystem3 = new SubSystem3();
    public void method1(){
        subSystem1.method();
        system2.methode2();
    }
    public void method2(){
        system2.methode2();
        subSystem3.method3();
    }

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.method1();
        facade.method2();
    }
}
