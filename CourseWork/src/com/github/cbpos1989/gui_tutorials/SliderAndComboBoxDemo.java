/**
 * 
 */
package com.github.cbpos1989.gui_tutorials;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * App that wil change the background and foreground colors depend on JSliders 
 * and alter the font style with a JComboBox.
 * 
 * @author Colm O'Sullivan
 *
 */
public class SliderAndComboBoxDemo {
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int screenWidth = (int)screenSize.getWidth();
	private int screenHeight = (int)screenSize.getHeight();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SliderAndComboBoxDemo scd = new SliderAndComboBoxDemo();
		scd.startProgram();

	}

	private void startProgram() {
		JFrame window = new JFrame("Slider & ComboBox Demo");
		ContentPanel content = new ContentPanel();
		window.setContentPane(content);
		window.pack();
		window.setLocation(screenWidth/2, screenHeight/2);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
	}

	class ContentPanel extends JPanel implements ActionListener, ChangeListener{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private JLabel displayLabel;
		private JComboBox<String> fontStyleSelect;
		private JSlider bgColorSlider, fgColorSlider;
		
		
		public ContentPanel(){
			//Color Sliders
			bgColorSlider = new JSlider(0,255,100);
			bgColorSlider.addChangeListener(this);
			
			fgColorSlider = new JSlider(0,255,100);
			fgColorSlider.addChangeListener(this);
			
			//Font Style ComboBox
			fontStyleSelect = new JComboBox<String>();
			fontStyleSelect.addItem("Plain Font");
			fontStyleSelect.addItem("Italic Font");
			fontStyleSelect.addItem("Bold Font");
			fontStyleSelect.addItem("Bold Italic Font");
			fontStyleSelect.setSelectedIndex(2);
			fontStyleSelect.addActionListener(this);
			
			//Label for Sliders and ComboBox to affect
			displayLabel = new JLabel("Hello World!", JLabel.CENTER);
			displayLabel.setOpaque(true);
			displayLabel.setBackground(new Color(100,100,100));
			displayLabel.setForeground(new Color(255,200,200));
			displayLabel.setFont(new Font("Serif",Font.BOLD,30));
			
			//Set Layout of Panel
			setLayout(new GridLayout(4,1));
			add(displayLabel);
			add(bgColorSlider);
			add(fgColorSlider);
			add(fontStyleSelect);
			
		}
		
		@Override
		//Method to change color of the label, Shades of grey for bg and shades of red/white for fg
		public void stateChanged(ChangeEvent evt) {
			if (evt.getSource() == bgColorSlider) {
				int bgVal = bgColorSlider.getValue();
				displayLabel.setBackground(new Color(bgVal,bgVal,bgVal));
			} else {
				int fgVal = fgColorSlider.getValue();
				displayLabel.setForeground(new Color(255,fgVal,fgVal));
			}
			
		}

		
		@Override
		//Method to take changes from ComboBox to affect Label font style
		public void actionPerformed(ActionEvent evt) {
			switch(fontStyleSelect.getSelectedIndex()){
			case 0:
				displayLabel.setFont(new Font("Serif", Font.PLAIN,30));
				break;
			case 1:
				displayLabel.setFont(new Font("Serif", Font.ITALIC,30));
				break;
			case 2:
				displayLabel.setFont(new Font("Serif", Font.BOLD,30));
				break;
			case 3:
				displayLabel.setFont(new Font("Serif", Font.BOLD + Font.ITALIC,30));
				break;
			}
			
		}
		
	}
}
