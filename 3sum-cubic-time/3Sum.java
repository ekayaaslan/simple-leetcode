// https://leetcode.com/problems/3sum
// LC15. 3Sum
// Time/space: Cubic time, constant extra-space.
// Concepts: Linear search, Sorting.
class 3Sum {
    class Triplet implements Comparable<Triplet> {
        int a, b, c;
        Triplet(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        boolean equals(Triplet other) {
            return compareTo(other) == 0;
        }
        List<Integer> toList() {
            return List.of(a, b, c);
        }
        @Override
        public int compareTo(Triplet other) {
            if (this.a != other.a) {
                return Integer.compare(this.a, other.a);
            }
            if (this.b != other.b) {
                return Integer.compare(this.b, other.b);
            }
            return Integer.compare(this.c, other.c);
        }
    }
    List<List<Integer>> getUniqueLists(List<Triplet> triplets) {
        if (triplets.isEmpty()) { 
            return List.of(); 
        }
        Collections.sort(triplets);
        List<List<Integer>> res = new ArrayList();
        res.add(triplets.get(0).toList());        
        Triplet lastTriplet = triplets.get(0);
        for (Triplet triplet : triplets) {
            if (!triplet.equals(lastTriplet)) {
                res.add(triplet.toList());
                lastTriplet = triplet;
            }
        }
        return res;
    }    
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<Triplet> triplets = new ArrayList();
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                for (int k=j+1; k<n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        triplets.add(new Triplet(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return getUniqueLists(triplets);
    }
}
