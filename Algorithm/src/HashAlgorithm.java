import java.util.Arrays;
import java.util.HashMap;

/* programmers : 완주하지 못한 선수 */
public class HashAlgorithm {
	
	/* 2개 배열을 미리 정렬 후 값 동일한 index 위치에 값을 비교하여 존재하지 않는 값을 찾는다. */
	public String solution1(String[] participants, String[] completions) {
		
		// 2개의 배열을 모두 정렬 함으로써, 한쪽 배열에 존재하지 않는 값을 쉽게 알 수 있음
		Arrays.sort(participants);
		Arrays.sort(completions);
		
		int i;
		for(i=0; i<completions.length; i++) {	// 더 적은 배열의 갯수만큼 for 문 loop
			if(!participants[i].equals(completions[i])) {	// 2개의 배열에서 같은 i번째에 값이 다르다면, 한쪽의 배열에만 값이 존재한다는 의미임
				return participants[i];
			}
		}
		
		return participants[i];
	}
	
	/* 2개의 배열을 loop 돌면서 HashMap에 value 값을 put(+1)/put(-1) 하여 존재하지 않는 값을 찾는다. */
	public String solution2(String[] participants, String[] completions) {
		String result = "";
		HashMap<String, Integer> hm = new HashMap<>();
		
		for(String participant : participants) {	// 배열을 갯수만큼 loop 돌면서, 중복 값이 있는 경우 value 값에 +1 함.
			hm.put(participant, hm.getOrDefault(participant, 0) + 1);	// hashmap getOrDefault : key에 해당 하는 값이 있으면 return 하고, 없으면 default 값을 return
		}
		
		for(String completion : completions) {	// 배열을 갯수만큼 loop 돌면서, 이미 이전에 key에 해당 하는 value 값이 있는 경우 -1 함.
			hm.put(completion, hm.get(completion) - 1);
		}
		
		for(String key : hm.keySet()) {
			if(hm.get(key) > 0) {
				result = key;
				return result;
			}
		}
		
		
		return result;
	}
	
	public static void main(String[] args) {
		
		HashAlgorithm hashAlgorithm = new HashAlgorithm();
		
		String[] participant = {"mislav", "stanko", "mislav", "ana"}; 
		String[] completion = {"stanko", "ana", "mislav"}; 
		
		System.out.println("solution1 result : " + hashAlgorithm.solution1(participant, completion));
		System.out.println("solution2 result : " + hashAlgorithm.solution2(participant, completion));
	}

}
