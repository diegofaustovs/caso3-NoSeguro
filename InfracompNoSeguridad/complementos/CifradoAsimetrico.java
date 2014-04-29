package complementos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import javax.crypto.Cipher;

public class CifradoAsimetrico
{
	private final static String ALGORITMO = "RSA";
	private KeyPair keyPair;
	
	public CifradoAsimetrico()
	{
		
	}
	
	public byte [] cifrar()
	{
		try
		{
			KeyPairGenerator generator = KeyPairGenerator.getInstance(ALGORITMO);
			generator.initialize(1024);
			keyPair = generator.generateKeyPair();
			Cipher cipher = Cipher.getInstance(ALGORITMO);
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			String pwd = stdIn.readLine();
			byte [] clearText = pwd.getBytes();
			String s1 = new String(clearText);
			System.out.println("Clave Original: " + s1);
			
			cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
			long startTime = System.nanoTime();
			byte [] cipheredText = cipher.doFinal(clearText);
			long endTime = System.nanoTime();
			System.out.println("Clave cifrada: " + new String(cipheredText));
			System.out.println("Tiempo asimétrico: " + (endTime - startTime));
			
			return cipheredText;
		}
		catch (Exception e)
		{
			System.out.println("Excepción: " + e.getMessage());
			return null;
		}
	}
	
	public void descifrar (byte [] cipheredText)
	{
		try
		{
			Cipher cipher = Cipher.getInstance(ALGORITMO);
			cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
			byte [] clearText = cipher.doFinal(cipheredText);
			String s3 = new String (clearText);
			System.out.println("Clave Original: " + s3);
		}
		catch (Exception e)
		{
			System.out.println("Excepción: " + e.getMessage());
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		CifradoAsimetrico cif = new CifradoAsimetrico();
		byte  [] c = cif.cifrar();
		cif.descifrar(c);
		

	}

}
