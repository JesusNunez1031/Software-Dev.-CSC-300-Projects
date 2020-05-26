
// This for NonRoutine Services
import java.awt.*;
import javax.swing.*;

public class NonService extends JPanel {
    public final double perHourCharge = 20.00; // per hour labor cost
    private JLabel partsLabel; // references parts charges label
    private JLabel laborLabel; // references hours of labor label
    private JTextField partsTextField; // references parts charges text field
    private JTextField laborTextField; // references hours of labor text field
    private JPanel panel;

    public NonService() {
        // Create labels
        partsLabel = new JLabel("Parts Charges:");
        laborLabel = new JLabel("Hours of Labor:");

        // Create the text Fields
        partsTextField = new JTextField(10);
        laborTextField = new JTextField(10);

        // Add a border around the panel
        setBorder(BorderFactory.createTitledBorder("Nonroutine services"));

        add(partsLabel);
        add(partsTextField);
        add(laborLabel);
        add(laborTextField);

        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        setLayout(new GridLayout(2, 2));
    }

    public double getNonroutineServicesCost() {
        return Double.parseDouble(partsTextField.getText())
                + (Double.parseDouble(laborTextField.getText()) * perHourCharge);
    }
}
