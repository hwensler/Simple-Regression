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
                y = nf.parse(values[1]).doubleValue();
            }
            catch(Error e){
                System.err.println("Error processing y:" + e);
            }

            //add to the input array
            double[] coordinates = {x, y};
            System.out.println(Double.toString(coordinates[0]) + "  " + Double.toString(coordinates[1]));
            input.add(coordinates);
        }

        return input;
    }

    public static Array[] getErrors(ArrayList<double[]> data){
        Array[] errors = new Array[data.size()];

        //for every item in the data
        for(int i = 0; i < data.size(); i++){

            //save the current item as the training point
            double[] testPoint = data.get(i);
            System.out.println("Test Point" + " " + i + ": " + Double.toString(testPoint[0]) + " " + Double.toString(testPoint[1]));

            //remove the current item from the training dataset
            ArrayList<double[]> trainingData = data;
            trainingData.remove(i);

            double sumX = 0;
            double sumX2 = 0;
            double sumY = 0;
            double sumXTimesY = 0;

            //get sum x and y
            for (int j=0; j < trainingData.size(); j++){
                sumX += trainingData.get(j)[0];
                sumX2 += Math.pow(trainingData.get(j)[0], 2);
                sumY += trainingData.get(j)[1];
                sumXTimesY += trainingData.get(j)[0] * trainingData.get(j)[1];
            }

            //calculate slope beta
            double beta = (trainingData.size() - (sumX * sumY))/(trainingData.size()*sumX2 - Math.pow(sumX, 2));

            //calculate intercept alpha
            double alpha = (sumY - beta * sumX)/trainingData.size();

            //calculate error
            double ytest = beta*testPoint[0] + alpha;
            double error = Math.sqrt(Math.pow(testPoint[1] + ytest,2));

            //add it to the list
            System.out.println("Error " + i + ": " + error);
        }

        return errors;
    }



}

