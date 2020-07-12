package basic.Enum;

public class test {
    public void judge(TestEnum testEnum){
        switch (testEnum) {
            case MAN:
                System.out.println("I am man");
                break;
            case WOMAN:
                System.out.println("I am woman");
                break;
        }
    }
    public static void main(String[] args) {
        TestEnum man;
       man = TestEnum.valueOf("lllMAN");
        man.setName("bitch");
        TestEnum.MAN.setName("bbbb");
        System.out.println(man.getName());
        System.out.println(man.toString());
        for (TestEnum t : TestEnum.values()
             ) {
            System.out.println(t);
        }
        new test().judge(TestEnum.WOMAN);
    }
}
