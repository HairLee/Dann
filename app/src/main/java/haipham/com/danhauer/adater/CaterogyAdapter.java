package haipham.com.danhauer.adater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import haipham.com.danhauer.R;
import haipham.com.danhauer.model.Caterogy;


public class CaterogyAdapter extends RecyclerView.Adapter<CaterogyAdapter.MyViewHolder> {

    private Context mContext;
    private List<Caterogy> caterogyList;
    private OnRemoveCallBack mOnRemoveCallBack;
    private String mLink;
    private String mName;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count,tvStt;
        public ImageView thumbnail, imvRemove;
        public LinearLayout lnItemLike;

        public MyViewHolder(View view) {
            super(view);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            count = (TextView) view.findViewById(R.id.count);
            title = (TextView) view.findViewById(R.id.title);
            tvStt = (TextView)view.findViewById(R.id.txt_stt);
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

        holder.tvStt.setText((position+1)+"");

        Log.d("hailpt","POS ++ +++ ++++ === "+position);

        switch (position) {
            case 0:
                // Luyen Nghe Tieng Anh
                mLink =  "https://i.ytimg.com/vi/gb5HmcdIHb8/hqdefault.jpg";
                mName = "Luyen Nghe Tieng Anh";
                break;
            case 1:
                // Chinh loi tieng Anh
                mLink =  "https://i.ytimg.com/vi/AZ9bKjH6tcQ/hqdefault.jpg";
                mName ="Chinh Loi Tieng Anh";
                break;
            case 2:
                // Tu vung va Ngu phap
                mLink =  "https://i.ytimg.com/vi/B3jxIZO9Rys/hqdefault.jpg";
                mName ="Tu Vung Va Ngu Phap";
                break;

            case 3:
                // Tieng Anh ngo
                mLink =  "https://i.ytimg.com/vi/SRsSUH2ogsc/hqdefault.jpg";
                mName ="Tieng Anh ngo";
                break;
            case 4:
                // VLish
                mLink =  "https://i.ytimg.com/vi/IJRcpQBLFmI/hqdefault.jpg";
                mName ="VLish";
                break;
            case 5:
                // Nhung clip hay nhat
                mLink =  "https://i.ytimg.com/vi/DFPD0ZTSpP8/hqdefault.jpg";
                mName ="Nhung Clip Hay Nhat";
                break;
            case 6:
                // Luyen phat am
                mLink =  "https://i.ytimg.com/vi/g5lL32-NoTI/hqdefault.jpg";
                mName ="Luyen Phat Am";
                break;
            case 7:
                // 42 ngay phat am
                mLink =  "https://i.ytimg.com/vi/Qejo8-epylk/hqdefault.jpg";
                mName ="42 Ngay Phat Am";
                break;
        }


        Glide.with(mContext).load(mLink).centerCrop().into(holder.thumbnail);
        holder.title.setText(mName);
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
