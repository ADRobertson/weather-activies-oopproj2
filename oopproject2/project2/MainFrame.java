//Aidan Robertson
//OOP Project 1
package project2;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;



public class MainFrame {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* THIS WAS TO CHECK OUT WHAT LOOK AND FEELS WERE INSTALLED, DEBUG
		for (LookAndFeelInfo lafInfo :UIManager.getInstalledLookAndFeels()) {
			System.out.println(lafInfo.getClassName());
		}
		*/
		
		
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
		
		
		
		frame.setPreferredSize(new Dimension(465,470));
		
		MainPanelComponents panel = new MainPanelComponents();
		frame.getContentPane().add(panel);
		
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
		
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				panel.doClose();
			}
		});

	}

}
