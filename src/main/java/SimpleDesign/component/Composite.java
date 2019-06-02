package SimpleDesign.component;

import java.util.LinkedList;
import java.util.List;

public class Composite extends Component {
    private List<Component> list = new LinkedList<>();

    public Composite(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        list.add(component);
    }

    @Override
    public void remove(Component component) {
        list.remove(component);
    }

    @Override
    public void Display(int depth) {
        System.out.println(depth + name) ;
        for (Component c :
                list) {
                c.Display(depth+1);
        }
    }

    public static void main(String[] args) {
        System.out.println(args.length);
        for (String s:args
             ) {
            System.out.println(s);
        }
        Composite root = new Composite("root");
        Leaf leaf1 = new Leaf("leaf1");
        Leaf leaf2 = new Leaf("leaf2");
        root.add(leaf1);
        root.add(leaf2);
        Composite next = new Composite("next");
        Leaf leaf3 = new Leaf("leaf3");
        Leaf leaf4 = new Leaf("leaf4");
        Leaf leaf5 = new Leaf("leaf5");
        next.add(leaf3);
        next.add(leaf4);
        next.add(leaf5);
        root.add(next);
        root.Display(1);
    }
}
