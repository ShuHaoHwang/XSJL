package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author ShuHao
 * @version 1.0
 * @date 2020/4/27
 */

@ToString
@Getter
@Setter

public class Opinion {
    private String openid;
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    @JsonFormat(pattern ="yyyy-MM-dd")
    private Date Date;
    private String opinionDetail;
}
