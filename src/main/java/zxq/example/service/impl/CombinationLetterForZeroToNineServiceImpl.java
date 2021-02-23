package zxq.example.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import zxq.example.service.ICombinationLetterService;


public class CombinationLetterForZeroToNineServiceImpl implements ICombinationLetterService {

	private static Map<Integer,String[]> digitLetterMap = new HashMap<>();
	static {
		digitLetterMap.put(0, new String[]{""});
		digitLetterMap.put(1, new String[]{""});
		digitLetterMap.put(2, new String[]{"a", "b", "c"});
		digitLetterMap.put(3, new String[]{"d", "e", "f"});
        digitLetterMap.put(4, new String[]{"g","h","i"});
        digitLetterMap.put(5, new String[]{"j","k","l"});
        digitLetterMap.put(6, new String[]{"m","n","o"});
        digitLetterMap.put(7, new String[]{"p","q","r","s"});
        digitLetterMap.put(8, new String[]{"t","u","v"});
        digitLetterMap.put(9, new String[]{"w","x","y","z"});

	}
	
	@Override
	public String combinationLetter(int[] inputArray) {
		// TODO Auto-generated method stub
		if(inputArray == null || inputArray.length == 0) {
			return "at least input one digit number";
		}
		for(int i = 0; i < inputArray.length; i++) {
			if(inputArray[i] < 0 || inputArray[i] > 9) {
				return "item value must be between 0 and 9";
			}
		}
		List<String> letters = doCombinationLetter(inputArray);
		return String.join(" ", letters);
	}
	
	private List<String> doCombinationLetter(int[] inputArray){
		if(inputArray.length == 1) {
			return Arrays.asList(digitLetterMap.get(inputArray[0]));
		}
		return doCombinationLetter(inputArray,0,inputArray.length-1);
	}
	
    private List<String> doCombinationLetter(int[] inputArray,int start,int end){
    	List<String> letters = new ArrayList<String>();
		if(end - start == 1 ) {
			for(String firstLetter : digitLetterMap.get(inputArray[start])) {
				for(String secondLetter : digitLetterMap.get(inputArray[end])) {
					letters.add(firstLetter+secondLetter);
				}
			}
		}else {
			List<String> subLetters = doCombinationLetter(inputArray,start + 1,end);
			for(String firstLetter : digitLetterMap.get(inputArray[start])) {
				for(String secondLetter : subLetters) {
					letters.add(firstLetter+secondLetter);
				}
			}
		}
		return letters;
	}

}
