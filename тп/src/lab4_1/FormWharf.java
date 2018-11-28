package lab3;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.lang.Object; 
import java.util.Random;



public class FormWharf {

	private JFrame frame;
	private JPanel panel;
	private JList listBoxLevels;
   	private DefaultListModel model;
	
	
	private JTextField maskedTextBox1;
   	MultiLevelWharf wharf;
	private int countLevel = 5;
    	private PanelShip pictureBoxTakeShip;
    	private PanelWharf panelWharf;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormWharf window = new FormWharf();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormWharf() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 938, 503);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		panelWharf= new PanelWharf();
		panelWharf.setBounds(10, 11, 768, 432);
		frame.getContentPane().add(panelWharf);
		
		wharf = panelWharf.getWharf();
		
		JPanel pictureBoxWharf = new JPanel();
		pictureBoxWharf.setBounds(0, 0, 778, 466);
		frame.getContentPane().add(pictureBoxWharf);
		
		JButton buttonSetSimpleShip = new JButton("Припарковать корабль");
		buttonSetSimpleShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Color mainColor = JColorChooser.showDialog(null, "Choose a color", Color.GRAY);
				SimpleShip ship = new SimpleShip(100, 1000, mainColor);
				int place = wharf.getWharf(listBoxLevels.getSelectedIndex()).Plus(ship);
				panelWharf.repaint();
			}
		});
		buttonSetSimpleShip.setBounds(790, 13, 118, 78);
		frame.getContentPane().add(buttonSetSimpleShip);
		
		JButton buttonSetShip = new JButton("Припарковать корабль-контейнеровоз");
		buttonSetShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color mainColor = JColorChooser.showDialog(null, "Choose a color", Color.GRAY);
				Color dopColor = JColorChooser.showDialog(null, "Choose a color", Color.GRAY);
				Ship ship = new Ship(100, 1000, mainColor, dopColor);
               			int place = wharf.getWharf(listBoxLevels.getSelectedIndex()).Plus(ship);					
				panelWharf.repaint();
			}
		});
		buttonSetShip.setBounds(790, 104, 118, 78);
		frame.getContentPane().add(buttonSetShip);
		
		JPanel panel = new JPanel();
		panel.setBounds(779, 226, 141, 230);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		pictureBoxTakeShip = new PanelShip();
		pictureBoxTakeShip.setBounds(12, 102, 118, 115);
		panel.add(pictureBoxTakeShip);
		
		JLabel label = new JLabel("Забрать корабль");
		label.setBounds(12, 0, 118, 16);
		panel.add(label);
		
		maskedTextBox1 = new JTextField();
		maskedTextBox1.setBounds(68, 29, 70, 22);
		panel.add(maskedTextBox1);
		maskedTextBox1.setColumns(10);
		
		JLabel label_1 = new JLabel("Место:");
		label_1.setBounds(12, 32, 56, 16);
		panel.add(label_1);
		
		JButton buttonTakeShip = new JButton("Забрать");
		buttonTakeShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!maskedTextBox1.getText().equals("")) {
                   			ITransport ship = wharf.Minus(Integer.parseInt(maskedTextBox1.getText()));
                    			if (ship != null) {
                        			ship.SetPosition(5, 5, pictureBoxTakeShip.getWidth(), pictureBoxTakeShip.getHeight());
                        			pictureBoxTakeShip.setShip(ship);
                        			pictureBoxTakeShip.repaint();
                        			panelWharf.repaint();
                    			} else {
                    				pictureBoxTakeShip.setShip(null);
                    				pictureBoxTakeShip.repaint();
                    			}
				}
			}
		});
		buttonTakeShip.setBounds(22, 64, 97, 25);
		panel.add(buttonTakeShip);
	}

	listBoxLevels = new JList();
		listBoxLevels.setBounds(790, 11, 118, 118);
		frame.getContentPane().add(listBoxLevels);
        model = new DefaultListModel();
        for(int i = 0; i < countLevel; i++)
        {
        	model.addElement("Уровень " + (i + 1));
        }
        listBoxLevels.setModel(model);
        listBoxLevels.setSelectedIndex(0);
        panelWharf.setListLevels(listBoxLevels);   
        listBoxLevels.addListSelectionListener(new ListSelectionListener() { 
			@Override 
			public void valueChanged(ListSelectionEvent e) { 
				panelWharf.repaint(); 
			} 
		});

	private void RedrawUI() {
		panelWharf.updateUI();		
	}
}
