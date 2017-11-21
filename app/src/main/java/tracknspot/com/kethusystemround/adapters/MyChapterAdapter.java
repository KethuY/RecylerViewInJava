package tracknspot.com.kethusystemround.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import tracknspot.com.kethusystemround.R;
import tracknspot.com.kethusystemround.models.SubjectChapters;
import tracknspot.com.kethusystemround.observer.Observer;

/**
 * Created by sriram on 21/11/17.
 */

public class MyChapterAdapter extends RecyclerView.Adapter<MyChapterAdapter.ViewHolder> {

    Context mContext;
    ArrayList<SubjectChapters> mSubjectChapters;
    Observer mistener;

    public MyChapterAdapter(Context context, ArrayList<SubjectChapters> subjects, Observer liObserver) {
        mContext = context;
        mSubjectChapters = subjects;
        mistener = liObserver;
    }


    @Override
    public MyChapterAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.chapter_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyChapterAdapter.ViewHolder holder, final int position) {

        String name=mSubjectChapters.get(position).getChapterName();
        holder.mTextView.setText(mSubjectChapters.get(position).getChapterName());

        holder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mistener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mSubjectChapters.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;


        public ViewHolder(View itemView) {
            super(itemView);
            mTextView=itemView.findViewById(R.id.chapterName);
        }
    }
}
