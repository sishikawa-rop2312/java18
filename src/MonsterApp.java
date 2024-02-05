import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MonsterApp {
	public static void main(String[] args) {
		// 読み込んだデータを格納するList
		List<Monster> list = new ArrayList<Monster>();

		// data.csvから読み込む
		String path = "monster.csv";
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				// カンマで区切られた１行のデータを配列にする
				String[] datas = line.split(",");
				// 各種データを個別に取得
				String name = datas[0];
				if(!name.equals("名称")) {
					// データからインスタンス生成、Listに追加
					Monster data = new Monster(name);
					list.add(data);
				}
			}
		} catch (IOException e) {
			System.out.println("ファイル読み込みに失敗しました");
		}

		// 読み込んだデータを表示
		for (int i = 0; i < list.size(); i++) {
			Monster data = list.get(i);
			System.out.println(data.name);
		}
	}
}
