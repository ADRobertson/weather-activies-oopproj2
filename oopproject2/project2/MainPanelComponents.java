package project2;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;

import java.awt.Component;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("unused")
public class MainPanelComponents extends JPanel{
	BufferedImage image = null;
	ImageIcon imagetest = null;
	private JList<Object> list;
	private Predictor predict;
	private JFrame parentFrame;
	public Object[] refreshList(Predictor predict) {
		return predict.getArrInstances();
	}
	public MainPanelComponents() {
		setLayout(null);
		imagetest = new ImageIcon(MainPanelComponents.class.getResource("/project2/ui.jpg"));
		parentFrame = (JFrame)SwingUtilities.getWindowAncestor(this);

		//Creating Predictor Object
		predict = new Predictor("./weather.numeric.txt");

		//Getting List of Instances from Predictor object
		list = new JList<Object>(refreshList(predict));
		list.setBackground(Color.LIGHT_GRAY);
		list.setBounds(64, 13, 240, 252);
		add(list);

		//MISCELLANEOUS COMPONENTS
		//----------------------------------------------------
		JScrollPane scrollBar = new JScrollPane(list);
		scrollBar.setBounds(10, 28, 276, 254);
		add(scrollBar);

		JCheckBox windyCheckBox = new JCheckBox("Windy?");
		windyCheckBox.setForeground(Color.LIGHT_GRAY);
		windyCheckBox.setBackground(Color.LIGHT_GRAY);
		windyCheckBox.setBounds(202, 359, 67, 23);
		add(windyCheckBox);


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
		instanceListLabel.setForeground(Color.LIGHT_GRAY);
		instanceListLabel.setBounds(10, 11, 118, 14);
		add(instanceListLabel);

		JLabel outlookLabel = new JLabel("Outlook:");
		outlookLabel.setForeground(Color.LIGHT_GRAY);
		outlookLabel.setBounds(10, 314, 60, 14);
		add(outlookLabel);

		JLabel temperatureLabel = new JLabel("Temp:");
		temperatureLabel.setForeground(Color.LIGHT_GRAY);
		temperatureLabel.setBounds(138, 314, 86, 14);
		add(temperatureLabel);

		JLabel humidityLabel = new JLabel("Hum:");
		humidityLabel.setForeground(Color.LIGHT_GRAY);
		humidityLabel.setBounds(138, 363, 86, 14);
		add(humidityLabel);

		JLabel lblNewLabel = new JLabel("<html>Select an Instance from the list on the left, use the above buttons to manipulate the selected value. Otherwise, use the bottom buttons to get an activity suggestion or to add a new instance to the list! </html>");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(296, 128, 139, 139);
		add(lblNewLabel);



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
		


		//BUTTONS AND EVENT HANDLERS
		//----------------------------------------------------
		JButton btnSuggestActivity = new JButton("Suggest Activity");
		btnSuggestActivity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//implementing default values in case things aren't selected in the input menus
				int temperature = 50;
				int humidity = 50;
				String windy = "FALSE";
				String activity = "sleep";
				String outlook = "sunny";

				//GETTING VALUE FROM RADIO BUTTONS
				//---------------------------------
				if (sunnyButton.isSelected()) {
					outlook = "sunny";
				}
				else if (overcastButton.isSelected()) {
					outlook = "overcast";
				}
				else if (rainyButton.isSelected()) {
					outlook = "rainy";
				}

				//GETTING SPINNER VALUES
				//---------------------------------
				temperature = (int)temperatureSpinner.getValue();
				humidity = (int)humiditySpinner.getValue();

				//GETTING WINDY VALUE
				//---------------------------------
				if (windyCheckBox.isSelected()) {
					windy = "TRUE";
				}
				Instance suggestorInstance = new Instance(outlook, temperature, humidity, windy);
				String activityToDo = predict.using(suggestorInstance);
				suggestorInstance.setActivity(activityToDo);
				//System.out.println(activityToDo);

				JDialog suggestionDialog = new JDialog(parentFrame, "Activity Suggestion");

				suggestionDialog.getContentPane().setLayout(null);
				JLabel suggestionLabel = new JLabel("<html>Given Today's weather: " + suggestorInstance +"</html>");

				JButton addInstanceButton = new JButton("Add As Instance");
				addInstanceButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//updates the instance in predict
						predict.updating(suggestorInstance);
						//refreshes the data in the JList object
						list.setListData(refreshList(predict));
						//closes the activityDialog window
						suggestionDialog.dispose();
					}
				});
				suggestionLabel.setBounds(30,10, 200,100);
				addInstanceButton.setBackground(Color.LIGHT_GRAY);
				addInstanceButton.setBounds(10, 100, 180, 25);

				suggestionDialog.setSize(220,200);
				suggestionDialog.getContentPane().add(suggestionLabel);
				suggestionDialog.getContentPane().add(addInstanceButton);
				suggestionDialog.setLocationRelativeTo(btnSuggestActivity);
				suggestionDialog.setModal(true);
				suggestionDialog.setVisible(true);
			}
		});
		btnSuggestActivity.setBackground(Color.LIGHT_GRAY);
		btnSuggestActivity.setBounds(290, 326, 139, 36);
		add(btnSuggestActivity);

		JButton addInstanceButton = new JButton("Add Instance");
		addInstanceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//implementing default values in case things aren't selected in the input menus
				int temperature = 50;
				int humidity = 50;
				String windy = "FALSE";
				String activity = "sleep";
				String outlook = "sunny";

				//GETTING VALUE FROM RADIO BUTTONS
				//---------------------------------
				if (sunnyButton.isSelected()) {
					outlook = "sunny";
				}
				else if (overcastButton.isSelected()) {
					outlook = "overcast";
				}
				else if (rainyButton.isSelected()) {
					outlook = "rainy";
				}

				//GETTING SPINNER VALUES
				//---------------------------------
				temperature = (int)temperatureSpinner.getValue();
				humidity = (int)humiditySpinner.getValue();

				//GETTING WINDY VALUE
				//---------------------------------
				if (windyCheckBox.isSelected()) {
					windy = "TRUE";
				}
				JDialog activityDialog = new JDialog(parentFrame,"Select Activity") {
					public void paintComponents(Graphics g) {
						super.paintComponents(g);
						g.drawImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("project2/dialogUI.jpg")), 0, 0, null);
				}	
				};

				//JLabel label = new JLabel("TESTINGTESTING");
				//activityDialog.add(label);
				String[] activities = predict.getActivities();



				JLabel activityDialogLabel = new JLabel("<html>Select an activity! (OR Enter a new activity!)</html>");
				activityDialogLabel.setBounds(10,5,150,100);

				JComboBox<String> activityComboBox = new JComboBox<String>();
				activityComboBox.setSize(new Dimension(100,50));
				activityDialog.setBackground(Color.DARK_GRAY);
				activityDialog.getContentPane().setLayout(null);
				activityDialog.setSize(200,250);

				for (String activityList : activities) {
					activityComboBox.addItem(activityList);
				}
				activityComboBox.setBounds(10,85,150,25);

				activityComboBox.setBackground(Color.LIGHT_GRAY);


				JTextField activityTextField = new JTextField();
				activityTextField.setBounds(10, 110, 150, 25);

				Instance newInstance = new Instance(outlook, temperature, humidity, windy);

				JButton dialogAddInstanceButton = new JButton("Add As Instance");
				addInstanceButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//updates the instance in predict
						predict.updating(newInstance);
						//refreshes the data in the JList object
						list.setListData(refreshList(predict));
						//closes the activityDialog window
						activityDialog.dispose();
					}
				});

				dialogAddInstanceButton.setBounds(10,140,150,25);
				dialogAddInstanceButton.setBackground(Color.LIGHT_GRAY);

				activityDialog.getContentPane().add(activityDialogLabel);
				activityDialog.getContentPane().add(activityComboBox);
				//activityDialog.getContentPane().add(decorativeActivityPanel);
				activityDialog.getContentPane().add(activityTextField);
				activityDialog.getContentPane().add(dialogAddInstanceButton);
				activityDialog.setLocationRelativeTo(addInstanceButton);
				activityDialog.setModal(true);
				activityDialog.setVisible(true);

			}
		});
		addInstanceButton.setBackground(Color.LIGHT_GRAY);
		addInstanceButton.setBounds(289, 378, 139, 36);
		add(addInstanceButton);

		JButton changeActivityButton = new JButton("Change Activity");
		changeActivityButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!list.isSelectionEmpty()) {
					//gets selected object
					Object object = list.getSelectedValue();
					//converts selected object to instance
					Instance instanceToUpdate = (Instance)object;
					//calls updating and passes selected object
					JDialog activityDialog = new JDialog(parentFrame,"Select Activity");

					//JLabel label = new JLabel("TESTINGTESTING");
					//activityDialog.add(label);
					String[] activities = predict.getActivities();



					JLabel activityDialogLabel = new JLabel("<html>Select an activity! (OR Enter a new activity!)</html>");
					activityDialogLabel.setBounds(10,5,150,100);

					JComboBox<String> activityComboBox = new JComboBox<String>();
					activityComboBox.setSize(new Dimension(100,50));
					activityDialog.setBackground(Color.DARK_GRAY);
					activityDialog.getContentPane().setLayout(null);
					activityDialog.setSize(200,250);

					for (String activity : activities) {
						activityComboBox.addItem(activity);
					}
					activityComboBox.setBounds(10,85,150,25);

					activityComboBox.setBackground(Color.LIGHT_GRAY);


					JTextField activityTextField = new JTextField();
					activityTextField.setBounds(10, 110, 150, 25);

					JPanel decorativeActivityPanel = new JPanel();
					decorativeActivityPanel.setBackground(Color.DARK_GRAY);
					decorativeActivityPanel.setBounds(10, 135, 100, 3);



					JButton updateInstanceButton = new JButton("Update Instance");
					updateInstanceButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String activityToUpdate = null;

							//if there is input in the text field, update activity with that value
							if (activityTextField.getText().equals("")) {
								activityToUpdate = (String)activityComboBox.getSelectedItem();
							}
							else {
								//else use the combobox selection
								activityToUpdate = activityTextField.getText();
							}

							//changes activity on instance selected from Jlist
							instanceToUpdate.setActivity(activityToUpdate);
							//updates the instance in predict
							predict.updating(instanceToUpdate);
							//refreshes the data in the JList object
							list.setListData(refreshList(predict));
							//closes the activityDialog window
							activityDialog.dispose();
						}
					});
					updateInstanceButton.setBounds(10,140,150,25);
					updateInstanceButton.setBackground(Color.LIGHT_GRAY);

					activityDialog.getContentPane().add(activityDialogLabel);
					activityDialog.getContentPane().add(activityComboBox);
					//activityDialog.getContentPane().add(decorativeActivityPanel);
					activityDialog.getContentPane().add(activityTextField);
					activityDialog.getContentPane().add(updateInstanceButton);
					activityDialog.setLocationRelativeTo(changeActivityButton);
					activityDialog.setModal(true);
					activityDialog.setVisible(true);
				}
				else {
					//JOptionPane.showMessageDialog(parentFrame, "Please Select an Instance from the list before trying to change an activity!");
					JOptionPane pane = new JOptionPane("<HTML>Select an Instance from the list before trying to change activity!</html>");
					JDialog d = pane.createDialog((JFrame)null, "*ERROR*");
					d.setLocationRelativeTo(changeActivityButton);
					d.setVisible(true);
				}


			}
		});
		changeActivityButton.setBackground(Color.LIGHT_GRAY);
		changeActivityButton.setBounds(290, 81, 139, 36);
		add(changeActivityButton);

		JButton removeButton = new JButton("Remove Selected");
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!list.isSelectionEmpty()) {
				//gets selected object
				Object instanceToRemove = list.getSelectedValue();
				// removes selected object
				predict.remove((Instance)instanceToRemove);
				// refreshes JList with new array of instances (with selected element removed)
				list.setListData(refreshList(predict));
				}
				else {
					JOptionPane pane = new JOptionPane("<HTML>Select an Instance from the list before trying to remove!</html>");
					JDialog d = pane.createDialog((JFrame)null, "*ERROR*");
					d.setLocationRelativeTo(changeActivityButton);
					d.setVisible(true);
				}
			}
		});
		removeButton.setBackground(Color.LIGHT_GRAY);
		removeButton.setBounds(290, 34, 139, 36);
		add(removeButton);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(imagetest.getImage(), 0, 0, this);
	}

	public void doClose() {
		predict.saveFile();
	}
}

