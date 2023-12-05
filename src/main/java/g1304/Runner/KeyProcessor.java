package g1304.Runner;

import com.googlecode.lanterna.input.KeyStroke;
import g1304.Runner.MovingObjects.AttackController;
import g1304.Runner.MovingObjects.MainCharacter;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class KeyProcessor implements KeyListener{
    boolean upPressed = false, downPressed = false, leftPressed = false, rightPressed = false;

    List<KeyStroke> actionsToProcess = new ArrayList<>();
    MainCharacter mainCharacter;
    AttackController attackController;

    KeyStroke LastKeyPressed;

    public boolean isDownPressed() {
        return downPressed;
    }

    public boolean isUpPressed() {
        return upPressed;
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch(code) {
            case KeyEvent.VK_W -> {
                upPressed = true;
            }
            case KeyEvent.VK_A-> {
                leftPressed = true;
            }
            case KeyEvent.VK_S -> {
                downPressed =true;
            }
            case KeyEvent.VK_D -> {
                rightPressed =true;
            }
            case KeyEvent.VK_UP -> {
                attackController.AttackUp();
            }
            case KeyEvent.VK_LEFT-> {
                attackController.AttackLeft();
            }
            case KeyEvent.VK_RIGHT -> {
                attackController.AttackRight();
            }
            case KeyEvent.VK_DOWN -> {
                attackController.AttackDown();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        switch(code) {
            case KeyEvent.VK_W -> {
                upPressed = false;
            }
            case KeyEvent.VK_A-> {
                leftPressed = false;
            }
            case KeyEvent.VK_S -> {
                downPressed =false;
            }
            case KeyEvent.VK_D -> {
                rightPressed =false;
            }
        }
    }

    public KeyProcessor (MainCharacter mainCharacter1, AttackController attackController1) {
        mainCharacter = mainCharacter1;
        attackController = attackController1;
    }
}

