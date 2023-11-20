package kr.co.green.board.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import kr.co.green.member.controller.loginController;

public class LoginControllerTest {
	
	private loginController lc;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;
	private RequestDispatcher dispatcher;
	
	@BeforeEach
	public void setup () throws Exception {
		lc = new loginController ();
		
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
		session = mock(HttpSession.class);
		dispatcher = mock(RequestDispatcher.class);
		
		when(request.getSession()).thenReturn(session);		
		
		when(request.getRequestDispatcher("/")).thenReturn(dispatcher);

	}
	
	@ParameterizedTest
	
	@CsvSource ({
		"username, password, /freeList.do?cpage=1",
		"'', password,/freeList.do?cpage=1",
		"username, '',/freeList.do?cpage=1"
	})
	
	public void testDoPost(String id, String pwd) throws Exception {
		
		when(request.getParameter("username")).thenReturn(id);
		when(request.getParameter("password")).thenReturn(pwd);
				
		lc.doPost(request, response);
		
		verify(dispatcher).forward(request,response);
	}
}
