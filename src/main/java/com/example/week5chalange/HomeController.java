package com.example.week5chalange;

import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    MemegRepository memegRepository;

    @Autowired
    cloudinaryConfig cloudc;

    @RequestMapping("/")
    public String listmemegram(Model model){
        model.addAttribute("memegram", memegRepository.findAll());
        return "list";
    }
    @GetMapping("/add")
    public String newMemeg(Model model){
        model.addAttribute("memeg", new Memeg());
        return "form";
    }

    @PostMapping("/add")
    public String processActor(@ModelAttribute Memeg memeg,
                               @RequestParam("file")MultipartFile file){

        if(file.isEmpty()){
            return "redirect:/add";
        }
        try{
            Map uploadResult = cloudc.upload(file.getBytes(), ObjectUtils.asMap("resourcetype", "auto"));
            memeg.setMemegname(uploadResult.get("url").toString());
            memegRepository.save(memeg);
        }catch(IOException e){
            e.printStackTrace();
            return "redirect:/add";
        }
        return "redirect:/";
    }
}