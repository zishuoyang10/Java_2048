package main;

import control.GameControl;
import dto.Dto;
import service.GameService;
import ui.MainFrame;
import ui.MainPanel;

public class start {


	public static void main(String[] args) {
		//����dto����
		Dto dto = new Dto();
		//����gameservice����
		GameService gameService = new GameService(dto);
		//������Ϸ������
		MainFrame mainFrame = new MainFrame();
		//������Ϸpanel
		MainPanel mainPanel = new MainPanel(dto, gameService);
		//������Ϸ����������
		GameControl gameControl = new GameControl(mainPanel, gameService);
		//���ô��ڿɼ�
		mainFrame.setVisible(true);
		//��Ӽ��̼�����
		mainFrame.addKeyListener(gameControl);
		//������Ϸ��panel
		mainFrame.setContentPane(mainPanel);
	}

}
