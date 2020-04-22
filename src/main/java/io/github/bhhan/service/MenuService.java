package io.github.bhhan.service;

import io.github.bhhan.domain.Menu;
import io.github.bhhan.domain.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hbh5274@gmail.com on 2020-04-22
 * Github : http://github.com/bhhan5274
 */

@Service
@RequiredArgsConstructor
@Transactional
public class MenuService {

    private final MenuRepository menuRepository;

    public Menu addMenu(MenuDto.MenuFormReq menuFormReq){
        return menuRepository.save(menuFormReq.toEntity());
    }

    public boolean deleteMenu(MenuDto.MenuReq menuReq){
        return menuRepository.deleteByIdAndName(menuReq.getId(), menuReq.getName()) >= 1;
    }

    public MenuDto.MenuRes selectMenuById(Long menuId){
        return new MenuDto.MenuRes(menuRepository.findById(menuId).orElseThrow(IllegalArgumentException::new));
    }

    public MenuDto.MenuRes updateMenu(MenuDto.MenuUpdateReq menuUpdateReq){
        return new MenuDto.MenuRes(menuRepository.save(menuUpdateReq.toEntity()));
    }
}
