package GroupGenerator;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;

public class groupGenerateur extends JFrame implements ActionListener{
    Random rand = new Random();
    ArrayList<String> alistName;
    ArrayList<String> [] group;//create groups

    JFrame frame;

    JLabel lblName = new JLabel("Name List");
    // java.awt.List nameList = new List(30, false);
    JScrollPane namesp;
    JList<String> listName;
    ListModel<String> lstModel;

    JLabel lblGrNum = new JLabel("Number of Group(s): ");
    JLabel lblMemNum = new JLabel("Number of Member(s): ");
    JLabel lblChoice = new JLabel("Group(s): ");

    Choice chGroup = new Choice();
    JPanel pnlChoice = new JPanel();

    JTextField txtGrNum = new JTextField(20);
    JTextField txtMemNum = new JTextField(20);

    JButton btnGenerate = new JButton("Generate");
    JButton btnShow = new JButton("Show");
    JButton btnRestart = new JButton("Restart");

    JTextArea txtInstr = new JTextArea("Fill in the number of group(s) and member(s). Then press Generate to start.");
    JTextArea txtGroup = new JTextArea();

    JPanel pnlName = new JPanel();

    JPanel pnlGroup = new JPanel(new FlowLayout(FlowLayout.LEADING, 5, 5));
    JPanel pnlMember = new JPanel(new FlowLayout(FlowLayout.LEADING, 5, 5));
    JPanel pnlGr = new JPanel(new FlowLayout(FlowLayout.LEADING, 5, 5));
    JPanel pnlBtn = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));

    JPanel pnlOperate = new JPanel();

    JPanel pnlDisplay = new JPanel(new BorderLayout(-5, -5));
    JPanel pnlnewGr = new JPanel();


    groupGenerateur(String [] students){
        
        frame = new JFrame();

        frame.setLayout(new BorderLayout());

        pnlName.setLayout(new BoxLayout(pnlName, BoxLayout.Y_AXIS));
        pnlName.add(lblName);

        alistName = new ArrayList<>();
        for(String i: students)
            alistName.add(i);

        listName = new JList<>(students);
        listName.setVisibleRowCount(30);
        //listName.addListSelectionListener(this);
        namesp = new JScrollPane(listName);
        pnlName.add(lblName);
        pnlName.add(namesp);
        lstModel = listName.getModel();

        //Setting pnlGroup & pnlMember for input
        pnlGroup.add(lblGrNum);
        pnlGroup.add(txtGrNum);

        pnlMember.add(lblMemNum);
        pnlMember.add(txtMemNum);

        // chGroup.setFont(new Font("Arial", Font.PLAIN, 14)); 
        // pnlChoice.setPreferredSize(chGroup.getPreferredSize()); 
        pnlChoice.add(chGroup);

        pnlGr.add(lblChoice);
        pnlGr.add(pnlChoice); 

        pnlBtn.add(btnGenerate);
        pnlBtn.add(btnShow);
        pnlBtn.add(btnRestart);

        pnlOperate.setLayout(new BoxLayout(pnlOperate, BoxLayout.Y_AXIS));
        pnlOperate.add(pnlGroup);
        pnlOperate.add(pnlMember);
        pnlOperate.add(pnlGr);
        pnlOperate.add(pnlBtn);
    
        btnGenerate.addActionListener(this);
        btnRestart.addActionListener(this);

        pnlnewGr.setLayout(new BoxLayout(pnlnewGr, BoxLayout.Y_AXIS));
        txtInstr.setEditable(false);
        txtGroup.setEditable(false);
        pnlnewGr.add(txtInstr);
        pnlnewGr.setBackground(Color.CYAN);
        pnlnewGr.add(txtGroup);

        // pnlDisplay.setLayout(new BoxLayout(pnlDisplay, BoxLayout.Y_AXIS));
        pnlDisplay.add(pnlOperate,BorderLayout.NORTH);
        pnlDisplay.add(pnlnewGr, BorderLayout.CENTER);

        frame.add(pnlName, BorderLayout.WEST);
        frame.add(pnlDisplay, BorderLayout.CENTER);
        frame.setSize(500, 500);
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==btnGenerate){
            groupDivision(alistName);
            for(int i=0; i <group.length; i++)
                chGroup.add("Group "+ (i+1));
        }
        if(ae.getSource()==btnShow){
            int selection = chGroup.getSelectedIndex();
            txtGroup.setText("Group" + (selection + 1)+"\n");
            for(String i: group[selection]){
                txtGroup.append(i);
                txtGroup.append("\n");
            }
        }
        if(ae.getSource()==btnRestart){
            txtGrNum.setText("");
            txtMemNum.setText("");
            txtGrNum.requestFocus();
        }
    }
    public void groupDivision(ArrayList<String> students){
        int newStudentSize, lastGroupSize, newStuIndex =0, halfaGroup;
        int newIndex;
        int groupNumber = Integer.parseInt(txtGrNum.getText());
        int memberNumber = Integer.parseInt(txtMemNum.getText());
        
        String newName;
        ArrayList<String> newStudents = new ArrayList<>(); //store students in a new List with new Index
        group = new ArrayList[groupNumber];
        for(int i = 0; i<groupNumber; i++){
            group[i] = new ArrayList<>();
        }

        //Assign new List
        int stuSize = students.size();
        for(int i= 0; i<stuSize; i++){
            newIndex = rand.nextInt(students.size());
            newName = students.get(newIndex);
            newStudents.add(newName);
            students.remove(newIndex);
        }
        newStudentSize = newStudents.size();
        halfaGroup = (memberNumber/2);
        for(int i = 0; i < groupNumber; i++){
            if(newStudentSize >= memberNumber){
                for(int j = 0; j < memberNumber; j++){
                    group[i].add(newStudents.get(newStuIndex));
                    newStudents.remove(newStuIndex);
                    newStudentSize--;
                }
            }
            else{
                for(int j = newStuIndex ; j<newStudentSize; j++){
                    group[i].add(newStudents.get(newStuIndex));
                    newStudents.remove(newStuIndex);
                    newStudentSize--;
                }
            }
        }  

        int lastGroup = groupNumber-1;
        lastGroupSize = group[lastGroup].size();
        if(group[lastGroup].size() < halfaGroup){
            while(!group[lastGroup].isEmpty()){
                for(int j = 0; j < lastGroupSize ; j++){
                    group[j].add(group[lastGroup].get(0));
                    group[lastGroup].remove(0);
                }
            }  
        }
        for(int i = 0; i<groupNumber; i++){
            if(!group[i].isEmpty()){
                System.out.print("Group "+ (i+1)+ ": \n");
                for(String t : group[i])
                    System.out.println("+ " + t);
            }   
        }
    }    

    public static void main(String[] args) {
        String [] students = { //38names
            "Rick Grimes", "Michonne Grimes","Carl Grimes","Judith Grimes","Carol Peletier",
                "Shane Walsh","Daryl Dixon","Maggie Rhee","Glenn Rhee","Negan Smith",
                "Jake Peralta","Amy Santiago","Rosa Diaz","Terry Jeffords","Charles Boyles",
                "Gina Lenetti","Alex Alvarez","Buck Robins","Celia St. James","Derek Morgan",
                "Effie Trinket","Fred Durst","Georgia Hyland","Helena Troy","Isa Newton",
                "John Kennedy","Kirsten Durst","Lola Gludini","Maureen Alastor","Nicole Bloom",
                "Olivia Sui","Patrick Star","Quentin Tar","Rue Starter","Selene Knights",
                "Thomas Brodie","Universe Solar","Vivienne Westworld"};
        new groupGenerateur(students);
    }
}
