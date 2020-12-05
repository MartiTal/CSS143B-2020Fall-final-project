package edu.uwb.css143b2020fall.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IndexerImpl implements Indexer {
    public Map<String, List<List<Integer>>> index(List<String> docs) {
        Map<String, List<List<Integer>>> indexes = new HashMap<>();
        // add your code
        for (int docnumber = 0; docnumber < docs.size(); docnumber++) { //Check each document

            String[] words = docs.get(docnumber).trim().split("\\s+");

            for (int pos = 0; pos < words.length; pos++) { //Check each word in each document

                if (!(indexes.containsKey(words[pos]))) { //Check to see if the index for this word has already been created

                    List<List<Integer>> documents = new ArrayList<>(docs.size());
                    for (int i = 0; i < docs.size(); i++) //Initialize a List of empty Lists for this new index
                        documents.add(new ArrayList<>());

                    documents.get(docnumber).add(pos); //Add the position of this word in this document to the index
                    indexes.put(words[pos], documents);

                } else { //If the index has already been created
                    indexes.get(words[pos]).get(docnumber).add(pos);
                }

            }

        }
        return indexes;
    }
}