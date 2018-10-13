package lab1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class FormShip {

	private JFrame frame;
	private JPanel panel;
	private JButton buttonUp;
	private JButton buttonDown;
	private JButton buttonLeft;
	private JButton buttonRight;
	private JButton buttonCreate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormShip window = new FormShip();
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

	public FormShip() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 901, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		panel = new PanelShip();
		panel.setBounds(12, 13, 864, 439);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		buttonRight = new JButton("");
		buttonRight.setIcon(new ImageIcon("C:\\Users\\ВИКА\\Desktop\\ArrowRight1.png"));
		buttonRight.setBounds(814, 386, 50, 50);
		panel.add(buttonRight);
		buttonRight.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PanelShip.initialization) {
					PanelShip.ship.MoveTransport(Direction.Right);
				}
				RedrawUI();
			}
		});
		buttonDown = new JButton("");
		buttonDown.setIcon(new ImageIcon("C:\\Users\\ВИКА\\Desktop\\ArrowDown1.png"));
		buttonDown.setBounds(751, 386, 50, 50);
		panel.add(buttonDown);
		buttonDown.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PanelShip.initialization) {
					PanelShip.ship.MoveTransport(Direction.Down);
				}
				RedrawUI();
			}
		});
		buttonLeft = new JButton("");
		buttonLeft.setIcon(new ImageIcon("C:\\Users\\ВИКА\\Desktop\\ArrowLeft1.png"));
		buttonLeft.setBounds(689, 386, 50, 50);
		panel.add(buttonLeft);
		buttonLeft.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PanelShip.initialization) {
					PanelShip.ship.MoveTransport(Direction.Left);
				}
				RedrawUI();
			}
		});
		buttonUp = new JButton("");
		buttonUp.setIcon(new ImageIcon("C:\\Users\\ВИКА\\Desktop\\ArrowUp1.png"));
		buttonUp.setBounds(751, 323, 50, 50);
		panel.add(buttonUp);
		buttonUp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PanelShip.initialization) {
					PanelShip.ship.MoveTransport(Direction.Up);
				}
				RedrawUI();
			}
		});
		buttonCreate = new JButton("Создать");
		buttonCreate.setBounds(0, 0, 81, 25);
		panel.add(buttonCreate);
		buttonCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Random rnd = new Random();
				PanelShip.ship = new Ship(rnd.nextInt(200) + 100, rnd.nextInt(1000) + 1000, Color.BLUE, Color.WHITE);
				PanelShip.initialization = true;
				PanelShip.ship.SetPosition(rnd.nextInt(90) + 10, rnd.nextInt(90) + 10, panel.getWidth(), panel.getHeight());
				RedrawUI();
			}
		});
	}

	private void RedrawUI() {
		panel.updateUI();		
	}
}
