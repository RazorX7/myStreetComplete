package de.westnordost.streetcomplete.debug;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import de.westnordost.streetcomplete.FragmentContainerActivity;
import de.westnordost.streetcomplete.R;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import android.widget.ListView;
import android.widget.TextView;
import java.util.List;
import java.util.LinkedList;

import java.io.*;


public class SampleActivity extends FragmentContainerActivity{

	private Button btn1, btn2,btn3,btn4;

	private ListView myListView = null;
	protected List<String> mlist=new LinkedList<>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sample);

		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		initView();
		init();
		setupViewComponent();
	}
	private void initView() {
		       btn1 = (Button) findViewById(R.id.button);
		       btn2 = (Button) findViewById(R.id.button1);
		       btn3 = (Button) findViewById(R.id.outPut);
		       btn4 = (Button) findViewById(R.id.Show);
		   }

	     //方法：控件View的点击事件
	public void onClick(View v) {
		Intent intent;
			switch (v.getId()) {
				 case R.id.button:
					Toast.makeText(SampleActivity.this, "搜索记录", Toast.LENGTH_SHORT).show();
					intent = new Intent(this, Search.class);
					startActivity(intent);
					setupViewComponent();
						break;
			 	 case R.id.button1:
					Toast.makeText(SampleActivity.this, "分享", Toast.LENGTH_SHORT).show();
					shareItem();
						break;
				case R.id.outPut:
					Toast.makeText(SampleActivity.this, "导出记录", Toast.LENGTH_SHORT).show();
					outPutToTxt();
					Toast.makeText(SampleActivity.this, "导出成功", Toast.LENGTH_SHORT).show();
					break;
				case R.id.Show:
					init_to();
					setupViewComponent();
					Toast.makeText(SampleActivity.this, "初始化记录成功", Toast.LENGTH_SHORT).show();
					break;

				 default:
				            break;
			       }
		   }

	private void shareItem() {
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("text/plain");
		intent.putExtra(Intent.EXTRA_SUBJECT, "分享");
		intent.putExtra(Intent.EXTRA_TEXT, "hi,来自StreetComplete App的分享");
		startActivity(Intent.createChooser(intent, "分享到"));
	}


	protected void setupViewComponent(){
		this.myListView = (ListView) findViewById(R.id.RecordsList);
		final RecordAdapter adapter = new RecordAdapter(SampleActivity.this, mlist);
		myListView.setAdapter(adapter);
		//ListView item 中的删除按钮的点击事件
		adapter.setOnItemDeleteClickListener(new RecordAdapter.onItemDeleteListener() {
			@Override
			public void onDeleteClick(int i) {
				mlist.remove(i);
				Toast.makeText(SampleActivity.this,"删除成功",Toast.LENGTH_SHORT).show();
				outPutToTxt();//更新本地数据文件
				adapter.notifyDataSetChanged();
			}
		});
	}

	public void init_to(){
		mlist.clear();
		for(int i=0;i<8;i++){
			mlist.add(i+" record_item");
		}
		outPutToTxt();
	}

	public void delete(int i){
		mlist.remove(i);
	}
	protected void init(){
		mlist.clear();
		FileInputStream in1=null;
		BufferedReader reader1=null;
		try{
			in1=openFileInput("RECORDS");
			reader1=new BufferedReader(new InputStreamReader(in1));
			String line="";
			while((line=reader1.readLine())!=null)
				mlist.add(line);
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			try{
				if(reader1!=null)
					reader1.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}

	protected void outPutToTxt(){
		FileOutputStream out=null;
		BufferedWriter writer=null;
		try{
			out=openFileOutput("RECORDS", Context.MODE_PRIVATE);
			writer=new BufferedWriter(new OutputStreamWriter(out));
			for(int i=0;i<mlist.size();i++)
				writer.write(mlist.get(i)+'\n');
		}catch(IOException e){
			e.printStackTrace();
		} finally {
			try{
				if(writer!=null)
					writer.close();
			}catch (IOException e){
				e.printStackTrace();
			}
		}
	}
}

