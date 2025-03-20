# Aufgabe 'Enums - OS'

Gegeben ist folgende enum-Klasse:

		public enum OS {
			UNIX, WINDOWS, MAC
		}

Und die main-Methode:

		System.out.println("*** statische Methode values:");
		OS[] allValues = OS.values();
		
		for (OS os : allValues) {
			System.out.println(os);
		}
		
		System.out.println("** toString:");
		OS var1 =  OS.MAC;
		System.out.println(var1); // MAC


- Erzeugen Sie eine 'normale' Klasse `MyOS`, die die enum-Klasse `OS` nachbildet. 

- Erzeugen Sie einen neue main-Methode, in der Ihre neue Klasse getestet wird (genauso wie die vorgebene main-Methode die enum-Klasse `OS` testet).

