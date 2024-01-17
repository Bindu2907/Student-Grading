import java.util.Scanner;
public class StudentGradingSystem1 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Welcome to the student Grading System");
        while(true){
            System.out.println("Enter student name:");
            String name=scanner.nextLine();

            System.out.println("Enter roll number: ");
            int rollNumber=scanner.nextInt();

            System.out.print("Enter the number of subjects: ");
            int numSubjects=scanner.nextInt();
 
            //input scores
            int[] subjectScore=new int[numSubjects];
            for(int i=0;i<numSubjects;i++){
                System.out.println("Enter score for Subject "+(i+1)+":");
                subjectScore[i]=scanner.nextInt();
                
            }
            //Calculate grade
            char overallGrade=calculateOverallGrade(subjectScore);
            
            //output
            displayResult(name,rollNumber,subjectScore,overallGrade);
            // Ask if the user wants to input details for another student
            System.out.print("Do you want to input details for another student? (yes/no): ");
            scanner.nextLine(); // Consume the newline character
            String choice = scanner.nextLine().toLowerCase();

            if (!choice.equals("yes")) {
                System.out.println("Exiting the program. Thank you!");
                break;
            }
        }
        scanner.close();
    }

    private static void displayResult(String name, int rollNumber, int[] subjectScores, char overallGrade) {
        System.out.println("\nResult for Student " + name + " (Roll Number: " + rollNumber + "):");
        System.out.println("Subject-wise scores:");

        for (int i = 0; i < subjectScores.length; i++) {
            System.out.println("Subject " + (i + 1) + ": " + subjectScores[i]);
        }

        System.out.println("Overall Grade: " + overallGrade + "\n");


    }

    private static char calculateOverallGrade(int[] subjectScores) {
        double averageScore = calculateAverage(subjectScores);

        // Define the grading scale
        if (averageScore >= 90) {
            return 'A';
        } else if (averageScore >= 80) {
            return 'B';
        } else if (averageScore >= 70) {
            return 'C';
        } else if (averageScore >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    private static double calculateAverage(int[] subjectScores) {
        int sum = 0;
        for (int score : subjectScores) {
            sum += score;
        }
        return (double) sum / subjectScores.length;
    }
}
