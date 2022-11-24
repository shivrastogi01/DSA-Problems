class ZerosAndOnes {

int[] ones;
int[] zeroes;
Integer[][][] cache;

public int findMaxForm(String[] strs, int m, int n) {
    
    ones = new int[strs.length];
    zeroes = new int[strs.length];
    cache = new Integer[strs.length+1][m+1][n+1];
    
    for (int i = 0; i < strs.length; i++) {
        
        String k = strs[i];
        
        for (char c: k.toCharArray()) {
            if (c == '0') {
                zeroes[i] += 1;
            }
            else {
                ones[i] += 1;
            }
        }
    }
    
    return rec(0, m, n);
}

private int rec(int pos, int m, int n) {
    
    if (m < 0 || n < 0) {
        return Integer.MIN_VALUE;
    }
    
    else if (pos == ones.length) {
        return 0;
    } 
    
    else if (cache[pos][m][n] != null) {
        return cache[pos][m][n];
    }
    
    else {
        cache[pos][m][n] = Math.max(1 + rec(pos+1, m - zeroes[pos], n - ones[pos]), rec(pos+1, m, n));
        return cache[pos][m][n];
    }
}
}