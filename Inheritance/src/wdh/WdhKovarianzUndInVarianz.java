package wdh;


class AutoFabrik{
	Car create() { return null;}
}

class NissanFabrik extends AutoFabrik{	
	Car create() { return null;}  // Invariance in Java is OK , Der Rückgabe-Typ beim Überschreiben bleibt gleich	
}

class BenzFabrik extends AutoFabrik {
	 Benz create() { return null;}  // Kovariance  in Java ist OK , der neue Rückgabe-Typ beim Überschreiben 
	 								// halt IS-A-Beziehung zum alten Rückgabe Typ
}

class ObjectFabrik extends AutoFabrik{
//	 Object create() { return null;}  // cf : Kontravariancz in Java beim Überschreiben geht nicht !
									  // Object IS kein Auto 
}

class Car{

}

class Nissan extends Car{
	
}

class Benz extends Car{
	
}

class Karotte{
	
}


public class WdhKovarianzUndInVarianz {

	public static void main(String[] args) {
	

	}

}
