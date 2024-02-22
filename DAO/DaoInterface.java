package DAO;

import java.util.ArrayList;

public interface DaoInterface <T>{
    public int insert(T t);
    public int update(T t);
    public ArrayList<T> selectAll();
    public T selectById(String t);
    String getAutoIncrement();
}
