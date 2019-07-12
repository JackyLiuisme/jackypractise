package SimpleDesign.Singletom;

public class StaticInnerClass {
    private StaticInnerClass(){}

    private static class innerClass{
        private static final StaticInnerClass instance = new StaticInnerClass();
    }

    public StaticInnerClass getInstance(){
        return innerClass.instance;
    }
}
