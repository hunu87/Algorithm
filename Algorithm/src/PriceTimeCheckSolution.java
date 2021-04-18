import java.util.Stack;

/* programmers : 스택/큐 -> 주식가격 -> Stack을 이용한 최적화 정답 */
/* 너무 복잡하고 어렵다. 다시 stac 활용에 대해 곱씹어 봐야할듯 */
public class PriceTimeCheckSolution {
	public int[] solution(int[] prices) {
        Stack<Integer> beginIdxs = new Stack<>();
        int i=0;
        int [] answer = new int[prices.length];
        
        beginIdxs.push(i);
        for(i=1; i<prices.length; i++) {        	
        	while(!beginIdxs.isEmpty() && prices[i] < prices[beginIdxs.peek()]) {
        		int beginIdx = beginIdxs.pop();
        		answer[beginIdx] = i - beginIdx;
        	}
        	beginIdxs.push(i);
        }
        
        while(!beginIdxs.isEmpty()) {
    		int beginIdx = beginIdxs.pop();
    		answer[beginIdx] = i - beginIdx -1;
    	}
        
        return answer;
    }
	
	public static void main(String[] args) {
		PriceTimeCheckSolution priceTimeCheck = new PriceTimeCheckSolution();
		int[] stockPrice = {1, 2, 3, 2, 3};
		
		int[] result = priceTimeCheck.solution(stockPrice);
		for(int i=0; i<result.length; i++) {
			System.out.print(result[i]);
			if(i+1 != result.length) {
				System.out.print(",");
			}
		}
	}
}
