Select leetcode (and neetcode) problems and their solutions for a refresh for coding interviews.

---

Part I. A comprehensive list of solutions to select leetcode problems.

[LC0001.](https://leetcode.com/problems/two-sum) Two Sum

* Solution at Quadratic time. Concepts: <i>Brute force.</i>

  ```cpp
  int n = nums.size();
  for (int i=0; i<n; i++) {
      for (int j=i+1; j<n; j++) {
          int sum = nums[i]+nums[j];
          if (sum == target) {
              return {i, j};
          }
      }
  }
  return {}
  ```

* Solution at Linearithmic-ish time. Concepts: <i>Divide and conquer, Recursive search, Hashing.</i><br>

  ```cpp
  // Recursively solve for range [lo, hi].
  vector<int> search(vector<int>& nums, int lo, int hi, int target) {
      if (lo == hi) {
          return {};
      }
      int mid = (lo+hi)/2;
      vector<int> left = search(nums, lo, mid, target);
      if (!left.empty()) {
          return left;
      }
      vector<int> right = search(nums, mid+1, hi, target);
      if (!right.empty()) {
          return right;
      }
      return search(nums, lo, mid, hi, target);
  }
  ```
  
  ```cpp
  // Solve for pairs, one from [lo,mid] and the other from [mid+1,lo].
  vector<int> search(vector<int>& nums, int lo, int mid, int hi, int target) {
      map<int,int> idx;
      for (int i=lo; i<=mid; i++) {
          idx[nums[i]] = i;
      }
      for (int j=mid+1; j<=hi; j++) {
          int cnum = target-nums[j];
          if (idx.contains(cnum)) {
              return {idx[cnum], j};
          }
      }
      return {};
  }
  ```

  ```cpp
  // Initiate the recursive search.
  int n = nums.size();
  return search(nums, 0, n-1, target);
  ```

* Solution at Linearithmic time. (v1) Concepts: <i>Sorting, Binary search, Symmetry, Data-index pairing.</i><br>
* Solution at Linearithmic time. (v2) Concepts: <i>Sorting, Two pointers, Data-index pairing.</i><br>
* Solution at Linear-ish time. (v1) Concepts: <i>Hashing, Counting, Index mapping.</i><br>
* Solution at Linear-ish time. (v2) Concepts: <i>Hashing, Index mapping, Math.</i><br>
* Solution at Linear-ish time. (v3) Concepts: <i>Hashing, Symmetry, Index mapping.</i><br>

LC0003. Longest Substring Without Repeating Characters

[LC0004.](https://leetcode.com/problems/median-of-two-sorted-arrays) Median of Two Sorted Arrays. 
* Solution at Linearithmic time. Concepts: <i>Sorting.</i><br>
* Solution at Linearithmic time. Concepts: <i>Balanced trees.</i><br>
* Solution at Linear-ish time. Concepts: <i>Quickselect.</i><br>
* Solution at Linear time. Concepts: <i>Merge sort.</i><br>
* Solution at Logsquare time. Concepts: <i>Binary serach, Search square.</i><br>
* Solution at Logarithmic time. Concepts: <i>Binary search, Median of two arrays search.</i><br>

LC0011. Container With Most Water

LC0042. Trapping Rain Water

LC0053. Maximum Subarray

LC0084. Largest Rectangle in Histogram

LC0128. Longest Consecutive Sequence

LC0152. Maximum Product Subarray

LC0217. Contains Duplicate
* Solution at Quadratic time. Concepts: <i>Brute force, Symmetry.</i><br>
* Solution at Linearithmic-ish time. Concepts: <i>Divide and conquer, Recursive search, Hashing.</i><br>
* Solution at Linearithmic time. Concepts: <i>Sorting, Linear search.</i><br>
* Solution at Linearish time. (v1) Concepts: <i>Hashing, Counting.</i><br>
* Solution at Linearish time. (v2) Concepts: <i>Hashing, Symmetry.</i><br>

LC0347. Top K Frequent Elements
* Solution at Quadratic time. Concepts: <i>Hashing, Counting, Brute force.</i><br>
* Solution at Linearithmic time. (v1) Concepts: <i>Hashing, Counting, Sorting, Data-count pairing.</i><br>
* Solution at Linearithmic time. (v2) Concepts: <i>Hashing, Counting, Priority queues, Data-count pairing, TopK.</i><br>
* Solution at Linearithmic time. (v3) Concepts: <i>Hashing, Running counts, Balanced trees, Multiset, Data-count pairing.</i><br>
* Solution at Linear-ish time. Concepts: <i>Hashing, Counting, Quickselect, Data-count pairing.</i><br>
* Solution at Linear time. (v1) Concepts: <i>Hashing, Counting, Bucket sort.</i><br>
* Solution at Linear time. (v2) Concepts: <i>Hashing, Running counts, Bucket sort.</i><br>

---

Part II. Solutions to select leetcode questions covering a comprehensive set of concepts.

[LC0002.](https://leetcode.com/problems/add-two-numbers) Add Two Numbers. Concepts: <i>Recursion, Linked List</i><br>
[LC0007.](https://leetcode.com/problems/reverse-integer) Reverse Integer. Concepts: <i>Digits, Integer bounds.</i><br>
[LC0008.](https://leetcode.com/problems/string-to-integer-atoi) String to Integer. Concepts: <i>Finite state machine, Integer bounds, Digits.</i><br>
[LC0009.](https://leetcode.com/problems/palindrome-number) Palindrome Number. Concepts: <i>Digits, Symmetry.</i><br>

```cpp
// Build vector of digits, in reverse order.
while (x > 0) {
    digits.push_back(x%10);
    x = x/10;
}
```

```cpp
// Is it palindrom?
for (int i=0; i<n/2; i++) {
    if (digits[i] != digits[n-i-1]) {
        return false;
    }
}
return true;
```

[LC0015.](https://leetcode.com/problems/3sum) 3Sum. Concepts: <i>Two Pointers, Reduction, Sorting, Deduplication. </i><br>
[LC0016.](https://leetcode.com/problems/3sum-closest) 3Sum Closest. Concepts: <i>Two Pointers, Binary Search, Reduction, Balanced trees.</i><br>
[LC0017.](https://leetcode.com/problems/letter-combinations-of-a-phone-number) Letter Combinations of a Phone Number. Concepts: <i>Backtracking, Combinations.</i><br>
[LC0020.](https://leetcode.com/problems/longest-repeating-character-replacement) Valid Parantheses. Concepts: <i>Stack.</i><br>
[LC0021.](https://leetcode.com/problems/merge-two-sorted-lists) Merge Two Sorted Lists. Concepts: <i>Two pointer-pointers.</i><br>
[LC0022.](https://leetcode.com/problems/generate-parentheses) Generate Parentheses. Concepts: <i>Backtracking, Parantheses, Catalan combinations, Precomputing.</i><br>
[LC0023.](https://leetcode.com/problems/merge-k-sorted-lists) Merge K Sorted Lists. Concepts: <i>Linked List, Priority Queue.</i><br>
[LC0026.](https://leetcode.com/problems/remove-duplicates-from-sroted-array) Remove Duplicates from Sorted Array. Concepts: <i>Two pointers, Inplace removal.</i><br>
[LC0027.](https://leetcode.com/problems/remove-element) Remove Element. Concepts: <i>Two pointers, Inplace removal.</i><br>
[LC0033.](https://leetcode.com/problems/search-in-rotated-sorted-array) Search In Rotated Sorted Array. Concepts: <i>Binary search, Reduction</i><br>
[LC0044.](https://leetcode.com/problems/wildcard-matching) Wildcard Matching. Concepts: <i>1D Dynamic programming, State compression, Wildcards.</i><br>
[LC0049.](https://leetcode.com/problems/group-anagrams) Group Anagrams. Concepts: <i>Hashing, Canonicalising.</i><br>

```cpp
// Populate the map.
unordered_map<string, vector<string>> groups;
for (string& str : strs) {
    string canonical = str;
    sort(canonical.begin(), canonical.end());
    groups[canonical].push_back(str);
}
```
```cpp
// Output values.
for (auto& [_, anagrams]: groups) {
    out.push_back(anagrams);
}
```

[LC0075.](https://leetcode.com/problems/sort-colors) Sort Colors. Concepts: <i>Three pointers.</i><br>
[LC0104.](https://leetcode.com/problems/maximum-depth-of-binary-tree) Maximum Depth of Binary Tree. Concepts: <i>Binary Tree, Recursion.</i><br>
[LC0121.](https://leetcode.com/problems/best-time-to-buy-and-sell-stock) Best Time to Buy And Sell Stock. Concepts: <i>Sliding window.</i><br>
[LC0127.](https://leetcode.com/problems/word-ladder) Word Ladder. Concepts: <i>Breath first search.</i><br>
[LC0141.](https://leetcode.com/problems/linked-list-cycle) Linked List Cycle. Concepts: <i>Linked List, Fast-slow pivots.</i><br>
[LC0143.](https://leetcode.com/problems/reorder-list) Reorder List. Concepts: <i>Linked List, Two pivots.</i><br>
[LC0236.](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree). Concepts: <i>Binary Tree, Tree Dynamic programming.</i><br>
[LC0242.](https://leetcode.com/problems/valid-anagram) Valid Anagram. Concepts: <i>Direct addressing, Anagrams, Canonicalising.</i><br>

```cpp
// First solution: Canonicalising
if (s.length() != t.length()) {
    return false;
}
std::sort(s.begin(), s.end());
std::sort(t.begin(), t.end());
return s == t;
```

```cpp
// Second solution: Direct addressing, Anagrams.
for (char ch : s) {
    counts[ch-'a'] ++;
}
for (char ch : t) {
    counts[ch-'a'] --;
}
for (int d=0; d<26; d++) {
    if (counts[d] != 0) {
        return false;
    }
}
return true;
```

[LC0271.](https://leetcode.com/problems/encode-and-decode-strings). Encode and Decode Strings. Concepts: <i>Encoding.</i><br>
[LC0329.](https://leetcode.com/problems/longest-increasing-path-in-a-matrix) Longest Increasing Path in a Matrix. Concepts: <i>DAG Dynamic programming</i><br>
[LC0380.](https://leetcode.com/problems/insert-delete-getrandom-o1) Insert Delete GetRandom. Concepts: <i>Design, Bag</i><br>
[LC0424.](https://leetcode.com/problems/longest-repeating-character-replacement) Longest Repeating Character Replacement. Concepts: <i>Sliding window.</i><br>
[LC0743.](https://leetcode.com/problems/network-delay-time) Network Delay Time. Concepts: <i>Shortest path.</i><br>
[LC0994.](https://leetcode.com/problems/rotting-oranges) Rotting Oranges. Concepts: <i>2D Search, Multi-source BFS.</i><br>
[LC1584.](https://leetcode.com/problems/min-cost-to-connect-all-points) Min Cost to Connect All Points. Concepts: <i>Minimum spanning tree.</i><br>

NC30. Binary Tree Level Order Traversal. Concepts: <i>FIFO queue.</i>.<br>
NC31. Validate Binary Search Tree. Concepts: <i>Binary Tree, Binary search tree.</i><br>
NC33. Construct Binary Tree From Preorder And Inorder Traversal. Concepts: <i>Binary Tree, Binary tree traversal, Recursion.</i><br>
NC34. Binary Tree Maximum Path Sum. Concepts: <i>Binary Tree, Tree dynamic programming.</i><br>
NC36. Find Median From Data Stream. Concepts: <i>Design, Priority Queue.</i><br>
NC37. Combination Sum. Concepts: <i>Backtracking, Combinatorial Search.</i><br>
NC41. Word Search II. Concepts: <i>Backtracking, 2D Search, Trie.</i><br>
NC42. Number of Islands. Concepts: <i>2D Search, Depth first search.</i><br> 
NC43. Clone Graph. Concepts: <i>Hashing, Graph traversal.</i><br>
NC44. Pacific Atlantic Water Flow. Concepts: <i>Reduction, Graph search, Depth first search.</i><br>
NC45. Course Schedule. Concepts: <i>Reduction, Graph cycles.</i><br>
NC46. Graph Valid Tree. Concepts: <i>Graph traversal, Connected components, Unrooted tree.</i><br>
NC47. Number of Connected Components In An Undirected Graph. Concepts: <i>Union-find.</i><br>
NC48. Alien Dictionary. Concepts: <i>Reduction, Directed acyclic graphs, Topological order.</i><br>
NC50. House Robber II. Concepts: <i>1D Dynamic programming, Reduction.</i><br>
NC52. Longest Palindromic Substring. Concepts: <i>Brute force, Running optimum, Palindrome center.</i><br>
NC54. Decode Ways. Concepts: <i>1D Dynamic programming, Combinatorics.</i><br>
NC55. Coin Change. Concepts: <i>2D Dynamic programming.</i><br>
NC58. Longest Increasing Subsequence. Concepts: <i>1D Dynamic programming, Running optimum.</i><br>
NC60. Longest Common Subsequence. Concepts: <i>2D Dynamic programming.</i><br>
NC65. Non Overlapping Intervals. Concepts: <i>Interval sorting, 1D Dynamic programing.</i><br>
NC66. Meeting Rooms. Concepts: <i>Interval sorting.</i><br>
NC67. Meeting Rooms II. Concepts: <i>Interval sorting, Greedy, Sweeping line.</i><br>
NC68. Rotate Image. Concepts: <i>Reduction, Cyclic shift.</i><br>
NC69. Spiral Matrix. Concepts: <i>2D Navigation.</i><br>
NC70. Set Matrix Zeroes. Concepts: <i>Brute force, Precomputing.</i><br>
NC72. Counting Bits. Concepts: <i>Binary numbers, 1D Dynamic programming.</i><br>
NC73. Reverse Bits. Concepts: <i>Digits, Binary numbers</i><br>
NC74. Missing Number. Concepts: <i>Base, Modular arithmetic.</i><br>

Further Concepts: Monotonic stack, Monotonic queue, Monotonic deque, Prime numbers.
