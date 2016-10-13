package com.hailpt.com.youtubeeng.adater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hailpt.com.youtubeeng.R;
import com.hailpt.com.youtubeeng.model.Youtube;

import java.util.List;

/**
 * Created by hailpt on 22/07/2016.
 */
public class VlogListAdapter extends RecyclerView.Adapter<VlogListAdapter.MyViewHolder> {

    private List<Youtube> youtubeList;
    private OnRemoveCallBack mOnRemoveCallBack;
    private Context mContext;

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView title;
        private ImageView imvAva;
        private RelativeLayout rlMain;

        private MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            imvAva = (ImageView) view.findViewById(R.id.thumbnail);
            rlMain = (RelativeLayout)view.findViewById(R.id.rl_main);
            rlMain.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.rl_main:
                    mOnRemoveCallBack.onItemClick(getLayoutPosition());
                    break;
            }
        }
    }

    public VlogListAdapter(Context pContext, List<Youtube> pYoutubeList, OnRemoveCallBack pOnRemoveCallBack) {
        youtubeList = pYoutubeList;
        mOnRemoveCallBack = pOnRemoveCallBack;
        mContext = pContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_vlog_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Youtube youtube = youtubeList.get(position);
        holder.title.setText(youtube.getTitle());
        Glide.with(mContext).load(youtube.getThumbnail()).override(200, 200).centerCrop().into(holder.imvAva);
    }

    @Override
    public int getItemCount() {
        return youtubeList.size();
    }

    public interface OnRemoveCallBack {
        public void remove(int pos);

        public void onItemClick(int pos);
    }
}
