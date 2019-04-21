package basic.Enum;

public class test {
    public static void main(String[] args) {
        TestEnum man;
        man = TestEnum.valueOf("MAN");
        man.setName("bitch");
        System.out.println(man.toString());
    }
}
