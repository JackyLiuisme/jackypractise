package SimpleDesign.component;

public class Leaf extends Component {

    public Leaf(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        System.out.println("leaf can not add ");
    }

    @Override
    public void remove(Component component) {
        System.out.println("leaf can not remove");
    }

    @Override
    public void Display(int depth) {
        System.out.println(depth +  name);
    }
}
