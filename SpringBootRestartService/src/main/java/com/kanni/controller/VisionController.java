package com.kanni.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.IntStream;

@RestController
public class VisionController {

    private static void accept(int e) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
           System.out.println("Application stopped accidentally !!");
        }
        System.out.println(" Count number ===> " + e);
    }

    @GetMapping("/vision")
    public String vision() {

        IntStream.range(1, 100).forEach(VisionController::accept);
        return "Robotic machine found!!";
    }
}
