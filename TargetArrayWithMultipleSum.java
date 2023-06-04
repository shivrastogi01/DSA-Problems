class TargetArrayWithMultipleSum {
   public boolean isPossible(int[] target) {
    long sum = target[0];
    int maxIndex = 0;
    for (int i = 1; i < target.length; i++) {
        sum += target[i];
        if (target[i] > target[maxIndex]) {
            maxIndex = i;
        }
    }
    long remainingSum = sum - target[maxIndex];
    if (target[maxIndex] == 1 || remainingSum == 1) {
        return true;
    }
    if (remainingSum >= target[maxIndex] || remainingSum == 0 || target[maxIndex] % remainingSum == 0) {
        return false;
    }
    target[maxIndex] %= remainingSum;
    return isPossible(target);
}
}