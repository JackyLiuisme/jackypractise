package SimpleDesign.decorate;

public class Person {
    private String name;
    public  Person(){}
    public Person(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println("装扮人： " + name);
    }
}
