package co.uk.prash.ctm.registration;

/**
 * Created by prasanth on 19/10/2014.
 */
public class Talk {

    private String topic;
    private int duration;

    public Talk(String topic, int duration) {
        this.topic = topic;
        this.duration = duration;
    }

    public String getTopic() {
        return topic;
    }

    public int getDuration() {
        return duration;
    }
}
