import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LineWriter {

	private PrintWriter writer;
	
	public void open(String filename) throws IOException {
		writer = new PrintWriter(new FileWriter(filename));
	}
	
	public void println(String line) {
		writer.println(line);
	}
	
	public void close() {
		writer.close();
	}
	
}
