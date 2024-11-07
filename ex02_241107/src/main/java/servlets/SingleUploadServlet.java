package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.ImageDao;
import dto.Image;

@MultipartConfig
@WebServlet("/singleUpload")
public class SingleUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String getFilename(Part part) {
		String contentDispositionHeader = part.getHeader("content-disposition");
//		System.out.println(contentDispositionHeader);
		String[] elements = contentDispositionHeader.split(";");
		for(String element : elements) {
			if(element.trim().startsWith("filename")) {
				return element.substring(element.indexOf('=') + 1)	// =뒤에 문자열이 필요해서 +1을 부여함.
						.trim().replace("\"", "");
			}
		}
		return null;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ImageDao dao = new ImageDao();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Part part = request.getPart("filename");
		String fileName = getFilename(part);
		if(fileName != null && !fileName.isEmpty()) {
			part.write(getServletContext().getRealPath("/images") + "/" + fileName);
		}
		
		PrintWriter out = response.getWriter();
		out.print("<br>업로드한 파일이름 : " + fileName);
		out.print("<br>크기 : " + part.getSize());
		
		String author = request.getParameter("author");
		out.print("<br>작성자 : " + author);
		out.print("<hr>");
		out.print("<img src='images/" + fileName + "' >");
		
		dao.regFilename(fileName, author);
		
		List<Image> list = dao.getIamgeList();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

}
