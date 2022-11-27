class InterSectionOfMultipleArrays {
    public List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (map.containsKey(nums[i][j])) {
                    map.put(nums[i][j], map.get(nums[i][j]) + 1);
                } else {
                    map.put(nums[i][j], 1);
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key) == nums.length) {
                list.add(key);
            }
        }
        Collections.sort(list);
        return list;
    }
}