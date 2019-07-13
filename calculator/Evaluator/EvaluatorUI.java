package Evaluator;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvaluatorUI extends JFrame implements ActionListener {

    private TextField txField = new TextField();
    private Panel buttonPanel = new Panel();

    // total of 20 buttons on the calculator,
    // numbered from left to right, top to bottom
    // bText[] array contains the text for corresponding buttons
    private static final String[] bText = {
        "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3",
        "*", "0", "^", "=", "/", "(", ")", "C", "CE"
    };

    /**
     * C  is for clear, clears entire expression
     * CE is for clear expression, clears last entry up until the last operator.
     */
    private Button[] buttons = new Button[bText.length];

    public static void main(String argv[]) {
        EvaluatorUI calc = new EvaluatorUI();
    }

    public EvaluatorUI() {
        setLayout(new BorderLayout());
        this.txField.setPreferredSize(new Dimension(600, 50));
        this.txField.setFont(new Font("Courier", Font.BOLD, 28));

        add(txField, BorderLayout.NORTH);
        txField.setEditable(false);

        add(buttonPanel, BorderLayout.CENTER);
        buttonPanel.setLayout(new GridLayout(5, 4));

        //create 20 buttons with corresponding text in bText[] array
        Button bt;
        for (int i = 0; i < EvaluatorUI.bText.length; i++) {
            bt = new Button(bText[i]);
            bt.setFont(new Font("Courier", Font.BOLD, 28));
            buttons[i] = bt;
        }

        //add buttons to button panel
        for (int i = 0; i < EvaluatorUI.bText.length; i++) {
            buttonPanel.add(buttons[i]);
        }

        //set up buttons to listen for mouse input
        for (int i = 0; i < EvaluatorUI.bText.length; i++) {
            buttons[i].addActionListener(this);
        }

        setTitle("Calculator");
        setSize(400, 400);
        setLocationByPlatform(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent button) {
        
        //initialize the button which is clicked.
        Button btn = (Button) button.getSource();
        
        //if button with text c is clicked. reset the textbar
        if(btn.getLabel().equals("C")){
            txField.setText("");
            return;
        }
        //if button with text ce is clicked. remove the last digit from expression
        if(btn.getLabel().equals("CE")){
            
            if(!txField.getText().isEmpty()){
            txField.setText(txField.getText().substring(0, txField.getText().length()-1));
            }
            return;
        }
        //any button other than equals adds its label to expression
        if(!btn.getLabel().equals("="))
        txField.setText(txField.getText()+""+btn.getLabel());
        else{
            
            //if equal button is pressed, create object of evaluator class
            Evaluator evaluator = new Evaluator();
            try{
                //sets the result of expression to text bar
                txField.setText(""+evaluator.eval(txField.getText()));
            }
            catch(Exception e){
                //if the expressoin is wrong. show error
                txField.setText("Incorrect expression");
            }
        }
    }
}
