package java18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class FilePracticeMain {
	public static void main(String[] args) throws IOException {
		String path = "test.txt";
		
		FileInputStream fis = new FileInputStream(path);
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		// 1行ずつ取得（3回実行しているので、1～3行が出力される → 実行するたびに読み込む行が遷移する）
		// 教科書のFileReader()だと1文字ずつ読み込むので、処理が遅いため非推奨
//		System.out.println(br.readLine());
//		System.out.println(br.readLine());
//		System.out.println(br.readLine());
		
		// 全行読み込み
		List<Integer> list = new ArrayList<Integer>();
		String line = null;
		while ((line = br.readLine()) != null) {
			int num = Integer.parseInt(line);
			list.add(num);
		}
		// 全行読み込んだのでクローズする
		br.close();
		
		System.out.println("==================");
		
		for (int s : list) {
			System.out.println(s);
		}
 	}

	public static void save() throws IOException {
		// ファイルの場所
		String path = "data.txt";

		// ファイルにデータを書き込むためのFileOutputStreamを作成します
		// trueで追記モード、falseで上書きモード
		FileOutputStream fos = new FileOutputStream(path, true);

		// ファイルにUTF-8で文字を書き込むためのOutputStreamWriterを作成します
		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");

		// ファイルにバッファリングして書き込むためのBufferedWriterを作成します
		BufferedWriter bw = new BufferedWriter(osw);
		
		bw.write("Hello World");
		bw.newLine(); // 改行
		bw.write("今日は良い天気\n");
		bw.write("書き込みはここで終了");
		bw.newLine();

		bw.close();
	}
}
