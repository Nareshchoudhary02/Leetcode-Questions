class Solution {
    public long countOfSubstrings(String word, int k) {
        return countAtLeastK(word, k) - countAtLeastK(word, k+1);
    }

    public boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c =='u';
    }

    public long countAtLeastK(String word, int k){
        HashMap<Character, Integer> map = new HashMap<>();
        int n = word.length();
        int left = 0;
        int right = 0; 
        int count = 0;
        long res = 0;

        while(right < n){
            char c = word.charAt(right);
            if(isVowel(c)) map.put(c, map.getOrDefault(c,0)+1);
            else count++;

            while(map.size() == 5 && count >= k){ 
                res += (long)(n - right);
                char l = word.charAt(left);
                if(isVowel(l)){
                    map.put(l, map.get(l)-1);
                    if(map.get(l) == 0){
                        map.remove(l);
                    }
                }
                else count--;
                left++;
            }
            right++;
        }

        return res;
    }
}