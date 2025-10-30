/* Student Name: Carl Nicolas Mendoza
 * Student Number: 301386435
 * Submission Date: 2025-10-30
 */

/**
 * Home controller to handle root and home page requests.
 * - index: Displays the index page
 * - home: Redirects to the flights page
 * 
 * @author nico
 * @version 0.1
 * @since 2025-10-30
 */
package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
	return "index";
    }

    @GetMapping("/home")
    public String home() {
	return "redirect:/flights";
    }
}

// ========================================
