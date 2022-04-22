package Amason.BookStore.Services;


import Amason.BookStore.Model.Info;
import Amason.BookStore.Repositories.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InfoService {

     @Autowired
    InfoRepository infoRepository;

    public List<Info> getAllInfo(){

        List<Info> info = new ArrayList<>();
        infoRepository.findAll().forEach(info1 -> info.add(info1));
        return info;
    }


    public Info getInfoById(int info_Id){
       return infoRepository.findById(info_Id).get();
    }

    public void saveOrUpdate(Info info){
        infoRepository.save(info);
    }

    public void deleteById(int info_id){
        infoRepository.deleteById(info_id);
    }

    public void update(Info info, int info_id){
        infoRepository.save(info);
    }

}
