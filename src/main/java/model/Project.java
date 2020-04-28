package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ToString
public class Project {
    private Long id;

    private String principalName;

    private String pPhonenumber;

    private String pAddress;

    @DateTimeFormat(pattern ="yyyy-MM-dd")
    @JsonFormat(pattern ="yyyy-MM-dd")
    private Date pAvailabletime;

    @DateTimeFormat(pattern ="yyyy-MM-dd")
    @JsonFormat(pattern ="yyyy-MM-dd")
    private Date pAddtime;

    private String pName;

    private Integer pType;

    private Integer pWages;

    private String missionImg;

    private String principalImg;

    private String pDesc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }

    public String getpPhonenumber() {
        return pPhonenumber;
    }

    public void setpPhonenumber(String pPhonenumber) {
        this.pPhonenumber = pPhonenumber;
    }

    public String getpAddress() {
        return pAddress;
    }

    public void setpAddress(String pAddress) {
        this.pAddress = pAddress;
    }

    public Date getpAvailabletime() {
        return pAvailabletime;
    }

    public void setpAvailabletime(Date pAvailabletime) {
        this.pAvailabletime = pAvailabletime;
    }

    public Date getpAddtime() {
        return pAddtime;
    }

    public void setpAddtime(Date pAddtime) {
        this.pAddtime = pAddtime;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Integer getpType() {
        return pType;
    }

    public void setpType(Integer pType) {
        this.pType = pType;
    }

    public Integer getpWages() {
        return pWages;
    }

    public void setpWages(Integer pWages) {
        this.pWages = pWages;
    }

    public String getMissionImg() {
        return missionImg;
    }

    public void setMissionImg(String missionImg) {
        this.missionImg = missionImg;
    }

    public String getPrincipalImg() {
        return principalImg;
    }

    public void setPrincipalImg(String principalImg) {
        this.principalImg = principalImg;
    }

    public String getpDesc() {
        return pDesc;
    }

    public void setpDesc(String pDesc) {
        this.pDesc = pDesc;
    }
}