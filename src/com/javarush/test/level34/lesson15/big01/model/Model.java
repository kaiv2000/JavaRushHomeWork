package com.javarush.test.level34.lesson15.big01.model;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;

import java.nio.file.Paths;

public class Model {

    public static final int FIELD_SELL_SIZE = 20;
    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader = new LevelLoader(Paths.get("./src/com/javarush/test/level34/lesson15/big01/res/levels.txt"));


    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects() {
        return gameObjects;
    }

    public void restartLevel(int level) {
        gameObjects = levelLoader.getLevel(level);
    }

    public void restart() {
        restartLevel(this.currentLevel);
    }

    public void startNextLevel() {
        currentLevel++;
        restart();
    }

    public void move(Direction direction) {
        Player player = gameObjects.getPlayer();

        if (checkWallCollision(player, direction))
        {
            return;
        }

        if (checkBoxCollision(direction)){
            return;
        }


        int newSize = FIELD_SELL_SIZE;

        switch (direction) {
            case LEFT:
                player.move(-newSize, 0);
                break;
            case RIGHT:
                player.move(newSize, 0);
                break;
            case UP:
                player.move(0, -newSize);
                break;
            case DOWN:
                player.move(0, newSize);
        }
        checkCompletion();
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction) {
        for (Wall wall : gameObjects.getWalls()) {

            if (gameObject.isCollision(wall, direction)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkBoxCollision(Direction direction) {

        Player player = gameObjects.getPlayer();

        GameObject stopObject = null;
        for (GameObject gameObject : gameObjects.getAll()) {
            if (!(gameObject instanceof Player) && !(gameObject instanceof Home) && player.isCollision(gameObject, direction)) {
                stopObject = gameObject;
            }
        }

        if ((stopObject == null)) {
            return false;
        }

        if (stopObject instanceof Box) {
            Box stopedBox = (Box) stopObject;
            if (checkWallCollision(stopedBox, direction)) {
                return true;
            }
            for (Box box : gameObjects.getBoxes()) {
                if (stopedBox.isCollision(box, direction)) {
                    return true;
                }
            }
            switch (direction) {
                case LEFT:
                    stopedBox.move(-FIELD_SELL_SIZE, 0);
                    break;
                case RIGHT:
                    stopedBox.move(FIELD_SELL_SIZE, 0);
                    break;
                case UP:
                    stopedBox.move(0, -FIELD_SELL_SIZE);
                    break;
                case DOWN:
                    stopedBox.move(0, FIELD_SELL_SIZE);
            }
        }
        return false;
    }

    public void checkCompletion() {

        boolean done = true;

        for (Home home : gameObjects.getHomes()) {
            boolean current = false;

            for (Box box : gameObjects.getBoxes()) {
                if ((box.getX() == home.getX()) && (box.getY() == home.getY()))
                    current = true;
            }

            if (!current) done = false;
        }

        if (done)
            eventListener.levelCompleted(currentLevel);
    }
}
