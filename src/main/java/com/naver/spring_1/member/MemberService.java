package com.naver.spring_1.member;

public class MemberService {
	private MemberDAO memberDAO;
	
	public MemberService() {
		this.memberDAO = new MemberDAO();
	}
	//join
	public int memberAdd(MemberVO memberDTO) throws Exception{
		int result = memberDAO.memberAdd(memberDTO);
		return result;
	}
	//login
	public MemberVO memberLogin(MemberVO memberDTO) throws Exception{
		return memberDAO.memberLogin(memberDTO); // 리턴갑은  null or null 아닌값
	}
	//delete
	public int memberDelete(MemberVO memberDTO) throws Exception{
		return memberDAO.memberDelete(memberDTO);
	}
	//update
	public int memberUpdate(MemberVO memberDTO) throws Exception{
		return memberDAO.memberUpdate(memberDTO);
	}
}
