package offer;

public class Power {
    public static double Power1(double base, int exponent) throws Exception {
        double result = 1,recurr = (int) base;
            int    power = exponent;

        if (exponent < 0 ){
            power = -power;
        }else if (exponent > 0){
            power = exponent;
        }else {
            if (base == 0){

                throw new  Exception("分母不能为零");
            }
            return 1;
        }

        while (power != 0){
            if ((power & 1) == 1){
                result *= recurr;
            }
            recurr *= recurr;

            power = power >> 1;
        }
        return exponent > 0 ? result: 1/result;

        }

    public static void main(String[] args) throws Exception {
        double power = Power1(5, 4);
        System.out.println(power);
    }
    }

