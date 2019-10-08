package com.bittago.reservation.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bittago.common.db.SqlConfig;
import com.bittago.repository.dao.ReservationDAO;
import com.bittago.repository.vo.Board;
import com.bittago.repository.vo.Reservation;
import com.bittago.repository.vo.Schedule;
import com.bittago.repository.vo.Seat;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

@WebServlet("/reservation/reservationSendEmail.do")
public class ReservationSendEmail extends HttpServlet {
	
	private ReservationDAO reservdao;

	public ReservationSendEmail() {
		this.reservdao = SqlConfig.getSqlSessionInstance().getMapper(ReservationDAO.class);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 여기는 아직 수정중 나중에 더 보충해야 함
		Reservation reservation = new Reservation();
		reservation.setRsvNo(reservation.getRsvNo());
		reservation.setSchNo(Integer.parseInt(req.getParameter("schNo")));
		reservation.setUserNo(Integer.parseInt(req.getParameter("userNo")));
		reservation.setNonuserNo(Integer.parseInt(req.getParameter("nonuserNo")));
		reservation.setAdultsCnt(Integer.parseInt(req.getParameter("adulsCnt")));
		reservation.setKidsCnt(Integer.parseInt(req.getParameter("kidsCnt")));
		reservation.setPayment(Integer.parseInt(req.getParameter("payment")));
		reservation.setRsvState(0);
		reservdao.insertReservation(reservation);
		
		Seat seat = new Seat();
		seat.setRsvNo(reservation.getRsvNo());
		String[] seatNo = req.getParameterValues("seatNo");
		for(int i = 0; i < seatNo.length; i++) {
			seat.setRsvNo(reservation.getRsvNo());
			seat.setSeatNo(Integer.parseInt(seatNo[i]));
			};
		reservdao.insertSeat(seat);
		
		Schedule schedule = new Schedule();
		schedule.setLineNo(Integer.parseInt(req.getParameter("lineNo")));
		schedule.setSchNo(reservation.getSchNo());
		schedule.setSchDate(new Date());
		reservdao.insertSchedule(schedule);
		
		
		
		
//		System.out.println(req.getParameter("price"));
//		System.out.println(req.getParameterValues("seatNo" + "결제정보 테이블이 필요하다"));
//
//		req.setAttribute("adulsCnt", req.getParameter("adulsCnt"));
//		req.setAttribute("kidsCnt", req.getParameter("kidsCnt"));
//		req.setAttribute("payment", req.getParameter("payment"));
//		req.setAttribute("seatNo", req.getParameterValues("seatNo"));
//		req.getRequestDispatcher("/jsp/reservation/NewFile.jsp").forward(req, res);

	}
	
	
	public static void main(String[] args) {
		// 네이버를 사용함
		String host = "smtp.naver.com";
		// 보내는 사람 네이버 아이디랑 비밀번호
		final String user = "naver_id";
		final String password = "password";
	
		// 받는 사람 이메일 주소 적으면 됨
		String to = "";

		// get the session object
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});

		// Compose the message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Subject
			// 메일 제목
			message.setSubject("[Subject] Java Mail Test");

			// Text
			// 보낼 내용을 적으면 됨
			message.setText("ui에 있는 내용 전부 보내기.");

			// send the message
			Transport.send(message);
			System.out.println("message sent successfully...");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	
}
