package LuckyDraw;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LuckyDraw extends JFrame implements ActionListener{
    String winner= "";
    Random rand = new Random();
    JFrame frame;
    JLabel lbTitle = new JLabel("LuckyDraw");
    JLabel lblName = new JLabel("Name: ");
    JLabel lblPh = new JLabel("Phone Number: ");

    JTextField txtName = new JTextField(20);
    JTextField txtPh = new JTextField(20);

    JButton btnAdd = new JButton("Add");
    JButton btnDelete = new JButton("Delete");
    JButton btnStart = new JButton("Start");
    JButton btnStop = new JButton("Stop");

    JTextArea txtDisplay = new JTextArea("Please add name and phone number to be selected!\n Press Start to randomize! Press stop to pick a winner!");

    List listBallot = new List();

    JPanel pnlTitle = new JPanel();
    JPanel pnlInput = new JPanel(new GridLayout(2,2));
    JPanel pnlButton = new JPanel(new FlowLayout());
    JPanel pnlcontent = new JPanel();

    LuckyDraw(){
        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        pnlcontent.setLayout(new BoxLayout(pnlcontent, BoxLayout.Y_AXIS));

        pnlTitle.setLayout(new BoxLayout(pnlTitle, BoxLayout.Y_AXIS));
        lbTitle.setHorizontalAlignment(JLabel.CENTER);
        lbTitle.setFont(new Font("Helvetica", Font.BOLD, 23));
        pnlTitle.add(lbTitle);

        pnlInput.add(lblName);
        pnlInput.add(txtName);
        pnlInput.add(lblPh);
        pnlInput.add(txtPh);
        pnlTitle.add(pnlInput);

        pnlcontent.add(pnlTitle);

        pnlButton.add(btnAdd);
        pnlButton.add(btnDelete);
        pnlButton.add(btnStart);
        pnlButton.add(btnStop);

        txtDisplay.setAlignmentX(CENTER_ALIGNMENT);
        txtDisplay.setFont(new Font("Arial", Font.ITALIC, 18));
        txtDisplay.setBackground(Color.YELLOW);
        
        pnlcontent.add(pnlButton);
        pnlcontent.add(txtDisplay);
        pnlcontent.add(listBallot);


        txtName.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke){
                if(ke.getKeyCode()== KeyEvent.VK_ENTER){
                    txtPh.requestFocus();
                } 
            }
        });
        txtPh.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke){
                if(ke.getKeyCode()== KeyEvent.VK_ENTER){
                    String str = "";
                    str = txtName.getText() + "     " + txtPh.getText();
                    listBallot.add(str);
                    txtName.setText("");
                    txtPh.setText("");
                    txtName.requestFocus();
                } 
            }
        });
        btnAdd.addActionListener(this);
        btnDelete.addActionListener(this);
        btnStart.addActionListener(this);
        btnStop.addActionListener(this);

        frame.add(pnlcontent, BorderLayout.NORTH);

        frame.setTitle("LuckyDraw");
        frame.setSize(500, 500);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == btnAdd){
            String str = "";
            str = txtName.getText() + "     " + txtPh.getText();
            listBallot.add(str);
            txtName.setText("");
            txtPh.setText("");
            txtName.requestFocus();
        }
        if(ae.getSource()==btnDelete){
            int index= listBallot.getSelectedIndex();
            listBallot.remove(index);
        }
        if(ae.getSource() == btnStart){
            txtDisplay.setText("A winner is being selected...! Press Stop to pick!");
            int nList = listBallot.getItemCount();
            int randomIndex = rand.nextInt(nList);
            winner = listBallot.getItem(randomIndex);
        }
        if(ae.getSource()==btnStop){
            String msg = "Congratulations to "+ winner + "!\n You have won!";
            JOptionPane.showMessageDialog(null, msg);
            txtDisplay.setText(msg);
        }
    }
    
    public static void main(String[] args) throws Exception {
        new LuckyDraw();
    }
}

