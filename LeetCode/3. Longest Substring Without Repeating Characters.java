// 3. Longest Substring Without Repeating Characters
//
// Given a string, find the length of the longest substring without repeating characters.
//
// Examples:
// 
// Given "abcabcbb", the answer is "abc", which the length is 3.
//
// Given "bbbbb", the answer is "b", with the length of 1.
//
// Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s  == null || s.length() == 0)
            return 0;

        char[] charArr = s.toCharArray();
        int maxLen = Integer.MIN_VALUE;
        int len = 0;
        int i,j;
        ArrayList<Character> substring = new ArrayList<Character>();

        for(i=0; i<charArr.length; i++){
            substring.clear();
            substring.add(charArr[i]);
            for(j=i+1; j<charArr.length;j++){
                char tmp = charArr[j];
                if(!substring.contains(tmp)){
                    substring.add(tmp);
                    continue;
                } else {
                    break;
                }
            }
            len = j-i;
            maxLen = maxLen > len ? maxLen : len;
        }
        return maxLen;
    }
}
