package two.test;

import java.io.Serializable;

/**
 * @author zhuangyq
 * @create 2018-03-02 上午 9:40
 **/
public class MeetingResponseTO implements Serializable {

    private static final long serialVersionUID = -7531003856661795028L;

    //会议号
    private String meetingNumber;

    //分享链接
    private String shareUrl;

    private String status;

    public String getMeetingNumber() {
        return meetingNumber;
    }

    public void setMeetingNumber(String meetingNumber) {
        this.meetingNumber = meetingNumber;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
