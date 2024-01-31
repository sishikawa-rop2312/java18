package java18.file_out_input;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	// ルートディレクトリ（プロジェクトの直下）からの「相対パス」を設定
	static String path = "save/save.txt";
	
	public static void main(String[] args) {
		Dog dog = load();
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println(dog.getName() + "のHP：" + dog.getHp());
			System.out.print("どれにする? 1:走る 2:寝る 3:セーブ 4:終了 >");
			int select = scan.nextInt();
			switch (select) {
			case 1:
				System.out.println(dog.getName() + "が走った");
				dog.run();
				break;
			case 2:
				System.out.println(dog.getName() + "は眠った");
				dog.sleep();
				break;
			case 3:
				save(dog);
				System.out.println("セーブしました");
				break;
			case 4:
				System.out.println("アプリを終了します。");
				scan.close();
				return;
			default:
				System.out.println("選択肢に無い番号です。");
			}
		}
	}

	public static void save(Dog dog) {
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF-8"))) {
			bw.write(String.valueOf(dog.getHp()));
		} catch (IOException e) {
			// セミコロンだけで何もしないということを示す
			;
		}
	}

	public static Dog load() {
		Dog dog = null;

		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"))) {
			int hp = Integer.parseInt(br.readLine());
			dog = new Dog("ポチ", hp);
		} catch (IOException e) {
			System.out.println("セーブデータがありませんでした。");
		}

		return dog;
	}
}
