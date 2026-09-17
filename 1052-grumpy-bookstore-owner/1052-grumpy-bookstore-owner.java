class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int base = 0;
        int window = 0;
        int maxWindow = 0;
        for(int i = 0; i < customers.length; i++) {
            if(grumpy[i] == 0) {
                base += customers[i];
            }
            if(grumpy[i] == 1) {
                window += customers[i];
            }
            if(i >= minutes && grumpy[i - minutes] == 1) {
                window -= customers[i - minutes];
            }
            maxWindow = Math.max(maxWindow, window);
        }
        return maxWindow + base;
    }
}