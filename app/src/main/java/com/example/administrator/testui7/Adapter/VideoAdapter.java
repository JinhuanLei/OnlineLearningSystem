package com.example.administrator.testui7.Adapter;

import android.content.Context;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.testui7.Bean.Video;
import com.example.administrator.testui7.R;
import com.example.administrator.testui7.base.OkHttpClientManager;


import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static android.R.attr.bitmap;

/**
 * Created by Administrator on 2017/4/12.
 */

public class VideoAdapter extends RecyclerView.Adapter<MyViewHolder>{

    private LayoutInflater mInflater;
    private Context mContext;
    private List<Video> mdatas;

    ImageView imView;
    public interface OnItemClickListener
    {
        void OnItemClik(View view,int position);
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mOnItemClickListener = listener;
    }

    public VideoAdapter(Context context, List<Video> datas){
        this.mContext=context;
        this.mdatas = datas;
        mInflater =LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_video,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Video vi = mdatas.get(position);
        OkHttpClientManager.displayImage(holder.iv_image, vi.getVideoImg().getFileUrl());
       // holder.iv_image.setImageBitmap();
        holder.tv_title.setText( vi.getVideoName());
        holder.tv_price.setText( "￥" + vi.getPrice());
        holder.tv_author.setText( "作者:" + vi.getAuther());
        holder.tv_date.setText("上传时间："+vi.getCreatedAt());
        holder.tv_num_rating.setText("评分:"+vi.getRating());
        holder.tv_viewer.setText("播放量：20");
        holder.itemView.setTag(vi.getObjectId());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnItemClickListener!=null){
                    mOnItemClickListener.OnItemClik(holder.itemView,position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mdatas.size();
    }

}

class MyViewHolder extends ViewHolder
{
    CardView cv;
    ImageView iv_image;
    TextView tv_title;
    TextView tv_price;
    TextView tv_author;
    TextView tv_date;
    TextView tv_num_rating;
    TextView tv_viewer;
    public MyViewHolder(View arg){
        super(arg);

        cv = (CardView) arg.findViewById(R.id.id_cv);

        iv_image= (ImageView) itemView.findViewById(R.id.iv_image);
        tv_title = (TextView) itemView.findViewById(R.id.tv_title);
        tv_price = (TextView) itemView.findViewById(R.id.tv_price);
        tv_author = (TextView) itemView.findViewById(R.id.tv_author);
        tv_num_rating = (TextView) itemView.findViewById(R.id.tv_num_rating);
        tv_date=(TextView) itemView.findViewById(R.id.tv_date);
        tv_viewer=(TextView) itemView.findViewById(R.id.tv_viewer);
    }
}
