package com.example.animation;

import java.util.Iterator;
import java.util.List;

import com.example.json.code.JsonTools;
import com.example.loginjson.http.HttpUtils;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.app.ProgressDialog;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import android.os.Build;

public class MainActivity extends Activity {
	private VideoView videoView;
	private List<String> list = null;
	private Button btn;
	private TextView text;
	private ArrayAdapter<String> adapter;

	private MyHandler handler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		videoView = (VideoView) findViewById(R.id.videoView);
		btn = (Button) findViewById(R.id.button1);
		text = (TextView) findViewById(R.id.text);
		
		handler = new MyHandler();

		String path = MainActivity.this.getFilesDir().getPath() + "/2.mp4";
		/**
		 * ������Ƶ����
		 */
		videoView.setVideoPath(path);
		/**
		 * ������Ƶ����
		 */
		// videoView.setVideoURI(Uri.parse(""));
		/**
		 * MediaController
		 */
		MediaController controller = new MediaController(this);
		/**
		 * ����videoView��MediaController��������
		 * 
		 */
		videoView.setMediaController(controller);
		/**
		 * ����MediaController��videoView��������
		 * 
		 */
		// controller.setMediaPlayer(videoView);
		/*
		 * videoView.seekTo(0); videoView.requestFocus(); videoView.start();
		 */
		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				//Toast.makeText(MainActivity.this, "���ǻ�ȡ���ݵ�", Toast.LENGTH_SHORT).show();
		      new MyTask().execute("http://192.168.1.231:8080/transportservice/type/jason/action/%20GetAllSense.do");
				
				//new Thread(new MyThread()).start();
			}
		});

	}
	
	 public class MyHandler extends Handler{
		 @Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			list = (List<String>) msg.obj;

			if (Integer.valueOf(list.get(1)) > 1000) {

				videoView.seekTo(0);
				videoView.requestFocus();
				videoView.start();
				text.setText("������ֵ̼Ϊ��" + list.get(1) + "���س���");
			} else {
				text.setText("������ֵ̼Ϊ��" + list.get(1) + "����");
			}
		}
	 }
	public class MyThread implements Runnable{

		int count = 0;
		@Override
		public void run() {
			//while(count<=20){
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//����Ϣ���л�ȡ��Ϣ�����û�У�����һ����Ϣ������ȡ����Ϣ����handler����
				Message message = Message.obtain();
				String jsonString = HttpUtils.sendPostMethod("http://192.168.1.231:8080/transportservice/type/jason/action/%20GetAllSense.do", "utf-8");
				// ����json����
				list = JsonTools.paraseList(jsonString);
				//message.arg1 = count;
				/*message.arg2;*/
				message.obj = list;
				/*Bundle data = new Bundle();
				message.setData(data);*/
				//count++;
				handler.sendMessage(message);
			//}
			
		}
		
	}
	class MyTask extends AsyncTask<String, Void, List<String>> {
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();

		}

		@Override
		protected List<String> doInBackground(String... params) {
			String jsonString = HttpUtils.sendPostMethod(params[0], "utf-8");
				// ����json����
				list = JsonTools.paraseList(jsonString);
			

			return list;
		}

		@Override
		protected void onPostExecute(List<String> result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			if (Integer.valueOf(list.get(1)) > 5000) {

				videoView.seekTo(0);
				videoView.requestFocus();
				videoView.start();
				text.setText("������ֵ̼Ϊ��" + list.get(1) + "���س���");
			} else {
				text.setText("������ֵ̼Ϊ��" + list.get(1) + "����");
			}

		}

	}

}
