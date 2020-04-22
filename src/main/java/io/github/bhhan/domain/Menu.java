package io.github.bhhan.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by hbh5274@gmail.com on 2020-04-22
 * Github : http://github.com/bhhan5274
 */

@Entity
@Table(name = "MENUS")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MENU_ID")
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "MENU_ID")
    private List<OptionGroup> optionGroups = new ArrayList<>();

    private String name;

    @Builder
    public Menu(Long id, String name, Collection<OptionGroup> optionGroups){
        this.id = id;
        this.name = name;
        this.optionGroups.addAll(optionGroups);
    }
}
