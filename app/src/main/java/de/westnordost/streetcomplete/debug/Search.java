package de.westnordost.streetcomplete.debug;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.LinkedList;
import java.util.List;

import android.view.View;
import android.widget.*;

import de.westnordost.streetcomplete.R;

public class Search extends SampleActivity {

	private Button btn1;
	protected List<String> reslist=new LinkedList<>();
	private EditText editText;
	private ListView SearchListView= null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		editText=(EditText)findViewById(R.id.editText);
	}

	private void initView() {
		btn1=(Button) findViewById(R.id.search_button);
	}

	//方法：控件View的点击事件
	public void onClick(View v) {

		switch (v.getId()) {
			case R.id.search_button:
				SearchItem();
				if(reslist.size()>0)
					Toast.makeText(Search.this, "搜索成功", Toast.LENGTH_SHORT).show();
				else
					Toast.makeText(Search.this, "搜索为空", Toast.LENGTH_SHORT).show();
				break;
			default:
				break;
		}
	}
	private void SearchItem(){
		init();
		reslist.clear();
		String res=editText.getText().toString();
		for(int i=0;i<mlist.size();i++){
			if(mlist.get(i).contains(res))
				reslist.add(mlist.get(i));
		}
		this.SearchListView = (ListView) findViewById(R.id.RecordsList);
		final SearchRecordAdapter adapter = new SearchRecordAdapter(Search.this, reslist);
		SearchListView.setAdapter(adapter);
	}

	public String SearchItem(String temp){

		for(int i=0;i<8;i++){
			reslist.add(i+" record_item");
		}
		for(int i=0;i<reslist.size();i++){
			if(reslist.get(i).contains(temp))
				return reslist.get(i);
		}
		return null;
	}

	public String FindItem(int k){

		for(int i=0;i<8;i++){
			reslist.add(i+" record_item");
		}
		if(k<reslist.size())
			return reslist.get(k);
		return null;
	}

	public int add(int x,int y){
		return x+y;
	}
}
