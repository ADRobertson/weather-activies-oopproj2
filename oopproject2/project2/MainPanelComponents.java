package project2;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.ImageIcon;

@SuppressWarnings("unused")
public class MainPanelComponents extends JPanel{
	public MainPanelComponents() {
		setBackground(Color.GRAY);
		setLayout(null);
		
		Predictor predict = new Predictor("./weather.numeric.txt");
		
		JList<Object> list = new JList<Object>(predict.getArrInstances());
		list.setBackground(Color.LIGHT_GRAY);
		list.setBounds(10, 64, 287, 264);
		add(list);
		
		JScrollPane scrollBar = new JScrollPane(list);
		scrollBar.setBounds(10, 28, 289, 254);
		add(scrollBar);
		
		JLabel lblNewLabel = new JLabel("Weather Instances:");
		lblNewLabel.setBounds(10, 11, 118, 14);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(10, 293, 763, 10);
		add(panel);
		
		JButton btnNewButton = new JButton("Remove Selected");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(309, 34, 139, 36);
		add(btnNewButton);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("sunny");
		rdbtnNewRadioButton.setBackground(Color.LIGHT_GRAY);
		rdbtnNewRadioButton.setBounds(10, 333, 109, 23);
		add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("overcast");
		rdbtnNewRadioButton_1.setBackground(Color.LIGHT_GRAY);
		rdbtnNewRadioButton_1.setBounds(10, 359, 109, 23);
		add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("rainy");
		rdbtnNewRadioButton_2.setBackground(Color.LIGHT_GRAY);
		rdbtnNewRadioButton_2.setBounds(10, 385, 109, 23);
		add(rdbtnNewRadioButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Outlook:");
		lblNewLabel_1.setBounds(10, 314, 60, 14);
		add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(125, 333, 3, 75);
		add(panel_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setForeground(Color.LIGHT_GRAY);
		spinner.setBackground(Color.LIGHT_GRAY);
		spinner.setBounds(138, 330, 46, 29);
		add(spinner);
		
		JLabel lblNewLabel_1_1 = new JLabel("Temp:");
		lblNewLabel_1_1.setBounds(138, 314, 86, 14);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Hum:");
		lblNewLabel_1_1_1.setBounds(138, 363, 86, 14);
		add(lblNewLabel_1_1_1);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setForeground(Color.LIGHT_GRAY);
		spinner_1.setBackground(Color.LIGHT_GRAY);
		spinner_1.setBounds(138, 382, 46, 29);
		add(spinner_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.DARK_GRAY);
		panel_1_1.setBounds(194, 333, 3, 75);
		add(panel_1_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Windy?");
		chckbxNewCheckBox.setBackground(Color.LIGHT_GRAY);
		chckbxNewCheckBox.setBounds(202, 359, 67, 23);
		add(chckbxNewCheckBox);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(Color.DARK_GRAY);
		panel_1_1_1.setBounds(276, 333, 3, 75);
		add(panel_1_1_1);
		
		JButton btnSuggestActivity = new JButton("Suggest Activity");
		btnSuggestActivity.setBackground(Color.LIGHT_GRAY);
		btnSuggestActivity.setBounds(289, 326, 139, 36);
		add(btnSuggestActivity);
		
		JButton btnAddInstance = new JButton("Add Instance");
		btnAddInstance.setBackground(Color.LIGHT_GRAY);
		btnAddInstance.setBounds(289, 378, 139, 36);
		add(btnAddInstance);
		
		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setBackground(Color.DARK_GRAY);
		panel_1_1_1_1.setBounds(289, 369, 140, 3);
		add(panel_1_1_1_1);
		
		JButton btnNewButton_1 = new JButton("Change Activity");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(309, 81, 139, 36);
		add(btnNewButton_1);
	}
}
