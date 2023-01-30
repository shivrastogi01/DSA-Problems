class SuperPower{
    public int superPow(int a, int[] b) {
        int M = 1337; 
        a %= M;
        int copy = a, cycle = M; //set cycle to M by default (set to 0 also works btw).
        int[] seen = new int[M];
        for (int i = 1, mod = a % M; i <= M; i++){
            if (seen[mod] != 0){
                cycle = i - seen[mod];
                break;
            }
            seen[mod] = i;
            a *= copy; //multiply copy, not a itself. it is important.
            mod = a % M;
            a %= M;
        }
        //a^b = a^(b + cycle) (mod M)

        int reminder = 0; //mod b with cycle and store the reminder
        for (int i = 0; i < b.length; i++){
            reminder *= 10;
            reminder += b[i];
            reminder %= cycle;
        }

        for (int i = 1; i < reminder; i++, a %= M) //now just normal % operation, no overflowing will ever occur.
            a *= copy;

        return a;
    }
}