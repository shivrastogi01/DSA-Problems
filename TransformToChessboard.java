class TransformToChessboard {
    public int movesToChessboard(int[][] board) {
        int[] boardValue = {-1, 1};
        int size = board.length;
        
        short[] adjustedRows = new short[size], adjustedCols = new short[size];
        int[] uniqueRows = new int[2], uniqueCols = new int[2];
        
        int rowCount = 0, colCount = 0;
        
        // Iterate over col and row.
        int colDifferential, rowDifferential, colCurrent, rowCurrent;
        for(int i = 0; i < size; i++){
            colDifferential = 0;
            rowDifferential = 0;
            
            colCurrent = 0;
            rowCurrent = 0;
            
            // Collect column, row into ints
            for(int j = 0; j < size; j++){
                int colEntry = board[j][i];
                int rowEntry = board[i][j];

                colCurrent = colCurrent << 1;
                rowCurrent = rowCurrent << 1;
                
                colCurrent |= colEntry;
                rowCurrent |= rowEntry;
                
                colDifferential += boardValue[colEntry];
                rowDifferential += boardValue[rowEntry];
            }
            
            // Count row
            if(uniqueRows[0] == rowCurrent || uniqueRows[0] == 0){
                uniqueRows[0] = rowCurrent;
                rowCount += 1;
                adjustedRows[i] = 1;
            } else if(uniqueRows[1] == rowCurrent || uniqueRows[1] == 0){
                uniqueRows[1] = rowCurrent;
                rowCount -= 1;
                adjustedRows[i] = 2;
            } else {
                // This is a third unique row, which is impossible to solve.
                return -1;
            }
            
            // Count col
            if(uniqueCols[0] == colCurrent || uniqueCols[0] == 0){
                uniqueCols[0] = colCurrent;
                colCount += 1;
                adjustedCols[i] = 1;
            } else if(uniqueCols[1] == colCurrent || uniqueCols[1] == 0){
                uniqueCols[1] = colCurrent;
                colCount -= 1;
                adjustedCols[i] = 2;
            } else {
                // This is a third unique col, which is impossible to solve.
                return -1;
            }
            
            // If this row had too many of a single digit, it's impossible to solve.
            if(Math.abs(rowDifferential) > 1 || Math.abs(colDifferential) > 1){
                return -1;
            }
        }
        
        // We didn't get enough unique rows.
        if(uniqueRows[1] == 0){
            return -1;
        }
        
        // We got too many of one type of row
        if(Math.abs(rowCount) > 1){
            return -1;
        }
        
        // If we had two types of rows in the same quantity, then try starting with both rows and 
        // just consider the one that took less swaps to create a chessboard.
        boolean tryBothRows = rowCount == 0;
        int mostCommonRow = (rowCount >= 1) ? 1 : 2;
        
        int minRowSwaps = size;
        if(tryBothRows){
            for(short row : new short[]{1, 2}){
                int candidateSwaps = 0;
                for(int i = 0; i < size; i += 2){
                    if(adjustedRows[i] != row){
                        candidateSwaps += 1;
                    }
                }
                
                minRowSwaps = Math.min(minRowSwaps, candidateSwaps);
            }
        } else {
            // Otherwise, just start with the more common row.
            minRowSwaps = 0;
            for(int i = 0; i < size; i += 2){
                if(adjustedRows[i] != mostCommonRow){
                    minRowSwaps += 1;
                }
            }
        }
        
        
        boolean tryBothCols = colCount == 0;
        int mostCommonCol = (colCount >= 1) ? 1 : 2;
        
        int minColSwaps = size;
        if(tryBothCols){
            for(short col : new short[]{1, 2}){
                int candidateSwaps = 0;
                for(int i = 0; i < size; i += 2){
                    if(adjustedCols[i] != col){
                        candidateSwaps += 1;
                    }
                }
                
                minColSwaps = Math.min(minColSwaps, candidateSwaps);
            }
        } else {
            minColSwaps = 0;
            for(int i = 0; i < size; i += 2){
                if(adjustedCols[i] != mostCommonCol){
                    minColSwaps += 1;
                }
            }
        }
        
        return minRowSwaps + minColSwaps;
    }
}