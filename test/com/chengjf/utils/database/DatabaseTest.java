package com.chengjf.utils.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库操作示例
 * 
 * @author chengjianfeng
 * @date 2016-07-20
 */
public class DatabaseTest {

	public static void main(String[] args) {
		sqliteTest();
		mysqlTest();
		mybatisSql();
	}

	/**
	 * sqlite数据库测试，需要引入sqlite的JDBC包。
	 */
	private static void sqliteTest() {

		try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager
					.getConnection("jdbc:sqlite:test.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.

			statement.executeUpdate("drop table if exists person");
			statement
					.executeUpdate("create table person (id integer, name string)");
			statement.executeUpdate("insert into person values(1, 'leo')");
			statement.executeUpdate("insert into person values(2, 'yui')");
			ResultSet rs = statement.executeQuery("select * from person");
			while (rs.next()) {
				// read the result set
				System.out.println("name = " + rs.getString("name"));
				System.out.println("id = " + rs.getInt("id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * mysql数据库测试，需要引入mysql的JDBC包。
	 */
	private static void mysqlTest() {
		// TODO
	}

	/**
	 * java.sql的日志是原SQL和参数分开，自己验证SQL的话需要手动将参数写进去<br/>
	 * 所以写了该方法，将SQL和参数拼装在一起
	 */
	private static void mybatisSql() {
		String sqlStr = "select codeId, description from ( select s.securno codeId,   s.secur_abbr_name   description from security_info s,wealth_pro_valuation_rel b where s.secur_type   = ? and s.securno = b.securno        and     s.marketno = ?          order by securid ) where rownum <= 1000  ";
		String params = "9, W";
		for (String str : params.split(", ")) {
			sqlStr = sqlStr.replaceFirst("\\?", "'" + str + "'");
		}
		System.out.println(sqlStr);

	}
}
