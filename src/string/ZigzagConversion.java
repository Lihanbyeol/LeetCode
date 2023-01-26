package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZigzagConversion {
	public static String convert(String s, int numRows) {
		String rslt = "";

		if(numRows == 1) {
			return s;
		}
		
		List<List<String>> info = new ArrayList<>();
		for (int i = 0; i < numRows; i++) {
			info.add(new ArrayList<>());
		}

		String[] sArr = s.split("");

		int idx = 0; // info¿« ¿Œµ¶Ω∫
		boolean flag = false; // false : + , true : -
		for (int i = 0; i < sArr.length; i++) {
			if (!flag) {
				info.get(idx).add(sArr[i]);
				if(idx < numRows - 1) {
					idx++;
				} else {
					flag = true;
					idx--;
				}
			} else {
				info.get(idx).add(sArr[i]);
				if(idx > 0) {
					idx--;
				} else {
					flag = false;
					idx++;
				}
			}
		}
		
		for(int i = 0; i < numRows; i++) {
			for(int j = 0; j < info.get(i).size(); j++) {
				rslt += info.get(i).get(j);
			}
		}

		return rslt;
	}
}
