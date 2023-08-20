class ValidTicTacToe {
   public static boolean validTicTacToe(String[] board) {
    Character[][] arr = new Character[3][3];
    int countX = 0, countO = 0;
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (board[i].charAt(j) == 'X') {
                countX++;
            }
            if (board[i].charAt(j) == 'O') {
                countO++;
            }
            arr[i][j] = board[i].charAt(j);
        }
    }
    return isValid(arr, countX, countO);
}

private static boolean isValid(Character[][] arr, int countX, int countO) {
    return (countX == countO && !isWinner(arr, 'X') && !isWinner(arr, 'O')) ||
            (countX == countO && isWinner(arr, 'O') && !isWinner(arr, 'X')) ||
            (countX - countO == 1 && !isWinner(arr, 'O') && !isWinner(arr, 'X')) ||
            (countX - countO == 1 && !isWinner(arr, 'O') && isWinner(arr, 'X'));
}

private static boolean isWinner(Character[][] arr, char c) {
    return (arr[0][0] == c && arr[0][1] == c && arr[0][2] == c) ||
            (arr[1][0] == c && arr[1][1] == c && arr[1][2] == c) ||
            (arr[2][0] == c && arr[2][1] == c && arr[2][2] == c) ||
            (arr[0][0] == c && arr[1][0] == c && arr[2][0] == c) ||
            (arr[0][1] == c && arr[1][1] == c && arr[2][1] == c) ||
            (arr[0][2] == c && arr[1][2] == c && arr[2][2] == c) ||
            (arr[0][0] == c && arr[1][1] == c && arr[2][2] == c) ||
            (arr[0][2] == c && arr[1][1] == c && arr[2][0] == c);
}
}