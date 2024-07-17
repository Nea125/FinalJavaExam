import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Calculator extends JFrame implements ActionListener {

    private JTextField firstNumberField, secondNumberField, resultField;
    private JButton addButton, subtractButton, multiplyButton, divideButton, moduloButton, clearButton;

    public Calculator() {
        setTitle("Calculator");
        setLayout(new GridLayout(5, 2, 5, 5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel firstNumberLabel = new JLabel("First Number:");
        firstNumberField = new JTextField();
        
        JLabel secondNumberLabel = new JLabel("Second Number:");
        secondNumberField = new JTextField();
        
        JLabel resultLabel = new JLabel("Result:");
        resultField = new JTextField();
        resultField.setEditable(false);

        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        moduloButton = new JButton("%");
        clearButton = new JButton("Clear");

        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);
        moduloButton.addActionListener(this);
        clearButton.addActionListener(this);

        add(firstNumberLabel);
        add(firstNumberField);
        add(secondNumberLabel);
        add(secondNumberField);
        add(resultLabel);
        add(resultField);
        add(addButton);
        add(subtractButton);
        add(multiplyButton);
        add(divideButton);
        add(moduloButton);
        add(clearButton);

        setSize(500, 500);
        setVisible(true);
        setLayout(null);
        setLocationRelativeTo(null);
        setBackground(Color.gray);
        setTitle("Calculator");
        addWindowListener(new WindowAdapter() 
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                dispose();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(firstNumberField.getText());
            double num2 = Double.parseDouble(secondNumberField.getText());
            double result = 0;

            if (e.getSource() == addButton) {
                result = num1 + num2;
            } else if (e.getSource() == subtractButton) {
                result = num1 - num2;
            } else if (e.getSource() == multiplyButton) {
                result = num1 * num2;
            } else if (e.getSource() == divideButton) {
                result = num1 / num2;
            } else if (e.getSource() == moduloButton) {
                result = num1 % num2;
            } else if (e.getSource() == clearButton) {
                firstNumberField.setText("");
                secondNumberField.setText("");
                resultField.setText("");
                return;
            }

            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
