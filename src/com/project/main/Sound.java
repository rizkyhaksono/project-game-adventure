package com.project.main;

import java.io.File;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

    Clip clip;
    URL soundURL[] = new URL[30];

//    public Sound() {
//        soundURL[0] = getClass().getResource("/sound/coin.wav");
//        soundURL[1] = getClass().getResource("/sound/door_unlock.wav");
//        soundURL[2] = getClass().getResource("/sound/door.wav");
//        soundURL[3] = getClass().getResource("/sound/knock.wav");
//        soundURL[4] = getClass().getResource("/sound/powerup.wav");
//        soundURL[5] = getClass().getResource("res/sound/BlueBoyAdventure.wav");
//    }

    public void setFile(int i) {

        try {
            File file1 = new File("res/sound/BlueBoyAdventure.wav");
            soundURL[0] = file1.toURI().toURL();

            File file2 = new File("res/sound/coin.wav");
            soundURL[1] = file2.toURI().toURL();

            File file3 = new File("res/sound/powerup.wav");
            soundURL[2] = file3.toURI().toURL();

            File file4 = new File("res/sound/unlock.wav");
            soundURL[3] = file4.toURI().toURL();

            File file5 = new File("res/sound/fanfare.wav");
            soundURL[4] = file5.toURI().toURL();

            AudioInputStream audioIS = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(audioIS);

            // debugging for the audio
            System.out.println("Sound " + i + " loaded");

        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }

    public void play() {
        clip.start();
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        clip.stop();
    }
}
