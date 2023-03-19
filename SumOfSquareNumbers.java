class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        int right = (int) Math.sqrt(c);
        int left = (int) Math.sqrt(c / 2);
        
        for (int i = left; i <= right; i++) {
            int j = (int) Math.sqrt(c - i*i);
            if (i*i + j*j == c)
                return true;
        }
        return false;
    }
}