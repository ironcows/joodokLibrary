package com.ironcows.joodok.mapper;

import com.ironcows.joodok.dto.Librarian;
import com.ironcows.joodok.dto.Member;

public interface LoginMapper {

	/**
	 * member 로그인
	 * @param member
	 * @return Member type
	 */
	public abstract Member loginMember(Member member);
	
	/**
	 * librarian 로그인
	 * @param librarian
	 * @return Librarian type
	 */
	public abstract Librarian loginLibrarian(Librarian librarian);
	
	
	
	
}
