package com.cdg.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputManager {


    public List<List<Integer>> readLevelLayout(String filePath) {
        List<List<Integer>> levelLayoutList = new ArrayList<>();

        try {
            // Open file.
            File file = new File(filePath);
            Scanner reader = new Scanner(file);
            // Go through file lines.
            while (reader.hasNextLine()) {
                // Current line.
                String line = reader.nextLine();

                // Turn line into a list.
                List<String> lineArrayListString = Arrays.asList(line.split(" "));
                List<Integer> lineArrayListInteger = lineArrayListString.stream().map(Integer::parseInt).collect(Collectors.toList());
                levelLayoutList.add(lineArrayListInteger);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }

        return levelLayoutList;
    }

    public void parseFile() {

    }
}
