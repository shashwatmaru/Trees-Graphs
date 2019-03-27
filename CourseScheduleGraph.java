import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleGraph {
        public static void main(String[] args){
            int[][] prerequisites = {{1,0},{0,1}};
            CourseScheduleGraph courseScheduler = new CourseScheduleGraph();
            System.out.println(courseScheduler.canFinish(2,prerequisites));
        }

        public  boolean canFinish(int numCourses, int[][] prerequisites) {
            if(prerequisites == null){
                return false;
            }

            // Take the length of prereqs to len variable
            int len = prerequisites.length;

            //This will help us to know whether a course has prereq or not
            int[] flag = new int[numCourses];
            for(int i=0;i<len;i++){
                flag[prerequisites[i][0]]++;
            }

            //This will hold the courses which has no prereq.
            Queue<Integer> queue = new LinkedList<>();
            for(int i=0;i<numCourses;i++){
                //it means the particular course has no prereq
                if(flag[i]==0){
                    queue.add(i);
                }
            }
            int coursesWithNoPrereq = queue.size();

            while(!queue.isEmpty()){
                //Check if the element in queue helps to know if this is a prereq for other course, if it then
                int top = queue.remove();
                for(int i=0;i<len;i++){
                    if(top == prerequisites[i][1]){
                        flag[prerequisites[i][0]]--;
                        if(flag[prerequisites[i][0]]==0){
                            coursesWithNoPrereq++;
                            queue.add(prerequisites[i][0]);
                        }
                    }
                }
            }
            return numCourses == coursesWithNoPrereq;
        }

}
