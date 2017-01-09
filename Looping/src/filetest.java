import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class filetest {
	
	public static void main(String args[]){
//		
//		System.load("/home/venkatesh/.bashrc");
//		System.out.println( "URjaRepoPAth"+System.getenv("URJA_REPO_PATH"));
//		
		String overrideFile;
//		String errors="EcovaAdvance_12966-MidAmericanMarketer_1 | MFerguson[ERROR]: time.zeroNumberofDays(Zero Number of Days): [Account(1911074060, Statement Date = 08/05/2016, 07/01/2016-08/02/2016) -> Meter(ElectricMeterData-230139604, 07/01/2016-08/02/2016) -> Usage(Name=null, Actual Usage=0E-10, Unit=kW, 07/01/2016-07/01/2016)] -> https://skylight.bigproduction.rainforest.urjanet.net/statementsearch/getfile?id=3346391736 ";
//		String errors="RubiconGldobal_1134-WasteIndustriesNC_1 | rubiconbills03[ERROR]: acct.checkAccountLevelStatementDate(<Account level statement data (statement date: Tue Mar 31 00:00:00 EDT 2015) is outside of required interval of 6 months in the past (Sun Jan 10 02:02:08 EST 2016) and 3 months into the future (Mon Oct 10 02:02:08 EDT 2016)>): [Account(000863876-00001, Statement Date = 03/31/2015, 03/01/2015-03/31/2015)] -> https://skylight.bigproduction.rainforest.urjanet.net/statementsearch/getfile?id=3237706782";
//		String errors="[SystemEvent: ERROR]----------------------------------------------"+
//"   AuditEventCode.AuditEventCode{auditName=time.futureDate}"+
//"   time.futureDate(Future Date Alarm): [Statement(FirstAccount(RG17), Statement Date = 12/27/2015, 02/01/2016-02/29/2016)]"+
//"[/SystemEvent]------------------------------------------------------------";
//		String errors="RubiconGlobal_10478-RubiconGlobalProvider0_1 | rubiconproduction@urjanet.com[ERROR]";

		String errors="/home/ubuntu/.extractioncontroller/jobs/RubiconGlobal_WasteIndustriesNCTemplateProvider/builds/197/log:271644:RubiconGlobal_11334-WasteIndustriesNC_1 | rubiconbills03[ERROR]: acct.checkAccountLevelStatementDate(<Account level statement data (statement date: Tue Mar 31 00:00:00 EDT 2015) is outside of required interval of 6 months in the past (Sun Jan 10 02:02:08 EST 2016) and 3 months into the future (Mon Oct 10 02:02:08 EDT 2016)>): [Account(000863876-00001, Statement Date = 03/31/2015, 03/01/2015-03/31/2015)] -> https://skylight.bigproduction.rainforest.urjanet.net/statementsearch/getfile?id=3237706782 ";
//		String errors="RubiconGlobal_10544-GHIGarbageAndRecyclablesIA_1 | ubuntu[ERROR]: acct.accountExtractFailures(Account Extract Failures: meta.require_error.sum.invoice_number=[YES]): [Account(R G D G 5823 703 W Taylar Creston Ia 50801, 05/01/2016-07/31/2016)] -> http://localhost:9002/statementsearch/getfile?id=828162 ";
//		String errors="RubiconGlobal_10478-RubiconGlobalProvider0_1 | rubiconproduction@urjanet.com[ERROR]: acct.checkAccountNumber(<The account number given (Carmike cinema's - Murfreesboro, TN) must be between 3 and 100 characters long and can only contain letters, numbers, dashes,dots,commas, and spaces>): [Account(Carmike cinema's - Murfreesboro, TN, Statement Date = 08/01/2016, 08/01/2016-08/31/2016)] -> http://localhost:9002/statementsearch/getfile?id=839852";
//		String errors="2016-08-11 06:50:17.0	Ameresco_7-Houston_1	[ERROR]: acct.checkSumCharge(<Charges don't checksum by 28.9800000000> {Total bill amount = 98.6900000000, Amount Due By Date = Mon Jun 27 00:00:00 EDT 2016}): [Account(0425-1520-1566, Statement Date = 06/06/2016, 04/24/2016-06/06/2016)] -> https://skylight.bigproduction.rainforest.urjanet.net/statementsearch/getfile?id=3347802660";
		String accessChannel= errors.substring(0,errors.indexOf("[ERROR]"));
//		
//		int startIndex = errors.indexOf("-")+"-".length();
//		accessChannel = accessChannel.substring(0, errors.indexOf("_1",startIndex)+"_1".length());
//		accessChannel = accessChannel.replaceAll("(.*)(?=\\s[A-Z]\\w+_\\d+-[A-Z]\\w+_1)", "");
//		
//		System.out.println("Access Chanenl="+accessChannel);


		
		
		Pattern accessChannelpattern = Pattern.compile("[A-Z]\\w+_\\d+-[A-Z]\\w+_1");
		Matcher regexMatcher = accessChannelpattern.matcher(accessChannel);
		
		if ( regexMatcher.find() ) {
			accessChannel= regexMatcher.group(regexMatcher.groupCount());
		}
		
		String customer_Provider=accessChannel.replaceAll("_\\d+-", "-");
	
		String BaseUrl="/opt/auditoverride/uds-overrides/src/main/resources/urjanet/think/pipeline/desc/overrides/";
		System.out.println("BaseURl="+BaseUrl);
		String OverrideSuffix=".override";

        if (Files.exists( Paths.get( BaseUrl+accessChannel+ OverrideSuffix))){

        	overrideFile=accessChannel;
        }
        else if ( Files.exists( Paths.get( BaseUrl+customer_Provider+ OverrideSuffix ))){

        	overrideFile=customer_Provider;
        }
        else{
    		String provider=customer_Provider.substring( customer_Provider.indexOf("-")+1);
        	overrideFile=provider;
        }
	
	
		System.err.println(errors);
//		String customer_Provider = accessChannel.replaceAll("_\\d+-", "-");
		System.out.println("CP="+customer_Provider);
		String provider=customer_Provider.substring( customer_Provider.indexOf("-")+1);
		System.out.println(provider);
//
//		String baseurl="/opt/auditoverride/uds-overrides/src/main/resources/urjanet/think/pipeline/desc/overrides/";
//		String overrideSuffix=".override";
//		overrideFile=provider;
//		
//		String checkurl = baseurl+customer_Provider+overrideSuffix;
//		System.out.println(checkurl);
//
//	         if ( new File(baseurl+accessChannel+overrideSuffix).exists()){
//	        	 overrideFile=accessChannel;
//		         System.out.println("I am here");
//	         }
//	         else if ( new File(baseurl+customer_Provider+overrideSuffix).exists()){
//	        	 overrideFile=customer_Provider;
//		         System.out.println("I am here");
//	         }
//	         else{
//	        	 overrideFile=provider;
//	         }
//	         System.out.print(overrideFile);
	}

}
