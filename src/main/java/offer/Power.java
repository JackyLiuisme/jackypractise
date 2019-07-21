package offer;

public class Power {
    public static double Power(double base, int exponent) throws Exception {
      /*  if(exponent==0 && base != 0)
            return 1;*/
        if(exponent==1)
            return base;
        if(base == 0 && exponent <= 0){
            throw new RuntimeException();
        }
        if(base ==0 && exponent>0){
            return 0;
        }
        int n= exponent;
        if(exponent<0){
            n = -exponent;
        }
        double  result=Power(base,n>>1);
        result*=result;
        if((n&1)==1)
            result*=base;
        if(exponent<0)
            result=1/result;
        return result;

    }
    public static double Power1(double base, int exponent) throws Exception {
        if (exponent == 0 && base != 0){
            return 1;
        }
        if(exponent==1)
            return base;
        if(base == 0 && exponent <= 0){
            throw new RuntimeException();
        }
        if(base ==0 && exponent>0){
            return 0;
        }
        int n  = exponent;
        if(exponent<0){
            n = -exponent;
        }
        double result = getResult(base,n);
        if(exponent < 0 ){
            result = 1/result;
        }
        return result;

    }
        public static double getResult(double base,int expont){
       /* if (expont == 0){
            return 1;
        }*/
       if (expont == 1){
           return base;
       }
       double result = getResult(base,expont>>1);
       result *= result;
       if ((expont & 1)== 1){
           result *= base;
       }
       return result;
    }

    public static void main(String[] args) throws Exception {
        double power = Power1(2, 3);
        System.out.println(power);
    }
    }

