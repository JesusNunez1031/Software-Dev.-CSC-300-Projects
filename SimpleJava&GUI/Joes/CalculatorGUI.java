import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 * The CalculatorGUI class creates the GUI for Joe's Automotive application.
 */

public class CalculatorGUI extends JFrame {

	// The following variables will reference the
	// custom panel objects.
	private Service sc; // Service panel
	private NonService ns; // NonService panel

	// The following variables will reference objects
	// needed to add the Calculate and Exit buttons.
	private JPanel buttonPanel; // To hold the buttons
	private JButton calcButton; // To calculate the cost
	private JButton exitButton; // To exit the application

	/**
	 * Constructor
	 */

	public CalculatorGUI() {
		// Display title.
		super("Joe's Automotive");
		setLocationRelativeTo(null);
		// Specify an action for the close button.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create a BorderLayout manager for
		// the content pane.
		setLayout(new BorderLayout());

		// Create the custom panels.
		sc = new Service();
		ns = new NonService();

		// Call the buildButtonPanel method to
		// create the button panel.
		buildButtonPanel();

		// Add the components to the content pane.
		add(sc, BorderLayout.PAGE_START);

		add(ns, BorderLayout.CENTER);

		add(buttonPanel, BorderLayout.PAGE_END);
		// Pack the contents of the window and display it.
		pack();
		setVisible(true);
	}

	/**
	 * The buildButtonPanel method builds the button panel.
	 */

	private void buildButtonPanel() {
		// Create a panel for the buttons.
		buttonPanel = new JPanel();

		// Create the buttons.
		calcButton = new JButton("Calculate Charges");
		exitButton = new JButton("Exit");

		// Register the action listeners.
		calcButton.addActionListener(new CalcButtonListener());
		exitButton.addActionListener(new ExitButtonListener());

		// Add the buttons to the button panel.
		buttonPanel.add(calcButton);
		buttonPanel.add(exitButton);

	}

	/**
	 * Private inner class that handles the event when the user clicks the Calculate
	 * button.
	 */

	private class CalcButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// The order subtotal

			double total; // The order total

			// Calculate the subtotal.
			total = sc.actionCalculate() + ns.getNonroutineServicesCost();

			// Create a DecimalFormat object to format
			// the total as a dollar amount.
			DecimalFormat dollar = new DecimalFormat("0.00");

			// Display the charges.
			JOptionPane.showMessageDialog(null, "Total: $" + dollar.format(total));

		}
	}

	/**
	 * Private inner class that handles the event when the user clicks the Exit
	 * button.
	 */

	private class ExitButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Exit the application.
			System.exit(0);
		}
    }
}