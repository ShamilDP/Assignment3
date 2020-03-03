package com.company;

public class Student {
    private String name;
    private int mathsMarks;
    private int scienceMarks;
    private int englishMarks;

    public Student(String name, int mathsMarks, int scienceMarks, int englishMarks) {
        this.name = name;
        this.mathsMarks = mathsMarks;
        this.scienceMarks = scienceMarks;
        this.englishMarks = englishMarks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMathsMarks() {
        return mathsMarks;
    }

    public void setMathsMarks(int mathsMarks) {
        this.mathsMarks = mathsMarks;
    }

    public int getScienceMarks() {
        return scienceMarks;
    }

    public void setScienceMarks(int scienceMarks) {
        this.scienceMarks = scienceMarks;
    }

    public int getEnglishMarks() {
        return englishMarks;
    }

    public void setEnglishMarks(int englishMarks) {
        this.englishMarks = englishMarks;
    }

    public double calculateAverage() {
        return ((mathsMarks + scienceMarks + englishMarks) / 3.0);
    }

    public static String calculateGrade(double averageData) {
        if (averageData >= 85) return "A";
        else if ((averageData >= 75) && (85 > averageData)) return "B";
        else if ((averageData >= 65) && (75 > averageData)) return "C";
        else if ((averageData >= 55) && (65 > averageData)) return "D";
        else return "F";
    }

    @Override
    public String toString() {
        return "---------------------------------------------------------------\n" +

                "Name:   \t" + name + "\n" +
                "Maths:  \t" + mathsMarks + "\n" +
                "Science \t" + scienceMarks + "\n" +
                "English \t" + englishMarks + "\n" +
                "Average \t" + calculateAverage() + "\n" +
                "Grade   \t" + calculateGrade(calculateAverage()) + "\n" +
                '\n';
    }
}
