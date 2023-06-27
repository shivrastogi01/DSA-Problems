class Skiplist {
    private static final int INIT_CAPACITY = 8;
    private final int MIN_BOUNDARY;     // lower boundary of headCapacity
    private final int MAX_LEVEL = 14;  // 2 ^ h = # of elements, where h is optimal maximum level, when P = 0.5
    private final double P = 0.5;
    private final Node head;
    private int headCapacity;
    private int headLevel = 0;
    
    private class Node {
        private final int val;
        private Node[] next;
               
        private Node(int val, int level) {
            this.val = val;
            next = new Node[level];
        }
    }

    public Skiplist() {
        this(INIT_CAPACITY);
    }
    
    public Skiplist(int size) {
        if (size == 0) throw new IllegalArgumentException("size should be greater than 0");
		if (size < INIT_CAPACITY) size = INIT_CAPACITY;
		MIN_BOUNDARY = size/2;
		headCapacity = size;
		head = new Node(0, size);
    }
    
    public boolean search(int target) {
        Node curr = head;
        for (int i = headLevel-1; i >= 0; i--) {
            while (curr.next[i] != null) {
                int cmp = target - curr.next[i].val;
                if (cmp < 0) break;
                else if (cmp > 0) curr = curr.next[i];
                else return true;                
            }
        }
        return false;
    }
    
    public void add(int num) {
        Node[] update = new Node[headLevel + 1];
        update[headLevel] = head;
        buildUpdate(num, update);
        
        int level = getRandomLevel();
        if (level > headLevel) {
            if (headLevel == headCapacity) resizeHead(2 * headCapacity);
            headLevel++;
        }
        
        Node x = new Node(num, level);
        for (int i = 0; i < level; i++) {
            Node n = update[i].next[i];
            update[i].next[i] = x;
            x.next[i] = n;
        }
    }
    
    public boolean erase(int num) {
        if (headLevel == 0) return false;
        Node[] update = new Node[headLevel];
        buildUpdate(num, update);
        if (update[0].next[0] == null || update[0].next[0].val != num) return false;
        
        for (int i = 0; i < headLevel; i++) {
            if (update[i].next[i] == null || update[i].next[i].val != num) break;
            update[i].next[i] = update[i].next[i].next[i];
        }
        
        if (head.next[headLevel-1] == null && --headLevel >= MIN_BOUNDARY && headLevel == headCapacity/4) resizeHead(headCapacity/2);
        return true;
    }
    
    private void buildUpdate(int x, Node[] update) {
        Node curr = head;
        for (int i = headLevel - 1; i >= 0; i--) {
            while (curr.next[i] != null && curr.next[i].val < x)
                curr = curr.next[i];
            update[i] = curr;
        }
    }
    
    // fixed the dice: generate a random level that is more than one greater than the current level
    private int getRandomLevel() {
        int level = 1, limit = Math.min(MAX_LEVEL, headLevel + 1);
        while (Math.random() < P && level < limit) level++;
        return level;
    }
    
    // resize head level
    private void resizeHead(int size) {
        Node[] copy = new Node[size];
        System.arraycopy(head.next, 0, copy, 0, headLevel);
        head.next = copy;
        headCapacity = size;
    }
}