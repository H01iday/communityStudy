package leetcode;

class Solution {
    public static void main(String[] args) {
        String needle = "ababaaaba";
        char[] pat = needle.toCharArray();
        int[] next = new int[pat.length];
        next[0] = 0;
        for (int i=1,j=0; i<pat.length; i++){
            while (j>0&&pat[i]!=pat[j]){
                j=next[j-1];
            }
            if (pat[i]==pat[j])j++;
            next[i]=j;
        }
        for (int i : next){
            System.out.print(i+" ");
        }
    }
}
