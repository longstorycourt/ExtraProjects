package studentBackground;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;

class studentInfo{
    String name, age, sex, interest;
    studentInfo(String n, String a, String s, String i ){
        name = n;
        age = a;
        sex = s;
        interest = i;
    }
    String getInfo(){
        String studentInfo = "Name: "+ name+"\nAge: "+ age +"y/o\tSex: "+ sex + "\nMajor: Computer Science\t Year: 2\nInterest: "+interest+ "\n";
        return studentInfo;
    }
}

public class studentBackground extends JFrame implements ActionListener{
        JLabel lblTitle = new JLabel("GROUP 3 MEMBERS");
        JLabel [] lblImage = new JLabel[7];
        JTextArea [] txtSt = new JTextArea[7];
        JCheckBox [] jcbs = new JCheckBox[7]; 
        String [] stg = new String[7];
        ImageIcon [] imgs = new ImageIcon[7];

        JPanel pnlSelect = new JPanel();
        JPanel [] pnlInfo = new JPanel[7];
        JPanel pnlDisplay = new JPanel();
        JPanel pnlContent = new JPanel();
        public studentBackground(ArrayList<studentInfo> st){
            super("");
            
            for(int i = 0; i<st.size();i++){
                jcbs[i] = new JCheckBox(st.get(i).name);
                jcbs[i].addActionListener(this);
                txtSt[i] = new JTextArea();
                txtSt[i].setEditable(false);
                txtSt[i].setBackground(new Color(229,255, 204));
                jcbs[i].setBackground(Color.LIGHT_GRAY);
            } 

            imgs[0] = new ImageIcon("studentBackground\\Soklinda.jpg");
            imgs[1] = new ImageIcon("studentBackground\\Sathya.jpg");
            imgs[2] = new ImageIcon("studentBackground\\Kimlong.jpg");
            imgs[3] = new ImageIcon("studentBackground\\Bunleng.jpg");
            imgs[4] = new ImageIcon("studentBackground\\Kimhong.jpg");
            imgs[5] = new ImageIcon("studentBackground\\Pisal.jpg");
            imgs[6] = new ImageIcon("studentBackground\\Yut.jpg");

            for(int i = 0; i<st.size(); i++){
                lblImage[i]= new JLabel();
                lblImage[i].setIcon(imgs[i]);
            }

            for(int i =0; i<st.size(); i++){
                pnlInfo[i] = new JPanel(new FlowLayout(FlowLayout.LEFT));
                pnlInfo[i].add(lblImage[i]);
                pnlInfo[i].add(txtSt[i]);
                pnlInfo[i].setBackground(new Color(229,255, 204));
                pnlInfo[i].setVisible(false);
            }
            for(int i =0; i<st.size(); i++){
                stg[i] = st.get(i).getInfo();
                txtSt[i].setText(stg[i]);
            }
            
            lblTitle.setHorizontalAlignment(JLabel.CENTER);
            lblTitle.setFont(new Font("Helvetica", Font.BOLD, 18));
            pnlSelect.setLayout(new BoxLayout(pnlSelect, BoxLayout.Y_AXIS));
            pnlSelect.setBackground(Color.LIGHT_GRAY);
            pnlDisplay.setBackground(new Color(229,255, 204));
            pnlDisplay.setLayout(new BoxLayout(pnlDisplay, BoxLayout.Y_AXIS));
            pnlDisplay.setVisible(true);            

            pnlSelect.add(lblTitle);
            for(int i = 0; i<st.size();i++){
                pnlSelect.add(jcbs[i]);
            } 
            for(int i =0; i<st.size(); i++){
                pnlDisplay.add(pnlInfo[i]);
            }
            
            setLayout(new BorderLayout());
            add(pnlSelect, BorderLayout.WEST);
            add(pnlDisplay, BorderLayout.CENTER);
            setSize(500,500);
            setVisible(true);
            setLocationRelativeTo(null);
        }
        public void actionPerformed(ActionEvent ae){
            if(jcbs[0].isSelected())
                pnlInfo[0].setVisible(true);
            else
                pnlInfo[0].setVisible(false);

            if(jcbs[1].isSelected())
                pnlInfo[1].setVisible(true);
            else
                pnlInfo[1].setVisible(false);

            if(jcbs[2].isSelected()){
                pnlInfo[2].setVisible(true);
            }
            else
                pnlInfo[2].setVisible(false);

            if(jcbs[3].isSelected()){
                pnlInfo[3].setVisible(true);
            }
            else
                pnlInfo[3].setVisible(false);

            if(jcbs[4].isSelected()){
                pnlInfo[4].setVisible(true);
            }
            else
                pnlInfo[4].setVisible(false);

            if(jcbs[5].isSelected()){
                pnlInfo[5].setVisible(true);
            }
            else
                pnlInfo[5].setVisible(false);
            if(jcbs[6].isSelected()){
                pnlInfo[6].setVisible(true);
                }
            else
                pnlInfo[6].setVisible(false);
        }
    public static void main(String[] args){
        ArrayList<studentInfo> students = new ArrayList<>();
        studentInfo st1 = new studentInfo("Pov Soklinda", "22", "F", "Reading, Writing");
        studentInfo st2 = new studentInfo("Moeun Sathya", "19", "F", "Reading, Cooking");
        studentInfo st3 = new studentInfo("Pov Kimlong", "20", "M", "Games, Music, movies");
        studentInfo st4 = new studentInfo("Meng Bunleng", "21", "M", "Football, music");
        studentInfo st5 = new studentInfo("Sreang Kimhong", "19", "M", "Games, music, movies");
        studentInfo st6 = new studentInfo("Meng Pisal", "20", "M", "Games");
        studentInfo st7 = new studentInfo("Mut Sopheakyut", "19", "M", "Games");

        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);
        students.add(st6);
        students.add(st7);

        new studentBackground(students);
    }
}
