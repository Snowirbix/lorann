package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOMap extends DAOEntity<Map> {

	/**
	 * Instantiates a new DAOMap.
	 * @param connection
	 * @throws SQLException
	 */
	public DAOMap(Connection connection) throws SQLException {
		super(connection);
	}

	@Override
	public boolean create(Map entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Map entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Map entity) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * TO get the map from the Database
	 * @param id
	 * the number of the map do you want (ID on the Database)
	 * 
	 */
	@Override
	public Map find(int id) {
		Map map = new Map();

		try {
			final String sql = "{call getMap(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, id);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			if (resultSet.first()) {
				map = new Map(resultSet.getInt("width"), resultSet.getInt("height"), resultSet.getString("map"));
			}
			return map;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
