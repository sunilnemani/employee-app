/*
*
*N Sunil 
*
*/

package com.sunil.employee.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SecureFpDataImpl
{
	
	private static final byte[] S_KEY = {105, 110, 116, 101, 103, 114, 97, 77, 105, 99, 114, 111, 33, 64, 35, 36, 105, 110, 116, 101, 103, 114, 97, 77, 105, 99, 114, 111, 33, 64, 35, 36};
	private static final String SCHEME = "AES/ECB/PKCS5Padding";
	// private static final String SCHEME = "AES/ECB/NoPadding";
	private SecretKey secretKey = null;

	private static final Logger log = LoggerFactory.getLogger(SecureFpDataImpl.class);
	public SecureFpDataImpl()
	{
		log.info("KEY_DATA.getBytes()  " + S_KEY.length);
		this.secretKey = new SecretKeySpec(S_KEY, "BC");
		log.info("secretKey  : "+this.secretKey.toString());
	}
	
	public byte[] doEncryt(byte[] input)
	{
		byte[] ciphered = null;
		try
		{
			Cipher enCipher = Cipher.getInstance(SCHEME);
			enCipher.init(Cipher.ENCRYPT_MODE, this.secretKey);
			ciphered = enCipher.doFinal(input);
		}
		catch (Exception ex)
		{
			throw new RuntimeException("Error while encrypting data", ex);
		}
		return ciphered;
	}
	
	public byte[] doDecrypt(byte[] input)
	{
		byte[] ciphered = null;
		try
		{
			Cipher deCipher = Cipher.getInstance(SCHEME);
			deCipher.init(Cipher.DECRYPT_MODE, this.secretKey);
			ciphered = deCipher.doFinal(input);
		}
		catch (Exception ex)
		{
			throw new RuntimeException( "Error while decrypting data", ex);
		}
		return ciphered;
	}
}
