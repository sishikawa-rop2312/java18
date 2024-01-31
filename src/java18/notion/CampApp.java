package java18.notion;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CampApp {
	public static void main(String[] args) {
		Map<String, Integer> names = new HashMap<String, Integer>(); // 個人ごとの金額
		Map<String, Integer> items = new HashMap<String, Integer>(); // 品目ごとの金額
		
		// csvファイルから会計データを取得
		String path = "data.csv";
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				// 名前、品目、金額をそれぞれ取得
				String[] datas = line.split(",");
				String name = datas[0];
				String item = datas[1];
				int price = Integer.parseInt(datas[2]);
				// 名前が一致している場合は加算、そうじゃなければ新規追加
				if (names.containsKey(name)) {
					names.put(name, names.get(name) + price);
				} else {
					names.put(name, price);
				}
				// 品目が一致している場合は加算、そうじゃなければ新規追加
				if (items.containsKey(item)) {
					items.put(item, items.get(item) + price);
				} else {
					items.put(item, price);
				}
			}
		} catch (IOException e) {
			;
		}

		// キャンプ会計表示
		System.out.println("キャンプ会計");
		System.out.println("------------------");
		int total = 0;
		for (String key : items.keySet()) {
			System.out.printf("%s:%d\n", key, items.get(key));
			total += items.get(key);
		}
		System.out.println();

		// 個人別の会計表示
		int perPrice = total / names.size();
		System.out.printf("個人別会計(１人あたり:%d円)\n", perPrice);
		System.out.println("------------------");
		for (String key : names.keySet()) {
			int money = names.get(key) - perPrice;
			System.out.printf("%s:%s%d\n", key, money < 0 ? "-" : "+", Math.abs(money));
		}
	}
}