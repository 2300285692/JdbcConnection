package example.dao.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookJdbcDao {
	
	private PreparedStatement ptmt = null;
	private ResultSet rs = null;

	public BookJdbcDao() {
	}
	
	
	public void findAll(Connection conn) throws SQLException
	{
		//to do
		
	}
	
	public void delete(Connection conn, int id) throws SQLException
	{
		String sql = "delete from tb_book where id=?";
		try{
			ptmt = conn.prepareStatement(sql);
			// 瀵筍QL璇彞涓殑绗竴涓崰浣嶇璧嬪�
			ptmt.setInt(1, id);
			// 鎵ц鏇存柊鎿嶄綔
			ptmt.executeUpdate();
			
		}finally{
			if (null!=ptmt) {
				ptmt.close();
			}
			
			if (null!=conn) {
				conn.close();
			}
			
		}
		
	}
	
	public void update(Connection conn, int id ,int bookcount) throws SQLException
	{
		//to do
		
	}
	

}
