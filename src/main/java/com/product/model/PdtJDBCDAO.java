package com.product.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.producttype.model.ProductTypeVO;

public class PdtJDBCDAO implements Pdt_Interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/hihidatabase?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "mary3293244";
	
	private static final String INSERT_STMT =
			"INSERT INTO Product (pdtTypeId,pdtStat,pdtName,pdtDesc,pdtPrice) VALUES (?,?,?,?,?)";
	private static final String GET_ALL_STMT =
			"SELECT pdtId,pdtTypeId,pdtStat,pdtName,pdtDesc,pdtPrice FROM Product order by pdtId";
	private static final String GET_ONE_STMT =
			"SELECT pdtId,pdtTypeId,pdtStat,pdtName,pdtDesc,pdtPrice FROM Product where pdtId = ?";
	private static final String GET_TYPE_STMT =
			"SELECT pdtId,pdtTypeId,pdtStat,pdtName,pdtDesc,pdtPrice FROM Product where pdtTypeId = ?";
	private static final String GET_STAT_STMT =
			"SELECT pdtId,pdtTypeId,pdtStat,pdtName,pdtDesc,pdtPrice FROM Product where pdtStat = ?";
	private static final String UPDATE =
			"UPDATE pdtTypeId=?, pdtStat=?, pdtName=?, pdtDesc=?, pdtPrice=? where pdtId = ?";
	private static final String UPDATE_STAT =
			"UPDATE pdtStat=? where pdtId = ?";
	
	@Override
	public int insert(PdtVO pdtVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url,userid,passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setInt(1, pdtVO.getPdtTypeId());
			pstmt.setInt(2, pdtVO.getPdtStat());
			pstmt.setString(3, pdtVO.getPdtName());
			pstmt.setString(4, pdtVO.getPdtDesc());
			pstmt.setInt(5, pdtVO.getPdtPrice());
			
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace(System.err);
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace(System.err);
				}
			}
		}
		return pdtVO.getPdtId();
	}

	@Override
	public int update(PdtVO pdtVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setInt(1, pdtVO.getPdtTypeId());
			pstmt.setInt(2, pdtVO.getPdtStat());
			pstmt.setString(3, pdtVO.getPdtName());
			pstmt.setString(4, pdtVO.getPdtDesc());
			pstmt.setInt(5, pdtVO.getPdtPrice());
			pstmt.setInt(6, pdtVO.getPdtId());
			
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		}finally {
			
				if(pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace(System.err);
					}
				}
				if(con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace(System.err);
					}
			}
		}
		return pdtVO.getPdtId();
	}

	@Override
	public PdtVO findByPrimaryKey(Integer pdtId) {
		// TODO Auto-generated method stub
		PdtVO pdtVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			
			pstmt.setInt(1, pdtId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				pdtVO= new PdtVO();
				pdtVO.setPdtId(rs.getInt("pdtId"));
				pdtVO.setPdtTypeId(rs.getInt("pdtTypeId"));
				pdtVO.setPdtStat(rs.getInt("pdtStat"));
				pdtVO.setPdtName(rs.getString("pdtName"));
				pdtVO.setPdtDesc(rs.getString("pdtDesc"));
				pdtVO.setPdtPrice(rs.getInt("pdtPrice"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		}finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace(System.err);
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace(System.err);
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace(System.err);
				}
			}
		}
		
		return pdtVO;
	}

	@Override
	public List<PdtVO> getAll() {
		// TODO Auto-generated method stub
		List<PdtVO> list = new ArrayList<PdtVO>();
		PdtVO pdtVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				pdtVO = new PdtVO();
				pdtVO= new PdtVO();
				pdtVO.setPdtId(rs.getInt("pdtId"));
				pdtVO.setPdtTypeId(rs.getInt("pdtTypeId"));
				pdtVO.setPdtStat(rs.getInt("pdtStat"));
				pdtVO.setPdtName(rs.getString("pdtName"));
				pdtVO.setPdtDesc(rs.getString("pdtDesc"));
				pdtVO.setPdtPrice(rs.getInt("pdtPrice"));
				list.add(pdtVO);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		}finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	@Override
	public PdtVO updateStat(PdtVO pdtVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_STAT);
			
			pstmt.setInt(1, pdtVO.getPdtStat());
			pstmt.setInt(2, pdtVO.getPdtId());
			
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		}finally {
			
				if(pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace(System.err);
					}
				}
				if(con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace(System.err);
					}
			}
		}
		return pdtVO;
	}

	@Override
	public List<PdtVO> findByForienKey(Integer pdtTypeId) {
		// TODO Auto-generated method stub
		List<PdtVO> list = new ArrayList<PdtVO>();
		PdtVO pdtVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_TYPE_STMT);
			pstmt.setInt(1, pdtTypeId);	
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				pdtVO= new PdtVO();
				pdtVO.setPdtId(rs.getInt("pdtId"));
				pdtVO.setPdtTypeId(rs.getInt("pdtTypeId"));
				pdtVO.setPdtStat(rs.getInt("pdtStat"));
				pdtVO.setPdtName(rs.getString("pdtName"));
				pdtVO.setPdtDesc(rs.getString("pdtDesc"));
				pdtVO.setPdtPrice(rs.getInt("pdtPrice"));
				list.add(pdtVO);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		}finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace(System.err);
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace(System.err);
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace(System.err);
				}
			}
		}
		
		return list;
	}

	@Override
	public List<PdtVO> findByStat(Integer pdtStat) {
		// TODO Auto-generated method stub
		List<PdtVO> list = new ArrayList<PdtVO>();
		PdtVO pdtVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_STAT_STMT);
			pstmt.setInt(1, pdtStat);	
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				pdtVO= new PdtVO();
				pdtVO.setPdtId(rs.getInt("pdtId"));
				pdtVO.setPdtTypeId(rs.getInt("pdtTypeId"));
				pdtVO.setPdtStat(rs.getInt("pdtStat"));
				pdtVO.setPdtName(rs.getString("pdtName"));
				pdtVO.setPdtDesc(rs.getString("pdtDesc"));
				pdtVO.setPdtPrice(rs.getInt("pdtPrice"));
				list.add(pdtVO);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		}finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace(System.err);
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace(System.err);
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace(System.err);
				}
			}
		}
		
		return list;
	}

}
