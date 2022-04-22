package Amason.BookStore.Controllers;

import Amason.BookStore.Services.InfoService;
import Amason.BookStore.Model.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InfoControllers {

    @Autowired
    InfoService infoService;

    @GetMapping("/info")
    private List<Info> getAllInfo(){
      return infoService.getAllInfo();
    }

    @GetMapping("/info/{info_id}")
    private Info getInfoById(@PathVariable("info_id") int info){
        return infoService.getInfoById(info);
    }

    @PostMapping("/info")
    private int saveInfo(@RequestBody Info info){
        infoService.saveOrUpdate(info);
        return info.getInfo_id();
    }

    @PutMapping("/info")
    private Info update(@RequestBody Info info){
        infoService.saveOrUpdate(info);
        return info;
    }

    @DeleteMapping("/info/{info_id}")
    private void delete(@PathVariable("info_id") int info){
        infoService.deleteById(info);
    }
}
