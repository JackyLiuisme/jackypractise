package SimpleDesign.component;

public abstract class Component {
    public Component(String name) {
        this.name = name;
    }

    protected String name;

    public abstract void add(Component component);
    public abstract void remove(Component component);
    public abstract void Display(int depth);
}
