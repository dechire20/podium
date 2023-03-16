package tilegame.pages;

import tilegame.Handler;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static tilegame.pages.LogInFrame.isLogIn;
import tilegame.utils.ConnectDB;

public class LeaderboardPage extends Page{
    LeaderboardForm leaderboard;
    Handler mHandler;
    public LeaderboardPage(Handler handler) {
        super(handler);    
        mHandler = handler;
        leaderboard = new LeaderboardForm();
        Connection con = ConnectDB.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        
        String leaderboard = "SELECT * FROM Leaderboard";
        try{
            ps = con.prepareStatement(leaderboard);
            rs = ps.executeQuery();
            
            while (rs.next()){
                System.out.println(rs.getInt("BestTime"));
            }
            /*else{
                 JOptionPane.showMessageDialog(null, "Incorrect username or password");
            }*/
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @Override
    public void update() {
        leaderboard.setVisible(true);
        
        if (leaderboard.isSwitch){
            leaderboard.dispose();
            PageManager.getInstance().setCurrentPage(PageManager.PAGESENUM.HOMEPAGE);
        }
    }

    @Override
    public void render(Graphics g) {
        
    }
}
