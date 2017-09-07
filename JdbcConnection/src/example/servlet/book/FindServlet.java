package example.servlet.book;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import example.bean.book.Book;

/**
 * Servlet implementation class FindServlet
 */
public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
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
			// 娣诲姞鍥句功淇℃伅鐨凷QL璇彞
			String sql = "select * from tb_book";
			// 鑾峰彇Statement
			Statement statement = conn.createStatement();

			ResultSet resultSet = statement.executeQuery(sql);

			List<Book> list = new ArrayList<Book>();
			while (resultSet.next()) {

				Book book = new Book();
				book.setId(resultSet.getInt("id"));
				book.setName(resultSet.getString("name"));
				book.setPrice(resultSet.getDouble("price"));
				book.setBookCount(resultSet.getInt("bookCount"));
				book.setAuthor(resultSet.getString("author"));
				list.add(book);

			}
			request.setAttribute("list", list);
			resultSet.close();
			statement.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("book_list.jsp")
				.forward(request, response);

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
