package member;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import common.ConnectDB;

public class MemberDAO extends ConnectDB {
	public int insertMember(MemberDTO member) {
		
		String sql = "insert into MEMBER"
				+ "	(M_ID,M_NAME,M_BIRTH,M_LEVEL,M_GENDER,P_NUMBER,EMAIL,NICKNAME,PASSWORD,M_TYPECODE,REG_DATE) "
				+ " values('11',?,?,?,?,?,?,?,?,?,SYSDATE)";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, member.getMemberName());
			psmt.setString(2, member.getBirth());
			psmt.setString(3, member.getLevel());
			psmt.setString(4, member.getGender());
			psmt.setString(5, member.getPhoneNumber());
			psmt.setString(6, member.getEmail());
			psmt.setString(7, member.getNickName());
			psmt.setString(8, member.getPassword());
			psmt.setString(9, member.getMemberTypeId());
			return psmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("회원가입 중 오류");
			e.printStackTrace();
		}
		return 0;
	}
	
	public MemberDTO getMember(String id) {
		String sql="select * from member where email=?";
		MemberDTO dto=null;
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			rs=psmt.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setBirth(rs.getString("m_birth"));
				dto.setEmail(rs.getString("email"));
				dto.setGender(rs.getString("m_gender"));
				dto.setLevel(rs.getString("m_level"));
				dto.setMemberId(rs.getString("m_id"));
				dto.setMemberName(rs.getString("m_name"));
				dto.setMemberTypeId(rs.getString("m_typecode"));
				dto.setNickName(rs.getString("nickname"));
				dto.setPassword(rs.getString("password"));
				dto.setPhoneNumber(rs.getString("p_number"));
				dto.setRegDate(rs.getDate("reg_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public List<MemberDTO> getMemberList(Map<String, Object> param) {
		List<MemberDTO> list = new ArrayList<>();
		
		String query = "select * from ("
				+ "select row_number() over(order by m_id desc) pnum, m.* "
				+ "from member m ";
		if (param.get("searchValue") != null) {
			query += "where "+param.get("searchType")+" like '%"+param.get("searchValue")+"%' ";
			//query += "where ? like '%?%' ";
		}
		query += "order by m_id desc"
			+ ")";
			//+ " where pnum between ? and ?";
		
		try {
			psmt = con.prepareStatement(query);
//			psmt.setString(1, param.get("searchType").toString());
//			psmt.setString(2, param.get("searchValue").toString());
//			psmt.setString(3, param.get("start").toString());
//			psmt.setString(4, param.get("end").toString());
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setBirth(rs.getString("m_birth"));
				dto.setEmail(rs.getString("email"));
				dto.setGender(rs.getString("m_gender"));
				dto.setLevel(rs.getString("m_level"));
				dto.setMemberId(rs.getString("m_id"));
				dto.setMemberName(rs.getString("m_name"));
				dto.setMemberTypeId(rs.getString("m_typecode"));
				dto.setNickName(rs.getString("nickname"));
				dto.setPassword(rs.getString("password"));
				dto.setPhoneNumber(rs.getString("p_number"));
				dto.setRegDate(rs.getDate("reg_date"));
				list.add(dto);
			}
		}
		catch (Exception e) {
			System.out.println("게시물 목록 조회 중 에러");
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
	
}
