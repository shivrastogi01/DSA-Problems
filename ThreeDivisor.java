class ThreeDivisor{
    public boolean isThree(int n) {
        int numDivisors = 0;
        for (int i = 1; i <= n; i++){
            numDivisors = (n % i == 0) ? numDivisors + 1 : numDivisors;
        }
        return (numDivisors == 3) ? true : false;
    }
}