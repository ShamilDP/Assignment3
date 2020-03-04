package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HandleStudentsDetails {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<Student> studentDetails = new ArrayList<>();
        List<List<String>> studentDetailsToFile = new ArrayList<>();
        // FileOperations fileOperations = new FileOperations();

        while (true) {
            int choise = mainMenu(scanner);
            if (choise == 1) {
                (new FileOperations()).openFile();
            } else if (choise == 2) {
                enterStudents(new FileOperations(), studentDetails, studentDetailsToFile, true);
            } else if (choise == 3) {
                enterStudents(new FileOperations(), studentDetails, studentDetailsToFile, false);
            } else if (choise == 4) {
                break;
            }
        }

    }

    public static int mainMenu(Scanner scan) {
        System.out.println("-------------------------");
        System.out.println("1) Load Previous Data");
        System.out.println("2) Add more data ");
        System.out.println("3) Create new data set");
        System.out.println("4) Exit");
        System.out.println("-------------------------");


        String userOption = "";
        while (!checkInputIsNumber(userOption)) {
            System.out.println("Enter your choise: ");
            userOption = scan.nextLine();
        }
        return Integer.parseInt(userOption);
    }

    public static boolean checkInputIsNumber(String input) {
        if (input.matches("-?\\d+(\\.\\d+)?")) {
            int choise = Integer.parseInt(input);
            return (choise >= 1) && (choise <= 4);
        } else return false;
    }

    public static void enterStudents(FileOperations fileOperations, List<Student> getStudentDetails, List<List<String>> getStudentDetailsToFile, boolean option2) {
        Scanner details = new Scanner(System.in);
        List<Student> studentDetails = null;
        List<List<String>> studentDetailsToFile = null;
        if (option2) {
            System.out.println("Adding to the previous list");
            studentDetails = getStudentDetails;
            studentDetailsToFile = getStudentDetailsToFile;
        } else {
            System.out.println("Adding to the new list");
            studentDetails = new ArrayList<>();
            studentDetailsToFile = new ArrayList<>();
        }
        // List<List<String>> studentDetailsToFile = new ArrayList<>();

        while (true) {
            try {
                System.out.print("Enter your name: (Exit-END)\n");
                String studentName = details.nextLine();
                if (studentName.equals("END")) {
                    System.out.println("Thank you, Come again");
                    showUpdate(studentDetails);
                    break;
                }

                System.out.println("Enter Maths Marks: ");
                int mathsMarks = getMarkFrom(details);

                System.out.println("Enter Science Marks: ");
                int scienceMarks = getMarkFrom(details);

                System.out.println("Enter English Marks: ");
                int englishMarks = getMarkFrom(details);

                studentDetails.add(new Student(studentName, mathsMarks, scienceMarks, englishMarks));
                studentDetailsToFile.add(Arrays.asList(studentName, Integer.toString(mathsMarks), Integer.toString(scienceMarks), Integer.toString(englishMarks)));
                if (option2) {
                    fileOperations.writeFile(studentDetailsToFile, false);
                } else {
                    fileOperations.writeFile(studentDetailsToFile, true);
                }
            } catch (IOException ex) {
                Logger.getLogger(HandleStudentsDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private static int getMarkFrom(Scanner scanner) {
        String enteredMark;
        int mark = Integer.MIN_VALUE;
        while ((enteredMark = scanner.nextLine()) != null) {
            try {
                mark = Integer.parseInt(enteredMark);
                if (isValidMark(Integer.parseInt(enteredMark))) {
                    break;
                } else {
                    System.out.println("Please Enter Valid Mark ");
                }
            } catch (NumberFormatException ignored) {
            }
        }
        return mark;
    }

    private static boolean isValidMark(int mark) {
        return (mark >= 0) && (mark <= 100);
    }

    private static void showUpdate(List<Student> studentDetailsDisplay) {
        for (Student student : studentDetailsDisplay) {
            System.out.println(student);
        }
    }
}
