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
        String[] searchedWords = keyPhrase.trim().split(" ");
        if (searchedWords.length == 1) {
            if (searchedWords[0].length() != 0) { //Ignore this part in the case of a search phrase being an empty String (test case)
                for (int i = 0; i < index.get(searchedWords[0]).size(); i++) {
                    if ( !(index.get(searchedWords[0]).get(i).isEmpty()) )
                        result.add(i);
                }
            }
            return result;
        }

        return result;
    }
}