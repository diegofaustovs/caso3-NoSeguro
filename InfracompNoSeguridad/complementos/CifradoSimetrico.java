package complementos;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class CifradoSimetrico
{
	private SecretKey desKey;
	private static String PADDING;
	
	public CifradoSimetrico(String algortimo)
	{
		PADDING = algortimo;
	}
	
	public byte [] cifrar(String text, SecretKey desKey)
	{
		byte [] cipheredText;
		try
		{
			this.desKey = desKey;
			Cipher cipher = Cipher.getInstance(PADDING);
			byte [] clearText = text.getBytes();
			cipher.init(Cipher.ENCRYPT_MODE, desKey);
			cipheredText = cipher.doFinal(clearText);
			
//			System.out.println("->Texto cifrado: " + new String (cipheredText));
			
			return cipheredText;
		}
		catch (Exception e)
		{
			System.out.println("Excepción cifrando: " + e.getMessage());
			return null;
		}
	}
	
	public byte [] cifrarByte(byte [] cif, SecretKey desKey)
	{
		byte [] cipheredText;
		try
		{
			this.desKey = desKey;
			Cipher cipher = Cipher.getInstance(PADDING);
			cipher.init(Cipher.ENCRYPT_MODE, desKey);
			cipheredText = cipher.doFinal(cif);
			
//			System.out.println("->Texto cifrado: " + new String (cipheredText));
			
			return cipheredText;
		}
		catch (Exception e)
		{
			System.out.println("Excepción cifrando: " + e.getMessage());
			return null;
		}
	}
	
	public String descifrar(byte [] cipheredText)
	{
		try
		{
			Cipher cipher = Cipher.getInstance(PADDING);
			cipher.init(Cipher.DECRYPT_MODE, desKey);
			byte [] clearText = cipher.doFinal(cipheredText);
			String s3 = new String(clearText);
			return s3;
		}
		catch (Exception e)
		{
			System.out.println("Excepción descifrando : " + e.getMessage());
			return null;
		}
	}
}
