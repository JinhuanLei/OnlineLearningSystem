package com.example.administrator.testui7.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.testui7.Bean.Comment;
import com.example.administrator.testui7.Bean.Video;
import com.example.administrator.testui7.R;

import java.util.List;

/**
 * Created by Administrator on 2017/4/12 0012.
 */

public class MyRecyclerViewAdapterForComment extends RecyclerView.Adapter<MyViewHolderForComment>implements View.OnClickListener  {
    private List<Comment> datas;
    private Context context;
    private List<Integer> lists;
    private LayoutInflater inflater;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;
    //define interface
    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, String data);
    }
    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
    public MyRecyclerViewAdapterForComment(Context context, List<Comment> datas) {
        this.datas = datas;
        this.context = context;
        inflater=LayoutInflater. from(context);
    }
    public void add(Comment ct, int position) {
        datas.add(position,ct);
        notifyItemInserted(position);
    }


    @Override
    public MyViewHolderForComment onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_comment, parent, false);
        MyViewHolderForComment viewHolder = new MyViewHolderForComment(view);
        view.setOnClickListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolderForComment holder, int position) {
       Comment ct=datas.get(position);
        holder.iv_image.setImageResource(R.drawable.user1);
        holder.tv_title.setText("评论："+ct.getCommentInfer());
       holder.tv_user.setText("用户ID："+ct.getUserid());
        System.out.println("..................."+ct.getCreatedAt()+ct.getCreatedAt()==null);
        if(ct.getCreatedAt()==null){
            holder.tv_date.setText("评论时间：刚刚");
        }else{
            holder.tv_date.setText("评论时间："+ct.getCreatedAt());
        }
       // holder.tv_date.setText("评论日期："+ct.getCreatedAt());
    }

//    @Override
//    public void onBindViewHolder(MyViewHolder holder, int position) {
//        // ViewGroup.LayoutParams params = holder.itemView.getLayoutParams();
//        // params.height = lists.get(position);//把随机的高度赋予item布局
//        //holder.itemView.setLayoutParams(params);
//        Video vi = datas.get(position);
//        holder.iv_image.setImageResource(R.drawable.book);
//        holder.tv_title.setText( vi.getVideoName());
//        holder.tv_price.setText( "￥" + vi.getPrice());
//        holder.tv_author.setText( "作者:" + vi.getAuther());
//
//        holder.tv_date.setText("上传时间："+vi.getCreatedAt());
//        //holder.tv_num_rating.setText("评分:"+vi.getRating());
//        holder.tv_num_rating.setText("评分:"+vi.getRating());
//        holder.itemView.setTag(vi.getObjectId());
//    }

    @Override
    public int getItemCount() {
        return datas.size();
    }


    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            mOnItemClickListener.onItemClick(v,(String)v.getTag());

        }
    }
}
class MyViewHolderForComment extends RecyclerView.ViewHolder
{
    CardView cv;
    ImageView iv_image;
    TextView tv_title;
    TextView tv_user;
    TextView tv_date;

    public MyViewHolderForComment(View arg){
        super(arg);

        cv = (CardView) arg.findViewById(R.id.commentpage_cv);

        iv_image= (ImageView) itemView.findViewById(R.id.iv_image);
        tv_title = (TextView) itemView.findViewById(R.id.tv_title);
        tv_user=(TextView) itemView.findViewById(R.id.tv_user);
        tv_date=(TextView) itemView.findViewById(R.id.tv_date);
    }
}



