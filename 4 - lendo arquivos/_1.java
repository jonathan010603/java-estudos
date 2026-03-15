import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program {
	
	public static void main(String args[]) {
		File file = new File("c:\\in.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		// Colocando o fechamento do recurso no finally
		// Isso vai fechar o recurso independente se deu certo ou não
		// O if evita uma null pointer exception
		finally {
			if(sc != null) {
				sc.close();	
			}
		}
	}
}
