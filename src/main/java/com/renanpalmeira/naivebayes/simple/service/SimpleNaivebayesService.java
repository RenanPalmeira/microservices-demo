package com.renanpalmeira.naivebayes.simple.service;

import java.io.File;
import java.util.*;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import opennlp.tools.doccat.DoccatModel;
import opennlp.tools.doccat.DocumentSample;
import opennlp.tools.doccat.DocumentSampleStream;
import opennlp.tools.doccat.DocumentCategorizerME;
import opennlp.tools.doccat.DoccatFactory;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;
import opennlp.tools.util.MarkableFileInputStreamFactory;
import opennlp.tools.util.InputStreamFactory;
import opennlp.tools.util.TrainingParameters;

public class SimpleNaivebayesService {

    DoccatModel model;

    public void trainModel() {
        try {
            InputStreamFactory inputStreamFactory = new MarkableFileInputStreamFactory(new File("input/tweets.txt"));
            ObjectStream<String> lineStream = new PlainTextByLineStream(inputStreamFactory, "UTF-8");

            ObjectStream<DocumentSample> sampleStream = new DocumentSampleStream(lineStream);

            model = DocumentCategorizerME.train(
                "en",
                sampleStream,
                TrainingParameters.defaultParams(),
                new DoccatFactory());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void classifyNewTweet(String tweet) {
        DocumentCategorizerME myCategorizer = new DocumentCategorizerME(model);

        double[] outcomes = myCategorizer.categorize(tweet);

        String category = myCategorizer.getBestCategory(outcomes);

        System.out.println(category);

        if (category.equalsIgnoreCase("2")) {
            System.out.println("The tweet is positive :) ");
        } else {
            System.out.println("The tweet is negative :( ");
        }
    }
}