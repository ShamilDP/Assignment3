package com.company;

import java.io.*;
import java.util.List;

public class FileOperations {
    File csvFile = new File("studentLog.csv");
    String row;


    public void openFile() throws FileNotFoundException, IOException {
        String[] data = null;
        if (csvFile.isFile()) {
            try (BufferedReader csvReader = new BufferedReader(new FileReader("studentLog.csv"))) {
                while ((row = csvReader.readLine()) != null) {
                    data = row.split(",");
                    for (String rowItem : data) {
                        System.out.printf("|%10s ", rowItem);
                    }
                    System.out.print("\n");
                }
            }
        }

    }

    boolean checkOption=true;
    public void writeFile(List<List<String>> rows, boolean writeOption) throws IOException, FileNotFoundException {

        FileWriter csvWriter = new FileWriter("studentLog.csv", true);
        if (writeOption ^ checkOption) {
            csvWriter.append("\n\n\n");
            checkOption = writeOption;
        }
        csvWriter.append("Name");
        csvWriter.append(",");
        csvWriter.append("Maths");
        csvWriter.append(",");
        csvWriter.append("Science");
        csvWriter.append(",");
        csvWriter.append("English");
        csvWriter.append("\n");

        for (List<String> rowData : rows) {
            csvWriter.append(String.join(",", rowData));
            csvWriter.append("\n");
        }
        csvWriter.append("\n\n");
        csvWriter.flush();
        csvWriter.close();

    }

}