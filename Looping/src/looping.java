
public class looping {
	
	static int i=0,length=4;
	
	public static void main(String args[]){
		
		int spaces,symbolCounts=1;
		recursivePrint(length,symbolCounts);
		
	}
	
	static void recursivePrint(int spaces,int symbolCounts){
		
		if(i<=length ){
			decrementalPrint("-", length);
//			incrementalPrint("*", symbolCounts);

			System.out.println();
			spaces--;
			symbolCounts+=2;
			recursivePrint(spaces, symbolCounts);
			i++;
		}
	}
	
	static void decrementalPrint(String symbol, int count ){
		
		if(count>=0){
			System.out.print(symbol);
			decrementalPrint(symbol, length);
			count--;
		}
		
	}
	
	static void incrementalPrint(String symbol, int count ){
		
		System.out.print(symbol);
		
	}
	
}
