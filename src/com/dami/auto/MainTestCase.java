package com.dami.auto;

import com.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;

public class MainTestCase extends ActivityInstrumentationTestCase2 {
	private Solo solo;
	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.damitv.ui.WelcomeActivity";

	private static Class<?> launcherActivityClass;
	static {
		try {
			launcherActivityClass = Class
					.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public MainTestCase() throws ClassNotFoundException {
		super(launcherActivityClass);
		// TODO Auto-generated constructor stub
	}

	public void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
		// getActivity();
	}

	@Override
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
		super.tearDown();
	}

	// 完整录制视频
	public void testRun() {
		preaction();
		recordVideo();
	}

	// 上传视频
	public void testUploadVideo(){
		preaction();
		recordVideo();
		solo.sleep(100);
		//视频剪辑界面点击完成
		solo.clickOnView(solo.getView("tv_finish"));
		solo.sleep(100);
		
	//	solo.clickOnEditText(1);
		solo.sleep(100);
		
		solo.enterText(0, "www");
		
		solo.sleep(500);
		solo.clickOnView(solo.getView("tv_right_title"));
		solo.sleep(100);
		
		//进入本地视频列表
		solo.goBack();
	}

	// 上传图片
	public void testUploadPicture(){
		preaction();
				
		//+
		solo.clickOnView(solo.getView("iv_show_more"));
		solo.sleep(1000);
		//图片
		solo.clickOnView(solo.getView("iv_upload_pic"));
		solo.sleep(1000);
		//拍摄图片
		solo.clickOnView(solo.getView("iv_take_pic"));
		solo.sleep(1000);
		//图片发布详情页
		solo.enterText(0, "picture");
		solo.clickOnView(solo.getView("tv_publish"));
		solo.sleep(5000);
		
	}
	
	// 刷新
	public void testRefresh(){
		//preaction();
		solo.sleep(5000);
		solo.drag(200, 200, 200, 700, 12);
		solo.sleep(5000);
//		solo.scrollDown();
//		solo.sleep(5000);
//		
//		solo.scrollToTop();
//		solo.sleep(5000);
//		
//		solo.scrollToSide(1);
	}
	
	// 准备动作
	public void preaction() {
		solo.waitForText("大米直播", 1, 3000);
		solo.sleep(2000);

		solo.assertCurrentActivity("正确", "MainActivity");
	}

	// 录制视频
	public void recordVideo() {
		solo.clickOnView(solo.getView("iv_show_more"));
		solo.sleep(1000);

		solo.clickOnView(solo.getView("iv_upload"));
		solo.sleep(1000);

		solo.clickOnView(solo.getView("checkbox_record"));
		solo.sleep(5000);

		solo.clickOnView(solo.getView("checkbox_record"));
	}

}
