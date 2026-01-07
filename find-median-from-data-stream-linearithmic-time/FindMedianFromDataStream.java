// https://leetcode.com/problems/find-median-from-data-stream
// LC295. Find Median from Data Stream
// Linearithmic time, Linear extra-space.
class FindMedianFromDataStream {

    List<Integer> items;
    public MedianFinder() {
        items = new ArrayList();
    }
    
    public void addNum(int item) {
        items.add(item);
    }
    
    public double findMedian() {
        Collections.sort(items);
        int n = items.size();
        if (n%2 == 0) {
            int lo = items.get((n-1)/2);
            int hi = items.get(n/2);
            return (double)(lo+hi)/2;
        }
        return items.get(n/2);
    }
}
