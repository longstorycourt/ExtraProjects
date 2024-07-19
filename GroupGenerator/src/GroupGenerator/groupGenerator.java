package GroupGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class groupGenerator{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int k, c=0, c1 =0, c2, last;
        int newIndex, groupNumber, memberNumber;
        String newName;
        Random rand = new Random();
        List<String> students = new ArrayList<>(Arrays.asList( //38names
            "Rick Grimes", "Michonne Grimes","Carl Grimes","Judith Grimes","Carol Peletier",
                "Shane Walsh","Daryl Dixon","Maggie Rhee","Glenn Rhee","Negan Smith",
                "Jake Peralta","Amy Santiago","Rosa Diaz","Terry Jeffords","Charles Boyles",
                "Gina Lenetti","Alex Alvarez","Buck Robins","Celia St. James","Derick Morgan",
                "Effie Trinket","Fred Durst","Georgia Hyland","Helena Troy","Isa Newton",
                "John Kennedy","Kirsten Durst","Lola Gludini","Maureen Alastor","Nicole Bloom",
                "Olivia Sui","Patrick Star","Quentin Tar","Rue Starter","Selene Knights",
                "Thomas Brodie","Universe Solar","Vivienne Westworld"));

        System.out.print("Enter the number of group: "); groupNumber = scan.nextInt();
        System.out.print("Enter the number of members per group: "); memberNumber = scan.nextInt();

        List<String> newStudents = new ArrayList<>(); //store students in a new List with new Index
        List<String> [] group = new List[groupNumber];  //create groups

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
        // System.out.println(newStudents.size());

        // for(String i: newStudents){
        //     System.out.println((c+1) +"/"+ i);
        //     c++;
        // }

        //Assign Groups from new List
        //*****TO-DO: lets not remove c1! so that we can regenerate *****
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
}