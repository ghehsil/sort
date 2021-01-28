package two.test;

import java.io.Serializable;

/**
 * @author zhuangyq
 * @create 2018-03-02 上午 10:27
 **/
public class LiveVideoResponseTO implements Serializable {
    private static final long serialVersionUID = 8157072367278737184L;

    //直播状态
    private String status;

    //直播id
    private String liveId;

    //流信息
    private String flv;

    //流信息
    private String hls;

    //直播地址
    private String viewUrl;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLiveId() {
        return liveId;
    }

    public void setLiveId(String liveId) {
        this.liveId = liveId;
    }

    public String getFlv() {
        return flv;
    }

    public void setFlv(String flv) {
        this.flv = flv;
    }

    public String getHls() {
        return hls;
    }

    public void setHls(String hls) {
        this.hls = hls;
    }

    public String getViewUrl() {
        return viewUrl;
    }

    public void setViewUrl(String viewUrl) {
        this.viewUrl = viewUrl;
    }
}
