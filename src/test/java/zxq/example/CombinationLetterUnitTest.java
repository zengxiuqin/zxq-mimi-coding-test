package zxq.example;

import org.junit.Assert;
import org.junit.Test;

import zxq.example.service.ICombinationLetterService;
import zxq.example.service.impl.CombinationLetterForZeroToNineServiceImpl;
import zxq.example.service.impl.CombinationLetterForZeroToNityServiceImpl;

public class CombinationLetterUnitTest {
	
	private ICombinationLetterService zeroToNineService = new CombinationLetterForZeroToNineServiceImpl();
	private ICombinationLetterService zeroToNityService = new CombinationLetterForZeroToNityServiceImpl();
	
	@Test
	public void testRightOfCombinationLetter() {
		
		String result1ForZeroToNine = zeroToNineService.combinationLetter(new int[]{2,3});
        String result2ForZeroToNine = zeroToNineService.combinationLetter(new int[]{9});
        String result1ForZeroToNity = zeroToNityService .combinationLetter(new int[]{2,3});
        String result2ForZeroToNity = zeroToNityService .combinationLetter(new int[]{9});

        // assert
        String expect1 = "ad ae af bd be bf cd ce cf";
        String expect2 = "w x y z";

        Assert.assertEquals(expect1,result1ForZeroToNine);
        Assert.assertEquals(expect1,result1ForZeroToNity);
        Assert.assertEquals(expect2,result2ForZeroToNine);
        Assert.assertEquals(expect2,result2ForZeroToNity);
	}
	
	
	@Test
	public void testErrorTipForZeroToNine() {
		String result1ForZeroToNine = zeroToNineService.combinationLetter(null);
		String result2ForZeroToNine = zeroToNineService.combinationLetter(new int[] {});
		String result3ForZeroToNine = zeroToNineService.combinationLetter(new int[] {10});
		
		String expectResult1 = "at least input one digit number";
		String expectResult2 = "item value must be between 0 and 9";
		Assert.assertEquals(result1ForZeroToNine,expectResult1);
	    Assert.assertEquals(result2ForZeroToNine,expectResult1);
	    Assert.assertEquals(result3ForZeroToNine,expectResult2);
	}
	
	@Test
	public void testErrorTipForZeroToNity() {
		String result1ForZeroToNine = zeroToNityService.combinationLetter(null);
		String result2ForZeroToNine = zeroToNityService.combinationLetter(new int[] {});
		String result3ForZeroToNine = zeroToNityService.combinationLetter(new int[] {100,1});
		
		String expectResult1 = "at least input one digit number";
		String expectResult2 = "item value must be between 0 and 99";
		Assert.assertEquals(result1ForZeroToNine,expectResult1);
	    Assert.assertEquals(result2ForZeroToNine,expectResult1);
	    Assert.assertEquals(result3ForZeroToNine,expectResult2);
	}

}
