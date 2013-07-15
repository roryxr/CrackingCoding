import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


class TestResult {
    int studentId;
    String testDate;
    int testScore;
 }


public class FinalScoreQuestion {
 
   Map <Integer, Double> calculateFinalScores (List<TestResult> results) {
   		Iterator itr = results.iterator();
   		Map<Integer,Double> map = new HashMap<Integer, Double>();
   		while(itr.hasNext()){
   			if(result.containsKey(itr.next().studentId)){
   				map.put(itr.next().studentId, map.values().add(double(itr.next().testScore)));
   			} else {
   				map.put(new(itr.next().studentId), itr.next().testScore);
   			}
   		}
   		findAvg(map);
   }
 
}