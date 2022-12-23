class ThreeEqualParts {
    public int[] threeEqualParts(int[] arr) {
        
        int ones = 0;
        
        for (int num : arr) {
            ones += num;
        }
        
        if (ones == 0) {
            return new int[] {0, 2};
        }
        else if (ones % 3 != 0) {
            return new int[] {-1, -1};
        }
        
        ones /= 3;
        int index1 = -1, index2 = -1, index3 = -1, totalOnes = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                continue;
            }
            
            totalOnes += arr[i];
            if (totalOnes == 1) {
                index1 = i;
            }
            else if (totalOnes == ones + 1) {
                index2 = i;
            }
            else if (totalOnes == 2 * ones + 1) {
                index3 = i;
            }
        }
        
        while (index3 < arr.length) {
            if (arr[index1] == arr[index3] && arr[index2] == arr[index3]) {
                ++index1;
                ++index2;
                ++index3;
            }
            else {
                return new int[] {-1, -1};
            }
        }
        
        return new int[] {index1 - 1, index2};
    }
}