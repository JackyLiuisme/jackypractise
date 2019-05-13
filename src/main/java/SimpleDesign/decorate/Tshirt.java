package SimpleDesign.decorate;

public class Tshirt extends Finery {
    @Override
    public void show(){
        System.out.println("wearing T-shirt");
        person.show();
    }

}
