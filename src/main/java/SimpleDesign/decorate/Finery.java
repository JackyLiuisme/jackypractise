package SimpleDesign.decorate;

public class Finery  extends Person{
         protected  Person person = null;
         public void Decorate(Person person){
             this.person = person;
         }
         @Override
         public void show(){
             if (person != null){
                 person.show();
             }
         }

}
