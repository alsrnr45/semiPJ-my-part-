package com.kh.faq.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.faq.model.service.FaqService;
import com.kh.faq.model.vo.Faq;

/**
 * Servlet implementation class FaqUpdateServlet
 */
@WebServlet("/update.fa")
public class FaqUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int faqNo = Integer.parseInt(request.getParameter("fno"));
		String qCategory = request.getParameter("category");
		String faqTitle = request.getParameter("title");
		String faqContent = request.getParameter("content");
		
		
		Faq f = new Faq();
		f.setFaqNo(faqNo);
		f.setqCategory(qCategory);
		f.setFaqTitle(faqTitle);
		f.setFaqContent(faqContent);
		
		
		int result = new FaqService().updateFaq(f);
		
		if(result>0) {
			
			request.getSession().setAttribute("alertMsg", "성공적으로 수정됐습니다.");
			response.sendRedirect(request.getContextPath() + "/detail.fa?fno=" + faqNo);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
