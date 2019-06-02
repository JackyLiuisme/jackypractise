package offer;

public class isNumeric {
    public static void main(String[] args) {
        String string = "-1.32e-23";

        boolean numeric = isNumeric(string.toCharArray());
        System.out.println(numeric);
    }
    private static int index = 0;

    public static boolean isNumeric(char[] str) {
        if (str.length < 1) {
            return false;
        }

        boolean flag = true;
        flag= hasSymbol(str);
        if ( index < str.length && str[index] == '.' ){
            index++;
            flag =  isNumber(str) || flag;
        }
        if (index < str.length && (str[index] == 'e' || str[index] == 'E')){
            index++;
            flag = flag && hasSymbol(str);
        }
        return flag && index == str.length;
    }

    public static boolean hasSymbol(char[] str){
        if (str[index] == '+' || str[index] == '-'){
            index++;
        }
        return isNumber(str);
    }

    public static boolean isNumber(char[] str){
        int start = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9' ){
            index++;
        }
        return start < index;
    }




















        /*boolean flag = scanInteger(str);

        if (index < str.length && str[index] == '.') {
            index++;
            flag = scanUnsignedInteger(str) || flag;
        }

        if (index < str.length && (str[index] == 'E' || str[index] == 'e')) {
            index++;
            flag = flag && scanInteger(str);
        }

        return flag && index == str.length;

    }

    private boolean scanInteger(char[] str) {
        if (index < str.length && (str[index] == '+' || str[index] == '-') ) {
            index++;
        }
        return scanUnsignedInteger(str);

    }

    private boolean scanUnsignedInteger(char[] str) {
        int start = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9') {
            index++;
        }
        return start < index; //是否存在整数
    }*/
}
