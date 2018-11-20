//package dao;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import DB.DBConnect;
//import model.Person_d;
//
//public class MySQLPersonDAO_d implements PersonDAO {
//
//	private DBConnect dbconnect;
//
//	public MySQLPersonDAO_d() {
//		dbconnect = DBConnect.getInstance();
//	}
//
//	@Override
//	public List<Person_d> findAllPersons() {
//		// ArrayList oder ObservableArrayList erzeutgen
//		// Statemnet
//		// Select
//		List<Person_d> personList = new ArrayList<>();
//		try (PreparedStatement ps = dbconnect.getConnection().prepareStatement("SELECT * FROM adressen")){
//			
//			ResultSet rs = ps.executeQuery();
//
//			while (rs.next()) {
//				Person_d p = new Person_d();
//				p.setId(rs.getInt("id"));
//				p.setVorname(rs.getString("vorname"));
//				p.setNachname(rs.getString("nachname"));
//				p.setOrt(rs.getString("ort"));
//				p.setPlz(rs.getString("plz"));
//				p.setStrasse(rs.getString("strasse"));
//				p.setTelefon(rs.getString("telefon"));
//				p.setMobil(rs.getString("mobil"));
//				p.setEmail(rs.getString("email"));
//				personList.add(p);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return personList;
//	}
//
//	@Override
//	public boolean savePerson(Person_d person_d) {
//		final String q = "INSERT INTO adressen (vorname,nachname,ort,plz,strasse, telefon,mobil,email) VALUES (?,?,?,?,?,?,?,?)";
//		try {
//			PreparedStatement inserStatement = dbconnect.getConnection().prepareStatement(q);
//			
//			inserStatement.setString(1, person_d.getVorname());
//			inserStatement.setString(2, person_d.getNachname());
//			inserStatement.setString(3, person_d.getOrt());
//			inserStatement.setString(4, person_d.getPlz());
//			inserStatement.setString(5, person_d.getStrasse());
//			inserStatement.setString(6, person_d.getTelefon());
//			inserStatement.setString(7, person_d.getMobil());
//			inserStatement.setString(8, person_d.getEmail());
//			
//			return inserStatement.executeUpdate()==1;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return false;
//	}
//
//	@Override
//	public boolean deletePerson(int id) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean updatePerson(int id, String fieldName, String newValue) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	public static void main(String[] args) {
//		MySQLPersonDAO_d dao = new MySQLPersonDAO_d();
//		System.out.println(dao.findAllPersons());
//	}
//
//}
