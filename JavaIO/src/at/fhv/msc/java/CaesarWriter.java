package at.fhv.msc.java;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class CaesarWriter extends Writer {
	private Writer _writer;
	private int _shift;
	
	public CaesarWriter(Writer out, int shift) {
		_writer = out;
		_shift = shift;
	}
	
	private char encrypt(char input) {
		char output = input;

		if ((input >= 'A') && (input <= 'Z')) {
			output = (char) (((input + _shift - 'A') % 26) + 'A');
		} else if ((input >= 'a') && (input <= 'z')) {
			output = (char)(((input + _shift - 'a') % 26) + 'a');
		}
		
		return output;
	}

	@Override
	public void close() throws IOException {
		_writer.close();
	}

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		for(int i = off; i < off + len; i += 1) {
			cbuf[i] = encrypt(cbuf[i]);
		}
		
		_writer.write(cbuf, off, len);
	}

	@Override
	public void flush() throws IOException {
		_writer.flush();
	}
	
	public static void main(String[] args) {
		try (BufferedWriter out = new BufferedWriter(new CaesarWriter(new FileWriter("C:/Users/manue/eclipse-javaspace/JavaIO/src/at/fhv/msc/java/secret.txt"), 4));) {
			out.write(("test TEST TeSt").toCharArray());
			out.newLine();
			out.write(("1 23( 98247%$ $72").toCharArray());
			out.newLine();
			out.write(("AZaz A Z Aa a z").toCharArray());
			out.newLine();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
