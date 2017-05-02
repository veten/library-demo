package com.example.library;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LibraryController {

	
	@RequestMapping("/")
    public String getRoot() {
        return "root.html";
    }
	
}
