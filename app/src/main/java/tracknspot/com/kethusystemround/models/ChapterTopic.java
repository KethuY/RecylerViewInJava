package tracknspot.com.kethusystemround.models;

/**
 * Created by sriram on 21/11/17.
 */

public class ChapterTopic
{
    private String chaptertopicid;

    private String TopicName;

    public String getChaptertopicid ()
    {
        return chaptertopicid;
    }

    public void setChaptertopicid (String chaptertopicid)
    {
        this.chaptertopicid = chaptertopicid;
    }

    public String getTopicName ()
    {
        return TopicName;
    }

    public void setTopicName (String TopicName)
    {
        this.TopicName = TopicName;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [chaptertopicid = "+chaptertopicid+", TopicName = "+TopicName+"]";
    }
}
