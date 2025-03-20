package arrays;



class TemperaturenFeurEinTagMitArray{
		int[] tArray = new int[24];
		
		
		int mittelwert() {
			int sum = 0 ;
			
			for( int i = 0 ; i < tArray.length; i++) {
				sum += tArray[i];
			}
			
			return sum/24;
		}
		
}


public class B02_TemperaturenMitArray {
		
	public static void main(String[] args) {
		
		new TemperaturenFeurEinTagMitArray();
	}

}
