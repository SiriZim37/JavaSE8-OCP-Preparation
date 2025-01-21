package designpatterns;

import java.util.Locale;


class PersonTest {
    private String name;
    private int age;
    private String address;

    public static class Builder {
        private String name;
        private int age;
        private String address;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public PersonTest build() {
            return new PersonTest(this);
        }
    }

    private PersonTest(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.address = builder.address;
    }
}
/*
 * อธิบาย: Person ใช้ Builder เพื่อสร้างอ็อบเจ็กต์ที่มีการตั้งค่า name, age, และ address. 
 * การใช้ Builder ช่วยให้การสร้างอ็อบเจ็กต์ที่มีหลายๆ ค่าทำได้ง่ายและอ่านง่าย.
 */
public class B02_Builder {

	/*
	 * 	Builder : Klasse so gestalten, dass damit das Bilden 
	 *  neuer komplizierter Objekte bequemer gestaltet werden kann,
	 *  als es mit vielen überladennen Konstruktoren möglich wäre.
	 */
	
	/*
	 * Builder Pattern (การสร้างอ็อบเจ็กต์ที่มีหลายค่า)
	 * Builder ใช้เมื่อคุณต้องการสร้างอ็อบเจ็กต์ที่มีการตั้งค่าหลายๆ ค่า 
	 * ซึ่งมีค่าหลายตัวเลือกและไม่ต้องการสร้างคอนสตรัคเตอร์ที่มีอาร์กิวเมนต์หลายตัว.
	 */
	public static void main(String[] args) {
	


		String s = new StringBuilder()
					.append(false)				// konstruieren	 > false
					.append("Java")				// konstruieren  > falseJava
					.replace(0, 5, "Sprache")	// konstruieren	 > SpracheJava
					.toString();				// bilden
		
		System.out.println("s :" +  s);
		
		
		Locale loc = new Locale.Builder()
					.setRegion("DE")
					.setLanguage("de")
					.build();			// bilden
		
		System.out.println("loc :" +  loc);	// loc :de_DE
		
	}

}
