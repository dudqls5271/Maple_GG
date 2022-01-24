import javax.swing.*; //JTable
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ColTest extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MyPanel panel = new MyPanel();

	public ColTest() {
		setTitle("drawString ��� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(500,800); //x,y,w,h);
		setVisible(true);
	}

	class MyPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g) {
			Font f1 = new Font("�����ý��丮", Font.PLAIN, 30);
			Font f2 = new Font("�����ý��丮", Font.PLAIN, 24);
			Font f3 = new Font("�Ƹ���-����(TTF)-Bold", Font.PLAIN, 50);
			super.paintComponent(g);

			g.setColor(Color.MAGENTA);
			g.drawRect(10,10,168,168);
			g.setColor(Color.black);
			
			g.setFont(f1);
			g.drawString("�����Ƶ�", 190,40);
			
			g.setFont(f2);
			g.drawString("Lv.239", 190,80);
			g.drawString("|", 275,80);
			g.drawString("�Ƶ�", 290,80);
			g.drawString("|", 335,80);
			g.drawString("�α⵵ : 150", 350,80);
			
			g.setFont(f3);
			g.drawString("��� : �̸�", 190,120);
			
			JPanel customerPn = new JPanel(new GridLayout(4, 1)); // import java.awt.*; -> �ؾ� GridLayout(4,1) ������ ������

			JPanel cPn1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			cPn1.add(new JLabel("�г��� : ")).setFont(f1);
			customerPn.add(cPn1);
			this.add(customerPn);

		}
	}
	public static void main(String[] args) {
		new ColTest();
	}
	
}