// https://leetcode.com/problems/combination-sum
// LC39. Combination Sum
class CombinationSum {
    class IntegerList implements Comparable<IntegerList> {
        List<Integer> list;
        IntegerList(List<Integer> list) {
            this.list = new ArrayList(list);
        }
        @Override
        public int compareTo(IntegerList other) {
            if (list.size() != other.list.size()) {
                return Integer.compare(list.size(), other.list.size());
            }
            int n = list.size();
            for (int i=0; i<n; i++) {
                if (list.get(i) != other.list.get(i)) {
                    return Integer.compare(list.get(i), other.list.get(i));
                }
            }
            return 0;
        }
        void sort() {
            Collections.sort(list);
        }
        List<Integer> getList() { return list; }
    }
    void search(int[] candidates, int target, List<Integer> list, List<IntegerList> out) {
        if (target == 0) {
            out.add(new IntegerList(list));
            return;
        }
        if (target < 0) { return; }
        int n = candidates.length;
        for (int i=0; i<n; i++) {
            list.add(candidates[i]);
            search(candidates, target-candidates[i], list, out);
            list.remove(list.size()-1);
        }
    }
    List<List<Integer>> deduplicate(List<IntegerList> in) {
        if (in.isEmpty()) { return List.of(); }
        for (IntegerList list : in) {
            list.sort();
        }
        Collections.sort(in);
        List<List<Integer>> out = new ArrayList();
        List<Integer> lastList = in.get(0).getList();
        out.add(lastList);
        for (IntegerList integerList : in) {
            List<Integer> list = integerList.getList();
            if (list.equals(lastList)) { continue; }
            out.add(list);
            lastList = list;
        }
        return out;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<IntegerList> out = new ArrayList();
        List<Integer> list = new ArrayList();
        search(candidates, target, list, out);
        return deduplicate(out);
    }
}
