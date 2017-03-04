package com.javarush.test.level36.lesson04.big01.view;

import com.javarush.test.level36.lesson04.big01.bean.User;
import com.javarush.test.level36.lesson04.big01.controller.Controller;
import com.javarush.test.level36.lesson04.big01.model.ModelData;

public class UsersView implements View {

    private Controller controller = new Controller();

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void refresh(ModelData modelData) {

        if (!modelData.isDisplayDeletedUserList()) {
            System.out.println("All users:");
        }
        if (modelData.isDisplayDeletedUserList()) {
            System.out.println("All deleted users:");
        }
        for (User oneUser : modelData.getUsers()) {
            System.out.println("\t" + oneUser);
        }
        System.out.println("===================================================");
    }

    public void fireEventShowAllUsers() {
        controller.onShowAllUsers();
    }

    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }

    public void fireEventOpenUserEditForm(long id) {
        controller.onOpenUserEditForm(id);
    }

    public void fireEventUserDeleted(long id) {controller.onUserDelete(id);}

}
