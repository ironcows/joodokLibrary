package com.ironcows.joodok.mapper;

import com.ironcows.joodok.dto.Librarian;

public interface LibrarianMapper {

	
	/**
	 * 사서 1명 가져오기
	 * @param librarian
	 * @return Librarian type
	 */
	public abstract Librarian getOneLibrarian(Librarian librarian);
	
	
	
	
}
