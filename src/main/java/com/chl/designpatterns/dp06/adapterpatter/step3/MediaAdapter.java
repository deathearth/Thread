package com.chl.designpatterns.dp06.adapterpatter.step3;

import com.chl.designpatterns.dp06.adapterpatter.step1.AdvancedMediaPlayer;
import com.chl.designpatterns.dp06.adapterpatter.step1.MediaPlayer;
import com.chl.designpatterns.dp06.adapterpatter.step2.Mp4Player;
import com.chl.designpatterns.dp06.adapterpatter.step2.VlcPlayer;

/**
 * �߼�Ӱ���ӿڵ�ʵ�֣�ʵ�ֶ�Ӧ�ľ���ʵ��
 * @author deathearth
 *
 */
public class MediaAdapter implements MediaPlayer {

	AdvancedMediaPlayer advancedMediaPlayer;
	
	public  MediaAdapter(String audioType){
		if(audioType.equalsIgnoreCase("vlc")){
			advancedMediaPlayer = new VlcPlayer();
		}else if(audioType.equalsIgnoreCase("mp4")){
			advancedMediaPlayer = new Mp4Player();
		}
	}
	
	public void play(String audioType, String fileName) {
		// TODO Auto-generated method stub
		if(audioType.equalsIgnoreCase("vlc")){
			advancedMediaPlayer.playVlc(fileName);
		}else if(audioType.equalsIgnoreCase("mp4")){
			advancedMediaPlayer.palyMp4(fileName);
		}
	}

	

}
