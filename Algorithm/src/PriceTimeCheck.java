
/* programmers : 스택/큐 -> 주식가격 -> 내가 푼 것 */
public class PriceTimeCheck {
	public int[] solution(int[] prices) {
        int prices_length = prices.length;
        int[] answer = new int[prices_length];
        int i;
        int j;
        
        for(i=0; i<prices_length; i++) {
        	for(j=i+1; j<prices_length; j++) {
        		answer[i]++;
        		if(prices[i] > prices[j]) {
        			break;
        		}
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		PriceTimeCheck priceTimeCheck = new PriceTimeCheck();
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
