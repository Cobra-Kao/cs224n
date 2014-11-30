package cs224n.deep;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.*;
import java.util.*;

import org.ejml.data.*;
import org.ejml.simple.*;


import java.text.*;

public class BaselineModel {

    protected SimpleMatrix L, W, Wout;

    public int windowSize, wordSize, hiddenSize;
    
    private HashMap<String, String> wordNerMap;

    public BaselineModel(int _windowSize, int _hiddenSize, double _lr){
        //TODO
        wordNerMap = new HashMap<String, String>();
    }

    /**
     * Initializes the weights randomly.
     */
    public void initWeights(){
        //TODO
        // initialize with bias inside as the last column
        // W = SimpleMatrix...
        // U for the score
        // U = SimpleMatrix...
    }


    /**
     * Simplest SGD training
     */
    public void train(List<Datum> _trainData){
        // TODO
        for (Datum datum : _trainData) {
            wordNerMap.put(datum.word, datum.label);
        }
    }


    public void test(List<Datum> testData){
        // TODO
        try {
            PrintWriter writer = new PrintWriter("../baseline.out");
            for (Datum datum : testData) {
                String label = "O";
                if (wordNerMap.containsKey(datum.word)) {
                    label = wordNerMap.get(datum.word); 
                }
                writer.println(datum.word + '\t' + datum.label + '\t' + label);
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found error.");
        }
    }

}