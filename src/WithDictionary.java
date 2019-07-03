import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class WithDictionary {
	protected List<String> readDictionary() {
		String word;
		List<String> words = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("dict.txt"));
			while ((word = reader.readLine()) != null) {
				words.add(word);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Dictionary File Not Found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Invalid Input");
			e.printStackTrace();
		}
		
		return words;
	}
}
