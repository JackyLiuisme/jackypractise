package leetcode;

/**
 * 示例 1:
 *
 * 输入: "172.16.254.1"
 *
 * 输出: "IPv4"
 *
 * 解释: 这是一个有效的 IPv4 地址, 所以返回 "IPv4"。
 * 示例 2:
 *
 * 输入: "2001:0db8:85a3:0:0:8A2E:0370:7334"
 *
 * 输出: "IPv6"
 *
 * 解释: 这是一个有效的 IPv6 地址, 所以返回 "IPv6"。
 * 示例 3:
 *
 * 输入: "256.256.256.256"
 *
 * 输出: "Neither"
 *
 * 解释: 这个地址既不是 IPv4 也不是 IPv6 地址。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-ip-address
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P468 {
    public static void main(String[] args) {
        String ip = "172.16.254.1";
        String string = validIpAdress(ip);
        System.out.println(string);
    }
    public static String validIPAddress1(String IP) {
        if(IP.startsWith(":")||IP.startsWith(".")
                ||IP.endsWith(":")||IP.endsWith(".")) {
            return "Neither";
        }
        String[] splitted = IP.split("\\.");
        if(splitted.length==4){
            int num=-1;
            for(int i=0;i<4;i++){
                try{
                    num=Integer.parseInt(splitted[i]);
                }catch(NumberFormatException e){
                    return "Neither";
                }
                if(num<0||num>255){
                    return "Neither";
                }
                if(splitted[i].length()>1
                        &&(splitted[i].startsWith("0")||splitted[i].startsWith("-"))) {
                    return "Neither";
                }
            }
            return "IPv4";
        }else{
            splitted = IP.split(":");
            if(splitted.length==8){
                long num=-1;
                for(int i=0;i<8;i++){
                    if(splitted[i].length()>4||splitted[i].startsWith("-")) {
                        return "Neither";
                    }
                    try{
                        num=Long.parseLong(splitted[i],16);
                    }catch(NumberFormatException e){
                        return "Neither";
                    }
                    if(num<0) {
                        return "Neither";
                    }
                }return "IPv6";
            }else {
                return "Neither";
            }
        }
    }

    public static String validIpAdress(String IP){
        if (IP.length() == 0){
            return "neither";
        }
        String [] str = IP.split("\\.");
        if (str.length == 4){
            for (int i = 0; i < 4; i++){
                if (str[i].length() > 1 && (str[i].startsWith("0") || str[i].startsWith("-")) ){
                    return "neither";
                }
                Long num;
                try{
                    num = Long.parseLong(str[i]);
                }catch (Exception e){
                    return "neither";
                }
                if (num >255 || num < 0){
                    return "neither";
                }
            }
            return "IPV4";
        } else {
            str = IP.split(":");
            if (str.length == 8) {
                for (int i = 0; i < 8; i++){
                    if (str[i].startsWith("-") || str[i].length() > 4){
                        return "neither";
                    }
                    long num;
                    try{
                        num = Long.parseLong(str[i],16);
                    }catch (Exception e){
                        return "neither";
                    }
                }
                return "IPV6";
            }else {
                return "neither";
            }
        }
    }
}
