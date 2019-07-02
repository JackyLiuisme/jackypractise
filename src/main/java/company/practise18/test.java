package company.practise18;

public class test {
    public static void main(String[] args) {
        String s = "abcd";
        String [] str = s.split("");
        for (String string:
             str) {
            System.out.println(string);
        }
        System.out.println(s.substring(0,1));

    }
}
