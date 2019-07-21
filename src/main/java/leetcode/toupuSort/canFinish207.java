package leetcode.toupuSort;

import java.util.LinkedList;

public class canFinish207 {
    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}, {0, 2}, {2, 3}, {2, 4}};
        boolean b = canFinish(5, prerequisites);
        System.out.println(b);
    }
    public static int[] canFinish1(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        int[][] matrix = new int[numCourses][numCourses];
        LinkedList<Integer> queue = new LinkedList<>();
        int[] result = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int pre = prerequisites[i][1];
            int ready = prerequisites[i][0];
            matrix[pre][ready] = 1;
            indegree[ready]++;
        }

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            Integer temp = queue.pop();
            result[count++] = temp;
            for (int i = 0; i < numCourses; i++) {
                if (matrix[temp][i] != 0) {
                    if (--indegree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        if (count == numCourses) {
            return result;
        }else {
            return new int[0];
        }
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int []  indegree = new int[numCourses];
        int[] [] matrix = new int[numCourses][numCourses];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i  = 0; i < prerequisites.length; i++) {
            int pre = prerequisites[i][1];
            int ready = prerequisites[i][0];
            matrix[pre][ready] = 1;
            indegree[ready]++;
        }

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()){
            Integer temp = queue.pop();
            count++;
            for (int i = 0; i < numCourses; i++) {
                if (matrix[temp][i] != 0) {
                    if (--indegree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }

        return count == numCourses;














/*        int[][] matrix = new int[numCourses][numCourses]; // i -> j
        int[] indegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int ready = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if (matrix[pre][ready] == 0)
                indegree[ready]++; //duplicate case
            matrix[pre][ready] = 1;
        }

        int count = 0;
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int i = 0; i < numCourses; i++) {
                if (matrix[course][i] != 0) {
                    if (--indegree[i] == 0)
                        queue.offer(i);
                }
            }
        }
        return count == numCourses;*/
    }
}
