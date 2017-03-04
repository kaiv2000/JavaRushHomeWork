package com.javarush.test.level32.lesson15.big01.listeners;

import com.javarush.test.level32.lesson15.big01.View;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TabbedPaneChangeListener implements ChangeListener { // будет слушать и обрабатывать изменения состояния панели вкладок

    private View view;

    public TabbedPaneChangeListener(View view) {
        this.view = view;
    }

    @Override
    public void stateChanged(ChangeEvent changeEvent) {
        view.selectedTabChanged();
    }
}
