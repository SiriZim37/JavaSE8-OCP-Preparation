package oca;

import java.io.IOException;

interface DeviceMobile { 
	public void doit(); 
	public void doit2(); 
}

class ElectronichMain  implements DeviceMobile{
	public void doit2() {}
	public void doit() {}
}


class PhoneAA extends ElectronichMain {
	// doit and doit2 have already implement by ElectronicMain
	public void changeSize(int n) {}
}
class PhoneAAA extends ElectronichMain {
	// doit and doit2 have already implement by ElectronicMain
	public void changeSize(long l) {}
	public int changeSize(int i , long l) {return (int)(i+l);}
	public double changeSize(double i , double l) {return i+l;}
	public int changeSize(int i , long l , float f) throws IOException {return (int)(i+l);}
}

//----------------------------------------------------------
abstract class ElectronicV extends ElectronichMain implements Device{
	protected void stockIt() {}
	public abstract void stuffIt();
}

class PhoneBB extends ElectronicV {
	// doit and doit2 have already implement by ElectronicMain
	public void stuffIt() {}
	
}
//----------------------------------------------------------
abstract class ElectronicCase  implements DeviceMobile{
	public void stockIt() {}
	public void doit() {}
	public abstract void stuffIt();
}

class PhoneCC extends ElectronicCase {
	// doit have already implement by ElectronicMain
	public void doit2() {}
	public void stuffIt() {}
	
	
}



public class AbstractExtendInstanceClassWithInterfaceClass {
	

	
}
