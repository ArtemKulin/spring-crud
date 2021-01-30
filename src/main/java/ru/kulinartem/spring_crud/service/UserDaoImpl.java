package ru.kulinartem.spring_crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kulinartem.spring_crud.dao.UserDAO;
import ru.kulinartem.spring_crud.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements DaoImpl<User>{

    private final UserDAO userDAO;

    @Autowired
    public UserDaoImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Override
    public User getItemById(long id) {
        return userDAO.getItemById(id);
    }


    @Override
    public List<User> getAllItems() {
        return userDAO.getAllItems();
    }


    @Override
    public void saveItem(User item) {
        userDAO.saveItem(item);
    }


    @Override
    public void deleteItem(User item) {
        userDAO.deleteItem(item);
    }


    @Override
    public void updateItem(User item, long id) {
        userDAO.updateItem(item, id);
    }
}
