package com.product.model;

import java.util.List;

public class PdtService {

	private Pdt_Interface dao;
	
	public PdtService() {
		dao = new PdtJDBCDAO();
	}
	
	public PdtVO addPdt (Integer pdtTypeId, Integer pdtStat, String pdtName, String pdtDesc, Integer pdtPrice) {
		
		PdtVO pdtVO = new PdtVO ();
		
		pdtVO.setPdtTypeId(pdtTypeId);
		pdtVO.setPdtStat(pdtStat);
		pdtVO.setPdtName(pdtName);
		pdtVO.setPdtDesc(pdtDesc);
		pdtVO.setPdtPrice(pdtPrice);
		dao.insert(pdtVO);
		
		return pdtVO;
	}
	
	public PdtVO updatePdt(Integer pdtTypeId, Integer pdtStat, String pdtName, String pdtDesc, Integer pdtPrice, Integer pdtId) {
		
		PdtVO pdtVO = new PdtVO ();
		
		pdtVO.setPdtTypeId(pdtTypeId);
		pdtVO.setPdtStat(pdtStat);
		pdtVO.setPdtName(pdtName);
		pdtVO.setPdtDesc(pdtDesc);
		pdtVO.setPdtPrice(pdtPrice);
		dao.update(pdtVO);
		
		return pdtVO;
	}
	
	public PdtVO getOnePdt(Integer pdtId) {
		return dao.findByPrimaryKey(pdtId);
	}
	
	public List<PdtVO> getAll(){
		return dao.getAll();
	}
	
	public PdtVO updateStat(Integer pdtId , Integer pdtStat) {
		PdtVO pdtVO = new PdtVO ();
		pdtVO.setPdtId(pdtId);
		pdtVO.setPdtStat(pdtStat);
		return dao.updateStat(pdtVO);
	}
}
