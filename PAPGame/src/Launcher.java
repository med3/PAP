import java.io.IOException;

import com.ensimag.pap.dao.DAOException;
import com.ensimag.pap.dao.DBConnect;
import com.ensimag.pap.dao.UserDAO;
import com.ensimag.pap.model.User;
import com.ensimag.pap.util.PropertiesUtil;

public class Launcher {

	public static void main(String[] args) throws DAOException, IOException {
		testUserGet();
	}

	private static void testConfigurationRead() throws IOException {
		System.out.println(PropertiesUtil.getProperty("db.url"));
		System.out.println(PropertiesUtil.getProperty("db.name"));
		System.out.println(PropertiesUtil.getProperty("db.driver"));
		System.out.println(PropertiesUtil.getProperty("db.username"));
		System.out.println(PropertiesUtil.getProperty("db.password"));
	}

	private static void testDBConnection() throws DAOException {
		DBConnect.getConnection();
	}

	private static void testUserInsertion() throws DAOException {
		User u = new User("toto", "titi");
		UserDAO.insert(u);
	}

	private static void testUserGet() throws DAOException {
		User u = new User("tOto", "titi");
		System.out.println(UserDAO.get(u));

		u = new User("toto", "tito");
		System.out.println(UserDAO.get(u));

		u = new User("%", "%");
		System.out.println(UserDAO.get(u));
	}
}
