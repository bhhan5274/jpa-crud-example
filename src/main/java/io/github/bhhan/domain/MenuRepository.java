package io.github.bhhan.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hbh5274@gmail.com on 2020-04-22
 * Github : http://github.com/bhhan5274
 */
public interface MenuRepository extends JpaRepository<Menu, Long> {
    Integer deleteByIdAndName(Long id, String name);
}
