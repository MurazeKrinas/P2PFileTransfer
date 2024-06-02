package networkprogramming.p2pfiletransfer.Utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.apache.commons.io.output.ByteArrayOutputStream;

public class GZipHelper {
    public static byte[] compress(final byte[] bytes) throws IOException {
		if (bytes == null || bytes.length == 0) {
			return new byte[0];
		}
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
		try (final OutputStream gzip = new GZIPOutputStream(out)) {
			gzip.write(bytes);
		}
		return out.toByteArray();
	}

	public static byte[] decompress(final byte[] bytes) throws IOException {
		if (bytes == null || bytes.length == 0) {
			return new byte[0];
		}
		try (final GZIPInputStream ungzip = new GZIPInputStream(new ByteArrayInputStream(bytes))) {
			final ByteArrayOutputStream out = new ByteArrayOutputStream();
			final byte[] data = new byte[8192];
			int nRead;
			while ((nRead = ungzip.read(data)) != -1) {
				out.write(data, 0, nRead);
			}
			return out.toByteArray();
		}
	}
}
