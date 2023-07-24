package com.example.TextService;


import java.util.*;


public class TextMerger {

    public static String mergeTexts(List<String> texts) {

        List<String[]> wordsList = new ArrayList<>();
        Set<String> wordSet = new HashSet<>();
        List<Map<String, Integer>> freqMaps = new ArrayList<>();
        int wordsListlen = 0;


        for (String text : texts) {
            String[] words = text.split("\\s+");
            wordsListlen += words.length;
            wordsList.add(words);
            wordSet.addAll(Arrays.asList(words));
            freqMaps.add(getWordFrequency(words));
        }

//        if (wordSet.size() == wordsListlen ){
//            return "Bu cümleler birleştirilemez";
//        }

        List<String> commonWords = getCommonWords(wordSet, freqMaps);
        StringBuilder sb = new StringBuilder();
        for (String[] words : wordsList) {
            for (int i = 0; i < words.length; i++) {
                if (commonWords.contains(words[i]) ) {
                    if (!sb.toString().contains(words[i])){
                        sb.append(words[i]).append(" ");
                    }
                } else {
                    if (!sb.toString().contains(words[i])){
                        sb.append("").append(words[i]).append(" ");
                    }

                }
            }
        }
        return sb.toString();
    }

    private static Map<String, Integer> getWordFrequency(String[] words) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            int freq = freqMap.getOrDefault(word, 0);
            freqMap.put(word, freq + 1);
        }
        return freqMap;
    }

    private static List<String> getCommonWords(Set<String> wordSet, List<Map<String, Integer>> freqMaps) {
        List<String> commonWords = new ArrayList<>();
        double maxSimilarity = 0;
        for (String word : wordSet) {
            double[] freqs = new double[freqMaps.size()];
            for (int i = 0; i < freqMaps.size(); i++) {
                freqs[i] = freqMaps.get(i).getOrDefault(word, 0);
            }
            double similarity = cosineSimilarity(freqs);
            if (similarity > maxSimilarity) {
                maxSimilarity = similarity;
                commonWords.clear();
                commonWords.add(word);
            } else if (similarity == maxSimilarity) {
                commonWords.add(word);
            }
        }
        return commonWords;
    }

    private static double cosineSimilarity(double[] freqs) {
        double dotProduct = 0;
        double norm = 0;
        for (double freq : freqs) {
            dotProduct += freq * freq;
            norm += freq * freq;
        }
        return dotProduct / Math.sqrt(norm);
    }
}

