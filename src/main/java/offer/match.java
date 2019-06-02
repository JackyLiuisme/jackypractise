package offer;

public class match {
    public static boolean match(char[] str, char[] pattern)
    {
        if (str == null){
            return true;
        }
       return matchCase(str,0,pattern,0);

    }
    public static boolean matchCase(char[] str,int strIndex,char[] pattern,int patternIndex){
        if (strIndex == str.length && patternIndex == pattern.length){
            return true;
        }
        if (strIndex == str.length && patternIndex != patternIndex){
            return false;
        }
        if (patternIndex + 1 < pattern.length && pattern[patternIndex+1] == '*'){
            if ((pattern[patternIndex] == str[strIndex] && strIndex != str.length) ||
                    (pattern[patternIndex] == '.' && strIndex != str.length)){
                return matchCase(str,strIndex+1,pattern,patternIndex+1)
                        || matchCase(str,strIndex+1,pattern,patternIndex + 2)
                        || matchCase(str,strIndex,pattern,patternIndex+2);
            }

        }
        if ((strIndex != str.length && str[strIndex] == pattern[patternIndex] )|| (strIndex != str.length && str[strIndex] == '.')){
            return matchCase(str,strIndex+1,pattern,patternIndex+1);
        }
        return false;


    }
}
