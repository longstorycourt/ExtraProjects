package GroupGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class groupgen extends Frame implements ActionListener {
    JLabel lbname = new JLabel();
    Label label;
    Button btnGenerate;
    Button btnreset;
    JComboBox cbgroup;
    TextField txtnumofgp = new TextField();
    TextField txtmeneachgp = new TextField();
    TextField result;
    JPanel panel;
    static  int newIndex, groupNumber, memberNumber;
    groupgen(){
        //numberofgroup
        label = new Label("Number of Group");
        designLabel(label,500,50,Color.black);
        add(label);
        designTextFeild(txtnumofgp,800,50,Color.black);
        add(txtnumofgp);
        //Member of student in group
        label = new Label("Number of student");
        designLabel(label,500,120,Color.black);
        add(label);
        designTextFeild(txtmeneachgp,800,120,Color.black);
        add(txtmeneachgp);
        //Button
        btnGenerate = new Button("Generate");
        designButton(btnGenerate,500,new Color(123,234,12),Color.white);
        add(btnGenerate);
        btnreset = new Button("Reset");
        designButton(btnreset,800,new Color(123,234,12),Color.white);
        add(btnreset);
        //Group generated
//        label = new Label("Group Generated");
//        designLabel(label,500,260,Color.black);
//        add(label);
//        String[] group={"Group1","Group2","Group3","Group4","Group5","Group6","Group7","Group8","Group9","Group10"};
//        cbgroup=new JComboBox(group);
//        designTextFeild(cbgroup,800,260,Color.black);
//        add(cbgroup);
        //group display
        panel =new JPanel();
        panel.setBounds(500,330,700,400);
        add(panel);

        JTextArea result = new JTextArea(5, 20);
        result.setEditable(false);
        add(result);
        //background
        panel =new JPanel();
        panel.setBounds(0,0,400,1080);
        panel.setBackground(new Color(180, 88, 22));
        add(panel);

        setLayout(null);
        setSize(1920,1080);
        setTitle("Group Generater");
        setLocationRelativeTo(this);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnGenerate){
            int groupNumber=Integer.parseInt(txtnumofgp.getText());
            int memberNumber=Integer.parseInt(txtmeneachgp.getText());
            int k, c=0, c1 =0, c2, last;
            String newName;
            Random rand = new Random();
            java.util.List<String> students = new ArrayList<>(Arrays.asList( //38names
                    "Rick Grimes", "Michonne Grimes","Carl Grimes","Judith Grimes","Carol Peletier",
                    "Shane Walsh","Daryl Dixon","Maggie Rhee","Glenn Rhee","Negan Smith",
                    "Jake Peralta","Amy Santiago","Rosa Diaz","Terry Jeffords","Charles Boyles",
                    "Gina Lenetti","Alex Alvarez","Buck Robins","Celia St. James","Derick Morgan",
                    "Effie Trinket","Fred Durst","Georgia Hyland","Helena Troy","Isa Newton",
                    "John Kennedy","Kirsten Durst","Lola Gludini","Maureen Alastor","Nicole Bloom",
                    "Olivia Sui","Patrick Star","Quentin Tar","Rue Starter","Selene Knights",
                    "Thomas Brodie","Universe Solar","Vivienne Westworld"));

            java.util.List<String> newStudents = new ArrayList<>(); //store students in a new List with new Index
            java.util.List<String>[] group = new List[groupNumber];  //create groups

            for(int i = 0; i<groupNumber; i++){
                group[i] = new ArrayList<>();
            }

            //Assign new List
            // System.out.println(students.size());
            int stuSize = students.size();
            for(int i= 0; i<stuSize; i++){
                newIndex = rand.nextInt(students.size());
                newName = students.get(newIndex);
                // System.out.println(students.get(newIndex));
                newStudents.add(newName);
                // System.out.println(newStudents);
                students.remove(newIndex);
            }

            k = newStudents.size();
            c2= (memberNumber/2);
            // System.out.println(c2);
            for(int i = 0; i < groupNumber; i++){
                if(k >= memberNumber){
                    for(int j = 0; j < memberNumber; j++){
                        group[i].add(newStudents.get(c1));
                        newStudents.remove(c1);
                        k--;
                    }
                }
                else{
                    for(int j = c1; j<k; j++){
                        group[i].add(newStudents.get(c1));
                        newStudents.remove(c1);
                        k--;
                    }
                }
            }

            last = groupNumber-1;
            k = group[last].size();
            // System.out.println(group[last]);
            // System.out.println(k);
            if(group[last].size()<=c2){
                while(!group[last].isEmpty()){
                    for(int j = 0; j < k ; j++){
                        group[j].add(group[last].get(0));
                        group[last].remove(0);
                    }
                }
            }
            //System.out.println(group[0]);
            //Output each group
            for(int i = 0; i<groupNumber; i++){
                if(!group[i].isEmpty()){
                    System.out.print("Group "+ (i+1)+ ": \n");
                    for(String t : group[i])
                        System.out.println("+ " + t);

                }
            }
        }
        if (e.getSource()==btnreset){

        }
    }
    public void designButton(Button button, int x, Color background, Color Foreground){
        button.setBounds(x,190,150,40);
        button.setFont(new Font("",Font.BOLD,22));
        button.setBackground(background);
        button.setForeground(Foreground);
    }
    public void designLabel(Component component,int x, int y,Color foreground){
        component.setBounds(x,y,225,40);
        component.setForeground(foreground);
        component.setFont(new Font("",Font.BOLD,24));
    }
    public void designTextFeild(Component textfield,int x,int y,Color foreground){
        textfield.setBounds(x,y,225,40);
        textfield.setFont(new Font("",Font.PLAIN,24));
        textfield.setForeground(foreground);
    }

    public static void main(String[] args) {
        new groupgen();
    }
}
