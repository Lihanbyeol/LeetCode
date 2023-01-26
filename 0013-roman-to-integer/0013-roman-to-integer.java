import java.util.*;

class Solution {
    public int romanToInt(String s) {
        		// 문제 : LeetCode String easy 13. Roman to Integer
        int rslt = 0;
    
        Map<String, Integer> romanNumarals = new HashMap<>();
        // V or X 이전이 I이면 IV(4) or IX(9)
        // L or C 이전이 X이면 XL(40) or XC(90)
        // D or M 이전이 C이면 CD(400) or CM(900)
        romanNumarals.put("I",1);
        romanNumarals.put("IV",4);
        romanNumarals.put("V",5);
        romanNumarals.put("IX",9);
        romanNumarals.put("X",10);
        romanNumarals.put("XL",40);
        romanNumarals.put("L",50);
        romanNumarals.put("XC",90);
        romanNumarals.put("C",100);
        romanNumarals.put("CD",400);
        romanNumarals.put("D",500);
        romanNumarals.put("CM",900);
        romanNumarals.put("M",1000);
        
        String[] inputInfoArr = s.split("");

        for(int i = 0; i < inputInfoArr.length; i++) {
        	String str = inputInfoArr[i];
        	if(i + 1 < inputInfoArr.length) {
        		String nextStr = inputInfoArr[i+1];
        		if(romanNumarals.containsKey(str + nextStr)) {
        			str = str + nextStr;
        			i++;
        		}
        	}
        	int value = romanNumarals.get(str);
        	
        	rslt += value;
        }

        return rslt;
    }
}