package SimpleDesign.decorate;

public class Pants extends Finery {
    @Override
    public void show(){
        System.out.println("wearing Pants");
        person.show();
    }

    public static void main(String[] args) {
        Person person = new Person("jacky");
        Pants pants = new Pants();
        Tshirt tshirt = new Tshirt();
        pants.Decorate(person);
       tshirt.Decorate(pants);
       // tshirt.Decorate(person);
        tshirt.show();
    }
}
