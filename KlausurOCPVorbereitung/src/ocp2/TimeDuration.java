package ocp2;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class TimeDuration {

	/*
	  Which statement is true about java.time.Duration?
		 A. It tracks time zones.
		 B. It preserves daylight saving time.
		 C. It defines time-based values.
		 D. It defines date-based values
	 */
	
	public static void main(String[] args) {
		
	
		/*
		 C. It defines time-based values.

		Explanation:
		java.time.Duration is part of the Java 8 Date and Time API (java.time) 
		and represents a time-based amount of time, such as hours, minutes, 
		and seconds. It is used to measure time differences in terms of seconds and nanoseconds.
		
		Why the other options are incorrect:
		
		A. It tracks time zones.
		Incorrect. Duration does not track time zones. Time zone tracking is handled by classes 
		like ZonedDateTime, not Duration.
	
		B. It preserves daylight saving time.
		Incorrect. Duration does not deal with daylight saving time adjustments. 
		It simply represents a period of time between two instants, irrespective of any calendar-specific concerns like daylight saving time.
		
		D. It defines date-based values.
		Incorrect. Date-based values (such as years, months, days) 
		are handled by classes like LocalDate and Period, not Duration.

		 */
	}
}
