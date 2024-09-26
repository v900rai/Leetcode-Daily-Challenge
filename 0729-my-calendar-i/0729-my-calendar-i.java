// class MyCalendar {

//     public MyCalendar() {
        
//     }
    
//     public boolean book(int start, int end) {
        
//     }
// }

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */

 import java.util.TreeMap;

class MyCalendar {

    private TreeMap<Integer, Integer> calendar;

    public MyCalendar() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        // Get the event with the largest start time that is less than the given start
        Integer prevEventEnd = calendar.floorKey(start);
        if (prevEventEnd != null && calendar.get(prevEventEnd) > start) {
            return false; // Overlaps with the previous event
        }

        // Get the event with the smallest start time that is greater than or equal to the given start
        Integer nextEventStart = calendar.ceilingKey(start);
        if (nextEventStart != null && nextEventStart < end) {
            return false; // Overlaps with the next event
        }

        // No overlap, so book the event
        calendar.put(start, end);
        return true;
    }
}
