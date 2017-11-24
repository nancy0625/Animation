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
	 * ����һ��AnimationSet���󣬸ö���洢���Ƕ����ļ��� ��������Ҫ������Ӧ��Animation����
	 * ���ݶ���������ΪAnimation����������Ӧ�����ݣ���ִ�н���� ��Animation��������ӵ�AnimationSet������
	 * ʹ�ÿؼ���ʼִ��AnimationSet����
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
		// ������ĸ��������������ת��Բ�ĵ�λ��
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
				Animation.RELATIVE_TO_SELF, 0f// X�Ὺʼ��λ��
				, Animation.RELATIVE_TO_SELF, 0.5f// X�������λ��
				, Animation.RELATIVE_TO_SELF, 0f// Y��Ŀ�ʼλ��
				, Animation.RELATIVE_TO_SELF, 1.0f// Y��Ľ���λ��
		);
		translateAnimation.setDuration(2000);
		animationSet.addAnimation(translateAnimation);
		animationSet.setFillAfter(false);// ����Ϊtrue���򶯻�ִ����֮��Ч��������ִ��֮���״̬
		animationSet.setFillBefore(true);// ����Ϊfalse���򶯻�ִ�����Ч��������ִ������״̬
		animationSet.setStartOffset(2000);// ���õ���һ��long���͵�ֵ����ָ�����ӳٶ��ٺ������
		animationSet.setRepeatCount(3);// ����Ч���ظ�����
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
