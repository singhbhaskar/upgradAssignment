import java.util.*;
import java.io.*;

class Student{
    String name;
    double cgpa;
    int token;
    Student(String n, double c, int t){
        name = n;
        cgpa = c;
        token = t;
    }

    int compare(Student x){
        if(this.cgpa > x.cgpa)
            return 1;
        else if(this.cgpa < x.cgpa)
            return -1;
        else{
            int temp = this.name.compareTo(x.name);
            if(temp > 0)
                return -1;
            else if(temp < 0)
                return 1;
            else{
                if(this.token > x.token)
                    return 1;
                else
                    return -1;
            }
            
        }
    }

    void printName(){
        System.out.print("\n" + name);
    }

}

class Queue{
    public static void main(String args[])throws IOException{
        // Creating List of class Student 
        LinkedList<Student> studentQueue = new LinkedList<Student>();

        // For More Information on LinkedList in java Check: https://www.geeksforgeeks.org/linked-list-in-java/ 

        // Linked List is used to implement the Priority Queue with Helper functions
        
        // int compare(Student x) : which will compare 2 Student Object and will return 1 if the calling Object has more
        // priority than the passed object or else -1 is returned.

        // void printName() : this function prints the name of the object calling it.

        Scanner in = new Scanner(System.in);
        
        String name, inputString; double cgpa; int token, noOfOperations, flag;

        noOfOperations = in.nextInt();
        for(int i=0; i < noOfOperations +1; i++){
            
            inputString = in.nextLine();      // Continuous Input Taken     

            String[] st = inputString.split(" "); // Split the Input String by delimeter " "
            if(inputString.equals("SERVED")){     // Check if Input is Served if so and Queue
                if(studentQueue.size() == 0)      // is not empty the Top Priority Element is
                    System.out.println("EMPTY");  // removed.
                else
                    studentQueue.removeFirst();
            }
            else if(st[0].equals("ENTER")){

                name = st[1];
                cgpa = Double.parseDouble(st[2]);
                token = Integer.parseInt(st[3]);
                Student stu = new Student(name, cgpa, token); // Created is New Object Using
                flag = 0;                                     // custom made Student Class
                
                // The new Object is Inserted to the Queue according to the Priority is
                // the Object. So Highest Priority object is at the Front and least Priority
                // is at the last. So to Serve all we need to do is to remove the First Element.
                
                for(int j=0; j<studentQueue.size(); j++){     
                    int res = studentQueue.listIterator(j).next().compare(stu);
                    if(res == -1){
                        flag = 1;
                        studentQueue.add(j, stu);
                        break;
                    }
                }
                // The Priority is least then the Object will be inserted to last of the Queue
                if(flag == 0)
                    studentQueue.add(stu);
            }
        }

        if(studentQueue.size() == 0){
            System.out.println("EMPTY");
        }
        else{
            for(int j=0; j<studentQueue.size(); j++){
                studentQueue.listIterator(j).next().printName();
            }
            System.out.println("");
        }

    }
}