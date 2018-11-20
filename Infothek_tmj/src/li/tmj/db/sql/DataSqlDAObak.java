//package li.tmj.db.sql;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.time.LocalDateTime;
//import java.util.Collections;
//import java.util.List;
//import java.util.function.Supplier;
//
//import li.tmj.db.dao.DataDAO;
//import li.tmj.db.model.Data;
//
//public abstract class DataSqlDAO extends DataDAO{
//	protected Connection con = DBConnect.getInstance().getConnection();
//	protected Supplier<Data> creator;
//
//	protected abstract String[] columns();
//	protected abstract void setStatementValues(PreparedStatement statement, Data data,int i);
//	protected abstract void getSelectedValues(PreparedStatement statement, Data data,int i);
//	protected abstract void getResultSetValues(ResultSet set, Data data,int i);
//
//	@Override
//	public List<Data> read(Data obj) { // searches db for all records mathing the fields set in the obj parameter
////		String query="SELECT * FROM Infothek WHERE id=? and name=''";
//		String query="select * from Infothek where ";
//		String[] labels=null;//TODO
//		if(labels.length>0) {
//			query=query+labels[0]+" like {} ";
//			for(int i=1; i<labels.length; i++) {
//				query=query+"and "+labels[i]+" like {} ";
//		}
//		Object[] values=null;//TODO
////		String s;
////		if(values[0] instanceof Integer) {
////			s=((Integer) values[0]).toString();
////		}else {
////			s="'"+(String) values[0]+"'";
////		}
////		query=query+labels[0]+" like "+  s+" ";
////		for(int i=1; i<labels.length; i++) {
////			if(values[i] instanceof Integer) {
////				s=((Integer) values[i]).toString();
////			}else {
////				s="'"+(String) values[i]+"'";
////			}
////			query=query+"and "+labels[i]+" like "+  s+" ";
////		}
//		try (PreparedStatement ps = con.prepareStatement(query)){
//			for(int i=0; i<values.length; i++) {
//				if(values[i] instanceof String) {
//					ps.setString(i+1, (String) values[i]);
//				}else {
//					ps.setInt(i+1, (int) values[i]);
//				}
//			}
//			ResultSet rs = ps.executeQuery();
//			Data data=new Data();
//			while (rs.next()) {
////				System.out.println("KundeMySQLDAO.findCustomer: new Customer...");
//				customer = new Customer();
////				System.out.println("KundeMySQLDAO.findCustomer: get id...");
//				customer.setKundenNummer(rs.getInt("id"));
////				System.out.println("KundeMySQLDAO.findCustomer: kundennummer=" + customer.getKundenNummer() + "get vorname...");
//				customer.setFirstname(rs.getString("vorname"));
////				System.out.println("KundeMySQLDAO.findCustomer: firstname=" + customer.getFirstname() + "get nachname...");
//				customer.setLastname(rs.getString("nachname"));
////				System.out.println("KundeMySQLDAO.findCustomer: lastname=" + customer.getLastname() + "get username...");
//				customer.setUsername(username);
//				customer.setPassword(rs.getString("passwort"));
////				System.out.println("KundeMySQLDAO.findCustomer: password=" + customer.getPassword() + "get email...");
//				customer.setEmail(rs.getString("email"));
////				System.out.println("KundeMySQLDAO.findCustomer: email=" + customer.getEmail() );
//	//			personList.add(p);
//			}
//			return customer;
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	@Override
//	public boolean save(Data[] objs) {
//		if(null==objs) {//exception?
//			return false;
//		}
//		if(objs.length<1) {
//			return true; // There was nothing to save and we saved nothing.
//		}
//		String[] columns=columns();
////		INSERT INTO MyTable ( Column1, Column2 ) VALUES ( Value1, Value2 ), ( Value1, Value2 )
//		String query;
//		if(columns.length>0) {
//			query="insert into "+DBConnect.getDbname()+" (";
//			query=query+columns[0];
//			for(int i=1; i<columns.length; i++) {
//				query=query + "," + columns[i];
//			}
//			query=query+") values " ;
//			String s= "("
//				+ String.join(",", Collections.nCopies(columns.length, ",?")) // n copies of string s
//				+ ")"; // Placeholder for every field of one record = one obj
//			query=query+" "+String.join(",", Collections.nCopies(objs.length, s)); // Placeholder for every record/object
//		}else {
//			query="";
//		}
//		System.out.println("PersonSqlDAO.save: query="+query);
//		try (PreparedStatement ps=con.prepareStatement(query) ) {
//			for(int i=0; i<objs.length; i++) {
//				setStatementValues(ps,objs[i],i*columns.length);
//			}
//			return objs.length==ps.executeUpdate(); // Did we save the expected count of records?
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
//
//	@Override public boolean remove(int[] ids) {
//		String query="delete from "+DBConnect.getDbname()+" where id in (" 
//				+ String.join(",", Collections.nCopies(ids.length, "?"))
//				+ ")";
//		try(PreparedStatement ps=con.prepareStatement(query)){
//			for(int i=0; i<ids.length; i++) {
//				ps.setInt(i+1, ids[i]);
//			}
//			return ids.length==ps.executeUpdate(); // Did we remove the expected count of records?
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return false;
//	}
//	
////	@Override public boolean update(Data[] objs) {
//
//	protected Data readData(ResultSet rs,Data data) throws SQLException {
////		Data data=new Data();
//		data.setId(rs.getInt("id"));
//		data.setCreated(LocalDateTime.parse(rs.getString("created")));
//		data.setChanged(LocalDateTime.parse(rs.getString("changed")));
//		return data;
//	}
//
//}
