import java.util.Arrays;

/* programmers : 정렬 -> K번째 수 -> 최적화 정답 */
public class ArraysAlgorithmSolution {
	
	public int[] solution(int[] arrays, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++) {
        	int temp[] = Arrays.copyOfRange(arrays, commands[i][0]-1, commands[i][1]);	// Arrays.copyOFRange 함수가 point
        	Arrays.sort(temp);
        	answer[i] = temp[commands[i][2]-1];
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
		ArraysAlgorithmSolution arraysAlgorithm = new ArraysAlgorithmSolution();
		
		int[] arrays = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		int[] answers = arraysAlgorithm.solution(arrays, commands);
		arraysAlgorithm.print(answers);
	}
}
