import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        
        HashMap<String, Integer> totalNum = new HashMap<>();
        HashMap<String, HashMap<Integer, Integer>> musics = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0 ;i<genres.length;i++) {
            totalNum.put(genres[i], totalNum.getOrDefault(genres[i], 0) + plays[i]);
            if(!musics.containsKey(genres[i])){
                HashMap<Integer, Integer> temp = new HashMap<>();
                temp.put(i, plays[i]);
                musics.put(genres[i], temp);
            }
            else
                musics.get(genres[i]).put(i, plays[i]);
        }
        
        List<String> keySet = new ArrayList<>(totalNum.keySet());
        
        keySet.sort((o1, o2) -> totalNum.get(o2) - totalNum.get(o1));
        
        for (String key : keySet) {
            HashMap<Integer, Integer> getMap = musics.get(key);
            List<Integer> keySet2 = new ArrayList<>(getMap.keySet());
            keySet2.sort((o1, o2) -> getMap.get(o2) - getMap.get(o1));
            list.add(keySet2.get(0));
            if(keySet2.size()>1)
                list.add(keySet2.get(1));
        }
        
        //System.out.println(musics.entrySet());
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}