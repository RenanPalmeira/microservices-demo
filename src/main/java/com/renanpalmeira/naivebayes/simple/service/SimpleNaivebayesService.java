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

import com.renanpalmeira.naivebayes.ProductCategory;

public class SimpleNaivebayesService {

    DoccatModel model;

    public void trainModel() {
        try {
            InputStreamFactory inputStreamFactory = new MarkableFileInputStreamFactory(new File("input/products.txt"));
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

    public void classify(String tweet) {
        DocumentCategorizerME categorizer = new DocumentCategorizerME(model);

        double[] outcomes = categorizer.categorize(tweet);

        String category = categorizer.getBestCategory(outcomes);

        if (category.equalsIgnoreCase(ProductCategory.TONER.getClassify()))
        {
            System.out.println("This product is a toner");
        }
        else if (category.equalsIgnoreCase(ProductCategory.PANTS.getClassify()))
        {
            System.out.println("This product is a pant");
        }
        else
        {
            System.out.println("This product is not a product");
        }
    }
}