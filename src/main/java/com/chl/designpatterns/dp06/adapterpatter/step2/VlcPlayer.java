package com.chl.designpatterns.dp06.adapterpatter.step2;

import com.chl.designpatterns.dp06.adapterpatter.step1.AdvancedMediaPlayer;
/**
 * VlC֧�ֲ���
 * @author deathearth
 *
 */
public class VlcPlayer implements AdvancedMediaPlayer {

	public void playVlc(String fileName) {
		System.out.println("playing vlc file.name "+ fileName);

	}

	public void palyMp4(String filename) {
		// TODO Auto-generated method stub
		// do nothing
	}

}
