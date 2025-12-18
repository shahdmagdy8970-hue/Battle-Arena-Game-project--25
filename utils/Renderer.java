package com.example.battlearena.utils;

import com.example.battlearena.models.Fighter;
import com.example.battlearena.models.Projectile;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.util.List;

public class Renderer {
    private int canvasWidth;
    private int canvasHeight;
    private int playerSize;
    private int projectileSize;

    public Renderer(int canvasWidth, int canvasHeight, int playerSize, int projectileSize) {
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
        this.playerSize = playerSize;
        this.projectileSize = projectileSize;
    }

    public void renderGame(GraphicsContext gc, Fighter player1, Fighter player2,
                           List<Projectile> projectiles, boolean fullMovement) {

        gc.setFill(Color.rgb(26, 26, 46, 0.6));
        gc.fillRect(0, 0, canvasWidth, canvasHeight);

        if (!fullMovement) {
            gc.setStroke(Color.WHITE);
            gc.setLineWidth(3);
            gc.setLineDashes(10, 10);
            gc.strokeLine(canvasWidth / 2.0, 0, canvasWidth / 2.0, canvasHeight);
            gc.setLineDashes(0);
        }

        drawPlayer(gc, player1);
        drawPlayer(gc, player2);

        for (Projectile p : projectiles) {
            gc.setFill(p.getWeapon().getColor());
            gc.fillOval(p.getX() - projectileSize / 2.0, p.getY() - projectileSize / 2.0,
                    projectileSize, projectileSize);

            gc.setStroke(Color.WHITE);
            gc.setLineWidth(2);
            gc.strokeOval(p.getX() - projectileSize / 2.0, p.getY() - projectileSize / 2.0,
                    projectileSize, projectileSize);
        }
    }

    private void drawPlayer(GraphicsContext gc, Fighter f) {
        gc.save();
        gc.translate(f.getX(), f.getY());
        gc.rotate(f.getRotation());

        gc.setFill(f.getColor());
        gc.fillRect(-playerSize / 2.0, -playerSize / 2.0, playerSize, playerSize);

        gc.setStroke(Color.WHITE);
        gc.setLineWidth(3);
        gc.strokeRect(-playerSize / 2.0, -playerSize / 2.0, playerSize, playerSize);

        gc.setFill(Color.WHITE);
        gc.fillRect(playerSize / 4.0, -3, playerSize / 4.0, 6);

        gc.restore();

        gc.setFill(Color.WHITE);
        gc.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(3);

        String name = f.getType().getDisplayName();
        double textX = f.getX() - 25;
        double textY = f.getY() + playerSize / 2.0 + 20;

        gc.strokeText(name, textX, textY);
        gc.fillText(name, textX, textY);
    }
}
