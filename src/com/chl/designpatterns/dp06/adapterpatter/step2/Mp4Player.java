package com.chl.designpatterns.dp06.adapterpatter.step2;

import com.chl.designpatterns.dp06.adapterpatter.step1.AdvancedMediaPlayer;
/**
 * MP4 �Ĵ���ʽ
 * @author deathearth
 *
 */
public class Mp4Player implements AdvancedMediaPlayer {

	public void playVlc(String fileName) {
		// TODO Auto-generated method stub
		// do nothing
	}

	public void palyMp4(String filename) {
		System.out.println("playing mp4 file.name "+ filename);
	}

}
