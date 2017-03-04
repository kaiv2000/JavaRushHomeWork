package com.javarush.test.level32.lesson15.big01;

import com.javarush.test.level32.lesson15.big01.listeners.FrameListener;
import com.javarush.test.level32.lesson15.big01.listeners.TabbedPaneChangeListener;
import com.javarush.test.level32.lesson15.big01.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener { //представление

    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane(); //панель с двумя вкладками
    private JTextPane htmlTextPane = new JTextPane(); //компонент для визуального редактирования html, будет размещен на первой вкладке
    private JEditorPane plainTextPane = new JEditorPane(); //компонент для редактирования html в виде текста
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

    public UndoListener getUndoListener() {
        return undoListener;
    }

    public View() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("view creating problem. Details: " + e);
        }
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public Controller getController() {
        return controller;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) { //будет вызваться при выборе пунктов меню у которых наше представление указано в виде слушателя событий
        String command = actionEvent.getActionCommand();
        switch (command)
        {
            case "Новый":
                controller.createNewDocument();
                break;
            case "Открыть":
                controller.openDocument();
                break;
            case "Сохранить":
                controller.saveDocument();
                break;
            case "Сохранить как...":
                controller.saveDocumentAs();
                break;
            case "Выход":
                controller.exit();
                break;
            case "О программе":
                showAbout();
                break;
        }
    }

    public void init() {
        initGui();
        FrameListener frameListener = new FrameListener(this);
        addWindowListener(frameListener);
        setVisible(true);
    }

    public void exit() {
        controller.exit();
    }

    public void initMenuBar() { //инициализация меню
        JMenuBar menuBar = new JMenuBar(); //панель меню
        MenuHelper.initFileMenu(this, menuBar);
        MenuHelper.initEditMenu(this, menuBar);
        MenuHelper.initStyleMenu(this, menuBar);
        MenuHelper.initAlignMenu(this, menuBar);
        MenuHelper.initColorMenu(this, menuBar);
        MenuHelper.initFontMenu(this, menuBar);
        MenuHelper.initHelpMenu(this, menuBar);
        getContentPane().add(menuBar, BorderLayout.NORTH);
    }

    public void initEditor() { //инициализация панелей редактора
        htmlTextPane.setContentType("text/html"); //Устанавливать значение "text/html" в качестве типа контента для компонента htmlTextPane
        tabbedPane.addTab("HTML", new JScrollPane(htmlTextPane)); //Создавать новый локальный компонент JScrollPane на базе htmlTextPane. Добавлять вкладку в панель tabbedPane с именем "HTML" и компонентом htmlTextPane
        tabbedPane.addTab("Текст", new JScrollPane(plainTextPane)); //Создавать новый локальный компонент JScrollPane на базе plainTextPane. Добавлять еще одну вкладку в tabbedPane с именем "Текст" и компонентом plainTextPane
        tabbedPane.setPreferredSize(new Dimension(800, 600)); //Устанавливать предпочтительный размер панели tabbedPane.
        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this)); //Создавать объект класса TabbedPaneChangeListener и устанавливать его в качестве слушателя изменений в tabbedPane
        getContentPane().add(tabbedPane, BorderLayout.CENTER); // Добавлять по центру панели контента текущего фрейма нашу панель с вкладками.
    }

    public void selectedTabChanged() {
        if (isHtmlTabSelected()){
            controller.setPlainText(plainTextPane.getText());
        }
        else
        {
            plainTextPane.setText(controller.getPlainText());
        }
        resetUndo();
    }

    public void initGui() {
        initMenuBar();
        initEditor();
        pack();
    }

    public boolean canUndo() {
        return undoManager.canUndo();
    }

    public boolean canRedo() {
        return undoManager.canRedo();
    }

    public void undo() {
        try {
            undoManager.undo();
        } catch (CannotUndoException e) {
            System.out.println(e);
        }
    }

    public void redo() {
        try {
            undoManager.redo();
        } catch (CannotRedoException e) {
            System.out.println(e);
        }
    }

    public void resetUndo() {
        undoManager.discardAllEdits();
    }

    public boolean isHtmlTabSelected() {
        return tabbedPane.getSelectedIndex() == 0;
    }

    public void selectHtmlTab() {
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }

    public void update() {
        htmlTextPane.setDocument(controller.getDocument());
    }

    public void showAbout() {
        JOptionPane.showMessageDialog(this, "This is super HTML editor! \n by kaiv =)", "About this software", JOptionPane.INFORMATION_MESSAGE);
    }

}
