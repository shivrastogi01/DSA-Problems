class ShortestSlidingWindow {
    public String minWindow(String s, String t) {
        
        if (t.length() > s.length() || t.equals(""))
            return "";
        
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        
        for(char c : t.toCharArray()){
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
            sMap.put(c, 0);
        }
        
        int start=0, matched=0;
        int minLength = s.length();
        int[] result = new int[]{-1,-1};
		
        for (int end=0; end < s.length(); end++){
            char curr = s.charAt(end);
            
            // Check if current char is present in target, then update character count in source map
            if(tMap.containsKey(curr)){
                sMap.put(curr, sMap.get(curr) + 1);            
                if(sMap.get(curr).equals(tMap.get(curr)))
                    matched++;
            }
            
            // When a valid window is found, try to reduce it until a valid window is not found
            if(matched == tMap.size()){
                // Iterate until the window is not valid
                while(matched == tMap.size()){
                    char first = s.charAt(start++);
                    // If current char is a character in target, 
                    // then reduce its count from the sMap as we'll reduce its count
                    if(sMap.containsKey(first)){
                        sMap.put(first, sMap.get(first) - 1);
                        // If count of first char in window < count in tMap, then reduce the matched count
                        if(sMap.get(first) < tMap.get(first))
                            matched--;
                    }
                }
                // Update length if current length is smaller than previous
                // Note - Check 1 character before start index as the start idx was already incremented in the while loop
                if (end - (start - 1) < minLength){
                    minLength = end - (start - 1) + 1;
                    result[0] = start - 1;
                    result[1] = end;
                }
            }
        }
        return result[0] != -1 ? s.substring(result[0], result[1] + 1) : "";
    }
}