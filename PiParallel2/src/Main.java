import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	
	public static void main(String[] args) throws IOException {
		File input = new File("C:\\Users\\robert\\eclipse-workspace\\PiParallel2\\inputs\\input1.txt");
		Scanner reader = new Scanner(input);
		FileWriter writer = new FileWriter("C:\\Users\\robert\\eclipse-workspace\\PiParallel2\\outputs\\output1.txt");
		while (reader.hasNextLine()) {
			long n = reader.nextLong();
			int runs = 10;
			double mean = 0;
			for (int run = 0; run < runs; run++) {
				double pi = 0;
				double startTime = System.currentTimeMillis();
				
				pi = IntStream.rangeClosed(0, (int) n)
						.mapToDouble(i -> Math.pow(-1, i) / (2 * i + 1))
						.parallel()
						.sum();
				
				pi = 4 * pi;
				writer.write("PI = " + pi + "\n");
				double endTime = System.currentTimeMillis();
				writer.write("Time " + (run + 1) + ": " + (endTime - startTime) / 1000 + "\n\n");
				mean += (endTime - startTime) / 1000;
			}
			writer.write("Time: " + mean / runs);
			writer.close();
		}
		reader.close();
	}
}