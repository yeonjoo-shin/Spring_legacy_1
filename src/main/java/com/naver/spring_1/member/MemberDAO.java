package com.naver.spring_1.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//import com.naver.point.PointDTO;
import com.naver.util.DBConnect;

public class MemberDAO {
	//1.Join
	public int memberAdd(MemberVO memberVO) throws Exception{
		Connection con = DBConnect.getConnect();
		
		String sql = "insert into member values(?,?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		//?값 세팅
		st.setString(1, memberVO.getId());
		st.setString(2,memberVO.getUpw());
		st.setString(3, memberVO.getUname());
		st.setInt(4,memberVO.getAge());
		st.setString(5, memberVO.getEmail());
		st.setInt(6,memberVO.getPhone());
		
		System.out.println("save");
		int result = st.executeUpdate();
		System.out.println(result);
		System.out.println("save result");
		st.close();
		con.close();
		
		return result;
	
	}
	
	//2. Login
	public MemberVO memberLogin(MemberVO memberVO) throws Exception{
		Connection con = DBConnect.getConnect();
		String sql = "select * from member where id=? and upw=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		//?세팅
		st.setString(1, memberVO.getId());
		st.setString(2,memberVO.getUpw());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {//로그인 성공
			memberVO.setUname(rs.getString("uname"));
			memberVO.setEmail(rs.getString("email"));
			memberVO.setPhone(rs.getInt("phone"));
			memberVO.setAge(rs.getInt("age"));
		}else {//로그인 실패
			memberVO=null;
			
		}
		
		rs.close();
		st.close();
		con.close();
		
		return memberVO;
	
		
	}
	//3.Delete
	public int memberDelete(MemberVO memberVO)throws Exception{
		int result =0;
		Connection con = DBConnect.getConnect();
		String sql="delete member where id=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, memberVO.getId());
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		return result;
		
	}
	//4.update
	public int memberUpdate(MemberVO memberVO) throws Exception{
		Connection con = DBConnect.getConnect();
		String sql = "UPDATE member set id=?,upw=?,uname=?,age=?,email=?,phone=? where id=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		//정보는 모든 것을 가져와야함
		st.setString(1, memberVO.getId());
		st.setString(2,memberVO.getUpw());
		st.setString(3, memberVO.getUname());
		st.setInt(4,memberVO.getAge());
		st.setString(5, memberVO.getEmail());
		st.setInt(6,memberVO.getPhone());
		st.setString(7,memberVO.getId());
		
		int result=st.executeUpdate();
		System.out.println(result);
		st.close();
		con.close();
		
		return result;
	}
	
	
	
}
