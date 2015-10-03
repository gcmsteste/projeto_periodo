package br.com.projetoperiodo.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Util {
	
	
	
	public static String criptografarSenha(String senha, String chave, String hash) {
		String senhaCriptografada = null;
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(hash);
			messageDigest.update(senha.getBytes());
			senhaCriptografada = stringHexa(messageDigest.digest(chave.getBytes()));
		} catch (NoSuchAlgorithmException e) {
			
		}
		return senhaCriptografada;
	}
	
	private static String stringHexa(byte[] bytes) {

		StringBuffer retorno = new StringBuffer();

		for (int i = 0; i < bytes.length; i++) {
			retorno.append(Integer.toHexString((((bytes[i] >> 4) & 0xf) << 4) | (bytes[i] & 0xf)));
		}

		return retorno.toString();
	}
}
