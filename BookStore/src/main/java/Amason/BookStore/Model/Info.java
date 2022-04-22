package Amason.BookStore.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Info {
    @Id
    @Column
    public int Info_id;
    @Column
    public String Info_name;
    @Column
    public String Info_author;
    @Column
    public int price;

    public int getInfo_id() {
        return Info_id;
    }

    public void setInfo_id(int info_id) {
        Info_id = info_id;
    }

    public String getInfo_name() {
        return Info_name;
    }

    public void setInfo_name(String info_name) {
        Info_name = info_name;
    }

    public String getInfo_author() {
        return Info_author;
    }

    public void setInfo_author(String info_author) {
        Info_author = info_author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
