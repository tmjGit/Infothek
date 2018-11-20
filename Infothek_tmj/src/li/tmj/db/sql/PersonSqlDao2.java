//package li.tmj.db.sql;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import li.tmj.db.model.DataEntry;
//import li.tmj.db.model.Person;
//
//public class PersonSqlDao2 extends DataSqlDAO<Person>{
//
//	@Override
//	protected String[] columns() {
//		return new String[] {"created","changed","dataFolder","messagesFolder","birthYear",
//			"birthMonth","birthDay","sex","died","category",
//			"nameFamily","nameFamilyPre","nameindividual","smokes","other",
//			"special","stop"};
//	}
//
//	@Override
//	protected void setStatementValues(PreparedStatement ps, Person p, int offset) throws SQLException {
//		int i=offset;
////		ps.setString(1, p.getCreated().toString());
////		ps.setString(2, p.getChanged().toString());
//		i++;
//		ps.setString(i, p.getDataFolder());
//		i++;
//		ps.setString(i, p.getMessagesFolder());
//		i++;
//		ps.setInt(i, p.getBirthYear());
//		i++;
//		ps.setInt(i, p.getBirthMonth());
//		i++;
//		ps.setInt(i, p.getBirthDay());
//		i++;
//		ps.setString(i, p.getSex());
//		i++;
//		ps.setString(i, p.getDied());
//		i++;
//		ps.setString(i, p.getCategory());
//		i++;
//		ps.setString(i, p.getNameFamily());
//		i++;
//		ps.setString(i, p.getNameFamilyPre());
//		i++;
//		ps.setString(i, p.getNameIndividual());
//		i++;
//		ps.setString(i, p.getSmokes());
//		i++;
//		ps.setString(i, p.getOther());
//		i++;
//		ps.setString(i, p.getSpecial());
//		i++;
//		ps.setString(i, p.getStop());
//	}
//
//	@Override
//	protected DataEntry[] getSelectedValues(Person data) {
//		ArrayList<DataEntry> entries=new ArrayList<>();
//		if(null!=data.getDataFolder()) {
//			entries.add(new DataEntry("dataFolder", data.getDataFolder()));
//		}
//		if(null!=data.getMessagesFolder()) {
//			entries.add(new DataEntry("messagesFolder", data.getMessagesFolder()));
//		}
//		if(0<data.getBirthYear()) {
//			entries.add(new DataEntry("birthYear", data.getBirthYear()));
//		}
//		if(0<data.getBirthMonth()) {
//			entries.add(new DataEntry("birthMonth", data.getBirthMonth()));
//		}
//		if(0<data.getBirthDay()) {
//			entries.add(new DataEntry("birthDay", data.getBirthDay()));
//		}
//		if(null!=data.getSex()) {
//			entries.add(new DataEntry("sex", data.getSex()));
//		}
//		if(null!=data.getDied()) {
//			entries.add(new DataEntry("died", data.getDied()));
//		}
//		if(null!=data.getCategory()) {
//			entries.add(new DataEntry("category", data.getCategory()));
//		}
//		if(null!=data.getNameFamily()) {
//			entries.add(new DataEntry("nameFamily", data.getNameFamily()));
//		}
//		if(null!=data.getNameFamilyPre()) {
//			entries.add(new DataEntry("nameFamilyPre", data.getNameFamilyPre()));
//		}
//		if(null!=data.getNameIndividual()) {
//			entries.add(new DataEntry("nameIndividual", data.getNameIndividual()));
//		}
////		if(!=data.getPic()) {
////			entries.add(new DataEntry("birthDay", data.getPic()));
////		}
//		if(null!=data.getSmokes()) {
//			entries.add(new DataEntry("smokes", data.getSmokes()));
//		}
//		if(null!=data.getOther()) {
//			entries.add(new DataEntry("other", data.getOther()));
//		}
//		if(null!=data.getSpecial()) {
//			entries.add(new DataEntry("special", data.getSpecial()));
//		}
//		if(null!=data.getStop()) {
//			entries.add(new DataEntry("birthDay", data.getStop()));
//		}
//		return null;
//	}
//
//	@Override
//	protected void getResultSetValues(ResultSet set, Person data) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//	
//	@Override
//	public boolean update(Person obj) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean update(Person[] objs) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	protected boolean save(List<Person> dataList) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//}
