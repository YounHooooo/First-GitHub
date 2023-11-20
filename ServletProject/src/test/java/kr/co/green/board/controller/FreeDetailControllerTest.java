package kr.co.green.board.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;

public class FreeDetailControllerTest {
	private FreeDetailController fdc;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private RequestDispatcher dispatcher;
	
	@Before
	public void setup() throws Exception {
		fdc = new FreeDetailController();
		
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
		dispatcher = mock(RequestDispatcher.class);
		
		
		when(request.getRequestDispatcher("/views/board/free/freeDetail.jsp")).thenReturn(dispatcher);
	}
	
	@Test
	public void testDoGet () throws Exception {
		when(request.getParameter("idx")).thenReturn("1");
		
		fdc.doGet(request, response);
		verify(dispatcher).forward(request, response);
		
	}
	
}
