package guicalculator;


/*
 * Simple calculator that performs standard operations of +, -, x, /, =, C and
 * incorporates standard memory functions of m+, m-, mc, mr
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The calculator panel
 * @author 
 */
public class CalculatorPanel extends JPanel {
    /**
     * Define instance variables
     */
    int CALC_WIDTH = 250;
    int CALC_HEIGHT = 235;
    JLabel result;
    JButton[] numbers;
    JButton[] operators;
    float num1, num2;
    char op;
    boolean opCheck;
    float memory;
    boolean memPress;

    /**
     * Constructor for the Calculator Panel: Sets up the GUI
     */
    public CalculatorPanel() {
        setBackground(Color.lightGray);
        setPreferredSize(new Dimension(CALC_WIDTH, CALC_HEIGHT));
        numbers = new JButton[10];
        operators = new JButton[10];
        String[] ops = {"*", "+", "/", "=", "C", "-", "mc", "m+", "m-", "mr"};
        opCheck = false;
        num1 = num2 = 0;
        memory = 0;
        memPress = false;

        result = new JLabel("0", JLabel.RIGHT);
        result.setPreferredSize(new Dimension(CALC_WIDTH - 5, 50));

        result.setBackground(Color.white);
        result.setOpaque(true);

        Font font = new Font("Helvetica", Font.BOLD, 40);
        result.setFont(font);
        add(result);

        Font buttonFont = new Font("Helvetica", Font.BOLD, 15);

        for (int i = 0; i < 10; i++) {
            JButton button = new JButton(Integer.toString(i));
            button.setFont(buttonFont);
            button.setPreferredSize(new Dimension(55, 30));
            button.addActionListener(new ButtonListener());
            button.setForeground(Color.red);
            numbers[i] = button;

            JButton button2 = new JButton(ops[i]);
            button2.setFont(buttonFont);
            button2.setPreferredSize(new Dimension(55, 30));
            button2.addActionListener(new ButtonListener());
            if ((i != 4)) {
                button2.setForeground(Color.blue);
            } else {
                button2.setForeground(Color.red);
            }
            operators[i] = button2;
        }


        this.add(operators[6]);
        this.add(operators[7]);
        this.add(operators[8]);
        this.add(operators[9]);
        this.add(numbers[7]);
        this.add(numbers[8]);
        this.add(numbers[9]);
        this.add(operators[0]);
        this.add(numbers[4]);
        this.add(numbers[5]);
        this.add(numbers[6]);
        this.add(operators[1]);
        this.add(numbers[1]);
        this.add(numbers[2]);
        this.add(numbers[3]);
        this.add(operators[2]);
        this.add(numbers[0]);
        this.add(operators[3]);
        this.add(operators[4]);
        this.add(operators[5]);


    }

    /**
     * Define the calculate method
     * Perform the calculations on <i>num1</i> and <i>num2</i> depending on
     * the operation <i>op</i>
     * @param op the operation
     * @param num1 the first number of the calculation
     * @param num2 the second number of the calculation
     * @return the result of the calculation
     */
    private float calculate(char op, float num1, float num2){
        switch(op) {
            case '+' -> {
                return num1 + num2;
            }
            case '-' -> {
                return num1 - num2;
            }
            case '*' -> {
                return num1 * num2;
            }
            case '/' -> {
                return num1 / num2;
            }
            default -> {
                return 0;
            }
        }
    }

    /**
     * Define the private inner class ButtonListener
     */

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String action = e.getActionCommand();

            switch (action){
                case "0" -> {
                    if (num1 == Float.parseFloat(result.getText())){
                        result.setText(action);
                    }
                    else if (!result.getText().equals("0")) {
                        result.setText(result.getText() + action);
                    }
                    else if (memPress) {
                        result.setText(action);
                        memPress = false;
                    }
                    else {
                        result.setText(action);
                    }
                }
                case "1", "2", "3", "4", "5", "6", "7", "8", "9" -> {
                    if (result.getText().equals("0")){
                        result.setText(action);
                    } else if (num1 == Float.parseFloat(result.getText())){
                        result.setText(action);
                    } else if (memPress){
                        result.setText(action);
                        memPress = false;
                    }
                    else {
                        result.setText(result.getText() + action);
                    }
                }
                case "+", "-", "*", "/" -> {
                    num1 = Float.parseFloat(result.getText());
                    opCheck = true;
                    op = action.charAt(0);
                }
                case "=" -> {
                    num2 = Float.parseFloat(result.getText());
                    result.setText(Float.toString(calculate(op, num1, num2)));
                    opCheck = false;
                }
                case "C" -> {
                    result.setText("0");
                    num1 = num2 = 0;
                    opCheck = false;
                }
                case "m+" -> {
                    memory = memory + Float.parseFloat(result.getText());
                    memPress = true;
                }
                case "m-" -> {
                    memory = memory - Float.parseFloat(result.getText());
                    memPress = true;
                }
                case "mr" -> {
                    result.setText(Float.toString(memory));
                }
                case "mc" -> {
                    memory = 0;
                    memPress = true;
                }

            }

        }
    }
}
