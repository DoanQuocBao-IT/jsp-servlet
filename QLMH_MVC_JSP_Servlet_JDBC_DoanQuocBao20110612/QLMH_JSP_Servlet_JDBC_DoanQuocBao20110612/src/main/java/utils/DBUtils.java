package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.MonHoc;

public class DBUtils {
	public static List<MonHoc> listMonHoc(Connection conn) throws SQLException {
		String sql = "Select a.maso_monhoc, a.ten_monhoc, a.sotinchi from MONHOC a ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<MonHoc> list = new ArrayList<MonHoc>();
		while (rs.next()) {
			int maso_monhoc = rs.getInt("maso_monhoc");
			String ten_monhoc = rs.getString("ten_monhoc");
			int sotinchi = rs.getInt("sotinchi");
			MonHoc monhoc = new MonHoc();
			monhoc.setMaso_monhoc(maso_monhoc);
			monhoc.setTen_monhoc(ten_monhoc);
			monhoc.setSotinchi(sotinchi);
			list.add(monhoc);
		}
		return list;
	}

	public static MonHoc findMonhoc(Connection conn, int maso_monhoc) throws SQLException {
		String sql = "Select a.maso_monhoc, a.ten_monhoc, a.sotinchi from MONHOC a where a.maso_monhoc=?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, maso_monhoc);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			String ten_monhoc = rs.getString("ten_monhoc");
			int sotinchi = rs.getInt("sotinchi");
			MonHoc monHoc = new MonHoc(maso_monhoc, ten_monhoc, sotinchi);
			return monHoc;
		}
		return null;
	}

	public static void updateMonhoc(Connection conn, MonHoc monhoc) throws SQLException {
		String sql = "Update MONHOC set ten_monhoc =?, sotinchi=? where maso_monhoc=? ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, monhoc.getTen_monhoc());
		pstm.setInt(2, monhoc.getSotinchi());
		pstm.setInt(3, monhoc.getMaso_monhoc());
		pstm.executeUpdate();
	}

	public static void insertMonhoc(Connection conn, MonHoc monhoc) throws SQLException {
		String sql = "Insert into MONHOC(maso_monhoc, ten_monhoc,sotinchi) values (?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setInt(1, monhoc.getMaso_monhoc());
		pstm.setString(2, monhoc.getTen_monhoc());
		pstm.setInt(3, monhoc.getSotinchi());

		pstm.executeUpdate();
	}

	public static void deleteMonhoc(Connection conn, int maso_monhoc) throws SQLException {
		String sql = "Delete From MONHOC where maso_monhoc= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setInt(1, maso_monhoc);

		pstm.executeUpdate();
	}
}
