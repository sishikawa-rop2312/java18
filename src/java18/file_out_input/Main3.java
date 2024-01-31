package java18.file_out_input;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main3 {
	public static void main(String[] args) {
		List<Dog> dogs = load();
		

		for (int i = 0; i < dogs.size(); i++) {
			System.out.println((i + 1) + "匹目");
			Dog dog = dogs.get(i);
			System.out.println("犬の名前:" + dog.getName());
			System.out.println("犬のHP:" + dog.getHp());
		}
		
		dogs.get(0).setName("ポチUpdate");
		dogs.get(1).setName("わんわんUpdate");
		dogs.get(2).setName("けるべろすUpdate");
		
		save(dogs);
	}
	
	public static void save(List<Dog> dogs) {
		String path = "classmate2.csv";
		
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF-8"))) {
			for (Dog dog : dogs) {
				String line = String.format("%s,%d\n", dog.getName(), dog.getHp());
				bw.write(line);
			}
		} catch (IOException e) {
			// セミコロンだけで何もしないということを示す
			;
		}
	}

	public static List<Dog> load() {
		String path = "classmate2.csv";
		List<Dog> list = new ArrayList<Dog>();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] param = line.split(",");
				Dog dog = new Dog(param[0], Integer.parseInt(param[1]));
				list.add(dog);
			}
		} catch (IOException e) {
			;
		}

		return list;
	}
}
