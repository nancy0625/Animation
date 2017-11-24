package com.example.animation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class Animatons_Activity extends Activity {
	private Button alpha;
	private Button translate;
	private Button scale;
	private Button rotata;
	private Button alpha_Translate;
	private ImageView imageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_animations);
		alpha = (Button) findViewById(R.id.alpha);
		scale = (Button) findViewById(R.id.scale);
		translate = (Button) findViewById(R.id.translate);
		rotata = (Button) findViewById(R.id.rotata);
		alpha_Translate = (Button) findViewById(R.id.alpha_Translate);
		imageView = (ImageView) findViewById(R.id.img);

		alpha.setOnClickListener(new MyButton());
		scale.setOnClickListener(new MyButton());
		translate.setOnClickListener(new MyButton());
		rotata.setOnClickListener(new MyButton());
		alpha_Translate.setOnClickListener(new MyButton());

	}

	class MyButton implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			switch (arg0.getId()) {
			case R.id.alpha:
				Alpha();
				break;
			case R.id.scale:
				Scale();
				break;
			case R.id.rotata:
				Rotata();
				break;
			case R.id.translate:
				Translate();
				break;
			case R.id.alpha_Translate:
				Alpha_Translate();
				break;
			}

		}

	}

	/**
	 * 创建一个AnimationSet对象，该对象存储的是动画的集合 根据需求要创建相应的Animation对象
	 * 根据动画的需求，为Animation对象设置相应的数据（即执行结果） 将Animation给对象添加到AnimationSet对象中
	 * 使用控件开始执行AnimationSet对象
	 */
	public void Alpha() {
		AnimationSet animationSet = new AnimationSet(true);
		AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
		alphaAnimation.setDuration(2000);
		animationSet.addAnimation(alphaAnimation);
		imageView.startAnimation(animationSet);
	}

	/**
	 * 
	 */
	public void Scale() {
		AnimationSet animationSet = new AnimationSet(true);
		ScaleAnimation scaleAnimation = new ScaleAnimation(1, 0.1f, 1, 0.1f,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);
		scaleAnimation.setDuration(2000);
		animationSet.addAnimation(scaleAnimation);
		imageView.startAnimation(animationSet);

	}

	public void Rotata() {
		AnimationSet animationSet = new AnimationSet(true);
		// 后面的四个参数定义的是旋转的圆心的位置
		RotateAnimation rotateAnimation = new RotateAnimation(0, 360,
				Animation.RELATIVE_TO_PARENT, 1f, Animation.RELATIVE_TO_PARENT,
				0f);
		rotateAnimation.setDuration(2000);
		animationSet.addAnimation(rotateAnimation);
		imageView.startAnimation(animationSet);

	}

	public void Translate() {
		AnimationSet animationSet = new AnimationSet(true);
		TranslateAnimation translateAnimation = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, 0f// X轴开始的位置
				, Animation.RELATIVE_TO_SELF, 0.5f// X轴结束的位置
				, Animation.RELATIVE_TO_SELF, 0f// Y轴的开始位置
				, Animation.RELATIVE_TO_SELF, 1.0f// Y轴的结束位置
		);
		translateAnimation.setDuration(2000);
		animationSet.addAnimation(translateAnimation);
		animationSet.setFillAfter(false);// 设置为true，则动画执行完之后效果定格在执行之后的状态
		animationSet.setFillBefore(true);// 设置为false，则动画执行完后效果定格在执行完后的状态
		animationSet.setStartOffset(2000);// 设置的是一个long类型的值，是指动画延迟多少毫秒出现
		animationSet.setRepeatCount(3);// 动画效果重复几次
		imageView.startAnimation(animationSet);

	}

	public void Alpha_Translate() {
		AnimationSet animationSet = new AnimationSet(true);
		AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
		alphaAnimation.setDuration(2000);
		animationSet.addAnimation(alphaAnimation);
		TranslateAnimation translateAnimation = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF,
				0.5f, Animation.RELATIVE_TO_SELF, 0f,
				Animation.RELATIVE_TO_SELF, 1.0f);
		translateAnimation.setDuration(2000);
		animationSet.addAnimation(translateAnimation);
		imageView.startAnimation(animationSet);
	}

}
