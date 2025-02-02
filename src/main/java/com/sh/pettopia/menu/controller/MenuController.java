package com.sh.pettopia.menu.controller;

import com.sh.pettopia.menu.entity.Menu;
import com.sh.pettopia.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menus")
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;
    private final SqlInitializationProperties sqlInitializationProperties;

    @GetMapping("/{menuCode}")
    public ResponseEntity<?> findByMenuCode(@PathVariable("menuCode") Long menuCode){
        return menuService.findById(menuCode);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Menu>> findByAll(){
        return menuService.findByAll();
    }
}
