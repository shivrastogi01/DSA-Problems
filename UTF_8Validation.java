class UTF_8Validation {
    private static final int bit_7_mask = 1 << 7;
    private static final int bit_6_mask = 1 << 6;
    private static final int bit_5_mask = 1 << 5;
    private static final int bit_4_mask = 1 << 4;
    private static final int bit_3_mask = 1 << 3;	
    
    public boolean validUtf8(int[] data) {
        int size = data.length;
        
        int i = 0, count = 1;
        int first, byteZ;
        
        while( i < size) {
            first = data[i++];
            byteZ = getBytes(first);
            
            if(byteZ == -1)
                return false;
            
            while(count < byteZ) {
                count++;
                if ((i == size) || (data[i++] < bit_7_mask))
                    return false;
            }
            count = 1;
        }
        
        return true;
    }
    
    private int getBytes(int first) {
        int i = 0;

        if((first & bit_7_mask) == 0)
            return 1;
        
        else if((first & bit_6_mask) == 0)
            return -1;
        
        else if((first & bit_5_mask) == 0)
            return 2;
        
        else if((first & bit_4_mask) == 0)
            return 3;
        
        else if((first & bit_3_mask) == 0)
            return 4;
        
        return -1;
    }
}