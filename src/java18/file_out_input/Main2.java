package java18.file_out_input;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
	public static void main(String[] args) {
		load();
	}
	
	
	public static void load() {
		String path = "classmate2.csv";
//		String path = "save.txt";
		String[] names = null;
		
		Dog dog = null;
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"))) {
			String line = br.readLine();
//			names = line.split(",");
			String[] param = line.split(",");
			dog = new Dog(param[0], Integer.parseInt(param[1]));
			
		} catch (IOException e) {
			;
		}

//		for (String name : names) {
//			System.out.println(name);
//		}
		
		System.out.println("犬の名前:" + dog.getName());
		System.out.println("犬のHP:" + dog.getHp());
		
	}
}
