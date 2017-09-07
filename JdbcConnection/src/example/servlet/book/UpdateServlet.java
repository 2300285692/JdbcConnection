package example.servlet.book;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int name = Integer.valueOf(request.getParameter("name"));
		int bookCount = Integer.valueOf(request.getParameter("bookCount"));
		try {
			// 鍔犺浇鏁版嵁搴撻┍鍔紝娉ㄥ唽鍒伴┍鍔ㄧ鐞嗗櫒
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// 鏁版嵁搴撹繛鎺ュ瓧绗︿覆
			 String url ="jdbc:sqlserver://localhost:1433;DatabaseName=db_book";
		     String userName = "sa";
			 String password = "123";
			// 鍒涘缓Connection杩炴帴
			Connection conn = DriverManager.getConnection(url, userName,
					password);
			// 鏇存柊SQL璇彞
			String sql = "update tb_book set bookcount=? where name=?";
			// 鑾峰彇PreparedStatement
			PreparedStatement ps = conn.prepareStatement(sql);
			// 瀵筍QL璇彞涓殑绗竴涓弬鏁拌祴鍊�
			ps.setInt(1, bookCount);
			// 瀵筍QL璇彞涓殑绗簩涓弬鏁拌祴鍊�
			ps.setInt(2, name);
			// 鎵ц鏇存柊鎿嶄綔
			ps.executeUpdate();
			// 鍏抽棴PreparedStatement
			ps.close();
			// 鍏抽棴Connection
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 閲嶅畾鍚戝埌FindServlet
		response.sendRedirect("FindServlet");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
