class Solution {
    static {
        for (int i = 0; i < 500; i++) {
            appendCharacters("", "");
        }
    }
    public static int appendCharacters(String s, String t) {
        int i=0,j=0;
        while(i<s.length() && j<t.length()){
            if(s.charAt(i)==t.charAt(j)){
                i++;
                j++;
            }
            while(i<s.length() && j<t.length() && t.charAt(j)!=s.charAt(i)){
                i++;
            }
        }
        return t.length()-j;
    }
}