package dt;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class B01_Typen {

	public static void main(String[] args) {
		Instant v0;			// Millisekunden seit 1.1.1970

		LocalDate v1;		// Datum
		LocalTime v2;		// Zeit
		LocalDateTime v3;	// Datum + Zeit
		
		ZoneId v33;			// Zeitzone
		ZonedDateTime v4;   // Datum + Zeit + Zeitzone
		
		Period v5;			// A date-based amount of time in the ISO-8601 calendar system,
							// such as "2 year and 4 days.
		
		Duration v6;		// A time-based amount of time, such as 34.5 seconds.
		
		ChronoUnit v7 = ChronoUnit.DAYS; // Zeiteinheiten
		
		ChronoField v8 = ChronoField.DAY_OF_MONTH; // Mögliche Eigenschaften von Datum/Zeit-Objekten
		
		DateTimeFormatter v9; // Formatierer und Parser
	}
}
