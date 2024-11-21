package com.product.model;

import java.util.List;

public interface Pdt_Interface {
	public int insert(PdtVO pdtVO);
	public int update(PdtVO pdtVO);
	public PdtVO updateStat (PdtVO pdtVO);
	public PdtVO findByPrimaryKey (Integer pdtId);
	public List<PdtVO> getAll();
	public List<PdtVO> findByForienKey(Integer pdtTypeId);
	public List<PdtVO> findByStat(Integer pdtStat);
}
