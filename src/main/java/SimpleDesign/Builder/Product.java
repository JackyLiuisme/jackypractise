package SimpleDesign.Builder;

import java.util.LinkedList;
import java.util.List;

public class Product {
    List<String > parts = new LinkedList<>();
    public void add(String part){
        parts.add(part);
    }

    public void show(){
        for (String part:parts
             ) {
            System.out.println(part);
        }
    }
}
