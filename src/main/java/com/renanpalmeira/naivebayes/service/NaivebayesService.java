package com.renanpalmeira.naivebayes.service;

import java.util.*;
import java.io.StringReader;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.br.BrazilianAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.util.Version;

@Component
public class NaivebayesService {

    public String train()
    {
        List l = new ArrayList();
        l.add("Música");
    }
    
}