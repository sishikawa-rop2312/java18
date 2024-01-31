package java18.notion;

public class ToDo {
	String title;
	int importance;

	// コンストラクタ
	ToDo(String title, int importance) {
		this.title = title;
		this.importance = importance;
	}

	// ステータス表示
	String showStatus() {
		return String.format("%s/重要度:%d", this.title, this.importance);
	}

	// 重要度変更
	void changeImportance(int importance) {
		this.importance = importance;
		System.out.println("重要度を変更しました。");
	}

	// データをcsv形式の文字列に変換
	String toCSV() {
		return String.format("%s,%d", this.title, this.importance);
	}
}