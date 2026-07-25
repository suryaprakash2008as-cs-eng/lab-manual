import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentRegistrationForm extends JFrame implements ActionListener {
    // Form components
    private JTextField usnField, nameField;
    private JComboBox<String> branchBox;
    private JRadioButton maleBtn, femaleBtn;
    private JCheckBox javaSkill, pythonSkill;
    private JButton submitBtn, clearBtn;
    private JTextArea outputArea;

    public StudentRegistrationForm() {
        setTitle("STUDENT REGISTRATION FORM");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));

        // USN
        add(new JLabel("USN:"));
        usnField = new JTextField(20);
        add(usnField);

        // Name
        add(new JLabel("Name:"));
        nameField = new JTextField(20);
        add(nameField);

        // Branch
        add(new JLabel("Branch:"));
        String[] branches = {"Computer Science", "Electronics", "Mechanical", "Civil"};
        branchBox = new JComboBox<>(branches);
        add(branchBox);

        // Gender
        add(new JLabel("Gender:"));
        maleBtn = new JRadioButton("Male");
        femaleBtn = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleBtn);
        genderGroup.add(femaleBtn);
        add(maleBtn);
        add(femaleBtn);

        // Skills
        add(new JLabel("Skills:"));
        javaSkill = new JCheckBox("Java");
        pythonSkill = new JCheckBox("Python");
        add(javaSkill);
        add(pythonSkill);

        // Buttons
        submitBtn = new JButton("Submit");
        clearBtn = new JButton("Clear");
        add(submitBtn);
        add(clearBtn);

        // Output area
        outputArea = new JTextArea(8, 40);
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea));

        // Event handling
        submitBtn.addActionListener(this);
        clearBtn.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitBtn) {
            String usn = usnField.getText();
            String name = nameField.getText();
            String branch = (String) branchBox.getSelectedItem();
            String gender = maleBtn.isSelected() ? "Male" : (femaleBtn.isSelected() ? "Female" : "Not Selected");

            StringBuilder skills = new StringBuilder();
            if (javaSkill.isSelected()) skills.append("Java ");
            if (pythonSkill.isSelected()) skills.append("Python ");
            if (skills.length() == 0) skills.append("None");

            outputArea.setText("------ Student Details ------\n");
            outputArea.append("USN: " + usn + "\n");
            outputArea.append("Name: " + name + "\n");
            outputArea.append("Branch: " + branch + "\n");
            outputArea.append("Gender: " + gender + "\n");
            outputArea.append("Skills: " + skills.toString() + "\n");
        } else if (e.getSource() == clearBtn) {
            usnField.setText("");
            nameField.setText("");
            branchBox.setSelectedIndex(0);
            maleBtn.setSelected(false);
            femaleBtn.setSelected(false);
            javaSkill.setSelected(false);
            pythonSkill.setSelected(false);
            outputArea.setText("");
        }
    }

    public static void main(String[] args) {
        new StudentRegistrationForm();
    }
}
