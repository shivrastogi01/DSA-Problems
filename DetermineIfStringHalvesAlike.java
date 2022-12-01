class DetermineIfStringHalvesAlike {
   public boolean halvesAreAlike(String s) {
        var v = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int a = 0, b = 0;
        for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
            if (v.contains(s.charAt(i))) 
                a +=  1;
            if(v.contains(s.charAt(j)))
                b +=  1;
        }
        return a == b;
    }
}