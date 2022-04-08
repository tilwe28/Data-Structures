import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.net.*;

import java.io.*;
import javax.sound.sampled.*;

public class MusicBox_Day1 extends JFrame implements Runnable, ActionListener, AdjustmentListener
{

	JToggleButton[][] button = new JToggleButton[37][50];
	JScrollPane buttonPane;
	JScrollBar tempoBar;
	JPanel buttonPanel;
	JFrame frame = new JFrame();
	boolean notStopped = true;
	String[] clipNames;
	Clip[] clip;
	int tempo = 150;
	boolean playing = true;
	int row =0, col=0;
	Font font = new Font("Times New Roman", Font.PLAIN, 10);
	String[] instrumentNames = {"Bell", "Piano", "Oboe", "Marimba", "Glockenspiel", "Oh_Ah"};
	Thread timing;

	public MusicBox_Day1()
	{
		  this.setSize(1000,800);
		  clipNames = new String[]{"C3","B3","ASharp3","A3","GSharp3","G3","FSharp3","F3","E3","DSharp3","D3","CSharp3","C2","B2","ASharp2","A2","GSharp2","G2","FSharp2","F2","E2","DSharp2","D2","CSharp2","C1","B1","ASharp1","A1","GSharp1","G1","FSharp1","F1","E1","DSharp1","D1","CSharp1","C0"};
		  clip = new Clip[clipNames.length];
		  String initInstrument = instrumentNames[5];
		  try {
			 for(int x=0;x<clipNames.length;x++)
			 {
				URL url = this.getClass().getClassLoader().getResource(initInstrument+"\\"+initInstrument+" - "+clipNames[x]+".wav");
				AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
				clip[x] = AudioSystem.getClip();
				clip[x].open(audioIn);
			}

		  } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
			 e.printStackTrace();
		  }
		  buttonPanel = new JPanel();
		  buttonPanel.setLayout(new GridLayout(button.length,button[0].length,2,5));
		  for(int r = 0; r < button.length;r++) {
			  String name = clipNames[r].replaceAll("Sharp","#");
			  for(int c = 0; c < button[0].length; c++) {
				  button[r][c] = new JToggleButton();
				  button[r][c].setFont(font);
				  button[r][c].setText(name);
				  button[r][c].setPreferredSize(new Dimension(30,30));
				  button[r][c].setMargin(new Insets(0,0,0,0));
				  buttonPanel.add(button[r][c]);
			  }
		  }

		  buttonPane = new JScrollPane(buttonPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		  this.add(buttonPane,BorderLayout.CENTER);


		  setVisible(true);
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  timing = new Thread(this);
		  timing.start();
	}

	public void run()
	{
		do
		{
			try
			{
				if(!playing)
				{
					timing.sleep(0); // 7
				}
				else
				{
					for(int r = 0; r < button.length;r++)
					{
						if(button[r][col].isSelected())
						{
							clip[r].start();
							button[r][col].setForeground(Color.YELLOW);
						}
					}

					timing.sleep(tempo);

					for(int r = 0; r < button.length; r++)
					{
						if(button[r][col].isSelected())
						{
							clip[r].stop();
							clip[r].setFramePosition(0);
							button[r][col].setForeground(Color.BLACK);
						}
					}
					col++;
					if(col == button[0].length)
						col = 0;
				}
			}
			catch(InterruptedException e) {
			}
		}while(notStopped);
	}

	public void actionPerformed(ActionEvent e)
	{
	}
	public void adjustmentValueChanged(AdjustmentEvent e)
	{
	}
	public static void main(String[] args)
	{
		MusicBox_Day1 app=new MusicBox_Day1();
	}

}