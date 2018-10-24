import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class LineReader implements Iterator<String> {

	private BufferedReader reader;
	private String stringBuffer;
	
	public void open(String filename) throws IOException {
		reader = new BufferedReader(new FileReader(filename));
		stringBuffer = reader.readLine();
	}
	
	public void close() throws IOException {
		reader.close();
	}
	
	@Override
	public boolean hasNext() {
		return stringBuffer != null;
	}

	@Override
	public String next() {
		String temp = stringBuffer;
		try {
			stringBuffer = reader.readLine();
		} catch (IOException e) {
			stringBuffer = null;
			e.printStackTrace();
		}
		return temp;
	}
	
	public String peek() {
		return stringBuffer;
	}
	
}
