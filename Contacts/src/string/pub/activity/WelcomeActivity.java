package string.pub.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import string.pub.contacts.MainActivity;
import string.pub.contacts.R;

public class WelcomeActivity extends Activity {
	private ImageView mShowPicture;
	private Animation mFadeInScale1;
	private Animation mFadeInScale2;
	SharedPreferences sharedPreferences;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);
		initWindow();
		setListener();
		mShowPicture.startAnimation(mFadeInScale1);
	}

	private void initWindow() {
		// 隐藏ActionBar
		if (getActionBar() != null) {
			getActionBar().hide();
		}
		// 透明状态栏
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		// 透明导航栏
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
	}

	void initView() {
		mShowPicture = (ImageView) findViewById(R.id.imageView1);
	}

	void initAnim() {
		mFadeInScale1 = AnimationUtils.loadAnimation(WelcomeActivity.this, R.anim.welcome_fade_in_scale1);
		mFadeInScale1.setDuration(3000);
		mFadeInScale2 = AnimationUtils.loadAnimation(WelcomeActivity.this, R.anim.welcome_fade_in_scale2);
		mFadeInScale2.setDuration(3000);
	}

	/**
	 * 监听事件
	 */
	private void setListener() {
		mFadeInScale1.setAnimationListener(new AnimationListener() {

			public void onAnimationStart(Animation animation) {

			}

			public void onAnimationRepeat(Animation animation) {

			}

			public void onAnimationEnd(Animation animation) {
				mShowPicture.startAnimation(mFadeInScale2);
				sharedPreferences = getSharedPreferences("string.pub.contacts", MODE_PRIVATE);
				boolean isFirst = sharedPreferences.getBoolean("isFirst", true);
				//if first use; go to guide page
				//if not, then to login view 
				//if login then go to main view
				if (isFirst) {
					Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
					startActivity(intent);
					// 实例化Editor对象
					Editor editor = sharedPreferences.edit();
					// 存入数据
					editor.putBoolean("isFirst", false);
					// 提交修改
					editor.commit();
					finish();
					return;
				}
				Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
				startActivity(intent);
			}
		});
		mFadeInScale2.setAnimationListener(new AnimationListener() {

			public void onAnimationStart(Animation animation) {

			}

			public void onAnimationRepeat(Animation animation) {

			}

			public void onAnimationEnd(Animation animation) {
				finish();
			}
		});
	}

}
