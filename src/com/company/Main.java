package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(mainMenu(scanner));

/*        try {
            String data = new String(Files.readAllBytes(Paths.get("word-test.txt")));
            String[] wordsArray = data.split("\\W+");
        } catch (IOException e) {
            System.out.println("No such file");
            choise = 4;
        }*/


        while (true){
            int choise=mainMenu(scanner);
            if (choise == 1){

            }else if (choise == 2){
                System.out.println("NO");
                enterStudents();
            }else if (choise == 3){

            }else if (choise == 4){
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

    public static void enterStudents() {
        System.out.println("YES");
        Scanner details = new Scanner(System.in);
        List<Student> studentDetails = new ArrayList<>();

        while (true) {
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
        for (Student student: studentDetailsDisplay) {
            System.out.println(student);
        }
    }
}
