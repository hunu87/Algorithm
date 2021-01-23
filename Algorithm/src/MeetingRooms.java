import java.util.Arrays;
import java.util.Comparator;

class Interval {
	
	int start;
	int end;
	
	public Interval() {
		this.start = 0;
		this.end = 0;
	}
	
	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
}

public class MeetingRooms {

	public static void main(String[] args) {
		
		MeetingRooms meetingRooms = new MeetingRooms();
		
		Interval interval1 = new Interval(15,20);
		Interval interval2 = new Interval(5,10);
		Interval interval3 = new Interval(0,30);
		
		Interval[] intervals = {interval1, interval2, interval3};
		boolean result = meetingRooms.solve(intervals);
		
		System.out.println("result :" + result);
	}
	
	public boolean solve(Interval intervals[]) {
		
		if(intervals == null) {
			return false;
		}
		
		Arrays.sort(intervals, comparator);
		// print(intervals);
		
		for(int i=1; i<intervals.length; i++) {
			if(intervals[i-1].end > intervals[i].start) {
				return false;
			}
		}
		
		return true;
	}
	
	public void print(Interval intervals[]) {
		for(Interval interval : intervals) {
			System.out.println("start : " + interval.start + ", end : " + interval.end);
		}
	}
	
	Comparator<Interval> comparator = new Comparator<Interval>() {
		@Override
		public int compare(Interval o1, Interval o2) {
			return o1.start - o2.start;	// 계산 결과가 양수가 나오면 o1, o2 서로 순서를 바꾼다. (여기는 오름차순)
			// return o2.start - 01.start; // (이거는 내림차순)
		}
	};
	
}
