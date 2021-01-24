import java.util.Arrays;

/* programmers : 정렬 -> K번째 수 -> 내가 푼 것 */
public class ArraysAlgorithm {
	public int[] solution(int[] arrays, int[][] commands) {
        int[] answer = {};
        int start;
        int end;
        int index;
                
        answer = new int[commands.length];
        
        int i;
        for (i=0; i<commands.length; i++) {
        	start = commands[i][0];
        	end = commands[i][1];
        	index = commands[i][2];
        	
        	int[] temp = new int[end-start+1];
        	int cnt = 0;
        	for(int j=start-1; j<end; j++) {
        		temp[cnt++] = arrays[j];
        	}
        	
        	Arrays.sort(temp);
        	answer[i] = temp[index-1];
        }
        
        return answer;
    }
		
	public void print(int[] arrays) {
		int i;
		for(i=0; i<arrays.length; i++) {
			System.out.print(arrays[i]);
			if(i != arrays.length-1) {
				System.out.print(",");
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		ArraysAlgorithm arraysAlgorithm = new ArraysAlgorithm();
		
		int[] arrays = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		int[] answers = arraysAlgorithm.solution(arrays, commands);
		arraysAlgorithm.print(answers);
	}

}
