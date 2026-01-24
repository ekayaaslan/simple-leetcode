Select leetcode (and neetcode) problems and their solutions for a refresh for coding interviews.

---

Part I. A comprehensive list of solutions to select leetcode problems.

[LC0001.](https://leetcode.com/problems/two-sum) Two Sum

* [Solution at Quadratic time.](/two-sum/TwoSumS7.cpp) Concepts: <i>Brute force.</i>

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

* [Solution at Linearithmic-ish time.](/two-sum/TwoSumS6.cpp) Concepts: <i>Divide and conquer, Recursive search, Hashing.</i><br>

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

* [Solution at Linearithmic time. (v1)](/two-sum/TwoSumS4.cpp) Concepts: <i>Sorting, Binary search, Symmetry, Data-index pairing.</i><br>
* [Solution at Linearithmic time. (v2)](/two-sum/TwoSumS5.cpp) Concepts: <i>Sorting, Two pointers, Data-index pairing.</i><br>
* [Solution at Linear-ish time. (v1)](/two-sum/TwoSumS1.cpp) Concepts: <i>Hashing, Counting, Index mapping.</i><br>
* [Solution at Linear-ish time. (v2)](/two-sum/TwoSumS2.cpp) Concepts: <i>Hashing, Index mapping, Math.</i><br>
* [Solution at Linear-ish time. (v3)](/two-sum/TwoSumS3.cpp) Concepts: <i>Hashing, Symmetry, Index mapping.</i><br>

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
* [Solution at Quadratic time.](/contains-duplicate/ContainsDuplicateS1.cpp) Concepts: <i>Brute force, Symmetry.</i><br>
* [Solution at Linearithmic-ish time.](/contains-duplicate/ContainsDuplicateS2.cpp) Concepts: <i>Divide and conquer, Recursive search, Hashing.</i><br>
* [Solution at Linearithmic time.](/contains-duplicate/ContainsDuplicateS3.cpp) Concepts: <i>Sorting, Linear search.</i><br>
* [Solution at Linearish time. (v1)](/contains-duplicate/ContainsDuplicateS4.cpp) Concepts: <i>Hashing, Counting.</i><br>
* [Solution at Linearish time. (v2)](/contains-duplicate/ContainsDuplicateS5.cpp) Concepts: <i>Hashing, Symmetry.</i><br>

LC0347. Top K Frequent Elements
* [Solution at Quadratic time.](/top-k-frequent-elements/TopKFrequentElementsS1.cpp) Concepts: <i>Hashing, Counting, Brute force.</i><br>
* [Solution at Linearithmic time. (v1)](/top-k-frequent-elements/TopKFrequentElementsS2.cpp) Concepts: <i>Hashing, Counting, Sorting, Data-count pairing.</i><br>
* [Solution at Linearithmic time. (v2)](/top-k-frequent-elements/TopKFrequentElementsS3.cpp) Concepts: <i>Hashing, Counting, Priority queues, Data-count pairing, TopK.</i><br>
* [Solution at Linearithmic time. (v3)](/top-k-frequent-elements/TopKFrequentElementsS4.cpp) Concepts: <i>Hashing, Running counts, Balanced trees, Multiset, Data-count pairing.</i><br>
* [Solution at Linear-ish time.](/top-k-frequent-elements/TopKFrequentElementsS5.cpp) Concepts: <i>Hashing, Counting, Quickselect, Data-count pairing.</i><br>
* [Solution at Linear time. (v1)](/top-k-frequent-elements/TopKFrequentElementsS6.cpp) Concepts: <i>Hashing, Counting, Bucket sort.</i><br>
* [Solution at Linear time. (v2)](/top-k-frequent-elements/TopKFrequentElementsS7.cpp) Concepts: <i>Hashing, Running counts, Bucket sort.</i><br>

---

Part II. Basic concepts and solutions to select leetcode questions.

[LC0002.](https://leetcode.com/problems/add-two-numbers) Add Two Numbers. Concepts: <i>Recursion, Linked List</i><br>
[LC0007.](https://leetcode.com/problems/reverse-integer) Reverse Integer. Concepts: <i>Digits, Integer bounds.</i><br>
[LC0008.](https://leetcode.com/problems/string-to-integer-atoi) String to Integer. Concepts: <i>Finite state machine, Integer bounds, Digits.</i><br>
[LC0009.](https://leetcode.com/problems/palindrome-number) Palindrome Number. Concepts: <i>Digits, Symmetry.</i><br>
[LC0016.](https://leetcode.com/problems/3sum-closest) 3Sum Closest. Concepts: <i>Two Pointers, Binary Search, Reduction, Balanced trees.</i><br>
[LC0044.](https://leetcode.com/problems/wildcard-matching) Wildcard Matching. Concepts: <i>1D Dynamic programming, State compression, Wildcards.</i><br>

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

---

Part III. Good solutions to select neetcode Blind-75 questions.

[NC02.](https://leetcode.com/problems/valid-anagram) Valid Anagram. Concepts: <i>Direct addressing, Anagrams, Canonicalising.</i><br>
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
<br>

[NC04.](https://leetcode.com/problems/group-anagrams) Group Anagrams. Concepts: <i>Hashing, Canonicalising.</i><br>

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
<br>

NC06. Encode and Decode Strings. Concepts: <i>Encoding.</i><br>
NC10. 3Sum. Concepts: <i>Two Pointers, Reduction, Sorting, Deduplication. </i><br>
NC12. Best Time to Buy And Sell Stock. Concepts: <i>Sliding window.</i><br>
NC14. Longest Repeating Character Replacement. Concepts: <i>Sliding window.</i><br>
NC16. Valid Parantheses. Concepts: <i>Stack.</i><br>
NC18. Search In Rotated Sorted Array. Concepts: <i>Binary search, Reduction</i><br>
NC21. Linked List Cycle. Concepts: <i>Linked List, Fast-slow pivots.</i><br>
NC22. Reorder List. Concepts: <i>Linked List, Two pivots.</i><br>
NC24. Merge K Sorted Lists. Concepts: <i>Linked List, Priority Queue.</i><br>
NC26. Maximum Depth of Binary Tree. Concepts: <i>Binary Tree, Recursion.</i><br>
NC29. Lowest Common Ancestor of a Binary Search Tree. Concepts: <i>Binary Tree, Tree Dynamic programming.</i><br>
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

---

Part IV. Further good-to-know slightly advanced concepts or ideas.

[LC0380.](https://leetcode.com/problems/insert-delete-getrandom-o1) Insert Delete GetRandom. Concepts: <i>Design, Bag</i><br>
LC0743. Network Delay Time. Concepts: <i>Shortest path.</i><br>
LC0127. Word Ladder. Concepts: <i>Breath first search.</i><br>
LC0994. Rotting Oranges. Concepts: <i>2D Search, Multi-source BFS.</i><br>
LC1584. Min Cost to Connect All Points. Concepts: <i>Minimum spanning tree.</i><br>
LC0329. Longest Increasing Path in a Matrix. Concepts: <i>DAG Dynamic programming</i><br>
LC0075. Sort Colors. Concepts: <i>Three pointers.</i><br>

---

Part V. Wish List of concepts. <i>Interval tree, Segment tree, Prime numbers.</i>
