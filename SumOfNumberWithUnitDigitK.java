class SumOfNumberWithUnitDigitK{
   public int minimumNumbers(int num, int k) {
        int val = num % 10;
        if (num == 0) return 0;
        if (num < k) return -1;
              
        for(int i=1; i<=10; i++) {
            if((k * i) % 10 == val && (k * i) <= num) {
                return i;
            }
        }
        
        return -1;
    }
}