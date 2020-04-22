package io.github.bhhan.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hbh5274@gmail.com on 2020-04-22
 * Github : http://github.com/bhhan5274
 */

@Entity
@Table(name = "OPTION_GROUPS")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class OptionGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OPTION_GROUP_ID")
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "OPTION_GROUP_ID")
    private List<Option> options = new ArrayList<>();

    private String name;

    @Builder
    public OptionGroup(Long id, String name, List<Option> options){
        this.id = id;
        this.name = name;
        this.options.addAll(options);
    }
}
