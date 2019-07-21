package offer;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * Example 1:
 *
 * Input: 3
 * Output: "III"
 * Example 2:
 *
 * Input: 4
 * Output: "IV"
 * Example 3:
 *
 * Input: 9
 * Output: "IX"
 * Example 4:
 *
 * Input: 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * Example 5:
 *
 * Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class intToRoman {
    public static void main(String[] args) {
        String s = intToRoman(9);
        System.out.println(s);
    }
    public static String intToRoman(int num) {
        int [] nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String [] str = {"M","MC","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder result = new StringBuilder();
        for (int i = 0;  i< nums.length; i++){
            while (num >= nums[i]){
                num -= nums[i];
                result.append(str[i]);
            }
        }
        return result.toString();









     /*   int [] nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String [] str = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        String result = "";
        int i = 0;
        while (num != 0){

            while (num >= nums[i]){
                num = num - nums[i];
                result += str[i];
            }
            if (i < 13) {
                i++;
            }
        }

        return result;*/
    }


}
