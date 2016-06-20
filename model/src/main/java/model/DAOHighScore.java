package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOHighScore extends DAOEntity<HighScore> {

	/**
	 * Instantiates a new DAOHighScore.
	 * 
	 * @param connection
	 * Connection to the BDD
	 * @see Connection
	 * @throws SQLException
	 */
	public DAOHighScore(Connection connection) throws SQLException {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(HighScore entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(HighScore entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(HighScore entity) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @param id
	 * @return the best score record on the BDD
	 * 
	 */
	@Override
	public HighScore find(int id) {
		HighScore highScore = new HighScore();

		try {
			final String sql = "{call getBestScore()}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			if (resultSet.first()) {
				highScore = new HighScore(resultSet.getInt("score"));
			}
			return highScore;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Add a score on the BDD
	 * @param life
	 * @return true if the procedure work
	 * else return false
	 */
	public boolean update(int life) {
		try {
			final String sql = "{call addHighScore(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, life);
			call.execute();
			return true;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
