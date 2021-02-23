package zxq.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import zxq.example.service.ICombinationLetterService;


public class CombinationLetterForZeroToNityServiceImpl implements ICombinationLetterService {

	
	private  ICombinationLetterService combinationLetterService;

	
	public CombinationLetterForZeroToNityServiceImpl() {
		this.combinationLetterService = new CombinationLetterForZeroToNineServiceImpl();
	}
	
	
	
	@Override
	public String combinationLetter(int[] inputArray) {
		// TODO Auto-generated method stub
		if(inputArray == null || inputArray.length == 0) {
			return "at least input one digit number";
		}
		List<Integer> items = new ArrayList<Integer>();
		for(int i = 0; i < inputArray.length; i++) {
			if(inputArray[i] < 0 || inputArray[i] > 99 ) {
				return "item value must be between 0 and 99";
			}
			if(inputArray[i] < 10) {
				items.add(inputArray[i]);
			}else {
				items.add(inputArray[i] / 10);
				items.add(inputArray[i] % 10);
			}
		}
		int[] array = items.stream().mapToInt(Integer::valueOf).toArray();
		return combinationLetterService.combinationLetter(array);
	}
	
}
