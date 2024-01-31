package java18.notion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class EnterKey {

	public static void main(String[] args) {
		int maxGold = load();
		
		if (maxGold != 0) {
			System.out.printf("前回までの最高金額:%dG\n", maxGold);
		} else {
			System.out.println("記録がありません");
		}
		
		int gold=0;

		System.out.print("Press EnterKey!");
		while (true) {
			new java.util.Scanner(System.in).nextLine();
			int num = new java.util.Random().nextInt(10) + 1;
			if (num == 4) {
				System.out.println("地雷を踏んだので終了です。。。");
				break;
			}
			System.out.print(num * 1000 + "G発見!");
			gold += num * 1000;
			if (num == 7) {
				System.out.println("\n脱出成功!" + gold + "G獲得した!");
				
				// 最高額を更新したらセーブする
				if (maxGold < gold) {
					System.out.println("最高額を更新したのでセーブします");
					save(gold);
				}
				
				break;
			}
		}
	}
	
	public static int load() {
		String path = "enter_key.txt";
		int gold = 0;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"))) {
			gold = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			System.out.println("セーブデータがありませんでした。");
		}

		return gold;
	}
	
	public static void save(int gold) {
		String path = "enter_key.txt";
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF-8"))) {
			bw.write(String.valueOf(gold));
		} catch (IOException e) {
			// セミコロンだけで何もしないということを示す
			;
		}
	}
}
