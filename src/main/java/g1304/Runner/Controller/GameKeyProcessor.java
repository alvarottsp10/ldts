package g1304.Runner.Controller;

import com.googlecode.lanterna.input.KeyStroke;
import g1304.Runner.Model.MovingObjects.AttackController;
import g1304.Runner.Model.MovingObjects.MainCharacter;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class GameKeyProcessor implements KeyListener{
    long timeOfLastAttack = 0;
    boolean upPressed = false, downPressed = false, leftPressed = false, rightPressed = false;

    List<KeyStroke> actionsToProcess = new ArrayList<>();
    MainCharacter mainCharacter;
    AttackController attackController;
    String currentState = "Menu";

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
                    downPressed = true;
                }
                case KeyEvent.VK_D -> {
                    rightPressed = true;
                }
                case KeyEvent.VK_UP -> {
                    if (System.currentTimeMillis() > timeOfLastAttack + 500) {
                        attackController.AttackUp();
                        mainCharacter.setAttackingUp(true);
                        timeOfLastAttack = System.currentTimeMillis();
                    }
                    else {
                        mainCharacter.setAttackingUp(false);
                    }


                }
                case KeyEvent.VK_LEFT-> {
                    if (System.currentTimeMillis() > timeOfLastAttack + 500) {
                        attackController.AttackLeft();
                        mainCharacter.setAttackingLeft(true);
                        timeOfLastAttack = System.currentTimeMillis();
                    }
                    else {
                        mainCharacter.setAttackingLeft(false);
                    }
                }
                case KeyEvent.VK_RIGHT -> {
                    if (System.currentTimeMillis() > timeOfLastAttack + 500) {
                        attackController.AttackRight();
                        mainCharacter.setAttackingRight(true);
                        timeOfLastAttack = System.currentTimeMillis();
                    }
                    else {
                        mainCharacter.setAttackingRight(false);
                    }
                }
                case KeyEvent.VK_DOWN -> {
                    if (System.currentTimeMillis() > timeOfLastAttack + 500) {
                        attackController.AttackDown();
                        mainCharacter.setAttackingDown(true);
                        timeOfLastAttack = System.currentTimeMillis();
                    }
                    else {
                        mainCharacter.setAttackingDown(false);
                    }
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
            case KeyEvent.VK_UP -> {
                attackController.AttackUp();
                mainCharacter.setAttackingUp(false);

            }
            case KeyEvent.VK_LEFT-> {
                attackController.AttackLeft();
                mainCharacter.setAttackingLeft(false);
            }
            case KeyEvent.VK_RIGHT -> {
                attackController.AttackRight();
                mainCharacter.setAttackingRight(false);
            }
            case KeyEvent.VK_DOWN -> {
                attackController.AttackDown();
                mainCharacter.setAttackingDown(false);
            }
        }
    }

    public GameKeyProcessor(MainCharacter mainCharacter1, AttackController attackController1) {
        mainCharacter = mainCharacter1;
        attackController = attackController1;
    }

    public Object getMainCharacter() {
        return mainCharacter;
    }
}

