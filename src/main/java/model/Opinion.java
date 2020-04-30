package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ToString
public class Opinion {
    private Integer id;

    private String openid;

    @DateTimeFormat(pattern ="yyyy-MM-dd")
    @JsonFormat(pattern ="yyyy-MM-dd")
    private Date date;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}