import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Monster2 {
	public static void main(String[] args) {
		// データ格納のリスト、見出し用の配列用意
		List<String[]> list = new ArrayList<String[]>();
		String[] header = null;

		// ファイル読み込み
		try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("monster.csv"),"UTF-8"))){
			// 見出し取得
			String line = br.readLine();
			header = line.split(",");
			// データ取得
			while((line = br.readLine()) != null) {
				list.add(line.split(","));
			}
		}catch(Exception e) {
			;
		}
		
		// データ表示
		System.out.println(header[0]);
		for(String[] line : list) {
			String name = line[0];
			System.out.println(name);
		}
	}
}
