package com.javarush.test.level32.lesson15.big01.listeners;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class UndoListener implements UndoableEditListener { //Этот класс будет следить за правками, которые можно отменить или вернуть.

    private UndoManager undoManager;

    public UndoListener(UndoManager undoManager) {
        this.undoManager = undoManager;
    }

    public void undoableEditHappened(UndoableEditEvent e){
        undoManager.addEdit(e.getEdit());
    }



}
