class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if (n <= 0) return tasks.length;
        int[] counters = new int[26];
        int maxCount = 0;
        for (char task : tasks) {
            int idx = task - 'A';
            counters[idx]++;
            maxCount = Math.max(maxCount, counters[idx]);
        }
        int maxNum = 0;
        for (int counter : counters) {
            if (counter == maxCount) maxNum++;
        }
        return Math.max(tasks.length, (maxCount - 1) * (n + 1) + maxNum);
    }
}