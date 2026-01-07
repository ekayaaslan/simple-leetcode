// https://leetcode.com/problems/course-schedule
// LC207. Course Schedule
// Quadratic time, linear extra-space.
class CourseSchedule {
    boolean canFinishAny(int n, int[][] prerequisites, boolean[] finish) {
        int m = prerequisites.length;
        boolean[] hasDependencies = new boolean[n];
        for (int j=0; j<m; j++) {
            int a = prerequisites[j][0];
            int b = prerequisites[j][1];
            if (!finish[a]) { hasDependencies[b] = true; }
        }
        for (int i=0; i<n; i++) {
            if (finish[i]) { continue; }
            if (!hasDependencies[i]) {
                finish[i] = true;
                return true;
            }
        }
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        boolean[] finish = new boolean[n];
        for (int i=0; i<n; i++) {
            if (!canFinishAny(n, prerequisites, finish)) {
                return false;
            }
        }
        return true;
    }
}
