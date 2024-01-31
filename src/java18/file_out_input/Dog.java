package java18.file_out_input;

public class Dog {
	private String name;
	private int hp;

	public Dog(String name, int hp) {
		this.name = name;
		this.hp = hp;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return this.hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void run() {
		setHp(getHp() - 10);
	}

	public void sleep() {
		setHp(getHp() + 10);
	}
}
