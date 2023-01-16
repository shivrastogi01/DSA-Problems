class VerbalArithmatic {
    // Similar approach to https://leetcode.com/problems/sudoku-solver/
    // Build a grid of words+1 rows and result.length() columns
    // Reverse each string so we can check them column by column
    // Build the column sum for words then check if the digit can map
    // onto the corresponding column in the result row.
    // Use empty chars to know when to skip processing a word/column.
    int[] map;
    char[][] grid;
    boolean solved;
    boolean[] usedDigit;
    char UNUSED = '\u0000';
    boolean[] mustNotBeZero;
    int rows, cols, resultRow;
    public boolean isSolvable(String[] words, String result) {
        this.solved = false;
        
        this.rows = words.length+1;  // +1 for the result
        this.cols = result.length(); // each word can be at most results length
        this.grid = new char[rows][cols]; // '\u0000' for unset
        this.mustNotBeZero = new boolean[26];
        this.usedDigit = new boolean[10];
        this.resultRow = rows-1;
        
        this.map = new int[26];
        Arrays.fill(map, -1);
        
        int maxLength = 0;
        for(int i = 0, j; i < words.length; i++){
            j = words[i].length();
            if(j > maxLength) maxLength = j; // keep track of max word length seen (must be within 1 length of result length)
            if(j > 1) mustNotBeZero[words[i].charAt(0)-'A'] = true; // if multi digit, first digit can't be zero
            if(j > cols) return false; // words can't be greater than length or result            
            for(char c : words[i].toCharArray()) grid[i][--j] = c; // reverse word in grid            
        }
        if(maxLength + 1 < cols) return false; // at least 1 word must be within 1 digit of result length
        
        int j = cols;
        if(j > 1) mustNotBeZero[result.charAt(0)-'A'] = true; // if multi digit, first digit can't be zero
        for(char c: result.toCharArray()) grid[resultRow][--j] = c;

        backtrack(0,0,0);
        
        return solved;
    }
    public boolean canPlace(int ci, int d){
        return (!usedDigit[d] && map[ci] == -1) || (map[ci] == d);
    }
    public void placeNum(int ci, int d){
        usedDigit[d] = true;
        map[ci] = d;
    }
    public void removeNum(int ci, int d){
        usedDigit[d] = false;
        map[ci] = -1;
    }
    public void placeNextNum(int r, int c, int sum){
        if(r == resultRow && c == cols-1){                
            solved = sum == 0; // just evaluated last row and col, check if no leftover sum
            // if(solved){
            //     System.out.println("solved!");
            //     for(int i=0; i < map.length; i++) if(map[i]!=-1) System.out.println(new String((char)(i+'A')+"")+"="+map[i]);
            // }                   
        }else{
            if(r == resultRow){
                backtrack(0,c+1,sum);                
            }else{
                backtrack(r+1,c,sum);                
            }
        }
    }
    public void backtrack(int r, int c, int sum){
        if(grid[r][c] == UNUSED){  // word row with no digit it column
            placeNextNum(r,c,sum);
        }else{
            int ci = grid[r][c]-'A';  // char index
            if(r == resultRow){  // handle result row
                int d = sum%10;
                //System.out.println("try to result grid["+r+","+c+"]="+grid[r][c]+" to "+d+" with sum="+sum);
                if(map[ci] == -1){                
                    if(canPlace(ci, d)){
                        placeNum(ci, d);
                        placeNextNum(r,c,sum/10);
                        if(solved) return;
                        removeNum(ci, d);
                    }
                }else{
                    if(map[ci] == d) placeNextNum(r,c,sum/10); // verify existing mapping aligns with current sum digit
                }
            }else{  // handle word row
                if(map[ci] == -1){
                    for(int d = mustNotBeZero[ci] ? 1 : 0 ; d < 10; d++){
                        //System.out.println("try to map word grid["+r+","+c+"]="+grid[r][c]+" to "+d+" with sum="+sum);
                        if(canPlace(ci, d)){
                            placeNum(ci, d);
                            placeNextNum(r,c,sum+d);
                            if(solved) return;
                            removeNum(ci, d);
                        }
                    }
                }else{
                    placeNextNum(r,c,sum+map[ci]); // add existing mapping to column sum
                }
            }
        }
    }
}