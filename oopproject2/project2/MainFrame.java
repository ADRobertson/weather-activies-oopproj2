package project2;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;



public class MainFrame {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (LookAndFeelInfo lafInfo :UIManager.getInstalledLookAndFeels()) {
			System.out.println(lafInfo.getClassName());
		}
		
		
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		JFrame frame = new JFrame("Activity Suggestor");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/project2/ball.png")));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		frame.setPreferredSize(new Dimension(800,500));
		
		MainPanelComponents panel = new MainPanelComponents();
		frame.getContentPane().add(panel);
		
		frame.pack();
		frame.setVisible(true);

	}

}
