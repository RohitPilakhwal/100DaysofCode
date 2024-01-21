import java.math.BigInteger;

class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==-2147483648 && divisor ==-1) return Integer.MAX_VALUE;
       BigInteger divden = new BigInteger(Integer.toString(dividend));
       BigInteger divsor = new BigInteger(Integer.toString(divisor));
       BigInteger ans = divden.divide(divsor);
       int res = ans.intValue();
       return res;
    }
}