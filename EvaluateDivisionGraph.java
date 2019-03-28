import java.util.HashMap;
import java.util.Map;

/*
Evaluate Division
  Go to Discuss
Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0.
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

According to the example above:

equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.


 */
public class EvaluateDivisionGraph {
        public class Node{
            String name;
            int flag;
            Map<Node,Double> neighbours=null;
            public Node(String value){
                name = value;
                flag=0;
                neighbours = new HashMap<>();
            }
        }

        public class Graph{
            Map<String,Node> nodeMap = null;
            public Graph(){
                nodeMap = new HashMap<>();
            }

            public void buildGraph(String[][] equations, double[] values){
                for(int i=0;i<equations.length;i++){
                    double value = values[i];
                    String[] equation = equations[i];
                    String first = equation[0];
                    String second = equation[1];
                    if(!nodeMap.containsKey(first)){
                        nodeMap.put(first,new Node(first));
                    }
                    if(!nodeMap.containsKey(second)){
                        nodeMap.put(second,new Node(second));
                    }
                    nodeMap.get(first).neighbours.put(nodeMap.get(second),value);
                    nodeMap.get(second).neighbours.put(nodeMap.get(first),1.0/value);
                }

            }

            public void reset(){
                for(String name: nodeMap.keySet()){
                    nodeMap.get(name).flag=0;
                }
            }

        }


        public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
            Graph graph = new Graph();
            graph.buildGraph(equations,values);

            int i=0;
            double[] answers = new double[queries.length];

            for(String[] query: queries){
                Node start = graph.nodeMap.get(query[0]);
                Node end = graph.nodeMap.get(query[1]);
                answers[i] = dfs(start, end, 1.0);
                i++;
                graph.reset();
            }
            return answers;
        }

        public double dfs(Node start,Node end, double product){
            if(start == null || end == null){
                return -1.0;
            }
            if(start.name.equals(end.name)){
                return product;
            }

            start.flag=1;
            for(Node nodes:start.neighbours.keySet()){
                if(nodes.flag==0){
                    double temp =dfs(nodes ,end, product*start.neighbours.get(nodes));
                    if(temp != -1){
                        return temp;
                    }
                }
            }

            return -1;
        }

        public static void main(String[] args){
            String[][] equations = {{"a","b"},{"b","c"}};
            double[] values = {2.0,3.0};
            String[][] queries = {{"a","c"},{"b","c"},{"a","e"},{"a","a"},{"x","x"}};
            EvaluateDivisionGraph evaluateDivision = new EvaluateDivisionGraph();
            double [] result = evaluateDivision.calcEquation(equations,values,queries);
            for(double ans: result){
                System.out.println(ans);
            }
        }
    }


