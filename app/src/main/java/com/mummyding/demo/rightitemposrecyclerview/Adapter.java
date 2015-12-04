package com.mummyding.demo.rightitemposrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by mummyding on 15-12-4.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.VH> {

    private int mSize = 0;
    private Context mContext;

    public Adapter(Context context,int size) {
        mSize = size;
        mContext = context;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext,R.layout.item,null);
        VH vh = new VH(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(final VH holder, final int position) {
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.image.setImageDrawable(mContext.getResources().getDrawable(R.drawable.icon_two));
                Toast.makeText(mContext,"position: "+position,Toast.LENGTH_SHORT).show();
            }
        });
        holder.image.setImageDrawable(mContext.getResources().getDrawable(R.drawable.icon_one));
    }

    @Override
    public int getItemCount() {
        return mSize;
    }

    protected class VH extends RecyclerView.ViewHolder{
        private ImageView image;
        public VH(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
