// 5. Longest Palindromic Substring
// 
// Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.


public class Solution {
    public String longestPalindrome(String s) {
        if(s  == null || s.length() == 0)
            return null;
        if(s.length() == 1)
            return s;
        if(s.length() == 2){
            if(s.charAt(0) == s.charAt(1)){
                return s;
            } else {
                return s.substring(0);
            }
        }
        String subStr = "";
        String tmpStr = "";


        for(int i=1; i< s.length(); i++){
            tmpStr = "";
            int j=i-1,k=i+1;
            while(j >= 0 && k <s.length()){
                if(s.charAt(j) == s.charAt(k)){
                    j--;
                    k++;
                    continue;
                } else {
                    break;
                }
            }
            tmpStr = s.substring(j+1,k);
            subStr = subStr.length() > tmpStr.length() ? subStr : tmpStr;
        }
        for(int i=0; i<s.length(); i++) {
            tmpStr = "";
            int j=i;
            int k=i+1;
            while(j >= 0 && k <s.length()){
                if(s.charAt(j) == s.charAt(k)){
                    j--;
                    k++;
                    continue;
                } else {
                    break;
                }
            }
            tmpStr = s.substring(j+1,k);
            subStr = subStr.length() > tmpStr.length() ? subStr : tmpStr;
        }
        if(s.charAt(0) == s.charAt(1)){
                String tmpFirst = s.substring(0,2);
                subStr = subStr.length() > tmpFirst.length() ? subStr : tmpFirst;
            }
        if(s.charAt(s.length()-2) == s.charAt(s.length()-1)){
            String tmpLast = s.substring(s.length()-2,s.length());
            subStr = subStr.length() > tmpLast.length() ? subStr : tmpLast;
        }
        return subStr;
    }
}
