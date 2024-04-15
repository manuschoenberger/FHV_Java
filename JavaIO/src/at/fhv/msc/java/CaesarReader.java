package at.fhv.msc.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class CaesarReader extends Reader {
	private Reader _reader;
	private int _shift;
	
	public CaesarReader(Reader in, int shift) {
		_reader = in;
		_shift = shift;
	}
	
	private char decrypt(char input) {
		char output = input;
		
		if ((input >= 'A') && (input <= 'Z')) {
			output = (char)(((input - _shift - 'A' + 26) % 26) + 'A');
		} else if ((input >= 'a') && (input <= 'z')) {
			output = (char)(((input - _shift - 'a' + 26) % 26) + 'a');
		}
		
		return output;
	}
	
	@Override
	public void close() throws IOException {
		_reader.close();
	}

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		int count = _reader.read(cbuf, off, len);
		
		
		for (int i = off; i < off + len; i += 1) {
			cbuf[i] = decrypt(cbuf[i]);
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		try (BufferedReader in = new BufferedReader(new CaesarReader(new FileReader("C:/Users/manue/eclipse-javaspace/JavaIO/src/at/fhv/msc/java/secret.txt"), 4));) {
			int c = 0;
			while ((c = in.read()) != -1) {
				System.out.print((char) c);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
