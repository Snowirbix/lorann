package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOSave extends DAOEntity<Save> {
	/**
	 * this constructor make a connection
	 * @param connection
	 * @throws SQLException
	 */
	public DAOSave(Connection connection) throws SQLException {
		super(connection);
	}

	@Override
	public boolean create(Save entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Save entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	/**
	 * this method is used to update the save
	 * @param entity
	 * @return True if the save works False if nothing to update
	 */
	public boolean update(Save entity) {
		try {
			final String sql = "{call setSave(?, ?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, entity.getLife());
			call.setInt(2, entity.getScore());
			call.execute();
			return true;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	/**
	 * this method find the save (call the procedure getSave in the database)
	 * @param id
	 * @return save if the save exist, null if save doesn't exist
	 */
	public Save find(int id) {
		Save save = new Save();

		try {
			final String sql = "{call getSave()}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			if (resultSet.first()) {
				save = new Save(resultSet.getInt("life"), resultSet.getInt("score"));
			}
			return save;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
