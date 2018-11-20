//package li.tmj.db.sql;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Timestamp;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import java.util.TreeMap;
//import java.util.function.Supplier;
//
//import li.tmj.db.dao.DataDAO;
//import li.tmj.db.model.Data;
//import li.tmj.db.model.DataEntry;
//
//public abstract class DataSqlDAO<T extends Data> extends DataDAO<T>{
//	protected Connection con = DBConnect.getInstance().getConnection();
//	protected Supplier<T> creator;
//
//	protected abstract String[] columns();
//	protected abstract void setStatementValues(PreparedStatement statement, T data,int i) throws SQLException ;
//	protected abstract DataEntry[] getSelectedValues(T data);
//	protected abstract void getResultSetValues(ResultSet set, T data);
//
//	@Override
//	public List<T> read(T obj) { // searches db for all records mathing the fields set in the obj parameter
////		String query="SELECT * FROM Infothek WHERE id=? and name=''";
//		String query="select * from Infothek where ";
//		DataEntry[] values=getSelectedValues(obj);
//		if(values.length>0) {
//			query=query+values[0].getFieldName()+" like {} ";
//			for(int i=1; i<values.length; i++) {
//				query=query+"and "+values[i].getFieldName()+" like {} ";
//			}
//			try (PreparedStatement ps = con.prepareStatement(query)){
//				for(int i=0; i<values.length; i++) {
//					if(values[i].valueIsString() ) {
//						ps.setString(i+1, values[i].getValueAsString());
//					}else if (values[i].valueIsLocalDateTime()){
//						ps.setTimestamp(i+1, Timestamp.valueOf( values[i].getValueAsLocalDateTime() ));
//					}
//				}
//				List<T> list=new ArrayList<>();
//				ResultSet rs = ps.executeQuery();
//				while (rs.next()) {
//					T data=creator.get();
//					data.setId(rs.getInt("id"));
//					data.setCreated(rs.getTimestamp("created").toLocalDateTime());
//					data.setChanged(rs.getTimestamp("changed").toLocalDateTime());
//					getResultSetValues(rs, data);
//					list.add(data);
//				}
//				return list;
//				
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return null;
//	}
//
//	@Override
//	public boolean save(T[] objs) {
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
