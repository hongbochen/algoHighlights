package site.laoc;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		lps.longestPalindrome("cbbd");
	}
	
	public void longestPalindrome(String s) {
        int length = s.length();
        
        for(int i = 0;i < length;i++){
        	char tmp = s.charAt(i);
        	
        	for(int p = i;p < length;p++){
        		char pt = s.charAt(p);
        		if(p == length-1 && pt == tmp){
        			String one = s.substring(i,p);
        			System.out.println(one);
        		}
        		
        		if(pt != tmp && p - i >= 2){
        			String one = s.substring(i,p);
        			System.out.println(one);
        		}
        	}
        	
        	int m,n;
        	for(m=i,n=i; m >=0 && n < length;m--,n++){
        		char mt = s.charAt(m);
        		char nt = s.charAt(n);
        		
        		if(mt == nt && m == 0){
        			String one = s.substring(m,n+1);
        			System.out.println(one);
        		}else if(mt == nt && n == length-1){
        			String one = s.substring(m,n);
        			System.out.println(one);
        		}else if(mt != nt){
        			System.out.println(m + " eeee " + n);
        			String one = s.substring(m+1,n);
        			System.out.println(one);
        		
        		}
        	}
        	
        	System.out.println("============================ " + i);
        }
    }

}
