package com.product.model;

public class PdtDAOTest {
	public static void main(String[] args) {
		PdtJDBCDAO dao = new PdtJDBCDAO();
		
//		新增
		PdtVO pdtVO1 = new PdtVO();
		pdtVO1.setPdtTypeId(4);
		pdtVO1.setPdtStat(0);
		pdtVO1.setPdtName("奶油起司脆餅");
		pdtVO1.setPdtDesc("近年風靡日本的Newyork Perfect Cheese奶油起司脆餅，混合了高達乳酪的法式貓舌脆餅，包裹著鬆軟的奶油和加入了奶油乳酪的白巧克力。");
		pdtVO1.setPdtPrice(600);
		dao.insert(pdtVO1);
		
//		修改
//		PdtVO pdtVO1 = new PdtVO();
//		pdtVO1.setPdtTypeId(4);
//		pdtVO1.setPdtStat(0);
//		pdtVO1.setPdtName("奶油起司脆餅");
//		pdtVO1.setPdtDesc("近年風靡日本的Newyork Perfect Cheese奶油起司脆餅，混合了高達乳酪的法式貓舌脆餅，包裹著鬆軟的奶油和加入了奶油乳酪的白巧克力。");
//		pdtVO1.setPdtPrice(600);
//		pdtVO1.setPdtId(1003);
//		dao.update(pdtVO1);
		
		
		
	}
}
