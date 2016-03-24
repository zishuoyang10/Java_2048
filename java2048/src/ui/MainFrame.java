package ui;

import javax.swing.JFrame;
/**
 * main JFrame
 * @author fengche
 * */
public class MainFrame extends JFrame{

	public MainFrame(){
		this.setTitle("java-2048");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(450,530);
		this.setLocationRelativeTo(null);
	}
}
