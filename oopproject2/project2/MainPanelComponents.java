package project2;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.ImageIcon;
import javax.swing.Icon;

@SuppressWarnings("unused")
public class MainPanelComponents extends JPanel{
	
	private JList<Object> list;
	public MainPanelComponents() {
		setBackground(Color.GRAY);
		setLayout(null);
		
		//Creating Predictor Object
		Predictor predict = new Predictor("./weather.numeric.txt");
		
		//Getting List of Instances from Predictor object
		list = new JList<Object>(predict.getArrInstances());
		list.setBackground(Color.LIGHT_GRAY);
		list.setBounds(64, 13, 240, 252);
		add(list);
		
		//MISCELLANEOUS COMPONENTS
		//----------------------------------------------------
		JScrollPane scrollBar = new JScrollPane(list);
		scrollBar.setBounds(10, 28, 276, 254);
		add(scrollBar);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Windy?");
		chckbxNewCheckBox.setBackground(Color.LIGHT_GRAY);
		chckbxNewCheckBox.setBounds(202, 359, 67, 23);
		add(chckbxNewCheckBox);
		
		
		//SPINNERS
		//----------------------------------------------------
		JSpinner temperatureSpinner = new JSpinner();
		temperatureSpinner.setForeground(Color.LIGHT_GRAY);
		temperatureSpinner.setBackground(Color.LIGHT_GRAY);
		temperatureSpinner.setBounds(138, 330, 46, 29);
		add(temperatureSpinner);
		
		JSpinner humiditySpinner = new JSpinner();
		humiditySpinner.setForeground(Color.LIGHT_GRAY);
		humiditySpinner.setBackground(Color.LIGHT_GRAY);
		humiditySpinner.setBounds(138, 382, 46, 29);
		add(humiditySpinner);
		
		//LABELS
		//----------------------------------------------------
		JLabel instanceListLabel = new JLabel("Weather Instances:");
		instanceListLabel.setBounds(10, 11, 118, 14);
		add(instanceListLabel);
		
		JLabel outlookLabel = new JLabel("Outlook:");
		outlookLabel.setBounds(10, 314, 60, 14);
		add(outlookLabel);
		
		JLabel temperatureLabel = new JLabel("Temp:");
		temperatureLabel.setBounds(138, 314, 86, 14);
		add(temperatureLabel);
		
		JLabel humidityLabel = new JLabel("Hum:");
		humidityLabel.setBounds(138, 363, 86, 14);
		add(humidityLabel);
		
		//BUTTONS AND EVENT HANDLERS
		//----------------------------------------------------
		JButton btnSuggestActivity = new JButton("Suggest Activity");
		btnSuggestActivity.setBackground(Color.LIGHT_GRAY);
		btnSuggestActivity.setBounds(290, 326, 139, 36);
		add(btnSuggestActivity);
		
		JButton btnAddInstance = new JButton("Add Instance");
		btnAddInstance.setBackground(Color.LIGHT_GRAY);
		btnAddInstance.setBounds(289, 378, 139, 36);
		add(btnAddInstance);
		
		JButton btnNewButton_1 = new JButton("Change Activity");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(290, 81, 139, 36);
		add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Remove Selected");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(290, 34, 139, 36);
		add(btnNewButton);
		
		
		//RADIO BUTTONS FOR SELECTING OUTLOOK
		//----------------------------------------------------
		JRadioButton sunnyButton = new JRadioButton();
		sunnyButton.setBackground(Color.LIGHT_GRAY);
		sunnyButton.setBounds(10, 333, 109, 23);
		add(sunnyButton);
		
		JRadioButton overcastButton = new JRadioButton("");
		overcastButton.setBackground(Color.LIGHT_GRAY);
		overcastButton.setBounds(10, 359, 109, 23);
		add(overcastButton);
		
		JRadioButton rainyButton = new JRadioButton("");
		rainyButton.setBackground(Color.LIGHT_GRAY);
		rainyButton.setBounds(10, 385, 109, 23);
		add(rainyButton);
		
		ButtonGroup outlookButtonGroup = new ButtonGroup();
		outlookButtonGroup.add(sunnyButton);
		outlookButtonGroup.add(overcastButton);
		outlookButtonGroup.add(rainyButton);
		
		
		JLabel sunnyLabel = new JLabel(new ImageIcon(MainPanelComponents.class.getResource("/project2/sunny.png")));
		sunnyLabel.setBounds(31, 333, 88, 23);
		add(sunnyLabel);
		
		JLabel overcastLabel = new JLabel(new ImageIcon(MainPanelComponents.class.getResource("/project2/overcast.png")));
		overcastLabel.setBounds(31, 359, 88, 23);
		add(overcastLabel);
		
		JLabel rainyLabel = new JLabel(new ImageIcon(MainPanelComponents.class.getResource("/project2/rainy.png")));
		rainyLabel.setBounds(31, 385, 88, 23);
		add(rainyLabel);
		//----------------------------------------------------
		//DECORATIVE PANELS
		JPanel decorativePanel_1 = new JPanel();
		decorativePanel_1.setBackground(Color.DARK_GRAY);
		decorativePanel_1.setBounds(276, 333, 3, 75);
		add(decorativePanel_1);
		
		JPanel decorativePanel_2 = new JPanel();
		decorativePanel_2.setBackground(Color.DARK_GRAY);
		decorativePanel_2.setBounds(289, 369, 140, 3);
		add(decorativePanel_2);
		
		JPanel decorativePanel_3 = new JPanel();
		decorativePanel_3.setBackground(Color.DARK_GRAY);
		decorativePanel_3.setBounds(289, 75, 140, 3);
		add(decorativePanel_3);
		
		JPanel decorativePanel_4 = new JPanel();
		decorativePanel_4.setBackground(Color.DARK_GRAY);
		decorativePanel_4.setBounds(125, 333, 3, 75);
		add(decorativePanel_4);
		
		JPanel decorativePanel_5 = new JPanel();
		decorativePanel_5.setBackground(Color.DARK_GRAY);
		decorativePanel_5.setBounds(194, 333, 3, 75);
		add(decorativePanel_5);
		
		JPanel decorativePanel_6 = new JPanel();
		decorativePanel_6.setBackground(Color.DARK_GRAY);
		decorativePanel_6.setBounds(10, 293, 435, 10);
		add(decorativePanel_6);
		
	}
}
