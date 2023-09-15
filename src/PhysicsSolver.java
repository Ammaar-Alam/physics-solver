// AP Physics I: Final | Block 03 - Ammaar Alam
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PhysicsSolver {

    private JFrame frame;
    private JPanel panel;
    private JTextField viField;
    private JTextField vfField;
    private JTextField aField;
    private JTextField tField;
    private JTextField dField;
    private JTextField angleField;
    private JTextField timeField;
    private JTextField heightField;
    private JTextField rangeField;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                PhysicsSolver solver = new PhysicsSolver();
                solver.createAndShowGUI();
            }
        });
    }

    private void createAndShowGUI() {
        frame = new JFrame("Physics Problem Solver");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Welcome to the AP Physics Motion Problem Solver!");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titleLabel);

        JLabel choiceLabel = new JLabel("Choose the type of problem you want to solve:");
        choiceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(choiceLabel);

        JButton oneDButton = new JButton("One-dimensional motion");
        oneDButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        oneDButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showOneDInput();
            }
        });
        panel.add(oneDButton);

        JButton twoDButton = new JButton("Two-dimensional motion");
        twoDButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        twoDButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showTwoDInput();
            }
        });
        panel.add(twoDButton);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private void showOneDInput() {
        frame.getContentPane().removeAll();

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("One-dimensional motion - Enter the variables:");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titleLabel);

        JLabel viLabel = new JLabel("Initial Velocity (or 'x' if unknown):");
        viField = new JTextField(10);
        panel.add(viLabel);
        panel.add(viField);

        JLabel vfLabel = new JLabel("Final Velocity (or 'x' if unknown):");
        vfField = new JTextField(10);
        panel.add(vfLabel);
        panel.add(vfField);

        JLabel aLabel = new JLabel("Acceleration (or 'x' if unknown):");
        aField = new JTextField(10);
        panel.add(aLabel);
        panel.add(aField);

        JLabel tLabel = new JLabel("Time (or 'x' if unknown):");
        tField = new JTextField(10);
        panel.add(tLabel);
        panel.add(tField);

        JLabel dLabel = new JLabel("Distance (or 'x' if unknown):");
        dField = new JTextField(10);
        panel.add(dLabel);
        panel.add(dField);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate1DUnknowns();
            }
        });
        panel.add(calculateButton);

        JButton backButton = new JButton("Back");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                createAndShowGUI();
            }
        });
        panel.add(backButton);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.revalidate();
        frame.repaint();
    }

    private void calculate1DUnknowns() {
        String viInput = viField.getText();
        Double vi = viInput.equals("x") ? null : Double.parseDouble(viInput);

        String vfInput = vfField.getText();
        Double vf = vfInput.equals("x") ? null : Double.parseDouble(vfInput);

        String aInput = aField.getText();
        Double a = aInput.equals("x") ? null : Double.parseDouble(aInput);

        String tInput = tField.getText();
        Double t = tInput.equals("x") ? null : Double.parseDouble(tInput);

        String dInput = dField.getText();
        Double d = dInput.equals("x") ? null : Double.parseDouble(dInput);

        if (vi != null && a != null && t != null) {
            vf = vi + a * t;
            d = vi * t + 0.5 * a * Math.pow(t, 2);
        } else if (vi != null && vf != null && t != null) {
            a = (vf - vi) / t;
            d = vi * t + 0.5 * a * Math.pow(t, 2);
        } else if (vi != null && vf != null && a != null) {
            t = (vf - vi) / a;
            d = vi * t + 0.5 * a * Math.pow(t, 2);
        } else if (vi != null && t != null && d != null) {
            a = 2 * (d - vi * t) / Math.pow(t, 2);
            vf = vi + a * t;
        } else {
            JOptionPane.showMessageDialog(frame, "Insufficient data to calculate unknowns. Please provide at least three known variables.");
            return;
        }

        display1DResults(vi, vf, a, t, d);
    }

    private void display1DResults(Double vi, Double vf, Double a, Double t, Double d) {
        frame.getContentPane().removeAll();

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel resultTitleLabel = new JLabel("One-dimensional motion - Results:");
        resultTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(resultTitleLabel);

        JLabel viResultLabel = new JLabel("Initial Velocity: " + vi);
        panel.add(viResultLabel);

        JLabel vfResultLabel = new JLabel("Final Velocity: " + vf);
        panel.add(vfResultLabel);

        JLabel aResultLabel = new JLabel("Acceleration: " + a);
        panel.add(aResultLabel);

        JLabel tResultLabel = new JLabel("Time: " + t);
        panel.add(tResultLabel);

        JLabel dResultLabel = new JLabel("Distance: " + d);
        panel.add(dResultLabel);

        JButton backButton = new JButton("Back");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                createAndShowGUI();
            }
        });
        panel.add(backButton);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.revalidate();
        frame.repaint();
    }

    private void showTwoDInput() {
        frame.getContentPane().removeAll();

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Two-dimensional motion - Enter the variables:");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titleLabel);

        JLabel viLabel = new JLabel("Initial Velocity (or 'x' if unknown):");
        viField = new JTextField(10);
        panel.add(viLabel);
        panel.add(viField);

        JLabel vfLabel = new JLabel("Final Velocity (or 'x' if unknown):");
        vfField = new JTextField(10);
        panel.add(vfLabel);
        panel.add(vfField);

        JLabel aLabel = new JLabel("Acceleration (or 'x' if unknown):");
        aField = new JTextField(10);
        panel.add(aLabel);
        panel.add(aField);

        JLabel tLabel = new JLabel("Time (or 'x' if unknown):");
        tField = new JTextField(10);
        panel.add(tLabel);
        panel.add(tField);

        JLabel angleLabel = new JLabel("Angle (or 'x' if unknown):");
        angleField = new JTextField(10);
        panel.add(angleLabel);
        panel.add(angleField);

        JLabel heightLabel = new JLabel("Height (or 'x' if unknown):");
        heightField = new JTextField(10);
        panel.add(heightLabel);
        panel.add(heightField);

        JLabel rangeLabel = new JLabel("Range (or 'x' if unknown):");
        rangeField = new JTextField(10);
        panel.add(rangeLabel);
        panel.add(rangeField);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate2DUnknowns();
            }
        });
        panel.add(calculateButton);

        JButton backButton = new JButton("Back");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                createAndShowGUI();
            }
        });
        panel.add(backButton);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.revalidate();
        frame.repaint();
    }

    private void calculate2DUnknowns() {
        String viInput = viField.getText();
        Double vi = viInput.equals("x") ? null : Double.parseDouble(viInput);

        String vfInput = vfField.getText();
        Double vf = vfInput.equals("x") ? null : Double.parseDouble(vfInput);

        String aInput = aField.getText();
        Double a = aInput.equals("x") ? null : Double.parseDouble(aInput);

        String tInput = tField.getText();
        Double t = tInput.equals("x") ? null : Double.parseDouble(tInput);

        String angleInput = angleField.getText();
        Double angle = angleInput.equals("x") ? null : Double.parseDouble(angleInput);

        String heightInput = heightField.getText();
        Double height = heightInput.equals("x") ? null : Double.parseDouble(heightInput);

        String rangeInput = rangeField.getText();
        Double range = rangeInput.equals("x") ? null : Double.parseDouble(rangeInput);

        final double g = 9.81; // Acceleration due to gravity

        if (vi != null && angle != null) {
            double angleInRadians = Math.toRadians(angle);

            if (t == null) {
                t = (2 * vi * Math.sin(angleInRadians)) / g;
            }

            if (height == null) {
                height = (Math.pow(vi, 2) * Math.pow(Math.sin(angleInRadians), 2)) / (2 * g);
            }

            if (range == null) {
                range = (Math.pow(vi, 2) * Math.sin(2 * angleInRadians)) / g;
            }
        } else if (vi != null && t != null) {
            if (angle == null) {
                angle = Math.toDegrees(Math.asin((g * t) / (2 * vi)));
            }

            if (height == null) {
                height = (vi * t * Math.sin(Math.toRadians(angle))) - (0.5 * g * Math.pow(t, 2));
            }

            if (range == null) {
                range = vi * t * Math.cos(Math.toRadians(angle));
            }
        } else if (vi != null && height != null) {
            if (angle == null) {
                angle = Math.toDegrees(Math.acos((vi * Math.sqrt((2 * height) / g)) / vi));
            }

            if (t == null) {
                t = (2 * vi * Math.sin(Math.toRadians(angle))) / g;
            }

            if (range == null) {
                range = vi * t * Math.cos(Math.toRadians(angle));
            }
        } else if (vi != null && range != null) {
            if (angle == null) {
                angle = Math.toDegrees(Math.acos(range * g / (2 * Math.pow(vi, 2))));
            }

            if (t == null) {
                t = range / (vi * Math.cos(Math.toRadians(angle)));
            }

            if (height == null) {
                height = (Math.pow(vi, 2) * Math.pow(Math.sin(Math.toRadians(angle)), 2)) / (2 * g);
            }
        } else if (vi != null && vf != null) {
            if (t == null) {
                t = (vf - vi) / g;
            }

            if (angle == null) {
                angle = Math.toDegrees(Math.asin((g * t) / (2 * vi)));
            }

            if (height == null) {
                height = (vi * t * Math.sin(Math.toRadians(angle))) - (0.5 * g * Math.pow(t, 2));
            }

            if (range == null) {
                range = vi * t * Math.cos(Math.toRadians(angle));
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Insufficient data to calculate unknowns. Please provide at least three known variables.");
            return;
        }

        display2DResults(vi, vf, a, t, angle, height, range);
    }

    private void display2DResults(Double vi, Double vf, Double a, Double t, Double angle, Double height, Double range) {
        frame.getContentPane().removeAll();
        
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel resultTitleLabel = new JLabel("Two-dimensional motion - Results:");
        resultTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(resultTitleLabel);

        JLabel viResultLabel = new JLabel("Initial Velocity: " + vi);
        panel.add(viResultLabel);

        JLabel vfResultLabel = new JLabel("Final Velocity: " + vf);
        panel.add(vfResultLabel);

        JLabel aResultLabel = new JLabel("Acceleration: " + a);
        panel.add(aResultLabel);

        JLabel tResultLabel = new JLabel("Time: " + t);
        panel.add(tResultLabel);

        JLabel angleResultLabel = new JLabel("Angle: " + angle);
        panel.add(angleResultLabel);

        JLabel heightResultLabel = new JLabel("Height: " + height);
        panel.add(heightResultLabel);

        JLabel rangeResultLabel = new JLabel("Range: " + range);
        panel.add(rangeResultLabel);

        JButton backButton = new JButton("Back");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                createAndShowGUI();
            }
        });
        panel.add(backButton);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.revalidate();
        frame.repaint();
    }
}