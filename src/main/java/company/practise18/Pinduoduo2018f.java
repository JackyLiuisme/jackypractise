package company.practise18;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 大整数相乘
 */
public class Pinduoduo2018f {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        BigDecimal bigDecimal1 = scanner.nextBigDecimal();
        BigDecimal bigDecimal2 = scanner.nextBigDecimal();
        BigDecimal result = bigDecimal1.multiply(bigDecimal2);
        System.out.println(result.toString());
    }
}
