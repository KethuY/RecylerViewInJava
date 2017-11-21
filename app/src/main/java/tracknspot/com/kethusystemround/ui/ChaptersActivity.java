package tracknspot.com.kethusystemround.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import tracknspot.com.kethusystemround.R;
import tracknspot.com.kethusystemround.adapters.MyChapterAdapter;
import tracknspot.com.kethusystemround.models.SubjectChapters;
import tracknspot.com.kethusystemround.observer.Observer;

public class ChaptersActivity extends AppCompatActivity implements Observer {

    public static ArrayList<SubjectChapters> mSubjectChapters;
    Observer mListener;
    RecyclerView mRecyclerView;
    RelativeLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapters);
        mRecyclerView = findViewById(R.id.recylerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainLayout = findViewById(R.id.main);
        mListener = this;
        int pos = getIntent().getIntExtra("pos", 0);
        mSubjectChapters = MainActivity.mSubjects.get(pos).getSubjectChapters();
        setDataToRecylerView();
    }

    private void setDataToRecylerView() {

        MyChapterAdapter mySubjectRecylerViewAdapter = new MyChapterAdapter(ChaptersActivity.this, mSubjectChapters, mListener);
        mRecyclerView.setAdapter(mySubjectRecylerViewAdapter);
    }


    @Override
    public void onItemClick(int position) {

        startActivity(new Intent(ChaptersActivity.this, TopicActivity.class).putExtra("pos", position));

    }
}
