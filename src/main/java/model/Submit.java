package model;

import lombok.ToString;

@ToString
public class Submit {
    private String openid;

    private Integer pId;

    private String remarks;

    private String missionimgs;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getMissionimgs() {
        return missionimgs;
    }

    public void setMissionimgs(String missionimgs) {
        this.missionimgs = missionimgs;
    }
}