package herhaling;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class FrameHerhaling {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.add(panel);
		JTextArea label = new JTextArea();
		JLabel labellenght = new JLabel("");
		frame.setSize(new Dimension(400, 200));
		JButton button = new JButton("tel char");
		JButton addrandomchatbutton = new JButton("random char");
		JButton delonechar = new JButton("del one");
		panel.add(button);
		JScrollPane scroll = new JScrollPane(label);
		scroll.setPreferredSize(new Dimension(100, frame.getHeight() - 80));
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getlen(label, labellenght);
				
			}
		});
		JButton deletetext = new JButton("del char");
		deletetext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				empty(label);
				
			}
		});
		addrandomchatbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				randomchar(label);
				
			}
		});
		delonechar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				delone(label);
				
			}
		});
		panel.setFocusable(true);
		panel.addKeyListener((new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyCode());
				
				if(e.getKeyChar() == 'r') {
					randomchar(label);
				}
				if(e.getKeyCode() == 127) {
					delone(label);
				}
				if(e.getKeyCode() == 8) {
					empty(label);
				}
				if(e.getKeyChar() == 'l') {
					getlen(label, labellenght);
				}
			}
		}));

		
		panel.add(delonechar);
		panel.add(addrandomchatbutton);
		panel.add(deletetext);
		panel.add(labellenght);
		panel.add(scroll);
		label.setEditable(false);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	private static void getlen(JTextArea label, JLabel labellenght) {
		labellenght.setText((label.getText().length()/2) + "");
	}

	private static void empty(JTextArea label) {
		label.setText("");
	}

	private static void randomchar(JTextArea label) {
		String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		int random = (int) Math.floor(Math.random() * 25);
		label.setText(label.getText() + alphabet[random] + "\n");
	}

	private static void delone(JTextArea label) {
		try {
			label.setText(label.getText().substring(0, (label.getText().length()-2)));
		}
		catch(Exception except) {
			System.out.println("cannot delete no more char");
		}
	}
	
}
