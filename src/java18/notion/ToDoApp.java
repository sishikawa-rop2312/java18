package java18.notion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoApp {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		File file = new File("todo.csv");
		List<ToDo> list;
		if (file.exists()) {
			list = load(file);
		} else {
			list = new ArrayList<>();
		}
		if (list.size() == 0) {
			System.out.println("ToDoは1件もありません");
		} else {
			displayList(list);
		}
		while (true) {
			System.out.println("——操作を入力してください。——");
			System.out.print("1/登録 2/重要度変更 3/削除 4/終了>");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				addItem(list, sc);
				break;
			case 2:
				updateItem(list, sc);
				break;
			case 3:
				deleteItem(list, sc);
				break;
			default:
				System.out.println("アプリケーションを終了します。");
				save(file, list);
				return;
			}
			displayList(list);
		}
	}

	// 重要度順に並び替え
	static void sortList(List<ToDo> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).importance < list.get(j).importance) {
					ToDo temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}
	}

	// 一覧表示
	static void displayList(List<ToDo> list) {
		sortList(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("%d・・・%s%n", i, list.get(i).showStatus());
		}

	}

	// ToDo追加
	static void addItem(List<ToDo> list, Scanner sc) {
		System.out.println("新規ToDoを作成します。");
		System.out.print("Todo内容を入力してください>>");
		String title = sc.next();
		System.out.print("重要度を1~10(最大)で入力してください>>");
		int importance = sc.nextInt();
		ToDo t = new ToDo(title, importance);
		list.add(t);
	}

	// ToDo更新
	static void updateItem(List<ToDo> list, Scanner sc) {
		if (list.size() == 0) {
			System.out.println("まだToDoがありません");
			return;
		}
		System.out.printf("重要度を変更します。番号を入力してください。0~%d>>", list.size() - 1);
		int no = sc.nextInt();
		ToDo t = list.get(no);
		System.out.print("重要度を再設定してください>>");
		int importance = sc.nextInt();
		t.changeImportance(importance);
	}

	// ToDo削除
	static void deleteItem(List<ToDo> list, Scanner sc) {
		System.out.printf("Todoを削除します。番号を入力してください。0~%d>", list.size() - 1);
		int no = sc.nextInt();
		list.remove(no);
		System.out.println("1件削除しました。");
	}

	// ファイルからToDo一覧を読み込み
	static List<ToDo> load(File file) {
		List<ToDo> list = new ArrayList<ToDo>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				// csvファイルからタイトルと重要度を取得
				String[] param = line.split(",");
				String title = param[0];
				int important = Integer.parseInt(param[1]);
				// ToDoインスタンスを生成し、Listに追加
				ToDo todo = new ToDo(title, important);
				list.add(todo);
			}
		} catch (IOException e) {
			;
		}
		return list;
	}

	// ToDoのデータをファイルに保存
	static void save(File file, List<ToDo> list) {
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"))) {
			for (ToDo todo : list) {
				bw.write(todo.toCSV());
				bw.newLine();
			}
		} catch (IOException e) {
			;
		}
	}
}
