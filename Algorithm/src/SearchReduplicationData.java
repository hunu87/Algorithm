import java.util.HashMap;
import java.util.stream.Stream;

/* 배열에서 중복 데이터 찾기 */
public class SearchReduplicationData {
	
	public void solution(String[] datas) {
		HashMap<String, Integer> hm = new HashMap<>();
		
		for(String data : datas) {
			hm.put(data, hm.getOrDefault(data,0) + 1);
		}
		
		Stream<HashMap.Entry<String, Integer>> stream = hm.entrySet().stream().filter(s -> s.getValue() > 1);
		stream.forEach(m -> System.out.println(m.getKey()));
	}
	
	public static void main(String[] args) {
		SearchReduplicationData searchReduplicationData = new SearchReduplicationData();
		String[] data = {"mislav", "stanko", "mislav", "ana", "stanko"}; 
		
		searchReduplicationData.solution(data);
	}

}
