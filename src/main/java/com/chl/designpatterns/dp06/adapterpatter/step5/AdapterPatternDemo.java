package com.chl.designpatterns.dp06.adapterpatter.step5;

import com.chl.designpatterns.dp06.adapterpatter.step4.AudioPlayer;


public class AdapterPatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AudioPlayer audioPlayer = new AudioPlayer();
		audioPlayer.play("mp3", "beyond the horizon.mp3");
		audioPlayer.play("mp4", "alone.mp4");
		audioPlayer.play("vlc", "far away from home.vlc");
		audioPlayer.play("avi", "fuc me.avi");
	}

}
