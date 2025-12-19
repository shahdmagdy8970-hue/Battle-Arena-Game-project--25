package com.example.battlearena.utils;

import com.example.battlearena.models.WeaponType;
import javafx.scene.input.KeyCode;
import java.util.HashSet;
import java.util.Set;

public class InputHandler {
    private Set<KeyCode> keysPressed;

    public InputHandler() {
        this.keysPressed = new HashSet<>();
    }

    public void addKeyPressed(KeyCode key) {
        keysPressed.add(key);
    }

    public void removeKeyPressed(KeyCode key) {
        keysPressed.remove(key);
    }

    public boolean isKeyPressed(KeyCode key) {
        return keysPressed.contains(key);
    }

    public WeaponType getPlayer1WeaponSwitch() {
        if (keysPressed.contains(KeyCode.DIGIT1)) {
            keysPressed.remove(KeyCode.DIGIT1);
            return WeaponType.PISTOL;
        }
        if (keysPressed.contains(KeyCode.DIGIT2)) {
            keysPressed.remove(KeyCode.DIGIT2);
            return WeaponType.CANNON;
        }
        if (keysPressed.contains(KeyCode.DIGIT3)) {
            keysPressed.remove(KeyCode.DIGIT3);
            return WeaponType.MAGIC_STAFF;
        }
        if (keysPressed.contains(KeyCode.DIGIT4)) {
            keysPressed.remove(KeyCode.DIGIT4);
            return WeaponType.BOW;
        }
        return null;
    }

    public WeaponType getPlayer2WeaponSwitch() {
        if (keysPressed.contains(KeyCode.DIGIT7)) {
            keysPressed.remove(KeyCode.DIGIT7);
            return WeaponType.PISTOL;
        }
        if (keysPressed.contains(KeyCode.DIGIT8)) {
            keysPressed.remove(KeyCode.DIGIT8);
            return WeaponType.CANNON;
        }
        if (keysPressed.contains(KeyCode.DIGIT9)) {
            keysPressed.remove(KeyCode.DIGIT9);
            return WeaponType.MAGIC_STAFF;
        }
        if (keysPressed.contains(KeyCode.DIGIT0)) {
            keysPressed.remove(KeyCode.DIGIT0);
            return WeaponType.BOW;
        }
        return null;
    }
}
