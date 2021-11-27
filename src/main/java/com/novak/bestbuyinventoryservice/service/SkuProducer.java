package com.novak.bestbuyinventoryservice.service;

import java.util.ArrayList;
import java.util.List;

public class SkuProducer {
	private static int skuIndex = 0;

	private static final String RTX3080 = "6330461,6409180,6373500,6430620,6430621,6432445,6430175,6429440,6432400,6436191";
	private static final String RTX3080_RTX3060 = "6436196,6432399,6436194,6439300,6437912,6432654";
	private static final String RTX3070 = "6429442,6439128,6438278,6439299,6439384,6439127,6437909,6439385,6439301,6432653";
//	private static final String RTX3060TI = "6439402,6452573,6444444,6444445,6444449,6442484,6441172,6442485";
	private static final String PLAYSTATION_5 = "6426149,6430161";

	private static List<String> skuList = new ArrayList<>();

	private SkuProducer() {

	}

	public static String getNext() {
		skuList.add(PLAYSTATION_5);
		if (skuIndex == skuList.size() - 1) {
			skuIndex = 0;
		} else {
			skuIndex++;
		}
		return skuList.get(skuIndex);
	}

}
