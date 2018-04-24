package com.company;

import java.io.IOException;
import java.util.ArrayList;

import static com.company.SimpleRegression.getRawValues;

public class Main {

    public static void main(String[] args) {

        //TODO: hardcode file location here
        String fileLocation = "C:\\Users\\Heather\\Documents\\Repositories\\Simple-Regression\\data\\auto insurance in sweden.txt";

        //data from filelocation
        ArrayList<double[]> data = null;

        //process file
        try {
            data = SimpleRegression.getRawValues(fileLocation);
        }
        catch(IOException e){
            System.err.println("File not read: " + e.getMessage());
        }
        catch(java.text.ParseException e){
            System.err.println("File not parsed: " + e.getMessage());
        }

        //save first item for testing
        double[] testPoint = data.get(0);
        System.out.println("Test Point: " + Double.toString(testPoint[0]) + " " + Double.toString(testPoint[1]));

        //remove first item from training dataset
        double[] trainingData = data.remove(0);
    }
}
