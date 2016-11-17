package desktop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;

import core.Hasher;

public class Main {

	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
		System.out.println("Enter Password:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String rawPass = br.readLine();
		System.out.println(Hasher.translate(Hasher.sha(rawPass)));
	}
}
