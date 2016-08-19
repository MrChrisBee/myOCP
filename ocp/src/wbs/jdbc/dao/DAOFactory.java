package wbs.jdbc.dao;

public class DAOFactory {
	public static IBuchDAO getBuchDAO() throws PersistenceException{
		return new BuchDaoImpl();
	}
	
	
}
