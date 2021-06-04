package services;

public class Crypto {
 
	
	public static byte[] Encrypt(byte[] password) {
	
		byte[] enc = new byte[password.length];
		
		for (int i=0; i<password.length; i++) {
			enc[i] =(byte) ((i % 2 == 0) ? password[i] + 1  : password[i] -1); 
		}
			
		
		return enc;
	}
	
	public static byte[] Decrypt(byte[] password) {
		
		byte[] dec = new byte[password.length];
		
		for (int i=0; i<password.length; i++) {
			dec[i] =(byte) ((i % 2 == 0) ? password[i] - 1 : password[i] +1); 
		}
			
		
		return dec;
	}
	 
}
