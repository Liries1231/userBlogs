package user.blog;

import java.util.Date;

public class Blog {
    private String text;
    private Date date;

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Blog() {
    }

    @Override
    public String toString() {
        return "Blog{" +
                "text='" + text + '\'' +
                ", date=" + date +
                '}';
    }
}
