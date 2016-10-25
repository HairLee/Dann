package haipham.com.danhauer.adater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import haipham.com.danhauer.R;
import haipham.com.danhauer.model.Caterogy;


public class CaterogyAdapter extends RecyclerView.Adapter<CaterogyAdapter.MyViewHolder> {

    private Context mContext;
    private List<Caterogy> caterogyList;
    private OnRemoveCallBack mOnRemoveCallBack;

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
        holder.title.setText(caterogy.getItemCount() + " Videos");
        holder.tvStt.setText((position+1)+"");


//        String caterogyId = caterogy.getId();
//
//        if (caterogyId.equals("PL7YqrWXed1abuC9zxSYx3OI4GklZM4zrl")) {
//            Glide.with(mContext)
//                    .load(Uri.parse("file:///android_asset/vlish.png"))
//                    .into(holder.thumbnail);
//            holder.count.setText("VLISH");
//        } else if (caterogy.equals("PL7YqrWXed1aZZWbmMDXx0m-ugJdylZ8rf")) {
//            Glide.with(mContext)
//                    .load(Uri.parse("file:///android_asset/fuck.png"))
//                    .into(holder.thumbnail);
//            holder.count.setText("Những Clip Hay Nhất");
//        } else if (caterogyId.equals("PL7YqrWXed1abaMsLal55KiDvlavvR-Why")) {
//            Glide.with(mContext)
//                    .load(Uri.parse("file:///android_asset/go_back.png"))
//                    .into(holder.thumbnail);
//            holder.count.setText("Từ Vựng Và Ngữ Pháp");
//        } else if (caterogy.equals("PL7YqrWXed1abz3FwdKMZEwclWMZ2cMHio")) {
//            Glide.with(mContext)
//                    .load(Uri.parse("file:///android_asset/fourty.png"))
//                    .into(holder.thumbnail);
//            holder.count.setText("42 Ngày Phát Âm");
//        } else if (caterogyId.equals("PL7YqrWXed1abWxt9d4IH2f1FGKylciC7P")) {
//            Glide.with(mContext)
//                    .load(Uri.parse("file:///android_asset/british_american.png"))
//                    .into(holder.thumbnail);
//            holder.count.setText("Luyện Phát Âm");
//        } else if (caterogy.equals("PL7YqrWXed1aaKMuLMJSnD3KJ3sWN99MjW")) {
//            Glide.with(mContext)
//                    .load(Uri.parse("file:///android_asset/beer.png"))
//                    .into(holder.thumbnail);
//            holder.count.setText("Luyện Nghe Tiếng Anh");
//        } else if (caterogyId.equals("PL7YqrWXed1aaAoGva5zyyWBz0Hg-bWlEJ")) {
//            Glide.with(mContext)
//                    .load(Uri.parse("file:///android_asset/stress.png"))
//                    .into(holder.thumbnail);
//            holder.count.setText("Chỉnh Lỗi Chính Tả");
//        }
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
