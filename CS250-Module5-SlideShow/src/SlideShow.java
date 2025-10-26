// Phillip Cowan - SNHU CS-250 Slide Show Application

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SlideShow extends JFrame {

	//Declare Variables
	private JPanel slidePane;
	private JPanel textPane;
	private JPanel buttonPane;
	private CardLayout card;
	private CardLayout cardText;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblSlide;
	private JLabel lblTextArea;

	/**
	 * Create the application.
	 */
	public SlideShow() throws HeadlessException {
		initComponent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initComponent() {
		//Initialize variables to empty objects
		//edited the color to white - personal preference
		card = new CardLayout();
		cardText = new CardLayout();
		slidePane = new JPanel();
		textPane = new JPanel();
		textPane.setBackground(Color.WHITE);
		textPane.setBounds(5, 470, 790, 55); // increased height to accommodate larger text
		textPane.setVisible(true);
		buttonPane = new JPanel();
		btnPrev = new JButton();
		btnNext = new JButton();
		lblSlide = new JLabel();
		lblTextArea = new JLabel();

		//Setup frame attributes
		setSize(800, 600);
		setLocationRelativeTo(null);
		setTitle("Top 5 Detox and Wellness Destinations"); // updated per request from Christy
		getContentPane().setLayout(new BorderLayout(10, 55)); // added padding to separate the icons (photos) and text area
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Setting the layouts for the panels
		slidePane.setLayout(card);
		textPane.setLayout(cardText);
		
		//logic to add each of the slides and text
		for (int i = 1; i <= 5; i++) {
			lblSlide = new JLabel();
			lblTextArea = new JLabel();
			lblSlide.setText(getResizeIcon(i));
			lblTextArea.setText(getTextDescription(i));
			slidePane.add(lblSlide, "card" + i);
			textPane.add(lblTextArea, "cardText" + i);
		}

		getContentPane().add(slidePane, BorderLayout.CENTER);
		getContentPane().add(textPane, BorderLayout.SOUTH);

		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

		btnPrev.setText("Previous");
		btnPrev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goPrevious();
			}
		});
		buttonPane.add(btnPrev);

		btnNext.setText("Next");
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goNext();
			}
		});
		buttonPane.add(btnNext);

		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}

	/**
	 * Previous Button Functionality
	 */
	private void goPrevious() {
		card.previous(slidePane);
		cardText.previous(textPane);
	}
	
	/**
	 * Next Button Functionality
	 */
	private void goNext() {
		card.next(slidePane);
		cardText.next(textPane);
	}

	/**
	 * Method to get the images
	 */
	private String getResizeIcon(int i) {
		String image = ""; 
		if (i==1){
			image = "<html><body><img height=auto width='800' max-height='500' src='" + getClass().getResource("/resources/BrazilRetreatNight.jpeg") + "'</body></html>";
		} else if (i==2){
			image = "<html><body><img height=auto width='800' max-height='500' src='" + getClass().getResource("/resources/ElephantPassAyurvedicRetreat.jpg") + "'</body></html>";
		} else if (i==3){
			image = "<html><body><img height=auto width='800' max-height='500' src='" + getClass().getResource("/resources/MalibuRanch.jpg") + "'</body></html>";
		} else if (i==4){
			image = "<html><body><img height=auto width='800' max-height='500' src='" + getClass().getResource("/resources/EuphoriaGreeceMystras.jpg") + "'</body></html>";
		} else if (i==5){
			image = "<html><body><img height=auto width='800' max-height='500' src='" + getClass().getResource("/resources/ResolutionsLakeKarapiro.jpg") + "'</body></html>";
		}
		return image;
	}
	
	/**
	 * Method to get the text values
	 */
	private String getTextDescription(int i) {
		String text = ""; 
		if (i==1){
			text = "<html><body><font size='5'>#1 Ayahuasca Retreat - Brazil</font> <br>Immerse yourself in a one-of-a-kind spiritual journey. Packages include the Ayuhausca ceremony as well as art, yoga, and guided meditations..</body></html>";
		} else if (i==2){
			text = "<html><body><font size='5'>#2 Ayurvedic Retreat - India</font> <br>One of the best places to enjoy a peaceful and authentic ayurvedic experience and yoga retreats in Kerala.</body></html>";
		} else if (i==3){
			text = "<html><body><font size='5'>#3 Malibu Ranch Resort - California</font> <br>The Ranch reconnect you to the foundational elements that have always sustained human vitality, so that you return to your life invigorated.</body></html>";
		} else if (i==4){
			text = "<html><body><font size='5'>#4 Euphoria Retreat - Greece</font> <br>Indulge in world-class wellness programs & rejuvenate in our state-of-the-art facilities. <br></body></html>";
		} else if (i==5){
			text = "<html><body><font size='5'>#5 Resolution Retreat - New Zealand</font> <br>Diet, exercise, treatments, therapies, therapists and education together in such a way that gives our guests the best results and the greatest opportunity to improve their lives.</body></html>";
		}
		return text;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				SlideShow ss = new SlideShow();
				ss.setVisible(true);
			}
		});
	}
}