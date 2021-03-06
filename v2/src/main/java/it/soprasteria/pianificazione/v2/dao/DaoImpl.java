package it.soprasteria.pianificazione.v2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import it.soprasteria.pianificazione.v2.bean.EmployeeBean;
import it.soprasteria.pianificazione.v2.bean.ProjectBean;
import it.soprasteria.pianificazione.v2.bean.RecordV2Bean;

public class DaoImpl extends JdbcDaoSupport implements Dao {
	private static final Logger LOG = Logger.getLogger(DaoImpl.class);

	@Override
	public List<EmployeeBean> getAllEmployees() {
		List<EmployeeBean> empl = getJdbcTemplate().query("SELECT * FROM risorse", new RowMapper<EmployeeBean>() {
			public EmployeeBean mapRow(ResultSet rs, int rowNumb) throws SQLException {
				EmployeeBean emplo = new EmployeeBean();
				String nameSurname;
				emplo.setName(rs.getString(2));
				emplo.setSurname(rs.getString(3));
				nameSurname = emplo.getName() + " " + emplo.getSurname();
				emplo.setNameSurname(nameSurname);
				emplo.setBadgeNumber(Integer.toString(rs.getInt("matricola")));
				return emplo;
			}
		});
		return empl;
	}

	@Override
	public List<ProjectBean> getAllProject() {
		List<ProjectBean> prog = getJdbcTemplate().query("SELECT * FROM progetti", new RowMapper<ProjectBean>() {
			public ProjectBean mapRow(ResultSet rs, int rowNumb) throws SQLException {
				ProjectBean proj = new ProjectBean();
				proj.setIdProject(rs.getLong("id_progetto"));
				proj.setDescription(rs.getString("progetto"));
				proj.setCustomer(rs.getString("cliente"));
				proj.setCurrency(rs.getString("valuta"));
				proj.setType(rs.getString("attivit�"));
				LOG.debug(proj.getType());
				return proj;
			}
		});
		return prog;
	}

	@Override
	public List<RecordV2Bean> getV2(final String month, final String user) {
		List<RecordV2Bean> result = new ArrayList<RecordV2Bean>();
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT *");
		sb.append(" FROM u_progetti_risorse");
		sb.append(" WHERE mese = ?");
		sb.append(" AND user_id = ?");

		result = getJdbcTemplate().query(sb.toString(), new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstm) throws SQLException {
				pstm.setString(1, month);
				pstm.setString(2, user);
			}
		}, new RowMapper<RecordV2Bean>() {
			@Override
			public RecordV2Bean mapRow(ResultSet rs, int rowNumb) throws SQLException {
				RecordV2Bean v2b = new RecordV2Bean();
				v2b.setMonth(month);
				v2b.setIdRecord(rs.getLong("id_unione"));
				v2b.setIdProject(rs.getInt("id_progetto"));
				v2b.setBadgeNumber(Integer.toString(rs.getInt("id_risorsa")));
				v2b.setCons0(rs.getInt("consolidato_1"));
				v2b.setProd0(rs.getInt("prodotto_1"));
				v2b.setCons1(rs.getInt("consolidato_2"));
				v2b.setProd1(rs.getInt("prodotto_2"));
				v2b.setCons2(rs.getInt("consolidato_3"));
				v2b.setProd2(rs.getInt("prodotto_3"));
				v2b.setPrice(rs.getInt("tariffa"));
				return v2b;
			}
		});
		return result;
	}

	@Override
	public EmployeeBean getEmployee(String id) {
		LOG.debug("MATRICOLAAA  :" + id);

		List<EmployeeBean> b1 = getJdbcTemplate().query("SELECT * FROM risorse WHERE matricola = " + id, new RowMapper<EmployeeBean>() {
			public EmployeeBean mapRow(ResultSet rs, int rowNumb) throws SQLException {
				EmployeeBean b = new EmployeeBean();
				b.setBadgeNumber(rs.getString(1));
				b.setName(rs.getString(2));
				b.setSurname(rs.getString(3));
				return b;
			}
		});
		LOG.debug("Lunghezza: " + b1.size());
		if (!b1.isEmpty()) {
			LOG.debug("Questo e' il primo elemento " + b1.get(0));
		}
		return b1.get(0);

	}

	@Override
	public ProjectBean getProject(long id) {
		LOG.debug("IDENTIFICATIVO  :" + id);
		List<ProjectBean> p1 = getJdbcTemplate().query("SELECT * FROM progetti WHERE  id_progetto = " + id, new RowMapper<ProjectBean>() {
			@Override
			public ProjectBean mapRow(ResultSet rs, int rowNumb) throws SQLException {
				ProjectBean p = new ProjectBean();
				p.setDescription(rs.getString("progetto"));
				p.setCustomer(rs.getString("cliente"));
				p.setCurrency(rs.getString("valuta"));
				p.setType(rs.getString("attivit�"));
				return p;
			}
		});
		LOG.debug("Lungezza :" + p1.size());
		if (!p1.isEmpty()) {
			LOG.debug("Questo � il primo elemento " + p1.get(0));
		}
		return p1.get(0);

	}

	@Override
	public RecordV2Bean getRecord(final long id) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT *");
		sb.append(" FROM u_progetti_risorse");
		sb.append(" WHERE id_unione  = ?");

		List<RecordV2Bean> l1 = getJdbcTemplate().query(sb.toString(), new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstm) throws SQLException {
				pstm.setLong(1, id);
			}
		}, new RowMapper<RecordV2Bean>() {
			public RecordV2Bean mapRow(ResultSet rs, int rowNumb) throws SQLException {
				RecordV2Bean rv = new RecordV2Bean();
				rv.setIdRecord(rs.getLong("id_unione"));
				rv.setMonth(rs.getString("mese"));
				rv.setCons0(rs.getInt("consolidato_1"));
				rv.setProd0(rs.getInt("prodotto_1"));
				rv.setCons1(rs.getInt("consolidato_2"));
				rv.setProd1(rs.getInt("prodotto_2"));
				rv.setCons2(rs.getInt("consolidato_3"));
				rv.setProd2(rs.getInt("prodotto_3"));
				rv.setIdProject(rs.getInt("id_progetto"));
				rv.setBadgeNumber(Integer.toString(rs.getInt("id_risorsa")));
				LOG.debug("*******TARIFFAAAAAAAAAAAAAAAA *****************" + rs.getInt("tariffa"));
				rv.setPrice(rs.getInt("tariffa"));
				return rv;

			};
		});
		return l1.get(0);
	}

	@Override
	public void update(final RecordV2Bean rec) {

		final StringBuilder sb = new StringBuilder();
		sb.append("UPDATE u_progetti_risorse");
		sb.append(" SET id_progetto=?,consolidato_1= ?,prodotto_1= ?,consolidato_2= ?,prodotto_2= ?,consolidato_3= ?,prodotto_3= ?,tariffa= ?");
		sb.append(" WHERE id_unione = ?");
		getJdbcTemplate().update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				int i = 1;
				PreparedStatement ps = conn.prepareStatement(sb.toString());
				ps.setLong(i++, rec.getIdProject());
				ps.setInt(i++, rec.getCons0());
				ps.setInt(i++, rec.getProd0());
				ps.setInt(i++, rec.getCons1());
				ps.setInt(i++, rec.getProd1());
				ps.setInt(i++, rec.getCons2());
				ps.setInt(i++, rec.getProd2());
				ps.setInt(i++, rec.getPrice());
				ps.setLong(i++, rec.getIdRecord());
				LOG.debug(rec.getIdRecord());
				return ps;
			}
		});
	}

	@Override
	public void insert(final RecordV2Bean rec) {
		final StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO u_progetti_risorse (mese,id_progetto,id_risorsa,consolidato_1," + "prodotto_1,consolidato_2,prodotto_2,consolidato_3," + "prodotto_3,user_id,tariffa)");
		sb.append("  VALUES(?,?,?,?,?,?,?,?,?,?,?)");
		getJdbcTemplate().update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				int i = 1;
				PreparedStatement ps = conn.prepareStatement(sb.toString());
				ps.setString(i++, rec.getMonth());
				ps.setLong(i++, rec.getIdProject());
				ps.setInt(i++, Integer.parseInt(rec.getBadgeNumber()));
				ps.setInt(i++, rec.getCons0());
				ps.setInt(i++, rec.getProd0());
				ps.setInt(i++, rec.getCons1());
				ps.setInt(i++, rec.getProd1());
				ps.setInt(i++, rec.getCons2());
				ps.setInt(i++, rec.getProd2());
				
				// TODO
				// sistemare, cablato nome utente
				ps.setString(i++, "Admin");
				ps.setInt(i++, rec.getPrice());
				return ps;
			}
		});
	}

	@Override
	public void delete(final RecordV2Bean rec) {
		final StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM u_progetti_risorse");
		sb.append(" WHERE id_unione = ?");
		getJdbcTemplate().update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement ps = conn.prepareStatement(sb.toString());
				ps.setLong(1, rec.getIdRecord());
				return ps;
			}
		});

	}
	
	@Override
	public List<RecordV2Bean> findAllV2(){
		List<RecordV2Bean> result = new ArrayList<RecordV2Bean>();
		StringBuilder sb = new StringBuilder();
		
		// TODO
		// recuperare l'elenco dei v2 in modo diverso

		sb.append("SELECT *");
		sb.append(" FROM u_progetti_risorse");
		sb.append(" GROUP BY mese");
       result = getJdbcTemplate().query(sb.toString(), new RowMapper<RecordV2Bean>(){
    	 @Override
    	public RecordV2Bean mapRow(ResultSet rs, int rowNumb) throws SQLException {
    		 RecordV2Bean rv = new RecordV2Bean();
    		 rv.setMonth(rs.getString("mese"));
    		 LOG.debug(rv.getMonth());
    		return rv;
    	}
       });
		return result;
	}

}
