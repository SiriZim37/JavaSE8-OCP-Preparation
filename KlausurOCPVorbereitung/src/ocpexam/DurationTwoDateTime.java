package ocpexam;

import java.time.Duration;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DurationTwoDateTime {

	public static void main(String[] args) {
		

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");

//        ZonedDateTime date1 = ZonedDateTime.of(2018, 11, 3, 22, 0, 0, 0);  // cf
//        ZonedDateTime date2 = ZonedDateTime.of(2018, 11, 4, 6, 0, 0, 0);   // cf
        

        ZonedDateTime date1 = ZonedDateTime.of(2018, 11, 3, 22, 0, 0, 0, ZoneOffset.ofHours(-3));
        ZonedDateTime date2 = ZonedDateTime.of(2018, 11, 4, 6, 0, 0, 0, ZoneOffset.ofHours(-6));

        
        Duration duration = Duration.between(date1, date2);

        System.out.println("Duration between the two times: " + duration.toHours() + " hours and " + duration.toMinutes() % 60 + " minutes.");
        
        // Duration between the two times: 11 hours and 0 minutes.
	}
}
