class SumOfDigitBaseK{
    public int sumBase(int n, int k) {
        int sum=0;
        while(n>0)
        {
            int digit=n%k;
            sum+=digit;
            n=n/k;
        }
        return sum;
    }
}