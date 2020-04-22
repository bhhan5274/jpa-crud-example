package io.github.bhhan.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by hbh5274@gmail.com on 2020-04-22
 * Github : http://github.com/bhhan5274
 */

@Entity
@Table(name = "OPTIONS")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OPTION_ID")
    private Long id;

    private String name;
    private int amount;

    @Builder
    public Option(Long id, String name, int amount){
        this.id = id;
        this.name = name;
        this.amount = amount;
    }
}
