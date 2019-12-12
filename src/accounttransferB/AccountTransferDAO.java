package accounttransferB;

import java.sql.*;
import java.util.ArrayList;

import accounttransferB.AccountTransferDTO;

// 전달 데이터단위인 (DTO : Data Transfer Object)를 사용하면서 DB 데이터를 직접 처리하는
// DAO(Data Access Object)
public class AccountTransferDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;

	/* MySQL 연결정보 */
	String jdbc_driver = "com.mysql.jdbc.Driver";
	
	String jdbc_url = "jdbc:mysql://127.0.0.1/jspdb?useSSL=true&verifyServerCertificate=false&serverTimezone=UTC";

	
	/******************************************************************************************/
	// DB연결 메서드
	/******************************************************************************************/
	void connect() {
		try {
			Class.forName(jdbc_driver);

			conn = DriverManager.getConnection(jdbc_url,"jspbook","1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/******************************************************************************************/
	// DB 연결해제 메소드
	/******************************************************************************************/
	void disconnect() {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/******************************************************************************************/
	// 컴퓨터 부품 입력 메서드
	/******************************************************************************************/
	public boolean insertDB(String str, AccountTransferDTO accountTransferDTO) {
		
		
		connect();

		String sql = "";

		if (str == "mainboard") {
			sql += "insert into mainboard(mbName, mbChipset, mbDDR, mbNVMe, mbSize) values(?,?,?,?,?)";
		}
		else if (str == "cpu") {
			sql += "insert into cpu(cpuName, cpuChipset) values(?,?)";
		}
		else if (str == "ram") {
			sql += "insert into ram(ramName, ramDDR) values(?,?)";
		}
		else if (str == "ssd") {
			sql += "insert into ssd(ssdName, ssdNVMe) values(?,?)";
		}
		else if (str == "cases") {
			sql += "insert into cases(casesName, casesSize, casesWidth) values(?,?,?)";
		}
		else if (str == "vga") {
			sql += "insert into vga(vgaName, vgaWidth) values(?,?)";
		}	
		
		try {
			
			pstmt = conn.prepareStatement(sql);

			// SQL문에 변수 입력
			
			if (str == "mainboard") {
				pstmt.setString(1,accountTransferDTO.getMbName());
				pstmt.setString(2,accountTransferDTO.getMbChipset());
				pstmt.setString(3,accountTransferDTO.getMbDDR());
				pstmt.setBoolean(4,accountTransferDTO.getMbNVMe());
				pstmt.setString(5,accountTransferDTO.getMbSize());
			}
			else if (str == "cpu") {
				pstmt.setString(1,accountTransferDTO.getCpuName());
				pstmt.setString(2,accountTransferDTO.getCpuChipset());
			}
			else if (str == "ram") {
				pstmt.setString(1,accountTransferDTO.getRamName());
				pstmt.setString(2,accountTransferDTO.getRamDDR());
			}
			else if (str == "ssd") {
				pstmt.setString(1,accountTransferDTO.getSsdName());
				pstmt.setBoolean(2,accountTransferDTO.getSsdNVMe());
			}
			else if (str == "cases") {
				pstmt.setString(1,accountTransferDTO.getCasesName());
				pstmt.setString(2,accountTransferDTO.getCasesSize());
				pstmt.setInt(3,accountTransferDTO.getCasesWidth());
			}
			else if (str == "vga") {
				pstmt.setString(1,accountTransferDTO.getVgaName());
				pstmt.setInt(2,accountTransferDTO.getVgaWidth());
			}	

			
			//SQL문 실행
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			disconnect();
		}
		return true;
	}
	
	/******************************************************************************************/
	// 부품목록 조회 메서드
	/******************************************************************************************/
	public ArrayList<AccountTransferDTO> getDBList(String part) {
		
		connect();
		
		ArrayList<AccountTransferDTO> accountTransferList = new ArrayList<AccountTransferDTO>();
		
		String sql = "select * from " + part;

		try {
			
			pstmt = conn.prepareStatement(sql);
			
			//SQL문 실행
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				
				// DO 객체 생성
				AccountTransferDTO accountTransferDTO = new AccountTransferDTO();
				
				// DB Select결과를 DO 객체에 저장
				if (part == "mainboard") {
					accountTransferDTO.setMbNumber(rs.getInt("mbNumber"));
					accountTransferDTO.setMbName(rs.getString("mbName"));
					accountTransferDTO.setMbChipset(rs.getString("mbChipset"));
					accountTransferDTO.setMbDDR(rs.getString("mbDDR"));
					accountTransferDTO.setMbNVMe(rs.getBoolean("mbNVMe"));
					accountTransferDTO.setMbSize(rs.getString("mbSize"));
				} 
				else if (part == "cpu") {
					accountTransferDTO.setCpuNumber(rs.getInt("cpuNumber"));
					accountTransferDTO.setCpuName(rs.getString("cpuName"));
					accountTransferDTO.setCpuChipset(rs.getString("cpuChipset"));
				}
				else if (part == "ram") {
					accountTransferDTO.setRamNumber(rs.getInt("ramNumber"));
					accountTransferDTO.setRamName(rs.getString("ramName"));
					accountTransferDTO.setRamDDR(rs.getString("ramDDR"));
				}
				else if (part == "ssd") {
					accountTransferDTO.setSsdNumber(rs.getInt("ssdNumber"));
					accountTransferDTO.setSsdName(rs.getString("ssdName"));
					accountTransferDTO.setSsdNVMe(rs.getBoolean("ssdNVMe"));
				}
				else if (part == "cases") {
					accountTransferDTO.setCasesNumber(rs.getInt("casesNumber"));
					accountTransferDTO.setCasesName(rs.getString("casesName"));
					accountTransferDTO.setCasesSize(rs.getString("casesSize"));
					accountTransferDTO.setCasesWidth(rs.getInt("casesWidth"));
				}
				else if (part == "vga") {
					accountTransferDTO.setVgaNumber(rs.getInt("vgaNumber"));
					accountTransferDTO.setVgaName(rs.getString("vgaName"));
					accountTransferDTO.setVgaWidth(rs.getInt("vgaWidth"));
				}
				
				
				accountTransferList.add(accountTransferDTO);
			}
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
		return accountTransferList;
	}
	

	/******************************************************************************************/
	// edit용 부품 1건 조회 메서드
	/******************************************************************************************/
	public AccountTransferDTO getDB(int id, String part) {
		
		connect();
		
		AccountTransferDTO accountTransferDTO = new AccountTransferDTO();
		
		String sql = "";
		
		if ("mainboard".equals(part)) {
			sql += "select * from mainboard where mbNumber = ?";
		}
		else if ("cpu".equals(part)) {
			sql += "select * from cpu where cpuNumber = ?";
		}
		else if ("ram".equals(part)) {
			sql += "select * from ram where ramNumber = ?";
		}
		else if ("ssd".equals(part)) {
			sql += "select * from ssd where ssdNumber = ?";
		}
		else if ("cases".equals(part)) {
			sql += "select * from cases where casesNumber = ?";
		}
		else if ("vga".equals(part)) {
			sql += "select * from vga where vgaNumber = ?";
		}
		
		try {
			
			pstmt = conn.prepareStatement(sql);

			// SQL문에 조회조건 입력
			pstmt.setInt(1,id);

			//SQL문 실행
			ResultSet rs = pstmt.executeQuery();
			// 데이터가 하나만 있으므로 rs.next()를 한번만 실행 한다.
			rs.next();
			
			// DB Select결과를 DO 객체에 저장
			if ("mainboard".equals(part)) {
				accountTransferDTO.setMbNumber(rs.getInt("mbNumber"));
				accountTransferDTO.setMbName(rs.getString("mbName"));
				accountTransferDTO.setMbChipset(rs.getString("mbChipset"));
				accountTransferDTO.setMbDDR(rs.getString("mbDDR"));
				accountTransferDTO.setMbNVMe(rs.getBoolean("mbNVMe"));
				accountTransferDTO.setMbSize(rs.getString("mbSize"));
			} 
			else if ("cpu".equals(part)) {
				accountTransferDTO.setCpuNumber(rs.getInt("cpuNumber"));
				accountTransferDTO.setCpuName(rs.getString("cpuName"));
				accountTransferDTO.setCpuChipset(rs.getString("cpuChipset"));
			}
			else if ("ram".equals(part)) {
				accountTransferDTO.setRamNumber(rs.getInt("ramNumber"));
				accountTransferDTO.setRamName(rs.getString("ramName"));
				accountTransferDTO.setRamDDR(rs.getString("ramDDR"));
			}
			else if ("ssd".equals(part)) {
				accountTransferDTO.setSsdNumber(rs.getInt("ssdNumber"));
				accountTransferDTO.setSsdName(rs.getString("ssdName"));
				accountTransferDTO.setSsdNVMe(rs.getBoolean("ssdNVMe"));
			}
			else if ("cases".equals(part)) {
				accountTransferDTO.setCasesNumber(rs.getInt("casesNumber"));
				accountTransferDTO.setCasesName(rs.getString("casesName"));
				accountTransferDTO.setCasesSize(rs.getString("casesSize"));
				accountTransferDTO.setCasesWidth(rs.getInt("casesWidth"));
			}
			else if ("vga".equals(part)) {
				accountTransferDTO.setVgaNumber(rs.getInt("vgaNumber"));
				accountTransferDTO.setVgaName(rs.getString("vgaName"));
				accountTransferDTO.setVgaWidth(rs.getInt("vgaWidth"));
			}
			
			
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
		return accountTransferDTO;
	}


	/******************************************************************************************/
	// 부품 수정 메서드
	/******************************************************************************************/
	public boolean updateDB(int id, String part, AccountTransferDTO accountTransferDTO) {
		
		connect();

		String sql = "";

		if ("mainboard".equals(part)) {
			sql += "update mainboard set mbName=?, mbChipset=?, mbDDR=?, mbNVMe=?, mbSize=? where mbNumber=?";
		}
		else if ("cpu".equals(part)) {
			sql += "update cpu set cpuName=?, cpuChipset=? where cpuNumber=?";
		}
		else if ("ram".equals(part)) {
			sql += "update ram set ramName=?, ramDDR=? where ramNumber=?";
		}
		else if ("ssd".equals(part)) {
			sql += "update ssd set ssdName=?, ssdNVMe=? where ssdNumber=?";
		}
		else if ("cases".equals(part)) {
			sql += "update cases set casesName=?, casesSize=?, casesWidth=? where casesNumber=?";
		}
		else if ("vga".equals(part)) {
			sql += "update vga set vgaName=?, vgaWidth=? where vgaNumber=?";
		}	
		
		try {
			
			pstmt = conn.prepareStatement(sql);

			// SQL문에 변수 입력
			if ("mainboard".equals(part)) {
				pstmt.setString(1,accountTransferDTO.getMbName());
				pstmt.setString(2,accountTransferDTO.getMbChipset());
				pstmt.setString(3,accountTransferDTO.getMbDDR());
				pstmt.setBoolean(4,accountTransferDTO.getMbNVMe());
				pstmt.setString(5,accountTransferDTO.getMbSize());
				pstmt.setInt(6,id);
			}
			else if ("cpu".equals(part)) {
				pstmt.setString(1,accountTransferDTO.getCpuName());
				pstmt.setString(2,accountTransferDTO.getCpuChipset());
				pstmt.setInt(3,id);
			}
			else if ("ram".equals(part)) {
				pstmt.setString(1,accountTransferDTO.getRamName());
				pstmt.setString(2,accountTransferDTO.getRamDDR());
				pstmt.setInt(3,id);
			}
			else if ("ssd".equals(part)) {
				pstmt.setString(1,accountTransferDTO.getSsdName());
				pstmt.setBoolean(2,accountTransferDTO.getSsdNVMe());
				pstmt.setInt(3,id);
			}
			else if ("cases".equals(part)) {
				pstmt.setString(1,accountTransferDTO.getCasesName());
				pstmt.setString(2,accountTransferDTO.getCasesSize());
				pstmt.setInt(3,accountTransferDTO.getCasesWidth());
				pstmt.setInt(4,id);
			}
			else if ("vga".equals(part)) {
				pstmt.setString(1,accountTransferDTO.getVgaName());
				pstmt.setInt(2,accountTransferDTO.getVgaWidth());
				pstmt.setInt(3,id);
			}	
			
		
			//SQL문 실행
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			disconnect();
		}
		return true;
	}
	
	
	/******************************************************************************************/
	// 부품 삭제 메서드
	/******************************************************************************************/
	public boolean deleteDB(int id, String part) {
		
		
		connect();
		String sqlq = "";
		if ("mainboard".equals(part)) {
			sqlq += "mbNumber";
		}
		else if ("cpu".equals(part)) {
			sqlq += "cpuNumber";
		}
		else if ("ram".equals(part)) {
			sqlq += "ramNumber";
		}
		else if ("ssd".equals(part)) {
			sqlq += "ssdNumber";
		}
		else if ("cases".equals(part)) {
			sqlq += "casesNumber";
		}
		else if ("vga".equals(part)) {
			sqlq += "vgaNumber";
		}	
		
		// id로 매칭하여 delete				
		String sql ="delete from " + part + " where " + sqlq + "=?";
		
		try {
			
			pstmt = conn.prepareStatement(sql);

			// SQL문에 변수 입력
			pstmt.setInt(1,id);
						
			//SQL문 실행
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
		}
		return true;
	}



	
	
}

