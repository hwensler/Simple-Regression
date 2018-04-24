package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;

public class SimpleRegression {

    /**
     * takes a 2 column CSV file of doubles and returns an arraylist of xy pairs
     * @param file the location of the csv file
     * @return an arraylist of doubles from the csv file
     * @throws IOException
     */
    public static ArrayList<double[]> getRawValues(String file) throws IOException, ParseException {

        System.out.println("Starting getRawValues");

        NumberFormat nf = NumberFormat.getInstance();

        //create reader to read file line by line
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;

        //all lines in the examples have two columns
        Integer columns = 2;

        //create an array to store data as pairs
        ArrayList<double[]> input = new ArrayList<double[]>();

        while((line = reader.readLine()) != null){

            //split line at the spaces
            String values[] = line.split("\\s+");
            
            //eliminate any white space
            values[0].replaceAll("\\s+","");
            values[1].replaceAll("\\s+","");

            //initialize x and y as ridiculous numbers
            double x = 99999999999.99;
            double y = 99999999999.99;

            //store as x and y values
            try {
                x = nf.parse(values[0]).doubleValue();
            }
            catch(Error e){
                System.err.println("Error processing x:" + e);
            }

            try {
                y = nf.parse(values[0]).doubleValue();
            }
            catch(Error e){
                System.err.println("Error processing y:" + e);
            }

            //add to the input array
            double[] coordinates = {x, y};
            input.add(coordinates);
        }

        return input;
    }



}

