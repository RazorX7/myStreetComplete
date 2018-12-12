package de.westnordost.streetcomplete.debug;

import java.util.*;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import de.westnordost.streetcomplete.R;


public class RecordAdapter extends BaseAdapter {
	private Context mContext;
	private List<String> mList = new ArrayList<>();
	public RecordAdapter(Context context, List<String> list) {
		mContext = context;
		mList = list;
	}

	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public Object getItem(int i) {
		return mList.get(i);
	}

	@Override
	public long getItemId(int i) {
		return i;
	}

	@Override
	public View getView(final int i, View view, ViewGroup viewGroup) {
		ViewHolder viewHolder = null;
		if (view == null) {
			viewHolder = new ViewHolder();
			view = LayoutInflater.from(mContext).inflate(R.layout.activity_recorditem, null);
			viewHolder.mTextView = (TextView) view.findViewById(R.id.textView4);
			viewHolder.bt1 = (Button) view.findViewById(R.id.button2);
			view.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) view.getTag();
		}
		viewHolder.mTextView.setText(mList.get(i));
		viewHolder.bt1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mOnItemDeleteListener.onDeleteClick(i);
			}
		});
		return view;
	}

	/**
	 * 删除按钮的监听接口
	 */
	public interface onItemDeleteListener {
		void onDeleteClick(int i);
	}
	private onItemDeleteListener mOnItemDeleteListener;

	public void setOnItemDeleteClickListener(onItemDeleteListener mOnItemDeleteListener) {
		this.mOnItemDeleteListener = mOnItemDeleteListener;
	}
	class ViewHolder {
		TextView mTextView;
		Button bt1;
	}

}
