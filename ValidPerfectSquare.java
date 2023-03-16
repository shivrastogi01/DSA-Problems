class ValidPerfectSquare {
public boolean isPerfectSquare(int num) {
    int sqrtVal = (int) Math.sqrt(num);
    if((sqrtVal*sqrtVal) == num)
        return true;
    return false;
}
}