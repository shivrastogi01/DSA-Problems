class WordBreaking
{
// Dynamic programming solution
HashMap<String, Boolean> memo = new HashMap<String, Boolean>();

public boolean wordBreak(String s, List<String> wordDict)
{
    if(memo.containsKey(s))
        return memo.get(s);
    
    if(s.equals("")) 
        return true;
    
    for(String word: wordDict)
    {
        int index = s.indexOf(word);
        if(index == 0)
        {
            // word is a prefix of s
            String remainder = s.substring(word.length());
            boolean b = wordBreak(remainder, wordDict);
            if(b)
            {
                memo.put(remainder, true);
                return true;
            }
        }
    }
    
    memo.put(s, false);
    return false;
}
}