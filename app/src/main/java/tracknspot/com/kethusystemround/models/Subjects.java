package tracknspot.com.kethusystemround.models;

import java.util.ArrayList;

/**
 * Created by sriram on 21/11/17.
 */

public class Subjects
{
    private String SubjectName;

    private ArrayList<SubjectChapters> SubjectChapters;

    private String subjectid;

    public String getSubjectName ()
    {
        return SubjectName;
    }

    public void setSubjectName (String SubjectName)
    {
        this.SubjectName = SubjectName;
    }

    public ArrayList<tracknspot.com.kethusystemround.models.SubjectChapters> getSubjectChapters() {
        return SubjectChapters;
    }

    public void setSubjectChapters(ArrayList<tracknspot.com.kethusystemround.models.SubjectChapters> subjectChapters) {
        SubjectChapters = subjectChapters;
    }

    public String getSubjectid ()
    {
        return subjectid;
    }

    public void setSubjectid (String subjectid)
    {
        this.subjectid = subjectid;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [SubjectName = "+SubjectName+", SubjectChapters = "+SubjectChapters+", subjectid = "+subjectid+"]";
    }
}
