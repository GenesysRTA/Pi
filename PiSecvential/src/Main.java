import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		File input = new File("C:\\Users\\robert\\eclipse-workspace\\PiSerial\\inputs\\input9.txt");
		Scanner reader = new Scanner(input);
		FileWriter writer = new FileWriter("C:\\Users\\robert\\eclipse-workspace\\PiSerial\\outputs\\output9.txt");
		while (reader.hasNextLine()) {
			long n = reader.nextLong();
			int runs = 10;
			double mean = 0;
			double startTime = 0;
			double endTime = 0;
			for (int run = 0; run < runs; run++) {
				double pi = 0;
				startTime = System.currentTimeMillis();
				
				for (int i = 0; i <= n; i ++) {
		            pi += Math.pow(-1, i) / (2 * i + 1);
		        }
				
				pi = 4 * pi;
				writer.write("PI = " + pi + "\n");
				System.out.println("PI = " + pi);
				endTime = System.currentTimeMillis();
				writer.write("Time " + (run + 1) + ": " + (endTime - startTime) / 1000 + "\n\n");
				System.out.println("Time " + run + ": " + (endTime - startTime) / 1000);
				mean += (endTime - startTime) / 1000;
			}
			writer.write("Time: " + mean / runs);
			System.out.println("Time: " + mean / runs);
			writer.close();
		}
		reader.close();
	}
}