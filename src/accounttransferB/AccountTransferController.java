// 패키지 정의
package accounttransferB;

// 서블릿 패키지 import
import java.io.*;
// import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

import org.json.simple.JSONObject;

import javax.servlet.annotation.WebServlet;

// 자바 클래스 import
import java.util.ArrayList;

// 어너테이션 서블릿과 URL 정의, urlPatters는 절대 Path
@WebServlet(description = "accounttransfer Controller 서블릿", urlPatterns = {
		"/accounttransferB/AccountTransferController" })
public class AccountTransferController extends HttpServlet {

	// 객체 직렬화(Serializable), 이클립스에서 자동 생성은 클래스 이름에서 Ctrl + 1
	private static final long serialVersionUID = 1L;

	// _jspxFactory 생성
	private static final javax.servlet.jsp.JspFactory _jspxFactory = javax.servlet.jsp.JspFactory.getDefaultFactory();

	// GET 요청을 처리하기 위한 메서드
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// doPost()로 포워딩.
		doPost(request, response);
	}

	// POST 요청을 처리하기 위한 메서드, doGet()에서도 호출하고 있기 때문에 모든 요청은 doPost()에서 처리되는 구조이다.
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		// pageContext 참조변수 선언
		// javax.servlet.jsp.PageContext pageContext = null;
		PageContext pageContext = null;

		try {

			// pageContext 참조변수 객체 생성
			pageContext = _jspxFactory.getPageContext(this, request, response, null, true, 8192, true);

			// 한글 인코딩
			request.setCharacterEncoding("UTF-8");

			// 클라이언트 응답시 전달될 컨텐트에 대한 타잎 설정과 캐릿터셋 지정
			response.setContentType("text/html; charset=UTF-8");

			// action구분 등 파라메터
			String action = request.getParameter("action");
			String part = (String) request.getParameter("part");
			System.out.println("Controller action = " + action);

			// 클라이언트 응답을 위한 출력 스트림 확보(alert 메세지용)
			PrintWriter out = response.getWriter();

			// accountTransferDTO 변수 정의
			AccountTransferDTO accountTransferDTO = new AccountTransferDTO();

			/* action에 따라 동작 */
			if ( (action.equals("insert_mainboard")) || ((action.equals("update")) && (part.equals("mainboard")))) {
				accountTransferDTO.setMbName(request.getParameter("mbName"));
				accountTransferDTO.setMbChipset(request.getParameter("mbChipset"));
				accountTransferDTO.setMbDDR(request.getParameter("mbDDR"));
				accountTransferDTO.setMbNVMe(Boolean.valueOf(request.getParameter("mbNVMe")));
				accountTransferDTO.setMbSize(request.getParameter("mbSize"));
			} else if ((action.equals("insert_cpu")) || ((action.equals("update")) && (part.equals("cpu")))) {
				accountTransferDTO.setCpuName(request.getParameter("cpuName"));
				accountTransferDTO.setCpuChipset(request.getParameter("cpuChipset"));
			} else if ((action.equals("insert_ram")) || ((action.equals("update")) && (part.equals("ram")))) {
				accountTransferDTO.setRamName(request.getParameter("ramName"));
				accountTransferDTO.setRamDDR(request.getParameter("ramDDR"));
			} else if ((action.equals("insert_ssd")) || ((action.equals("update")) && (part.equals("ssd")))) {
				accountTransferDTO.setSsdName(request.getParameter("ssdName"));
				accountTransferDTO.setSsdNVMe(Boolean.valueOf(request.getParameter("ssdNVMe")));
			} else if ((action.equals("insert_cases")) || ((action.equals("update")) && (part.equals("cases")))) {
				accountTransferDTO.setCasesName(request.getParameter("casesName"));
				accountTransferDTO.setCasesSize(request.getParameter("casesSize"));
				accountTransferDTO.setCasesWidth(Integer.parseInt((String) request.getParameter("casesWidth")));
			} else if ((action.equals("insert_vga")) || ((action.equals("update")) && (part.equals("vga")))) {
				accountTransferDTO.setVgaName(request.getParameter("vgaName"));
				accountTransferDTO.setVgaWidth(Integer.parseInt((String) request.getParameter("vgaWidth")));
			}

			// accountTransferDAO 변수 정의
			AccountTransferDAO accountTransferDAO = new AccountTransferDAO();

			/* action에 따라 동작 */
			if (action.equals("mainboard_list")) {

				// 컴퓨터 부품 조회
				ArrayList<AccountTransferDTO> accountTransferList = accountTransferDAO.getDBList("mainboard");

				// List를 setAttribute
				request.setAttribute("action", action);
				request.setAttribute("part", part);
				
				request.setAttribute("accountTransferList", accountTransferList);

				pageContext.forward("accounttransfer_list.jsp");

			} else if (action.equals("cpu_list")) {

				// 부품 조회결과
				ArrayList<AccountTransferDTO> accountTransferList = accountTransferDAO.getDBList("cpu");

				// List를 setAttribute
				request.setAttribute("action", action);
				request.setAttribute("accountTransferList", accountTransferList);

				pageContext.forward("accounttransfer_list.jsp");

			} else if (action.equals("ram_list")) {

				// 부품 조회결과
				ArrayList<AccountTransferDTO> accountTransferList = accountTransferDAO.getDBList("ram");

				// List를 setAttribute
				request.setAttribute("action", action);
				request.setAttribute("accountTransferList", accountTransferList);

				pageContext.forward("accounttransfer_list.jsp");

			} else if (action.equals("ssd_list")) {

				// 부품 조회결과
				ArrayList<AccountTransferDTO> accountTransferList = accountTransferDAO.getDBList("ssd");

				// List를 setAttribute
				request.setAttribute("action", action);
				request.setAttribute("accountTransferList", accountTransferList);

				pageContext.forward("accounttransfer_list.jsp");

			} else if (action.equals("cases_list")) {

				// 부품 조회결과
				ArrayList<AccountTransferDTO> accountTransferList = accountTransferDAO.getDBList("cases");

				// List를 setAttribute
				request.setAttribute("action", action);
				request.setAttribute("accountTransferList", accountTransferList);

				pageContext.forward("accounttransfer_list.jsp");

			} else if (action.equals("vga_list")) {

				// 부품 조회결과
				ArrayList<AccountTransferDTO> accountTransferList = accountTransferDAO.getDBList("vga");

				// List를 setAttribute
				request.setAttribute("action", action);
				request.setAttribute("accountTransferList", accountTransferList);

				pageContext.forward("accounttransfer_list.jsp");

			}

			else if (action.equals("add_mainboard")) {

				// 부품 입력화면 오픈
				request.setAttribute("action", action);

				pageContext.forward("accounttransfer_view.jsp");

			} else if (action.equals("add_cpu")) {

				// 부품 입력화면 오픈
				request.setAttribute("action", action);

				pageContext.forward("accounttransfer_view.jsp");

			} else if (action.equals("add_ram")) {

				// 부품 입력화면 오픈
				request.setAttribute("action", action);

				pageContext.forward("accounttransfer_view.jsp");
			} else if (action.equals("add_ssd")) {
				// 부품 입력화면 오픈
				request.setAttribute("action", action);

				pageContext.forward("accounttransfer_view.jsp");
			} else if (action.equals("add_cases")) {

				// 부품 입력화면 오픈
				request.setAttribute("action", action);

				pageContext.forward("accounttransfer_view.jsp");

			} else if (action.equals("add_vga")) {

				// 부품 입력화면 오픈
				request.setAttribute("action", action);

				pageContext.forward("accounttransfer_view.jsp");

			}

			/******************************************************************************************/
			// INSERT
			/******************************************************************************************/

			else if (action.equals("insert_mainboard")) {
				String str = "mainboard";
				if (accountTransferDAO.insertDB(str, accountTransferDTO)) {

					ArrayList<AccountTransferDTO> accountTransferList = accountTransferDAO.getDBList("mainboard");

					request.setAttribute("action", "mainboard_list");
					request.setAttribute("accountTransferList", accountTransferList);
					pageContext.forward("accounttransfer_list.jsp");

				} else {
					throw new Exception("DB 입력오류");
				}

			}

			else if (action.equals("insert_cpu")) {
				String str = "cpu";
				if (accountTransferDAO.insertDB(str, accountTransferDTO)) {

					ArrayList<AccountTransferDTO> accountTransferList = accountTransferDAO.getDBList("cpu");

					request.setAttribute("action", "cpu_list");
					request.setAttribute("accountTransferList", accountTransferList);
					pageContext.forward("accounttransfer_list.jsp");

				} else {
					throw new Exception("DB 입력오류");
				}

			} else if (action.equals("insert_ram")) {
				String str = "ram";
				if (accountTransferDAO.insertDB(str, accountTransferDTO)) {

					ArrayList<AccountTransferDTO> accountTransferList = accountTransferDAO.getDBList("ram");

					request.setAttribute("action", "ram_list");
					request.setAttribute("accountTransferList", accountTransferList);
					pageContext.forward("accounttransfer_list.jsp");

				} else {
					throw new Exception("DB 입력오류");
				}

			} else if (action.equals("insert_ssd")) {
				String str = "ssd";
				if (accountTransferDAO.insertDB(str, accountTransferDTO)) {

					ArrayList<AccountTransferDTO> accountTransferList = accountTransferDAO.getDBList("ssd");

					request.setAttribute("action", "ssd_list");
					request.setAttribute("accountTransferList", accountTransferList);
					pageContext.forward("accounttransfer_list.jsp");

				} else {
					throw new Exception("DB 입력오류");
				}

			} else if (action.equals("insert_cases")) {
				String str = "cases";
				if (accountTransferDAO.insertDB(str, accountTransferDTO)) {

					ArrayList<AccountTransferDTO> accountTransferList = accountTransferDAO.getDBList("cases");

					request.setAttribute("action", "cases_list");
					request.setAttribute("accountTransferList", accountTransferList);
					pageContext.forward("accounttransfer_list.jsp");

				} else {
					throw new Exception("DB 입력오류");
				}

			} else if (action.equals("insert_vga")) {
				String str = "vga";
				if (accountTransferDAO.insertDB(str, accountTransferDTO)) {

					ArrayList<AccountTransferDTO> accountTransferList = accountTransferDAO.getDBList("vga");

					request.setAttribute("action", "vga_list");
					request.setAttribute("accountTransferList", accountTransferList);
					pageContext.forward("accounttransfer_list.jsp");

				} else {
					throw new Exception("DB 입력오류");
				}

			}
			/******************************************************************************************/
			// EDIT
			/******************************************************************************************/
			else if (action.equals("edit")) {

				// edit용 1건을 select
				accountTransferDTO = accountTransferDAO.getDB(Integer.parseInt((String) request.getParameter("id")),
						part);
				
				// edit를 setAttribute
				request.setAttribute("id", Integer.parseInt((String) request.getParameter("id")));
				request.setAttribute("action", action);
				request.setAttribute("part", part);
				request.setAttribute("accountTransferDTO", accountTransferDTO);

				pageContext.forward("accounttransfer_view.jsp");

			} else if (action.equals("update")) {

				// 부품 수정

				if (accountTransferDAO.updateDB(Integer.parseInt((String) request.getParameter("id")), part,
						accountTransferDTO)) {

					// 부품 조회결과
					ArrayList<AccountTransferDTO> accountTransferList = accountTransferDAO.getDBList(part);

					// List를 setAttribute
					request.setAttribute("accountTransferList", accountTransferList);

					// 결과 조회를 위하여 조회화면 호출
					pageContext.forward("accounttransfer_list.jsp");
				} else {
					throw new Exception("DB 수정오류");
				}

			} else if (action.equals("delete")) {

				// 부품 삭제
				if (accountTransferDAO.deleteDB(Integer.parseInt((String) request.getParameter("id")), part)) {

					// 부품 조회결과
					ArrayList<AccountTransferDTO> accountTransferList = accountTransferDAO.getDBList("mainboard");

					// List를 setAttribute
					request.setAttribute("accountTransferList", accountTransferList);

					// 결과 조회를 위하여 조회화면 호출
					pageContext.forward("accounttransfer_list.jsp");
				} else {
					throw new Exception("DB 삭제오류");
				}

			} 

			
			
			
			else {

				out.println("<script>alert('action 파라미터를 확인해 주세요!!!')</script>");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
