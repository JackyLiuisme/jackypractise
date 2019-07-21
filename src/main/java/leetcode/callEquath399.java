package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.
 *
 * Example:
 * Given a / b = 2.0, b / c = 3.0.
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 *
 * The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.
 *
 * According to the example above:
 *
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 */
public class callEquath399 {
    Map<String, String> father;
    Map<String, Double> weight;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        father = new HashMap();
        weight = new HashMap();
        for(int i = 0; i < equations.size(); i ++){
            String a = equations.get(i).get(0), b = equations.get(i).get(1);
            father.putIfAbsent(a, a);
            weight.putIfAbsent(a, 1.0);
            father.putIfAbsent(b, b);
            weight.putIfAbsent(b, 1.0);
            union(a, b, values[i]);
        }
        double[] res = new double[queries.size()];
        for(int i = 0; i < queries.size(); i ++){
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            if(find(a) == null || find(b) == null || !find(a).equals(find(b))){
                res[i] = -1.0;
            } else{
                res[i] = weight.get(b) / weight.get(a);
            }
        }
        return res;
    }

    private String find(String str){
        if(father.get(str) == null) return null;
        if(father.get(str).equals(str)) return str;
        weight.put(str, weight.get(str) * weight.get(father.get(str)));
        father.put(str, find(father.get(str)));
        return father.get(str);
    }

    private void union(String a, String b, double w){
        String root_a = find(a);
        String root_b = find(b);
        if(!root_a.equals(root_b)){
            father.put(root_b, root_a);
            weight.put(root_b, w * weight.get(a) / weight.get(b));
        }
    }

}
