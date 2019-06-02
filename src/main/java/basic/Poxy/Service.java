package basic.Poxy;

public class Service implements proxy {
    public Service(){
        System.out.println("service init");
    }


    @Override
    public void doservice(String order){
        System.out.println("service the order");
    }
    final public void sayHello(){
        System.out.println("this is final hello");
    }

}
