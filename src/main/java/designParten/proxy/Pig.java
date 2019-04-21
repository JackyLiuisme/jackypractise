package designParten.proxy;

public class Pig {
    private static PigLeg PigLeg;

    int age;
    public class PigLeg{
        int length , weight;
    }

    public static void main(String[] args) {
        PigLeg pigLeg = Pig.PigLeg;
    }
}
