package com.bittago.repository.dao;

import java.util.List;

import com.bittago.repository.vo.Line;
import com.bittago.repository.vo.Reservation;
import com.bittago.repository.vo.Schedule;
import com.bittago.repository.vo.Search;
import com.bittago.repository.vo.Seat;
import com.bittago.repository.vo.Terminal;

public interface ReservationDAO {

//	int DateAtLine(Date date);
	List<Terminal> terminalName(); //전체 터미널 출력
	List<Terminal> arrivals(int no); //출발지 선택후 도착지 출력
	List<Line> lineSelect(Search search); //출, 도착지 선택후 노선 출력
	String tName(int i);//터미널번호에 해당하는 터미널이름 출력
	List<Line> selectAll(Search search); //출, 도착지, 출발날짜 선택 후 노선 출력
	
	int insertReservation(Reservation reservation);
	int insertSeat(Seat seat);
	int insertSchedule(Schedule schedule);
	
	
}
