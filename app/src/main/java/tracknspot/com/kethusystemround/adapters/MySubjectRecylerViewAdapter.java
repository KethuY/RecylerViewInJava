package tracknspot.com.kethusystemround.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import tracknspot.com.kethusystemround.R;
import tracknspot.com.kethusystemround.models.Subjects;
import tracknspot.com.kethusystemround.observer.Observer;

/**
 * Created by sriram on 21/11/17.
 */

public class MySubjectRecylerViewAdapter extends RecyclerView.Adapter<MySubjectRecylerViewAdapter.ViewHolder> {

    Context mContext;
    ArrayList<Subjects> mSubjects;
    Observer mistener;
    public MySubjectRecylerViewAdapter(Context context, ArrayList<Subjects> subjects, Observer liObserver){
        mContext=context;
        mSubjects=subjects;
        mistener=liObserver;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(mContext).inflate(R.layout.subject_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mSubjectName.setText(mSubjects.get(position).getSubjectName());
        holder.mSubjectName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mistener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mSubjects.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView mSubjectName;
        public ViewHolder(View itemView) {
            super(itemView);
            mSubjectName=itemView.findViewById(R.id.subjectName);
        }
    }
}
