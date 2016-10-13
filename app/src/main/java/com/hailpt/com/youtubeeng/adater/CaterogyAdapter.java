package com.hailpt.com.youtubeeng.adater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hailpt.com.youtubeeng.R;
import com.hailpt.com.youtubeeng.model.Caterogy;

import java.util.List;


public class CaterogyAdapter extends RecyclerView.Adapter<CaterogyAdapter.MyViewHolder> {

    private Context mContext;
    private List<Caterogy> caterogyList;
    private OnRemoveCallBack mOnRemoveCallBack;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public ImageView thumbnail, imvRemove;
        public LinearLayout lnItemLike;

        public MyViewHolder(View view) {
            super(view);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            count=(TextView)view.findViewById(R.id.count);
            title = (TextView)view.findViewById(R.id.title);
            thumbnail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnRemoveCallBack.onItemClick(getLayoutPosition());
                }
            });
        }

    }


    public CaterogyAdapter(Context mContext, List<Caterogy> albumList, OnRemoveCallBack pOnRemoveCallBack) {
        this.mContext = mContext;
        this.caterogyList = albumList;
        mOnRemoveCallBack = pOnRemoveCallBack;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_like_content, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Caterogy caterogy = caterogyList.get(position);
        holder.title.setText(caterogy.getItemCount()+" Videos");

        if(caterogy.getId().equals("PL7YqrWXed1abuC9zxSYx3OI4GklZM4zrl")){
//            Glide.with(mContext).load("https://i.ytimg.com/vi/IJRcpQBLFmI/sddefault.jpg").override(200, 200).centerCrop().into(holder.thumbnail);
            holder.count.setText("VLISH");
        } else if(caterogy.getId().equals("PL7YqrWXed1abz3FwdKMZEwclWMZ2cMHio")){
//            Glide.with(mContext).load("https://i.ytimg.com/vi/Qejo8-epylk/sddefault.jpg").override(200, 200).centerCrop().into(holder.thumbnail);
            holder.count.setText("42 Ngày Phát Âm");
        } else if(caterogy.getId().equals("PL7YqrWXed1aaKMuLMJSnD3KJ3sWN99MjW")){
//            Glide.with(mContext).load("https://i.ytimg.com/vi/g5lL32-NoTI/sddefault.jpg").override(200, 200).centerCrop().into(holder.thumbnail);
            holder.count.setText("Luyện Nghe Tiếng Anh");
        }else if(caterogy.getId().equals("PL7YqrWXed1aaAoGva5zyyWBz0Hg-bWlEJ")){
//            Glide.with(mContext).load("https://i.ytimg.com/vi/1RDs-ivyXlA/sddefault.jpg").override(200, 200).centerCrop().into(holder.thumbnail);
            holder.count.setText("Chỉnh Lỗi Chính Tả");
        } else if(caterogy.getId().equals("PL7YqrWXed1abWxt9d4IH2f1FGKylciC7P")){
//            Glide.with(mContext).load("https://i.ytimg.com/vi/trrPPPjxe-4/sddefault.jpg").override(200, 200).centerCrop().into(holder.thumbnail);
            holder.count.setText("Luyện Phát Âm");
        }else if(caterogy.getId().equals("PL7YqrWXed1abaMsLal55KiDvlavvR-Why")){
//            Glide.with(mContext).load("https://i.ytimg.com/vi/MpHQ0At8JCw/sddefault.jpg").override(200, 200).centerCrop().into(holder.thumbnail);
            holder.count.setText("Từ Vựng Và Ngữ Pháp");
        } else if(caterogy.getId().equals("PL7YqrWXed1aZZWbmMDXx0m-ugJdylZ8rf")){
//            Glide.with(mContext).load("https://i.ytimg.com/vi/DFPD0ZTSpP8/sddefault.jpg").override(200, 200).centerCrop().into(holder.thumbnail);
            holder.count.setText("Những Clip Hay Nhất");
        } else if(caterogy.getId().equals("PL7YqrWXed1aaFMn8Rakj0OQb0_dkw71hs")){
//            Glide.with(mContext).load("https://i.ytimg.com/vi/Cq8uxQbjb_w/sddefault.jpg").override(200, 200).centerCrop().into(holder.thumbnail);
            holder.count.setText("-----");
        }

        // loading album cover using Glide library

//            Glide.with(mContext).load(Youtube.getYoutubeThumbnailUrlFromVideoUrl(content.getVideoUrl())).override(200, 200).centerCrop().into(holder.thumbnail);

    }


    @Override
    public int getItemCount() {
        return caterogyList.size();
    }

    public interface OnRemoveCallBack {
        public void remove(int pos);
        public void onItemClick(int pos);
    }
}
