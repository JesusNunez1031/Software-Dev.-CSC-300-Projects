import javax.swing.*;		// import the swing classes
import java.awt.event.*;	// import needed for ActionListener Interface


public class RetailPriceCalculator	extends JFrame
{
  private	JPanel panel;							// to reference a panel
  private	JLabel wholeSaleMessageLabel;		// to reference a label
  private	JLabel markupMessageLabel;			// to reference a label
  private	JLabel retailPriceLabel;			// to reference a label

  private	JTextField	wholeSalePriceField;	// to reference the Whole Sale Price Field
  private	JTextField	markUpPercentage;		// to reference the Mark Up text field
  private	JTextField	retailPrice;			// to reference the Retail Price Field
  private	JButton	calculateButton;			// to reference button
 
 
 	
	public RetailPriceCalculator()
 	{
	
		// set window title
		setTitle("Retail Price Calculator");
	
		// set widow size
		setSize(400, 150);
	
		// tell what to do when the window closes
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		// build the panel and add it to the frame
		buildPanel();
		
		// add the panel to the frame's content pane
		add(panel);
	
		// display the window
		setVisible(true);
	 }

	private void buildPanel()
	{
	
		// create a label for the wholesale price
		wholeSaleMessageLabel = new JLabel("Enter Wholesale Price: ");
		
		// create a text field 15 characters wide
		wholeSalePriceField = new JTextField(10);
		
		// create a label for the mark up percentage
		markupMessageLabel = new JLabel("Enter Mark Up Percentage: ");
		
		// create a text field 15 characters wide
		markUpPercentage = new JTextField(10);
		
		// create a button with the capation "Calculate Retail Price"
		calculateButton = new JButton("Calculate Retail Price");
		
		
		// add an action listener to the button
		calculateButton.addActionListener(new CalcButtonListener());
		
		
		// create a label for the retail price
		retailPriceLabel = new JLabel("The Retail Price is:  $");
		
		// create a text field 15 characters wide for the retail price
		retailPrice = new JTextField(15);
		
		// create a JPanel object and let the panel filed reference it
		panel = new JPanel();
		
		// add the labels, rext field and button compnenets to the panel
		panel.add(wholeSaleMessageLabel);
		panel.add(wholeSalePriceField);
		panel.add(markupMessageLabel);
		panel.add(markUpPercentage);
	   panel.add(calculateButton);
   	   panel.add(retailPriceLabel);
	   panel.add(retailPrice);
		
	}
	 
	 
	/** calculateButton is an action listener class for the Calculate Button
	*/
	
	private class CalcButtonListener implements ActionListener
	{
		// This method executes when the user clicks on the Calculate Button
		
		public void actionPerformed(ActionEvent e)
		{
			String	wholesaleInput;	// to hold user input for wholesale price
			String	markUpInput;		// to hold user input for mark up percentage
			double	retailPriceD;		// declare retail price as a double
			double 	wholePrice;			// declare wholesale prcie as a double
			double	markUp;				// declare markup percentage as a double
			
			// get the text entered by the user in the text field box
			wholesaleInput = wholeSalePriceField.getText();
			
			// convert wholesale text to double
			wholePrice = Double.parseDouble(wholesaleInput);
			
			// get the text entered by the user in the percentage text field
			markUpInput = markUpPercentage.getText();
			
			// parse out the markup percentage from the percentage text field
			markUp = Double.parseDouble(markUpInput);
			
			// do function to calculate retail price( wholesale * markup)
            retailPriceD = ((wholePrice * markUp) * .01) + wholePrice;
            
			
			// display the results
            //JOptionPane.showMessageDialog(null, retailPrice);
            retailPrice.setText(Double.toString(retailPriceD));
			
			
		}
	}
}

