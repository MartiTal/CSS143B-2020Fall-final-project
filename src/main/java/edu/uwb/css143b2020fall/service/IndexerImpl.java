package edu.uwb.css143b2020fall.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IndexerImpl implements Indexer {
    public Map<String, List<List<Integer>>> index(List<String> docs) {
        Map<String, List<List<Integer>>> indexes = new HashMap<>();
        // add your code
        for (int docnumber = 0; docnumber < docs.size(); docnumber++) {

            String[] words = docs.get(docnumber).trim().split("\\s+");

            for (int i = 0; i < words.length; i++) {
                List<List<Integer>> document = new ArrayList<>(docs.size());
                List<Integer> location = new ArrayList<>();

                location.add(i);
                document.add(docnumber, location);
                indexes.put(words[i], document);
            }
        }
        return indexes;
    }
}