package edu.uwb.css143b2020fall.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
DO NOT CHANGE
 */

@Service
public class SearcherImpl implements Searcher {
    public List<Integer> search(String keyPhrase, Map<String, List<List<Integer>>> index) {
        List<Integer> result = new ArrayList<>();
        // add your code
        String[] searchedWords = keyPhrase.trim().split(" "); //Create an array of every word in the search phrase

        if (searchedWords.length == 1) { //In case of a one-word search

            if (searchedWords[0].length() != 0) { //This code will not execute in the case of a search phrase being an empty String (test case)
                for (int i = 0; i < index.get(searchedWords[0]).size(); i++) {
                    if ( !(index.get(searchedWords[0]).get(i).isEmpty()) )
                        result.add(i); //Essentially, we will just return each document that does not have an empty list in this word's index
                }
            }
            return result;

        }

        Map<Integer, Integer> commonDocFinder = new HashMap<>(); //Find the common documents where every word in the search exists

        for (int i = 0; i < searchedWords.length; i++) { //Each word in the phrase search
            if (index.get(searchedWords[i]) != null) //To avoid NullPointerException if this word happens to not be found anywhere
                for (int j = 0; j < index.get(searchedWords[i]).size(); j++) { //Check each document to see if it contains said word somewhere
                    if ( !(index.get(searchedWords[i]).get(j).isEmpty()) ) {
                        if (commonDocFinder.containsKey(j)) { //If this document was already found to have a word in it, increment its value in the HashMap instead
                            commonDocFinder.put(j, commonDocFinder.get(j) + 1);
                        } else {
                            commonDocFinder.put(j, 1);
                        }

                    }
                }
        }

        List<Integer> commonDocs = new ArrayList<>();

        for (int i : commonDocFinder.keySet()) {
            if (commonDocFinder.get(i) == searchedWords.length)
               commonDocs.add(i);
        }

        return result;
    }
}