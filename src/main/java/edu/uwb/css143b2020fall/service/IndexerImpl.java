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

                List<Integer> locations = new ArrayList<>();

                locations.add(pos);

                for (int pos2 = pos + 1; pos2 < words.length; pos2++) { //Check the rest of the words in this document to see if this word shows up multiple times
                    if (words[pos2].equals(words[pos]))
                        locations.add(pos2);
                }

                if (indexes.containsKey(words[pos])) { //Check to see if the index for this word has already been created

                    List<List<Integer>> documents = new ArrayList<>(docs.size()); //The documents each word appears in
                    documents.add(docnumber, locations);
                    indexes.put(words[pos], documents);

                } else { //If the index has already been created
                    indexes.get(words[pos]).add(docnumber, locations);
                }


            }

        }
        return indexes;
    }
}