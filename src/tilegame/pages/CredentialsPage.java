/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tilegame.pages;

import java.awt.Font;
import java.awt.Graphics;
import tilegame.Handler;
import tilegame.states.*;
import java.awt.Color;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;



/**
 *
 * @author Ersum
 */
public class CredentialsPage extends Page{
    LogInFrame login;
    Handler mHandler;
    public CredentialsPage(Handler handler) {
        super(handler);
        mHandler = handler;
        login = new LogInFrame();
        login.setVisible(true);
    }

    @Override
    public void update() {
        if (login.isLogIn()){

            PageManager.getInstance().setCurrentPage(PageManager.PAGESENUM.HOMEPAGE);
            mHandler.getGame().getDisplay().setVisible(true);
            login.dispose();
        }
        else{
            mHandler.getGame().getDisplay().setVisible(false);
        }
        
        if (login.createAcc()){
            login.dispose();
            new SignUpForm().setVisible(true);
            login.setCreateAcc(false);
        }
        else if (login.isVisible()){
            login.setVisible(true);
        }
    }

    @Override
    public void render(Graphics g) {
        
    }
    
}
