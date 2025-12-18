package com.example.battlearena.controllers;

import com.example.battlearena.models.*;
import com.example.battlearena.utils.CollisionDetector;
import com.example.battlearena.utils.InputHandler;
import com.example.battlearena.utils.Renderer;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;

import java.util.*;

public class GameController {
    private static final int CANVAS_WIDTH = 800;
    private static final int CANVAS_HEIGHT = 600;
    private static final int PLAYER_SIZE = 40;
    private static final int PROJECTILE_SIZE = 10;
    private static final double MOVEMENT_SPEED = 5.0;

    private Fighter player1;
    private Fighter player2;
    private List<Projectile> projectiles;
    private InputHandler inputHandler;
    private CollisionDetector collisionDetector;
    private Renderer renderer;
    private boolean fullMovement;
    private AnimationTimer gameLoop;
    private GameStateListener gameStateListener;

    public interface GameStateListener {
        void onPlayerHealthChanged();
        void onGameOver(String winner);
    }

    public GameController(boolean fullMovement) {
        this.projectiles = new ArrayList<>();
        this.inputHandler = new InputHandler();
        this.collisionDetector = new CollisionDetector(PLAYER_SIZE, PROJECTILE_SIZE);
        this.renderer = new Renderer(CANVAS_WIDTH, CANVAS_HEIGHT, PLAYER_SIZE, PROJECTILE_SIZE);
        this.fullMovement = fullMovement;
    }

    public void setGameStateListener(GameStateListener listener) {
        this.gameStateListener = listener;
    }

    public void initializePlayers(FighterType p1Type, FighterType p2Type) {
        player1 = FighterFactory.createFighter(p1Type, 100, CANVAS_HEIGHT / 2.0);
        player2 = FighterFactory.createFighter(p2Type, CANVAS_WIDTH - 100, CANVAS_HEIGHT / 2.0);

        player1.setWeapon(WeaponFactory.createWeapon(WeaponType.PISTOL));
        player2.setWeapon(WeaponFactory.createWeapon(WeaponType.PISTOL));

        projectiles.clear();
    }

    public void startGameLoop(GraphicsContext gc) {
        gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                updateGame();
                renderer.renderGame(gc, player1, player2, projectiles, fullMovement);

                if (gameStateListener != null) {
                    gameStateListener.onPlayerHealthChanged();
                }

                if (player1.getHealth() <= 0 || player2.getHealth() <= 0) {
                    stop();
                    if (gameStateListener != null) {
                        String winner = player1.getHealth() > 0 ?
                                "Player 1 (" + player1.getType().getDisplayName() + ")" :
                                "Player 2 (" + player2.getType().getDisplayName() + ")";
                        gameStateListener.onGameOver(winner);
                    }
                }
            }
        };
        gameLoop.start();
    }

    public void stopGameLoop() {
        if (gameLoop != null) {
            gameLoop.stop();
        }
    }

    private void updateGame() {
        updatePlayer1Movement();
        handlePlayer1WeaponSwitch();
        handlePlayer1Shooting();

        updatePlayer2Movement();
        handlePlayer2WeaponSwitch();
        handlePlayer2Shooting();

        updateProjectiles();
    }

    private void updatePlayer1Movement() {
        double p1X = player1.getX();
        double p1Y = player1.getY();

        if (inputHandler.isKeyPressed(KeyCode.W)) {
            p1Y = Math.max(PLAYER_SIZE / 2.0, p1Y - MOVEMENT_SPEED);
        }
        if (inputHandler.isKeyPressed(KeyCode.S)) {
            p1Y = Math.min(CANVAS_HEIGHT - PLAYER_SIZE / 2.0, p1Y + MOVEMENT_SPEED);
        }
        if (inputHandler.isKeyPressed(KeyCode.A)) {
            p1X = Math.max(PLAYER_SIZE / 2.0, p1X - MOVEMENT_SPEED);
        }
        if (inputHandler.isKeyPressed(KeyCode.D)) {
            double maxX = fullMovement ? CANVAS_WIDTH - PLAYER_SIZE / 2.0 : CANVAS_WIDTH / 2.0 - PLAYER_SIZE / 2.0;
            p1X = Math.min(maxX, p1X + MOVEMENT_SPEED);
        }

        player1.setPosition(p1X, p1Y);

        if (inputHandler.isKeyPressed(KeyCode.D)) player1.setRotation(0);
        else if (inputHandler.isKeyPressed(KeyCode.A)) player1.setRotation(180);
        else if (inputHandler.isKeyPressed(KeyCode.W)) player1.setRotation(-90);
        else if (inputHandler.isKeyPressed(KeyCode.S)) player1.setRotation(90);
    }

    private void handlePlayer1WeaponSwitch() {
        WeaponType weapon = inputHandler.getPlayer1WeaponSwitch();
        if (weapon != null) {
            player1.setWeapon(WeaponFactory.createWeapon(weapon));
        }
    }

    private void handlePlayer1Shooting() {
        if (inputHandler.isKeyPressed(KeyCode.F)) {
            Projectile projectile = player1.shoot(1);
            if (projectile != null) {
                projectiles.add(projectile);
            }
        }
    }

    private void updatePlayer2Movement() {
        double p2X = player2.getX();
        double p2Y = player2.getY();

        if (inputHandler.isKeyPressed(KeyCode.UP)) {
            p2Y = Math.max(PLAYER_SIZE / 2.0, p2Y - MOVEMENT_SPEED);
        }
        if (inputHandler.isKeyPressed(KeyCode.DOWN)) {
            p2Y = Math.min(CANVAS_HEIGHT - PLAYER_SIZE / 2.0, p2Y + MOVEMENT_SPEED);
        }
        if (inputHandler.isKeyPressed(KeyCode.LEFT)) {
            double minX = fullMovement ? PLAYER_SIZE / 2.0 : CANVAS_WIDTH / 2.0 + PLAYER_SIZE / 2.0;
            p2X = Math.max(minX, p2X - MOVEMENT_SPEED);
        }
        if (inputHandler.isKeyPressed(KeyCode.RIGHT)) {
            p2X = Math.min(CANVAS_WIDTH - PLAYER_SIZE / 2.0, p2X + MOVEMENT_SPEED);
        }

        player2.setPosition(p2X, p2Y);

        if (inputHandler.isKeyPressed(KeyCode.RIGHT)) player2.setRotation(0);
        else if (inputHandler.isKeyPressed(KeyCode.LEFT)) player2.setRotation(180);
        else if (inputHandler.isKeyPressed(KeyCode.UP)) player2.setRotation(-90);
        else if (inputHandler.isKeyPressed(KeyCode.DOWN)) player2.setRotation(90);
    }

    private void handlePlayer2WeaponSwitch() {
        WeaponType weapon = inputHandler.getPlayer2WeaponSwitch();
        if (weapon != null) {
            player2.setWeapon(WeaponFactory.createWeapon(weapon));
        }
    }

    private void handlePlayer2Shooting() {
        if (inputHandler.isKeyPressed(KeyCode.L)) {
            Projectile projectile = player2.shoot(2);
            if (projectile != null) {
                projectiles.add(projectile);
            }
        }
    }

    private void updateProjectiles() {
        Iterator<Projectile> it = projectiles.iterator();
        while (it.hasNext()) {
            Projectile p = it.next();
            p.update();

            boolean hit = false;
            if (p.getOwner() == 1 && collisionDetector.checkCollision(p, player2)) {
                double damage = p.getWeapon().calculateDamage(p.getFighter());
                player2.takeDamage(damage);
                hit = true;
            } else if (p.getOwner() == 2 && collisionDetector.checkCollision(p, player1)) {
                double damage = p.getWeapon().calculateDamage(p.getFighter());
                player1.takeDamage(damage);
                hit = true;
            }

            if (hit || p.getX() < 0 || p.getX() > CANVAS_WIDTH || p.getY() < 0 || p.getY() > CANVAS_HEIGHT) {
                it.remove();
            }
        }
    }

    public Fighter getPlayer1() {
        return player1;
    }

    public Fighter getPlayer2() {
        return player2;
    }

    public void addKeyPressed(KeyCode key) {
        inputHandler.addKeyPressed(key);
    }

    public void removeKeyPressed(KeyCode key) {
        inputHandler.removeKeyPressed(key);
    }
}
