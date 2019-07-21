package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * intput Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 */
public class RestoreIpAddresses {
    public static void main(String[] args) {
        String str = "25525511135";
        List<String> list = restoreIpAddresses(str);
        for (String string : list
             ) {
            System.out.println(string);
        }
    }
    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        int len = s.length();
        for (int i = 0; i < 4 && i < len - 2; i++) {
            for (int j = i + 1; j < i + 4 && j < len - 1; j++) {
                for (int k = j + 1; k < j + 4 && k < len; k++) {
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i, j);
                    String s3 = s.substring(j, k);
                    String s4 = s.substring(k, len);
                    if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                        result.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }
                }
            }
        }
        return result;
    }

    private static boolean isValid(String s) {
        if (s.length() > 3 || s.length() == 0 || (s.charAt(0) == '0' && s.length() > 1) || Integer.parseInt(s) > 255) {
            return false;
        }
        return true;
    }
   /* public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<>();
        ArrayList<String> ip = new ArrayList<>();
        //存放中间结果
        dfs(s, res, ip, 0);
        return res;
    }

    private void dfs(String s, ArrayList<String> res, ArrayList<String> ip, int start){
        if(ip.size() == 4 && start == s.length()){
            //找到一个合法解
            res.add(ip.get(0) + '.' + ip.get(1) + '.' + ip.get(2) + '.' + ip.get(3));
            return;
        }
        if(s.length() - start > 3 * (4 - ip.size())) {
            //剪枝
            return;
        }
        if(s.length() - start < (4 - ip.size())) {
            //剪枝
            return;
        }
        int num = 0;
        for(int i = start; i < start + 3 && i < s.length(); i++){
            num = num * 10 + (s.charAt(i) - '0');
            if(num < 0 || num > 255) {
                //剪枝
                continue;
            }
            ip.add(s.substring(start, i + 1));
            dfs(s, res, ip, i + 1);
            ip.remove(ip.size() - 1);

            if(num == 0) {
                //不允许前缀0
                break;
            }
        }
    }*/

 /*   public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        restoreIpAddresses(s, 0, result, "", 4);
        return result;
    }*/

   /* private void restoreIpAddresses(String ip, int begin, List<String> result, String temp, int count) {
        if (count == 0) {
            if (begin == ip.length()) {
                result.add(temp);
            }
            return;
        }
        for (int i = 1; i < 4; i++) {
            if (begin + i > ip.length()) {
                break;
            }
            String s = ip.substring(begin, begin + i);
            if ((s.charAt(0) == '0' && s.length() > 1) || Integer.parseInt(s) > 255) {
                continue;
            }
            restoreIpAddresses(ip, begin + i, result, temp + s + (count == 1 ? "" : "."), count - 1);
        }
    }*/
}
