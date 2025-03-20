package oca;

interface Device{ public void doit(); public void doit2(); }
abstract class Electronic implements Device{
	public void doit() {}
}
class PhoneMe extends Electronic implements Device{
	public void doit2() {}
}

public class AbstractInterfaceClass {
	

	
}
