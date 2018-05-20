package com.company;

import java.io.IOException;
import java.util.ArrayList;

import static com.company.SimpleRegression.getRawValues;

public class Main {

    public static void main(String[] args) {

        //TODO: hardcode file location here
        String fileLocation = "C:\\Users\\Heather\\Documents\\Repositories\\Simple-Regression\\data\\fire and theft in chicago.txt";

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


        //perform regression, get errors
        SimpleRegression.getErrors(data);


    }
}
