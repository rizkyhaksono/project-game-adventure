package com.project.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed;
    boolean checkDrawTime = false;

    public KeyHandler (GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        // TITLE STATE
        if (gp.gameState == gp.titleState) {

            // title screen 0
            if (gp.ui.titleScreenState == 0) {

                // increment commandNum
                if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
                    gp.ui.commandNum--;
                    if (gp.ui.commandNum < 0) {
                        gp.ui.commandNum = 2;
                    }
                }

                // decrement commandNum
                if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
                    gp.ui.commandNum++;
                    if (gp.ui.commandNum > 2) {
                        gp.ui.commandNum = 0;
                    }
                }

                // enter
                if (code == KeyEvent.VK_ENTER) {
                    if (gp.ui.commandNum == 0) {
                        gp.ui.titleScreenState = 1;
                    }

                    if (gp.ui.commandNum == 1) {
                        // add later
                    }

                    if (gp.ui.commandNum == 2) {
                        System.exit(0);
                    }
                }
            } else if (gp.ui.titleScreenState == 1) { // title screen 1

                // increment commandNum
                if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
                    gp.ui.commandNum--;
                    if (gp.ui.commandNum < 0) {
                        gp.ui.commandNum = 3;
                    }
                }

                // decrement commandNum
                if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
                    gp.ui.commandNum++;
                    if (gp.ui.commandNum > 3) {
                        gp.ui.commandNum = 0;
                    }
                }

                // enter
                if (code == KeyEvent.VK_ENTER) {
                    if (gp.ui.commandNum == 0) {
                        System.out.println("Do some fighter specific stuff!");
                        gp.gameState = gp.playState;
                        gp.playMusic(0);
                    }

                    if (gp.ui.commandNum == 1) {
                        System.out.println("Do some thief specific stuff!");
                        gp.gameState = gp.playState;
                        gp.playMusic(0);
                    }

                    if (gp.ui.commandNum == 2) {
                        System.out.println("Do some sorcerer specific stuff!");
                        gp.gameState = gp.playState;
                        gp.playMusic(0);
                    }

                    if (gp.ui.commandNum == 3) {
                        gp.ui.titleScreenState = 0;
                    }
                }
            }
        }

        // play state
        if (gp.gameState == gp.playState) {

            // WASD
            if (code == KeyEvent.VK_W) {
                upPressed = true;
            }
            if (code == KeyEvent.VK_S) {
                downPressed = true;
            }
            if (code == KeyEvent.VK_A) {
                leftPressed = true;
            }
            if (code == KeyEvent.VK_D) {
                rightPressed = true;
            }

            // PAUSE
            if (code == KeyEvent.VK_P) {
                gp.gameState = gp.pauseState;
            }

            // ENTER
            if (code == KeyEvent.VK_ENTER) {
                enterPressed = true;
            }

            // DEBUG
            if (code == KeyEvent.VK_T) {

                if (checkDrawTime == false) {
                    checkDrawTime = true;
                } else if (checkDrawTime == true){
                    checkDrawTime = false;
                }
            }
        }

        // pause state
        else if (gp.gameState == gp.pauseState) {
            if (code == KeyEvent.VK_P) {
                gp.gameState = gp.playState;
            }
        }

        // dialogue state
        else if (gp.gameState == gp.dialogState) {
            if (code == KeyEvent.VK_ENTER) {
                gp.gameState = gp.playState;
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }
    }
}

