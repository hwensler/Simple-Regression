package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class SimpleRegression {

    /**
     * takes a 2 column CSV file of doubles and returns an arraylist of xy pairs
     * @param file the location of the csv file
     * @return an arraylist of doubles from the csv file
     * @throws IOException
     */
    public static ArrayList<double[]> getRawValues(String file) throws IOException {

        //create reader to read file line by line
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;

        //all lines in the examples have two columns
        Integer columns = 2;

        //create an array to store data as pairs
        ArrayList<double[]> input = new ArrayList<double[]>();

        while((line = reader.readLine()) != null){
            //split line at the commas
            String values[] = line.split(",");

            //store as x and y values
            double x = Double.parseDouble(values[0]);
            double y = Double.parseDouble(values[1]);

            //add to the input array
            double[] coordinates = {x, y};
            input.add(coordinates);
        }

        return input;
    }



}

