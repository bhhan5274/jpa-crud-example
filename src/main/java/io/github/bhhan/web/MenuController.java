package io.github.bhhan.web;

import io.github.bhhan.domain.Menu;
import io.github.bhhan.service.MenuDto;
import io.github.bhhan.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by hbh5274@gmail.com on 2020-04-22
 * Github : http://github.com/bhhan5274
 */

@RestController
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @PostMapping("/menu")
    @ResponseStatus(HttpStatus.CREATED)
    public Menu addMenu(@RequestBody @Valid MenuDto.MenuFormReq menuFormReq){
        return menuService.addMenu(menuFormReq);
    }

    @DeleteMapping("/menu")
    @ResponseStatus(HttpStatus.OK)
    public boolean deleteMenu(@RequestBody @Valid MenuDto.MenuReq menuReq){
        return menuService.deleteMenu(menuReq);
    }

    @GetMapping("/menu/{menuId}")
    @ResponseStatus(HttpStatus.OK)
    public MenuDto.MenuRes selectMenuById(@PathVariable("menuId") Long menuId){
        return menuService.selectMenuById(menuId);
    }

    @PutMapping("/menu")
    @ResponseStatus(HttpStatus.OK)
    public MenuDto.MenuRes updateMenu(@RequestBody @Valid MenuDto.MenuUpdateReq menuUpdateReq){
        return menuService.updateMenu(menuUpdateReq);
    }
}
