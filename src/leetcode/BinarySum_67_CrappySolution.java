package leetcode;

import java.util.Arrays;

public class BinarySum_67_CrappySolution {

    public static void main(String[] args) {
        System.out.println(new BinarySum_67_CrappySolution().addBinary("1010","1011"));
        System.out.println(new BinarySum_67_CrappySolution().addBinary("11","1"));
        System.out.println(new BinarySum_67_CrappySolution().addBinary("0","0"));
        System.out.println(new BinarySum_67_CrappySolution().addBinary("0","1"));
    }

    public String addBinary(String a, String b) {


        int maxLength = Integer.max(a.length(), b.length());


        char[] s = new char[maxLength+1];
        Arrays.fill(s, '0');


        StringBuilder sba = new StringBuilder();
        sba.append("0".repeat(Math.max(0, maxLength - a.length() + 1)));

        StringBuilder sbb = new StringBuilder();
        sbb.append("0".repeat(maxLength - b.length() + 1));

        char[] x = (sba+a).toCharArray();
        char[] y = (sbb+b).toCharArray();


        char p = '0';
        int xi = -1;
        int yi = -1;
        for(int i=s.length-1;i>=0;--i) {

            if(x[i]=='0' && y[i]=='0') {
                if(p=='1') {
                    s[i] = '1';
                    p = '0';
                } else {
                    s[i] = '0';
                }
            } else if(x[i]!='0' && y[i]=='0') {
                if(p=='1') {
                    s[i] = '0';
                } else {
                    s[i] = '1';
                    p = '0';
                }
            } else if(x[i]=='0' && y[i]!='0') {
                if(p=='1') {
                    s[i] = '0';
                } else {
                    s[i] = '1';
                    p = '0';
                }
            } else {
                if(p=='0') {
                    s[i] = '0';
                    p = '1';
                } else {
                    s[i]='1';
                }
            }
        }

         if(xi>0) {
             for(int i=xi;i>=0;--i) {
                 if(p=='1') {
                     s[i] = '0';
                     p = '0';
                 } else {
                     s[i]='0';
                 }
             }
         } else if(yi>0) {
             for(int i=yi;i>=0;--i) {
                                 if(p=='1') {
                     s[i] = '0';
                     p = '0';
                 } else {
                     s[i]='0';
                 }
             }
         }

         if(p=='1') {
             s[0] = '1';
         }




        int leadingZeroesCount = 0;

        for (char c : s) {
            if (c != '0') {
                break;
            } else {
                leadingZeroesCount++;
            }
        }

         if(leadingZeroesCount==s.length) {
             return "0";
         }

         char[] result = new char[s.length-leadingZeroesCount];
         int j = 0;
         for(int i=0;i<s.length;++i) {
             if(i<leadingZeroesCount) {
                if(j<result.length) {
                    ++j;
                }
             } else {
                 if(j<result.length) {
                     result[j++] = s[i];
                 }
             }
         }

         return new String(result);
    }

}
