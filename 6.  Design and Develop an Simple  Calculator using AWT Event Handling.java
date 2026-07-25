import java.awt.*;
import java.awt.event.*;
public class SimpleCalculator extends Frame {
    TextField t1, t2, t3;
    Button add, sub, mul, div;
    public SimpleCalculator() {
        setTitle("Simple Calculator");
        setSize(300, 250);
        setLayout(new FlowLayout());
        add(new Label("First Number"));
        t1 = new TextField(15);
        add(t1);
        add(new Label("Second Number"));
        t2 = new TextField(15);
        add(t2);
        add = new Button("Add");
        sub = new Button("Subtract");
        mul = new Button("Multiply");
        div = new Button("Divide");
        add(add);
        add(sub);
        add(mul);
        add(div);
        add(new Label("Result"));
        t3 = new TextField(15);
        t3.setEditable(false);
        add(t3);
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate('+');
            }
        });
        sub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate('-');
            }
        });
        mul.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate('*');
            }
        });
        div.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate('/');
            }
        });
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setVisible(true);
    }
    private void calculate(char op) {
        try {
            double a = Double.parseDouble(t1.getText().trim());
            double b = Double.parseDouble(t2.getText().trim());
            switch (op) {
                case '+': t3.setText(String.valueOf(a + b)); break;
                case '-': t3.setText(String.valueOf(a - b)); break;
                case '*': t3.setText(String.valueOf(a * b)); break;
                case '/': 
                    if (b == 0) {
                        t3.setText("Cannot divide by zero");
                    } else {
                        t3.setText(String.valueOf(a / b));
                    }
                    break;
            }
        } catch (NumberFormatException ex) {
            t3.setText("Invalid Input");
        }
    }
    public static void main(String[] args) {
        if (GraphicsEnvironment.isHeadless()) {
            System.out.println("Code compiled successfully!");
            System.out.println("Note: Online compilers do not support AWT/Swing GUI popups directly.");
            System.out.println("To see the window, run this file locally on your machine using 'java SimpleCalculator'.");
        } else {
            new SimpleCalculator();
        }
    }
}
