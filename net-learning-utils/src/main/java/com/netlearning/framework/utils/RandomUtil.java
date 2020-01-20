package com.netlearning.framework.utils;

import java.util.*;

/**
 * @program: net-learning
 * @description:随机生成1到10位的随机数的工具类
 * @author: XUCHANG
 * @time: 2020/1/11 14:18
 */
public class RandomUtil {

	public static String  getRandom(int num) {
		int[] array = {0,1,2,3,4,5,6,7,8,9};
		//随机对象
		Random rand = new Random();
		//循环产生
		for (int i = 10; i > 1; i--) {
		int index = rand.nextInt(i);
		int tmp = array[index];
		array[index] = array[i - 1];
		array[i - 1] = tmp;
		}
		int result = 0;
		for(int i = 0; i < num; i++) {
			result = result * 10 + array[i];
		}
		String code = Integer.toString(result);
		if (code.length() == num-1) {
			code = "0" + code;
		}
		return code;

	}


}
