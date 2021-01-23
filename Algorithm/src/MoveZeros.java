
public class MoveZeros {

	public static void main(String[] args) {
		
		MoveZeros moveZeros = new MoveZeros();
		
		int[] numbers = {0,3,2,0,8,5};
		int index = 0;
		
		for(int i=0; i<numbers.length; i++) {
			if(numbers[i] != 0) {
				numbers[index] = numbers[i];	// 배열 데이터를 하나하나 체크 하면서 조건에 맞는 경우, 앞에 index 부터 넣어주는게 point
				index++;
			}
		}
		
		while(index < numbers.length) {
			numbers[index] = 0;
			index++;
		}
		
		moveZeros.print(numbers);
	}
	
	public void print(int[] numbers) {
		for(int i=0; i<numbers.length; i++) {
			System.out.print(numbers[i]);
		}
	}
}
