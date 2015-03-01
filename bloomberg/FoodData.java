import java.util.ArrayList;
import javax.net.ssl.HttpsURLConnection;

/**
 * Class to access prices and usage amounts of certain ingredients.
 */

public abstract class FoodData
{
	public static void main(String[] args)
	{
		// HttpsUrlConnection con = (HttpsUrlConnection) new Url("https://http-api.openbloomberg.com/request?ns=blp&service=refdata&type=HistoricalDataRequest").openConnection();
		// con.setRequestMethod("POST");
		// con.getOutputStream().write("{\"securities\":[\"3AGSREG Index\"],\"fields\":[\"PX_LAST\"],\"startDate\":\"20150101\",\"endDate\":\"20150105\",\"periodicitySelection\":\"DAILY\"}".getBytes("UTF-8"));
		// InputStream in = con.getInputStream();
		// int c;
		// while((c=in.read()) != -1)
		// {
		// 	System.out.print((char) c);
		// }
	}
}