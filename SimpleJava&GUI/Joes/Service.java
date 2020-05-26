import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Service extends JPanel {
// The following constants are used to indicate
// the cost of services for automotive.
public final double OIL_CHANGE = 26.00;
public final double LUBE_JOB = 18.00;
public final double RADIATOR_FLUSH = 30.00;
public final double TRANSMISSION_FLUSH = 80.00;
public final double INSPECTION = 15.00;
public final double MUFFLER_REPLACEMENT = 100.00;
public final double TIRE_ROTATION = 20.00;
// for text field.
private JTextField calcTextField;
// Check boxes for the available services.
private JCheckBox Oil_change;
private JCheckBox Lube_job;
private JCheckBox Radiator_flush;
private JCheckBox Transmission_flush;
private JCheckBox Inspection;
private JCheckBox Muffler_replacement;
private JCheckBox Tire_rotation;

/**
* Constructor
*/

public Service() {
// Create a GridLayout manager with
// seven rows and one column.
setLayout(new GridLayout(7, 1));

// Create the check boxes.
Oil_change = new JCheckBox("Oil Change ($26.00)");

Lube_job = new JCheckBox("Lube Job ($18.00)");

Radiator_flush = new JCheckBox("Radiator Flush ($30.00)");

Transmission_flush = new JCheckBox("Transmission Flush ($80.00)");

Inspection = new JCheckBox("Inspection ($15.00)");

Muffler_replacement = new JCheckBox("Muffler Replacement ($100.00)");

Tire_rotation = new JCheckBox("Tire Rotation ($20.00)");

// Add a border around the panel.
setBorder(BorderFactory.createTitledBorder("Routine Services"));

// Add the check boxes to this panel.

add(Oil_change);

add(Lube_job);

add(Radiator_flush);

add(Transmission_flush);

add(Inspection);

add(Muffler_replacement);

add(Tire_rotation);
}

/**
* The actionCalculate method returns the cost of the selected services.
*/

public double actionCalculate() {
double total = 0;
if (Oil_change.isSelected())
total = total + OIL_CHANGE;

if (Lube_job.isSelected())
total = total + LUBE_JOB;

if (Radiator_flush.isSelected())
total = total + RADIATOR_FLUSH;

if (Transmission_flush.isSelected())
total = total + TRANSMISSION_FLUSH;

if (Inspection.isSelected())
total = total + INSPECTION;

if (Muffler_replacement.isSelected())
total = total + MUFFLER_REPLACEMENT;

if (Tire_rotation.isSelected())
total = total + TIRE_ROTATION;
return total;

}

	public static void main(String args[]) {

		new CalculatorGUI();

	}

}