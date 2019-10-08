package com.bittago.repository.dao;

import java.util.List;

import com.bittago.repository.vo.Bus;
import com.bittago.repository.vo.Line;
import com.bittago.repository.vo.Page;
import com.bittago.repository.vo.ScheduleList;
import com.bittago.repository.vo.Terminal;

public interface AdminDAO {
	/* 버스 관련 ======================================== */
	public List<Bus> selectBus(Page page);	// 버스 전체 조회
	public Bus selectOneBus(int busNo);		// 버스 상세 조회
	public void insertBus(Bus bus);			// 버스 추가
	public void deleteBus(int busNo);		// 버스 삭제
	public int selectBusCount();			// 버스 전체 개수
	public List<Terminal> selectTerminal();		// 터미널 전체 조회
	
	/* 노선 관련 ======================================== */
	public List<Line> selectLine();			// 노선 전체 조회
	public Line selectOneLine(int lineNo);  // 노선 상세 조회
	public void insertLine(Line line);		// 노선 추가
	public void deleteLine(int lineNo);		// 노선 삭제
	public void updateLine(int lineNo);		// 노선 수정
	
	/* 스케줄 관련 ======================================== */
	public List<ScheduleList> selectSchedule();
	public int selectScheduleCount();
	
	/* 통계 관련 ======================================== */
	public List<Integer> selectYearReservationCnt();	//년도별 예약수
	public List<Integer> selectMonthReservationCnt();





}
