package com.chl.designpatterns.dp06.adapterpatter.step4;

import com.chl.designpatterns.dp06.adapterpatter.step1.MediaPlayer;
import com.chl.designpatterns.dp06.adapterpatter.step3.MediaAdapter;

/**
 * ��ͨ��Ӱ���ӿ�ʵ��
 * @author deathearth
 *
 */
public class AudioPlayer implements MediaPlayer {
	MediaAdapter mediaAdapter;
	public void play(String audioType, String fileName) {
		// TODO Auto-generated method stub
		// ����MP3�����ļ�������֧��
		if(audioType.equalsIgnoreCase("MP3")){
			System.out.println("Playing mp3 file.Name "+fileName);
		}
		else if (audioType.equalsIgnoreCase("vlc") ||audioType.equalsIgnoreCase("mp4")){
			mediaAdapter = new MediaAdapter(audioType);
			mediaAdapter.play(audioType, fileName);
		}
		else {
			System.out.println("Invalid media. "+ audioType + "format not supported!!");
		}
	}

}
