/**
 * ��򵥵���Ƶ��վ
 * Simplest Video Website
 *
 * ������ Lei Xiaohua
 * 
 * leixiaohua1020@126.com
 * �й���ý��ѧ/���ֵ��Ӽ���
 * Communication University of China / Digital TV Technology
 * http://blog.csdn.net/leixiaohua1020
 *
 * ��������һ����򵥵���Ƶ��վ��Ƶ����֧��
 * 1.ֱ��
 * 2.�㲥
 * This software is the simplest video website.
 * It support: 
 * 1. live broadcast 
 * 2. VOD 
 */
package action.video;

import java.sql.Timestamp;
import java.util.Date;

import service.BaseService;

import bean.Video;

import com.opensymphony.xwork2.ActionSupport;
/**
 * @author ������
 * ������Ƶ��Ϣ��ACtion
 */
public class VideoUpdate extends ActionSupport {
	private int videoid;
	private String name;
	private String intro;
	private BaseService baseService;
	private Video video;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public BaseService getBaseService() {
		return baseService;
	}
	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	public int getVideoid() {
		return videoid;
	}
	public void setVideoid(int videoid) {
		this.videoid = videoid;
	}
	public String Read(){
		try{
			video=(Video) baseService.ReadByID("Video", videoid);
			return SUCCESS;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return ERROR;
		}
	}
	public String Update(){
		try{
			video.setName(name);
			video.setIntro(intro);
			video.setEdittime(new Timestamp(new Date().getTime()));
			baseService.update(video);
			return SUCCESS;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return ERROR;
		}
	}
}
