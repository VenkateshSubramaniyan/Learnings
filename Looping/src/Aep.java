import java.util.Arrays;
import java.util.List;




public class Aep {

	public static void main(String args[]){
		
		String providerids="AEP_1,AEPaliad,Aep1";
		List<String> provideridsList = Arrays.asList( providerids.split(","));
		
		System.out.print(provideridsList.get(1));
		
		
	}
}
