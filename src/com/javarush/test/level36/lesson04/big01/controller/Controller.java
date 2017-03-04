package com.javarush.test.level36.lesson04.big01.controller;

import com.javarush.test.level36.lesson04.big01.model.Model;
import com.javarush.test.level36.lesson04.big01.view.EditUserView;
import com.javarush.test.level36.lesson04.big01.view.UsersView;

public class Controller { //Этот класс будет получать запрос от клиента, оповещать Модель об этом, а Модель, в свою очередь, будет обновлять ModelData-у

    private Model model;
    private UsersView usersView;
    private EditUserView editUserView;

    public void setEditUserView(EditUserView editUserView) {
        this.editUserView = editUserView;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void onShowAllUsers() {
        model.loadUsers();
        usersView.refresh(this.model.getModelData());
    }

    public void setUsersView(UsersView usersView) {
        this.usersView = usersView;
    }

    public void onShowAllDeletedUsers() {
        model.loadDeletedUsers();
        usersView.refresh(model.getModelData());
    }

    public void onOpenUserEditForm(long userId) {
        model.loadUserById(userId);
        editUserView.refresh(model.getModelData());
    }

    public void onUserDelete(long id)
    {
        model.deleteUserById(id);
        usersView.refresh(model.getModelData());
    }

    public void onUserChange(String name, long id, int level)
    {
        model.changeUserData(name, id, level);
        usersView.refresh(model.getModelData());
    }
}
