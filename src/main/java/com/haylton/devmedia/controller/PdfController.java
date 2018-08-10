package com.haylton.devmedia.controller;

import com.itextpdf.text.Document;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class PdfController {
    
    @RequestMapping("/")
    public String getPdf(){
        return "/home";
    }
}
