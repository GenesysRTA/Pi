import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InterruptedException, IOException {
		File input = new File("C:\\Users\\robert\\eclipse-workspace\\PiParallel\\inputs\\input9.txt");
		Scanner reader = new Scanner(input);
		FileWriter writer = new FileWriter("C:\\Users\\robert\\eclipse-workspace\\PiParallel\\outputs\\output9.txt");
		int noOfThreads = 2;
		while (reader.hasNextLine()) {
			long n = reader.nextLong();
			int runs = 10;
			double mean = 0;
			for (int run = 0; run < runs; run++) {
				double pi = 0;
				double startTime = System.currentTimeMillis();
				JavaThread[] threads = new JavaThread[noOfThreads];
			
				for (int i = 0; i < noOfThreads; i++) {
					threads[i] = new JavaThread(noOfThreads, i, n);
					threads[i].start();
				}	
				for (int i = 0; i < noOfThreads; i++) {
					threads[i].join();
				}		
				for (int i = 0; i < noOfThreads; i++) {
					pi += threads[i].getSum();
				}
		
				pi = 4 * pi;
				writer.write("PI = " + pi);
				double endTime = System.currentTimeMillis();
				writer.write("Time " + run + ": " + (endTime - startTime) / 1000);
				mean += (endTime - startTime) / 1000;
				Thread.sleep(5000);
			}
			writer.write("Time: " + mean / runs);
			writer.close();
		}
		reader.close();
	}
}