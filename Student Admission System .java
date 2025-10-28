##College Admission Process
import java.util.Scanner;

class Admission {
    String name;
    int interMarks;
    int emcetRank;
    int jeePercent;
}

public class CollegeAdmission {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Admission a = new Admission();

        System.out.println("***************__Details of the Student__***************");
        System.out.print("Enter your name: ");
        a.name = sc.next();

        System.out.print("Enter Inter marks: ");
        a.interMarks = sc.nextInt();

        System.out.print("Enter EAMCET rank: ");
        a.emcetRank = sc.nextInt();

        System.out.print("Enter JEE percentage: ");
        a.jeePercent = sc.nextInt();

        System.out.println("\n\t\tDisplay the details");
        System.out.println("\t\t====================");
        System.out.println("Name of the student        : " + a.name);
        System.out.println("Inter marks of the student : " + a.interMarks);
        System.out.println("EAMCET rank of the student : " + a.emcetRank);
        System.out.println("JEE Mains % of the student : " + a.jeePercent);

        System.out.println("\n########### Enter your caste details ############");
        System.out.println("1. OC");
        System.out.println("2. BC");
        System.out.println("3. SC");
        System.out.println("4. ST");
        System.out.println("5. Minority");
        System.out.print("Enter your caste: ");
        int caste = sc.nextInt();

        switch (caste) {
            case 1 -> System.out.println("You have chosen OC");
            case 2 -> System.out.println("You have chosen BC");
            case 3 -> System.out.println("You have chosen SC");
            case 4 -> System.out.println("You have chosen ST");
            case 5 -> System.out.println("You have chosen Minority");
            default -> System.out.println("Invalid caste option!");
        }

        System.out.println("\n-----------------------------------------");
        System.out.println("Courses in the college:");
        System.out.println("-----------------------------------------");
        System.out.println("1. CSE");
        System.out.println("2. ECE");
        System.out.println("3. Civil");
        System.out.println("4. Mechanical");
        System.out.println("5. EEE");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        // Scholarship logic
        if ((a.interMarks >= 990 && a.interMarks <= 1000) || 
            (a.emcetRank > 1 && a.emcetRank < 999) || 
            (a.jeePercent > 97 && a.jeePercent <= 100)) {
            scholarship(choice, 100, sc);
        } else if ((a.interMarks >= 980 && a.interMarks <= 989) || 
                   (a.emcetRank > 999 && a.emcetRank < 1500) || 
                   (a.jeePercent > 95 && a.jeePercent <= 97)) {
            scholarship(choice, 70, sc);
        } else if ((a.interMarks >= 970 && a.interMarks <= 979) || 
                   (a.emcetRank > 1500 && a.emcetRank < 30000) || 
                   (a.jeePercent > 90 && a.jeePercent <= 95)) {
            scholarship(choice, 50, sc);
        } else if ((a.interMarks >= 960 && a.interMarks <= 969) || 
                   (a.emcetRank > 30000 && a.emcetRank < 50000) || 
                   (a.jeePercent > 85 && a.jeePercent <= 90)) {
            scholarship(choice, 40, sc);
        } else if ((a.interMarks >= 940 && a.interMarks <= 959) || 
                   (a.emcetRank > 50000 && a.emcetRank < 80000) || 
                   (a.jeePercent > 80 && a.jeePercent <= 85)) {
            scholarship(choice, 30, sc);
        } else if ((a.interMarks >= 920 && a.interMarks <= 939) || 
                   (a.emcetRank > 80000 && a.emcetRank < 100000) || 
                   (a.jeePercent > 75 && a.jeePercent <= 80)) {
            scholarship(choice, 25, sc);
        } else if ((a.interMarks >= 850 && a.interMarks <= 919) || 
                   (a.emcetRank > 100000 && a.emcetRank < 150000) || 
                   (a.jeePercent > 60 && a.jeePercent <= 75)) {
            scholarship(choice, 15, sc);
        } else {
            scholarship(choice, 5, sc);
        }

        System.out.println("\n**************************************************************");
        System.out.println("\t\t************__NOTE__************");
        System.out.println("Scholarship is applicable only on Tuition Fee");
        System.out.println("Tuition Fee   : 1,12,500/- Per semester");
        System.out.println("Other Fee     : 12,150/-");
        System.out.println("Additional 10,000 for Specialization");
        System.out.println("Application Fee: 1,000/-");
        System.out.println("Enrollment Fee : 5,000/-");
        System.out.println("****************************************************************");

        sc.close();
    }

    static void scholarship(int choice, int percent, Scanner sc) {
        int baseFee = 112500;
        double finalFee = baseFee * (1 - percent / 100.0);

        System.out.println("\nYou will get a scholarship of " + percent + "%");

        switch (choice) {
            case 1 -> subCourse("CSE", finalFee, sc);
            case 2 -> subCourse("ECE", finalFee, sc);
            case 3 -> System.out.println("You have chosen Civil\nFee per semester: " + (int) finalFee);
            case 4 -> System.out.println("You have chosen Mechanical\nFee per semester: " + (int) finalFee);
            case 5 -> System.out.println("You have chosen EEE\nFee per semester: " + (int) finalFee);
            default -> System.out.println("Invalid course choice!");
        }
    }

    static void subCourse(String branch, double fee, Scanner sc) {
        System.out.println("\nYou have chosen " + branch);
        System.out.println("Select sub course:");
        System.out.println("1. Data Science");
        System.out.println("2. AIML");
        System.out.println("3. General " + branch);
        System.out.print("Enter your sub course: ");
        int sub = sc.nextInt();

        String subCourseName = switch (sub) {
            case 1 -> "Data Science";
            case 2 -> "AIML";
            case 3 -> "General " + branch;
            default -> "Invalid";
        };

        System.out.println("You have chosen: " + subCourseName);
        System.out.println("Fee per semester: " + (int) fee);
    }
}
