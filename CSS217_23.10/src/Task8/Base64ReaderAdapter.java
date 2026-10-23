package Task8;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Base64;

public class Base64ReaderAdapter extends Reader {
    private String decodedString;
    private int pos = 0;

    public Base64ReaderAdapter(InputStream inputStream) throws IOException {
        byte[] encodedBytes = inputStream.readAllBytes();
        byte[] decodedBytes = Base64.getDecoder().decode(encodedBytes);
        this.decodedString = new String(decodedBytes);
    }

    public int read(char[] cbuf, int off, int len) throws IOException {
        if (pos >= decodedString.length()) {
            return -1;
        }

        int count = 0;
        while (count < len && pos < decodedString.length()) {
            cbuf[off + count] = decodedString.charAt(pos);
            count++;
            pos++;
        }
        return count;
    }


    public void close() throws IOException {
        decodedString = null;
    }
}