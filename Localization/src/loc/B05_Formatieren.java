package loc;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class B05_Formatieren {

	/*
	 * Formatieren : Objekt in ein String verwandeln
	 * 
	 * Parsen 	   : ein String in ein Objekt (vom anderen Typ) verwandeln 
	 * 
	 * 
	 * การฟอร์แมตด้วย Locale (Formatieren von Locale) ใน Java หมายถึง การปรับรูปแบบของข้อมูลต่าง ๆ 
	 * เช่น วันที่ เวลา จำนวนเงิน หรือข้อความ ตามสภาพแวดล้อมของผู้ใช้ (Locale) 
	 * ซึ่งจะช่วยให้แอปพลิเคชันสามารถแสดงข้อมูลได้ตามความคาดหวังของผู้ใช้ในแต่ละประเทศหรือภูมิภาค
	 * 
	 * 
	 *  Formatieren (การฟอร์แมต):หมายถึงการแปลง อ็อบเจ็กต์ (Object) เป็น สตริง (String) ตามรูปแบบที่ต้องการ
	 *  การฟอร์แมตมักจะใช้เมื่อต้องการแสดงข้อมูลในรูปแบบที่อ่านง่ายหรือเหมาะสมกับบริบท เช่น การแสดงวันที่หรือจำนวนเงิน
	 * 
	 * 
	 *  Parsen (การแปลง):
	 *  หมายถึงการแปลง สตริง (String) กลับมาเป็น อ็อบเจ็กต์ (Object) หรือ ประเภทข้อมูลอื่น ๆ 
	 *  เช่น การแปลงสตริงที่เก็บวันที่เป็นอ็อบเจ็กต์ประเภท Date หรือแปลงสตริงเป็นตัวเลข
	 */
	public static void main(String[] args) throws ParseException {
		
		Locale loc = new Locale("us", "US");
		double value = 3513.789;
		
		
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		System.out.println(nf.format(12345.67));		  		// 12.345,67 €
		
		/*
		 * Formatieren mit dem default-Locale
		 */
		nf = NumberFormat.getCurrencyInstance(loc);
		System.out.println(nf.format(12345.67)); 		 		// US$ 12,345.67

	    
		String formattedValue = nf.format(value);
		System.out.println("1. formattedValue: " + formattedValue);	// $3,513.79
		
	   /*
	    * Parsen
	    */
	    Number n1 = nf.parse(formattedValue);
	    System.out.println("Parsen n1 : " + n1  );
	    
	    
	    System.out.println("\n------------------------------------------------------------------");
	    
	    
		/*
		 * Formatieren mit dem speziellen Locale
		 */
		nf = NumberFormat.getCurrencyInstance(Locale.CANADA);
		System.out.println(nf.format(12345.67));	   	 		//  $12,345.67
		
		String formattedValue2 = nf.format(value);
		System.out.println("2. formattedValue2: " + formattedValue2);	// $3,513.79
		
		/*
		 * Parsen
		 */
	    Number n2 = nf.parse(formattedValue2);
	    System.out.println("Parsen n1 : " + n2  );
		
		
	    System.out.println("\n------------------------------------------------------------------");
	
		 
		//DecimalFormat ใช้ในการฟอร์แมตตัวเลขเป็นสตริงที่มีเครื่องหมายคั่นพัน (,) และทศนิยมสองตำแหน่ง
	    DecimalFormat formatter = new DecimalFormat("#,###.00$");
	    String formattedValue3 = formatter.format(value);
	    System.out.println("3. formattedValue3: " + formattedValue3);  // ผลลัพธ์: 3.513,79
	    
	    /*
		 * Parsen
		 */
//	    Number n3 = nf.parse(formattedValue);	//  java.text.ParseException: Unparseable number: "3.513,79
//	    System.out.println("Umgekerht n3 : " + n3  );
	    
        // Parsing formatted value back using DecimalFormat
	    
        DecimalFormat parseFormatter = new DecimalFormat("#,###.00");
        parseFormatter.setParseBigDecimal(true);  // To parse as BigDecimal
        Number n3 = parseFormatter.parse(formattedValue3);
        System.out.println("Parsen n3 : " + n3); 		 // 3513.79
        
        System.out.println("\n------------------------------------------------------------------");
        
        
        bsp_MitDateTimeFormatter();
	}
	
	static void bsp_MitDateTimeFormatter() {
		System.out.println("\n*** DateFormatter");
		
		LocalDate date = LocalDate.now();
		System.out.println("date: " + date);
		
//		String title = "|	sprache		|		E|		EE|		EEE|		EEEE|		EEEEE|";
		
		String fmt = "|%-25s|%-20s|%-20s|%-20s|%-20s|%-20s|%n";
		
		System.out.printf(fmt , "sprache" , "E","EE","EEE","EEEE","EEEEE");
		
		Locale loc = Locale.getDefault();
		DateTimeFormatter f1 =  DateTimeFormatter.ofPattern("E");
		DateTimeFormatter f2 =  DateTimeFormatter.ofPattern("EE");
		DateTimeFormatter f3 =  DateTimeFormatter.ofPattern("EEE");
		DateTimeFormatter f4 =  DateTimeFormatter.ofPattern("EEEE");
		DateTimeFormatter f5 =  DateTimeFormatter.ofPattern("EEEEE");  //  limit 5 (E bis EEEEE )
		
		String formatedValue = f1.format(date);
		System.out.println("formatedValue: " + formatedValue);
		
		formatedValue = f5.format(date);
		System.out.println("formatedValue: " + formatedValue);
		
		System.out.printf(fmt , "sprache" , 
								f1.format(date), 
							    f2.format(date),
							    f3.format(date), 
							    f4.format(date),
							    f5.format(date));
		
		System.out.println("\n------------------------------------------------------------------");
		  
		Consumer<Locale> consumer = local -> {
			DateTimeFormatter v1 =  DateTimeFormatter.ofPattern("E" , local);
			DateTimeFormatter v2 =  DateTimeFormatter.ofPattern("EE" , local);
			DateTimeFormatter v3 =  DateTimeFormatter.ofPattern("EEE", local);
			DateTimeFormatter v4 =  DateTimeFormatter.ofPattern("EEEE", local);
			DateTimeFormatter v5 =  DateTimeFormatter.ofPattern("EEEEE", local);  //  limit 5 (E bis EEEEE )
			
			System.out.printf(fmt ,local.getDisplayLanguage() , 
									v1.format(date), 
								    v2.format(date),
								    v3.format(date), 
								    v4.format(date),
								    v5.format(date));
		};
		
		Locale[] allLocales =Locale.getAvailableLocales();
		
		Comparator<? super Locale> cmp = (l1 , l2) -> l1.getDisplayLanguage() .compareTo(l2.getDisplayLanguage());
		
		Stream.of(allLocales)
				.sorted(cmp)
				.map(Locale::getLanguage)
				.distinct()
				.map(Locale::new)
				.forEach(consumer);
		
	}

}
