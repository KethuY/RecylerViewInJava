package tracknspot.com.kethusystemround.ui;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import tracknspot.com.kethusystemround.R;
import tracknspot.com.kethusystemround.adapters.MySubjectRecylerViewAdapter;
import tracknspot.com.kethusystemround.helpers.PermissionChecker;
import tracknspot.com.kethusystemround.models.ChapterTopic;
import tracknspot.com.kethusystemround.models.ReadJsonFile;
import tracknspot.com.kethusystemround.models.SubjectChapters;
import tracknspot.com.kethusystemround.models.Subjects;
import tracknspot.com.kethusystemround.observer.Observer;

public class MainActivity extends AppCompatActivity implements Observer {

    RecyclerView mRecyclerView;
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int READ_WRITE_EXTER_STORAGE = 100;
     public static  ArrayList<Subjects> mSubjects;

    Observer mListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] PERMISSIONS = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};

        if (!PermissionChecker.hasPermissions(this, PERMISSIONS)) {
            ActivityCompat.requestPermissions(this, PERMISSIONS, READ_WRITE_EXTER_STORAGE);
        }
        mListener=this;

        mRecyclerView = findViewById(R.id.recylerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        String jsonData = ReadJsonFile.ReadFile();

        if (jsonData != null) {
            getJsonDataFromString(jsonData);
        }

        setDataToRecylerView();
    }

    private void setDataToRecylerView() {

        MySubjectRecylerViewAdapter mySubjectRecylerViewAdapter=new MySubjectRecylerViewAdapter(MainActivity.this,mSubjects,mListener);
        mRecyclerView.setAdapter(mySubjectRecylerViewAdapter);
    }

    private void getJsonDataFromString(String jsonDataStr) {

        try {
            JSONObject jsonObject = new JSONObject(jsonDataStr);
            mSubjects = new ArrayList<>();

            if (jsonObject.has("Subjects")) {

                if (jsonObject.getJSONArray("Subjects") != null) {

                    JSONArray jsonArray = jsonObject.getJSONArray("Subjects");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        Subjects subjects = new Subjects();
                        JSONObject object = jsonArray.getJSONObject(i);

                        if (object.has("SubjectName") && object.getString("SubjectName") != null) {
                            subjects.setSubjectName(object.getString("SubjectName"));
                        }
                        if (object.has("SubjectChapters") && object.getJSONArray("SubjectChapters") != null && object.getJSONArray("SubjectChapters").length() > 0) {

                            JSONArray jsonArray1 = object.getJSONArray("SubjectChapters");
                            ArrayList<SubjectChapters> subjectChapters = new ArrayList<>();

                            for (int j = 0; j < jsonArray1.length(); j++) {
                                JSONObject jsonObject1 = jsonArray1.getJSONObject(j);
                                SubjectChapters subjectChapters1 = new SubjectChapters();

                                if (jsonObject1.has("ChapterName") && jsonObject1.getString("ChapterName") != null) {
                                    subjectChapters1.setChapterName(jsonObject1.getString("ChapterName"));
                                }

                                if (jsonObject1.has("subjectchapterid") && jsonObject1.getString("subjectchapterid") != null) {
                                    subjectChapters1.setSubjectchapterid(jsonObject1.getString("subjectchapterid"));
                                }

                                if (jsonObject1.has("ChapterTopic") && jsonObject1.getJSONArray("ChapterTopic") != null && jsonObject1.getJSONArray("ChapterTopic").length() > 0) {
                                    {
                                        JSONArray jsonArray2 = jsonObject1.getJSONArray("ChapterTopic");

                                        ArrayList<ChapterTopic> chapterTopics = new ArrayList<>();

                                        for (int k = 0; k < jsonArray2.length(); k++) {
                                            ChapterTopic chapterTopic = new ChapterTopic();

                                            JSONObject jsonObject2 = jsonArray2.getJSONObject(k);

                                            if (jsonObject2.has("TopicName") && jsonObject2.getString("TopicName") != null) {
                                                chapterTopic.setTopicName(jsonObject2.getString("TopicName"));
                                            }
                                            if (jsonObject2.has("chaptertopicid") && jsonObject2.getString("chaptertopicid") != null) {
                                                chapterTopic.setChaptertopicid(jsonObject2.getString("chaptertopicid"));
                                            }

                                            chapterTopics.add(chapterTopic);
                                        }

                                        subjectChapters1.setChapterTopic(chapterTopics);

                                    }
                                }

                                subjectChapters.add(subjectChapters1);
                            }
                            subjects.setSubjectChapters(subjectChapters);
                        }
                        if (object.has("subjectid") && object.getString("subjectid") != null) {
                            subjects.setSubjectid(object.getString("subjectid"));
                        }

                        mSubjects.add(subjects);
                    }
                }
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case READ_WRITE_EXTER_STORAGE: {
                // If request is cancelled, the result arrays are empty.
                if (!(grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    Toast.makeText(MainActivity.this, "Storage permissions denied", Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }

    @Override
    public void onItemClick(int position) {
        startActivity(new Intent(MainActivity.this, ChaptersActivity.class).putExtra("pos",position));
    }
}
