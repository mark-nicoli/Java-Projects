package cs211Lab;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
public class sha256 
{
	 static String sha256(String input) throws NoSuchAlgorithmException 
	 {
		 byte[] in = hexStringToByteArray(input);
		 MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
		 byte[] result = mDigest.digest(in);
		 StringBuffer sb = new StringBuffer();
		 for (int i = 0; i < result.length; i++) 
		 {
			 sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
		 }
		 return sb.toString();
	 }

	 public static byte[] hexStringToByteArray(String s) 
	 {
		 int len = s.length();
		 byte[] data = new byte[len / 2];
		 for (int i = 0; i < len; i += 2) 
		 {
			 data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)+ Character.digit(s.charAt(i+1), 16));
	     }
		 return data;
	 }
	 
	public static String ecdsa()
	{
			Random rand = new Random();
			String hex = "";
			for(int i = 0;i<64;i++)
			{
				int value = rand.nextInt();
				hex = hex+Integer.toHexString(value).toUpperCase();
			}
			
			String string80 = "80"+hex;
			return string80;
	}
	
	static String base58(BigInteger n)
	{
		String alphabet = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz";
		String result = "";
		while(n.compareTo(new BigInteger("58"))>0)
		{
			BigInteger mod = n.mod(new BigInteger("58"));
			result = alphabet.charAt(mod.intValue())+result;
			n = n.divide(new BigInteger("58"));
		}
		if(n.compareTo(new BigInteger("0"))>0)
		{
			result = alphabet.charAt(n.intValue())+result;
		}
		return result;
	}
	 
	public static void main(String[] args) throws NoSuchAlgorithmException 
	{
		String string80 = ecdsa();
		String hash = sha256(string80);
		String doublehash = sha256(hash);
		//System.out.println(doublehash);
		String x = doublehash.substring(0,8);
		String a = doublehash+x;
		//System.out.println(a);
		BigInteger n = new BigInteger(a,16);
		System.out.println(base58(n));
	}
	
}
