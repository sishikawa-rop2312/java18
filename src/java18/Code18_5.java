package java18;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Code18_5 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("はじめてのGUI");
		JLabel label = new JLabel("Hellow World!");
		JButton button = new JButton("押してね");
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(label);
		frame.getContentPane().add(button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}
