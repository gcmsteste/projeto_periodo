package br.com.projetoperiodo.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Util {
	
	public final static String CONSTANTE_CRIPTOGRAFIA = "MD5";
	
	public static String criptografarSenha(String senha, String metodo) {
		try {
			MessageDigest message = MessageDigest.getInstance(metodo);
			message.update(senha.getBytes(), 0, senha.length());
			return message.digest().toString();
		} catch(NoSuchAlgorithmException e) {
			new RuntimeException(e);
		}
		
		return null;
	}
}
