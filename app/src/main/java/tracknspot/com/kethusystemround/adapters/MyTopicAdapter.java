package tracknspot.com.kethusystemround.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import tracknspot.com.kethusystemround.R;
import tracknspot.com.kethusystemround.models.ChapterTopic;
import tracknspot.com.kethusystemround.observer.Observer;

/**
 * Created by sriram on 21/11/17.
 */

public class MyTopicAdapter extends RecyclerView.Adapter<MyTopicAdapter.ViewHolder> {


    Context mContext;
    ArrayList<ChapterTopic> mTopics;
    Observer mistener;

    public MyTopicAdapter(Context context, ArrayList<ChapterTopic> subjects, Observer liObserver) {
        mContext = context;
        mTopics = subjects;
        mistener = liObserver;
    }

    @Override
    public MyTopicAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.topic_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mTextView.setText(mTopics.get(position).getTopicName());
        holder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mistener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTopics.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;


        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.topic);
        }
    }
}
