package ua.com.alevel.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Request {
    private String ip;
    private String userAgent;
    private Date created;
}
