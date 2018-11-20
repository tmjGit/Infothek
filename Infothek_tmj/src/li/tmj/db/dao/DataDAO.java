//package li.tmj.db.dao;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import li.tmj.db.model.Data;
//
////public abstract class DataDAO implements GenericDAO<Data> {
//public abstract class DataDAO<T extends Data> implements GenericDAO<T> {
//	
////	protected abstract boolean save(List<T> dataList);
//	
////	@Override public List<Data> read(Data obj) { { // searches db for all records mathing the fields set in the obj parameter
//	
//	@Override
//	public boolean save(T obj) {
//		ArrayList<T> list=new ArrayList<>();
//		list.add(obj);
//		return save(list);
//	}
//	
////	@Override public boolean save(T[] objs) {
////		List<T> list=Arrays.asList(objs);
////		return save(list); 
////	}
//	
//	@Override
//	public boolean remove(int id) {
//		return remove(new int[] {id});
//	}
//	
//	@Override
//	public boolean remove(T obj) {
//		if(null==obj) {//TODO exception?
//			return false;
//		}
//		return remove(obj.getId());
//	}
//	
////	@Override public boolean remove(int[] ids) { return false; }
//	
//	@Override
//	public boolean remove(T[] objs) {
//		int[] ids=new int[objs.length];
//		for(int i=0; i<objs.length; i++) {
//			if(null!=objs[i]) {
//				ids[i]=objs[i].getId();				
//			}
//		}
//		return remove(ids);
//	}
//	
////	@Override
////	public boolean update(T obj) {
////		return update(new T[] {obj});
////	}
//	
////	@Override public boolean update(T[] objs) {
//
//}
