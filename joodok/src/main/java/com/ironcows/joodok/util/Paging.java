package com.ironcows.joodok.util;

public class Paging {

	int maxPost;		// 페이지당 표시될 게시물 최대 갯수 및 현재 게시물 갯수
	int firstPageNo;	// 첫번째 페이지 번호
	int prevPageNo;		// 이전 페이지 번호
	int startPageNo;	// 시작 페이지
	int currentPageNo;  // 현재 페이지 번호
	int endPageNo;		// 끝 페이지
	int nextPageNo;	  	// 다음 페이지 번호
	int finalPageNo;	// 마지막 페이지 번호
	int numberOfRecords;// 전체 레코드 수
	int sizeOfPage;		// 보여지는 페이지 갯수(1, 2, 3, 4, 5)

	public Paging(int currentPageNo, int maxPost) {
		this.currentPageNo = currentPageNo;
		this.sizeOfPage = 5; // 기본 페이지를 5개로 표시하도록 설정
		// 게시물 최대 갯수가 0개가 아니라면 현재 게시물 갯수(maxPost)이고,
		// 만약 게시물 수가 0개라면 10개 표현이다.(10은 3항 연산자에 의한 고정값)
		this.maxPost = (maxPost != 0) ? maxPost : 10;
	}

	public int getMaxPost() {
		return maxPost;
	}

	public void setMaxPost(int maxPost) {
		this.maxPost = maxPost;
	}

	public int getFirstPageNo() {
		return firstPageNo;
	}

	public void setFirstPageNo(int firstPageNo) {
		this.firstPageNo = firstPageNo;
	}

	public int getPrevPageNo() {
		return prevPageNo;
	}

	public void setPrevPageNo(int prevPageNo) {
		this.prevPageNo = prevPageNo;
	}

	public int getStartPageNo() {
		return startPageNo;
	}

	public void setStartPageNo(int startPageNo) {
		this.startPageNo = startPageNo;
	}

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public int getEndPageNo() {
		return endPageNo;
	}

	public void setEndPageNo(int endPageNo) {
		this.endPageNo = endPageNo;
	}

	public int getNextPageNo() {
		return nextPageNo;
	}

	public void setNextPageNo(int nextPageNo) {
		this.nextPageNo = nextPageNo;
	}

	public int getFinalPageNo() {
		return finalPageNo;
	}

	public void setFinalPageNo(int finalPageNo) {
		this.finalPageNo = finalPageNo;
	}

	public int getNumberOfRecords() {
		return numberOfRecords;
	}

	public void setNumberOfRecords(int numberOfRecords) {
		this.numberOfRecords = numberOfRecords;
	}

	public int getSizeOfPage() {
		return sizeOfPage;
	}

	public void setSizeOfPage(int sizeOfPage) {
		this.sizeOfPage = sizeOfPage;
	}
	
	//페이징 생성
	public void makePaging() {
		//게시물이 1개도 없다면 return 으로 종료, 게시물이 하나도 나타나지 않게 된다.
		if(numberOfRecords == 0) {
			return;
		}
		
		//현재 페이지가 0 이라면(게시물이 1개도 없다면)
		if(currentPageNo == 0) {
			setCurrentPageNo(1);
		}
		
		//한 페이지당 10개의 게시물을 표시하도록 고정값 10을 설정
		if(maxPost == 0) {
			setMaxPost(10);
		}
		
		//finalPageNo 의 값을 설정하기 위한 변수 설정
		//finalPage = (전체 게시물 수 + (한 페이지당 최대 게시물수 - 1)) / 한 페이지당 최대 게시물 수
		int finalPage = (numberOfRecords + (maxPost - 1)) / maxPost;
		
		//현재 페이지가 마지막 페이지보다 큰 경우에 마지막 페이지로 재설정
		//ex) 마지막 페이지가 9인데 6페이지에서 '다음' 을 누르게 되면 11페이지로 가야 하는데 11페이지는 없으므로
		//    9페이지로 재설정 하는 것
		if(currentPageNo > finalPage) {
			setCurrentPageNo(finalPage);
		}
		
		//현재 페이지가 0보다 작다면 1페이지로 고정하도록 설정
		//1~5페이지 에서 [이전]을 누를 경우 -5 ~ -1 페이지를 보여주어야 하는데 그럴 수가 없으므로!
		//해당 페이징 모듈에서는 1~5 페이지에서는 [이전] 을 표시하지 않을 것이므로 아래의 설정이 크게 의미는 없다
		if(currentPageNo < 0) {
			currentPageNo = 1;
		}
		
		//현재 페이지가 1페이지이면 true 아니면 false
		boolean isNowFirst = currentPageNo == 1 ? true : false;
		//현재 페이지가 마지막 페이지랑 같으면 true 아니면 false
		boolean isNowFinal = currentPageNo == finalPage ? true : false;
		
		//페이지의 이동을 할 때 표시가 될 시작페이지와 끝페이지를 위한 설정
		//ex) 현재 페이지가 4일 경우 ((4 - 1) / sizeOfPage(5)) * 5 + 1 => 1페이지가 첫 페이지
		//ex) 현재 페이지가 7일 경우 ((7 - 1) / sizeOfPage(5)) * 5 + 1 => 6페이지가 첫 페이지
		int startPage = ((currentPageNo - 1) / sizeOfPage) * sizeOfPage + 1;
		//ex) 현재 페이지가 4일 경우 첫 페이지는 1, 1 + 5 - 1 => 5 가 끝페이지
		//ex) 현재 페이지가 7일 경우 첫 페이지는 6, 6 + 5 - 1 => 10 가 끝페이지
		int endPage = startPage + sizeOfPage - 1;
		
		//만약 게시물 갯수가 81개여서 finalPage가 9인데,
		//1~5페이지에서 [다음] 버튼을 누르면 sizeOfPage 변수에 따라 5개씩 표시가 되어
		//6~10 페이지가 표시되는 오류가 발생한다. 그렇기에 9페이지까지만 표시될 수 있도록
		//endPage의 값을 재설정한다.
		if(endPage > finalPage) {
			endPage = finalPage;
		}
		
		//시작 페이지를 1로 설정
		setFirstPageNo(1);
		
		//startPage(초기값 1)이 1보다 작으면 1페이지를 표시하고, 그게 아니라면 (시작페이지 - 1) 을 표시
		//ex) 8페이지에 있는 경우 이전을 누르면 초기페이지(6)에서 -1을 한 5페이지가 표시된다.
		if(!isNowFirst) {
			setPrevPageNo((startPage - 1) < 1 ? 1 : (startPage - 1));
		}
		
		//위에서 설정한 startPage와 endPage의 변수에 설정한 값으로
		//startPageNo 와 endPageNo 를 설정한다.
		setStartPageNo(startPage);
		setEndPageNo(endPage);
		
		//끝 페이지는 13페이지인데 내가 현제 7페이지에 있을 때 [다음] 을 클릭하면 아래의 조건을 수행
		//현재 있는 페이지(7)가 있는 블록의 끝 페이지(endPage)는 10 이고
		//그 페이지에 1을 더한 값이 finalPage(13) 보다 크면 finalPage를, 아니면 endPage+1 을 합한 11을 표시한다 
		if(!isNowFinal) {
			setNextPageNo(((endPage + 1 > finalPage ? finalPage : (endPage + 1))));
		}
		
		//위에서 설정한 finalPage 변수에 설정한 값으로
		//finalPageNo 를 설정한다.
		setFinalPageNo(finalPage);
	}
	
	
}
