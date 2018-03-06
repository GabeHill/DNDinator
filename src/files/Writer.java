package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import encryptor.AES;

public class Writer {

	public static Object read(String path, String key, Class<?> className) throws IOException {
		byte[] in;
		try {
			in = Files.readAllBytes(Paths.get(path + ".json"));
		} catch (IOException e) {
			throw new IOException("Check your filepath and try again.");
		}
		String f = new String(in);
		f = AES.decrypt(f, key);
		Object o = GSONifier.unGSONify(f, className);
		return o;
	}

	public static void write(Object o, String path, String key) throws IOException {
		String out = GSONifier.GSONify(o);
		out = AES.encrypt(out, key);

		try {
			Files.write(Paths.get(path + ".json"), out.getBytes(), StandardOpenOption.CREATE);
		} catch (IOException e) {
			throw new IOException("Check your filepath and try again.");
		}
	}
}
