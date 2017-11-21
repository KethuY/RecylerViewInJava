package tracknspot.com.kethusystemround.models;

import java.util.ArrayList;

/**
 * Created by sriram on 21/11/17.
 */

public class SubjectChapters
{
    private ArrayList<ChapterTopic> ChapterTopic;

    private String ChapterName;

    private String subjectchapterid;

    public ArrayList<tracknspot.com.kethusystemround.models.ChapterTopic> getChapterTopic() {
        return ChapterTopic;
    }

    public void setChapterTopic(ArrayList<tracknspot.com.kethusystemround.models.ChapterTopic> chapterTopic) {
        ChapterTopic = chapterTopic;
    }

    public String getChapterName ()
    {
        return ChapterName;
    }

    public void setChapterName (String ChapterName)
    {
        this.ChapterName = ChapterName;
    }

    public String getSubjectchapterid ()
    {
        return subjectchapterid;
    }

    public void setSubjectchapterid (String subjectchapterid)
    {
        this.subjectchapterid = subjectchapterid;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [ChapterTopic = "+ChapterTopic+", ChapterName = "+ChapterName+", subjectchapterid = "+subjectchapterid+"]";
    }
}
