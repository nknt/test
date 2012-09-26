package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.roseindia.form.Account;

public class DBAccount extends DBActionSupport{
	public Account login(String username, String password) {
		initializeConnection();
		// Just test
		PreparedStatement pstmt = null;
		Account account = null;
		String cmd = "SELECT firstName, lastName, type FROM account WHERE username = ? AND password = ?";
		
		try {
			pstmt = con.prepareStatement(cmd);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				account = new Account();
				account.setFirstName(rs.getString(1));
				account.setLastName(rs.getString(2));
				account.setType(rs.getInt(3));
				
				return account;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
