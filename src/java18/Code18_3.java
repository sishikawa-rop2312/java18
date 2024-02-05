package java18;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Code18_3 {
	public static void main(String[] args) throws IOException {
		URL u = new URL("https://book.impress.co.jp");
		InputStream is = u.openStream();
		int i = is.read();
		while (i != -1) {
			char c = (char) i;
			System.out.print(c);
			i = is.read();
		}
	}
}
