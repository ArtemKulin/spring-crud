package ru.kulinartem.spring_crud.service;

import java.util.List;

public interface DaoImpl<T> {

    public T getItemById(long id);

    public List<T> getAllItems();

    public void saveItem(T item);

    public void deleteItem(T item);

    public void updateItem (T item, long id);

}
