package lab3;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.File;
import java.io.IOException;
import java.lang.Object; 
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;



public class FormWharf {

	private JFrame frame;
	private JList listBoxLevels;
    private DefaultListModel model;
	
	
	private JTextField maskedTextBox1;
	MultiLevelWharf wharf;
	private JPanel panel;
	private JPanel panelTake;
	private int countLevel = 5;
    private PanelShip pictureBoxTakeShip;
    private PanelWharf panelWharf;
    
    FileHandler fh;
	private static Logger logger= Logger.getLogger(FormWharf.class.getName());
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
		
		try {
			fh = new FileHandler("D:/logger.txt");
			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);
		} catch (SecurityException ex){
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);

		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser filesave = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("txt file", "txt");
				filesave.setFileFilter(filter);
				if (filesave.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					File file = filesave.getSelectedFile();
					String path = file.getAbsolutePath();
					try{
						wharf.saveData(path);
						JOptionPane.showMessageDialog(null, "Saved");
						logger.info("Сохранено в файл " + file.getName());
					}
					catch(Exception ex){
						JOptionPane.showMessageDialog(null, "Save failed", "", 0, null);
					}
				}
			}
		});
		menuFile.add(menuSave);

		JMenuItem menuLoad = new JMenuItem("Load");
		menuLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("txt file", "txt");
				fileChooser.setFileFilter(filter);
				if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					try {
						wharf.loadData(file.getAbsolutePath());
						JOptionPane.showMessageDialog(null, "Loaded");
						logger.info("Загружено из файла " + file.getName());					
					} catch (WharfOccupiedPlaceException ex) {
						JOptionPane.showMessageDialog(null, "Занято место", ex.getMessage(), JOptionPane.ERROR_MESSAGE);

					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage(), "Load failed", 0, null);
					}
					
					panelWharf.repaint();
				}
			}
		});
		menuFile.add(menuLoad);

		
		panelWharf= new PanelWharf();
		panelWharf.setBounds(0, 11, 777, 443);
		frame.getContentPane().add(panelWharf);
		
		wharf = panelWharf.getWharf();
		
		JPanel pictureBoxWharf = new JPanel();
		pictureBoxWharf.setBounds(0, 0, 778, 466);
		frame.getContentPane().add(pictureBoxWharf);
		
		JButton buttonSetShip = new JButton("Заказать корабль");
		buttonSetShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (listBoxLevels.getSelectedIndex() > -1) {
					try{
						DialogConfig dConfig = new DialogConfig(frame);
	                    if (dConfig.isSuccessful()) {
	                    	PanelTakeWharf.ship = dConfig.getShip();
	                        int i = wharf.getWharf(listBoxLevels.getSelectedIndex()).Plus(PanelTakeWharf.ship);
	                        logger.info("Добавлен корабль " + PanelTakeWharf.ship.getInfo() + " на место " + i);
	                        panelWharf.repaint();
	                    }
					}catch(WharfOverflowException ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage(), "Переполнение", JOptionPane.ERROR_MESSAGE);
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage(), "Неизвестная ошибка", JOptionPane.ERROR_MESSAGE);
					} 
                }
			}
		});
		buttonSetShip.setBounds(790, 141,  118, 41);
		frame.getContentPane().add(buttonSetShip);
		
		
		JButton buttonSort = new JButton("Сортировать");
		buttonSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				wharf.sort();
				panelWharf.repaint();
				logger.info("Отсортировано");
			}
		});
		buttonSort.setBounds(790, 181,  118, 41);
		frame.getContentPane().add(buttonSort);
		
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
					try{
						ITransport ship = wharf.getWharf(listBoxLevels.getSelectedIndex()).Minus(Integer.parseInt(maskedTextBox1.getText()));
						ship.SetPosition(5, 5, pictureBoxTakeShip.getWidth(), pictureBoxTakeShip.getHeight());
                        pictureBoxTakeShip.setShip(ship);
                        pictureBoxTakeShip.repaint();
                        panelWharf.repaint();
                        logger.info("Изъят корабль " + ship.getInfo() + " с места " + maskedTextBox1.getText());
                    } catch(WharfNotFoundException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Не найдено", JOptionPane.ERROR_MESSAGE);
                    }
					panelWharf.repaint();
				}
			}
		});
		buttonTakeShip.setBounds(22, 64, 97, 25);
		panel.add(buttonTakeShip);
		
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
	
	}
	private void RedrawUI() {
		panelWharf.updateUI();		
	}
}
