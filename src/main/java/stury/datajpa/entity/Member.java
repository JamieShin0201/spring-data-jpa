package stury.datajpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Setter
@Getter
@Entity
public class Member {

    @GeneratedValue
    @Id
    private Long id;

    private String username;

    public Member(String username) {
        this.username = username;
    }
}

