package tracknspot.com.kethusystemround.ui;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import tracknspot.com.kethusystemround.R;
import tracknspot.com.kethusystemround.adapters.MyTopicAdapter;
import tracknspot.com.kethusystemround.models.ChapterTopic;
import tracknspot.com.kethusystemround.observer.Observer;

public class TopicActivity extends AppCompatActivity implements Observer {
    Observer mListener;
    RecyclerView mRecyclerView;
    RelativeLayout mainLayout;
    ArrayList<ChapterTopic> mChapters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);

        mRecyclerView = findViewById(R.id.recylerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainLayout = findViewById(R.id.main);
        mListener = this;
        int pos = getIntent().getIntExtra("pos", 0);
        mChapters = ChaptersActivity.mSubjectChapters.get(pos).getChapterTopic();
        setDataToRecylerView();
    }

    private void setDataToRecylerView() {

        MyTopicAdapter mySubjectRecylerViewAdapter = new MyTopicAdapter(TopicActivity.this, mChapters, mListener);
        mRecyclerView.setAdapter(mySubjectRecylerViewAdapter);
    }

    @Override
    public void onItemClick(int position) {

        Snackbar snackbar1 = Snackbar.make(mainLayout, "Chapter Topic Id" + mChapters.get(position).getChaptertopicid(), Snackbar.LENGTH_SHORT);
        snackbar1.show();
    }
}
