package complementos;

import javax.crypto.Mac;
import javax.crypto.SecretKey;

public class HashMAC
{

	private SecretKey key;
	private String algorithm;

	public HashMAC(SecretKey secretKey, String algoritmo)
	{
		algorithm = algoritmo;
		key = secretKey;
	}
	
	public byte [] calcular (String entrada)
	{
		try
		{
			Mac hash = Mac.getInstance(algorithm);
			hash.init(key);
			byte [] text = entrada.getBytes();
			byte [] gen = hash.doFinal(text);
			return gen;
		}
		catch (Exception e)
		{
			System.out.println("Excepción generando hash: " + e.getMessage());
			return null;
		}
	}
	
	public boolean verificar(byte [] codigo, String in)
	{
		byte [] texto = calcular(in);
		
		if (codigo.length == texto.length)
		{
			for (int i = 0; i < texto.length; i++)
			{
				if (texto[i] == codigo[i])
				{
					
				}
				else
				{
					return false;
				}
			}
			
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
}
