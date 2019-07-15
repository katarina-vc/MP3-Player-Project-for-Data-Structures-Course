/*
 * Name:		Katarina Capalbo n01399315
 * Date:		5/28/2019
 * Assignment:	Project 1 COP3530
 * 
 * Description: MP3 Player GUI that plays songs, originally implements an arraylist as an underlying data structure,
 * 				Project: Covert arraylist usage to a linked list.
 */
import javazoom.jl.player.*;
import javazoom.jl.player.advanced.*;
import java.io.FileInputStream;
import java.util.Scanner;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Mp3Player extends JPanel implements ActionListener{
    static JButton play,pause,next;
    JLabel songname, songlist;
    PlayThread runnable;
    Thread t;
    static List songList;
    static int selectedSong;
    
    public Mp3Player() {
        selectedSong = 0;
        //GridLayout layout = new GridLayout(0,3);
        //setLayout(layout);
        setPreferredSize(new Dimension(300,250));
        play = new JButton("Play");
        play.setVerticalTextPosition(AbstractButton.CENTER);
        play.setHorizontalTextPosition(AbstractButton.LEADING);
        play.setActionCommand("play");
        
        next = new JButton("Next");
        next.setVerticalTextPosition(AbstractButton.BOTTOM);
        next.setHorizontalTextPosition(AbstractButton.CENTER);
        next.setActionCommand("next");
        
        pause = new JButton("Stop");
        pause.setActionCommand("pause");
        pause.setEnabled(false);
        
        play.addActionListener(this);
        pause.addActionListener(this);
        next.addActionListener(this);
        
        
        songname = new JLabel(songList.get(selectedSong));
        songname.setPreferredSize(new Dimension(200,30));
        songlist = new JLabel(songList.toHTMLString());
        songlist.setPreferredSize(new Dimension(240,180));
        JLabel n = new JLabel("Song Name:");
        add(n);
        add(songname);
        add(new JLabel(""));
        add(play);
        add(pause);
        add(next);
        add(songlist);
    }
    
    public void actionPerformed(ActionEvent e) {
        if("play".equals(e.getActionCommand())) {
            runnable = new PlayThread(songList.get(selectedSong));
            t = new Thread(runnable);
            t.start();
            play.setEnabled(false);
            pause.setEnabled(true);
        }
        if("pause".equals(e.getActionCommand())) {
            t.stop();
            
            pause.setEnabled(false);
            play.setEnabled(true);
        }
        if("next".equals(e.getActionCommand())) {
            selectedSong++;
            selectedSong = selectedSong % songList.size();
            String nextsong = songList.get(selectedSong);
            songname.setText(nextsong);
        }
    }
    public static void doneSong() {
        
        pause.setEnabled(false);
        play.setEnabled(true);
    }
    private static void createAndShowGUI() {
        
        //Create and set up the window.
        JFrame frame = new JFrame("MP3 Player");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Create and set up the content pane.
        Mp3Player newContentPane = new Mp3Player();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        songList = new List();
        songList.insertItem("barbie_girl.mp3");
        songList.insertItem("call_me_maybe.mp3");
        songList.clear();
 
        songList.insertItem("barbie_girl.mp3");
        songList.insertItem("call_me_maybe.mp3");
        songList.insertItem("chandelier.mp3");
        
        songList.insertItem("mmmbop.mp3",1);
        songList.insertItem("macarena.mp3",0);
        songList.insertItem("who_let_the_dogs_out.mp3",1);
        
        songList.removeItem("mmmbop.mp3");
        songList.insertItem("mmmbop.mp3");
        
        System.out.println(songList);
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
        
    }
}

class PlayThread implements Runnable {
    public String song;
    
    public PlayThread(String song) {
        this.song = song;
    }
    public void run() {
        try{
            FileInputStream fis = new FileInputStream(song);
            AdvancedPlayer p = new AdvancedPlayer(fis);
            p.play();
        } catch(Exception e){}
        Mp3Player.doneSong();
    }
    
}

