package edu.nju.ee.zerosix.yan;

import java.util.*;

/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]
Example 2:

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]
 */
public class WordBreakII implements Solution{
    @Override
    public void run() {
        System.out.println(wordBreak("catsanddog", new ArrayList<String>(Arrays.asList("cat", "cats", "and", "sand", "dog"))));
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashMap<String, List<String>> m = new HashMap<>();
        return dfs(s,wordDict, m);
    }

    public List<String> dfs(String s, List<String> dict, HashMap<String, List<String>> map) {
        if (map.containsKey(s)){
            return map.get(s);
        }
        List<String> res = new LinkedList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for(String word: dict){
            if(s.startsWith(word)){
                String remainder = s.substring(word.length());
                for(String substring : dfs(remainder, dict, map)){
                    res.add(word + (substring.isEmpty() ? "" :" ") + substring);
                }
            }
        }
        map.put(s, res);
        return res;
    }
}
