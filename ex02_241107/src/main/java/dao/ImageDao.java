package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Image;

public class ImageDao {
	Connection conn = DBcon.getConnection();
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	public int regFilename(String filename, String writer) {
		int result = 0;
		String query = "INSERT INTO images_241107 (title, writer) VALUES (?, ?)";
		try {
			stmt = conn.prepareStatement(query);
			stmt.setString(1, filename);
			stmt.setString(2, writer);
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Image> getIamgeList(){
		List<Image> list = new ArrayList<>();
		String sql = "SELECT title, writer FROM Images_241107";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				
				Image img = new Image();
				img.setTitle(title);
				img.setWriter(writer);
				list.add(img);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
