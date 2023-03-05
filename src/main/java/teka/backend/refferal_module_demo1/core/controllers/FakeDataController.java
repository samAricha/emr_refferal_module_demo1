package teka.backend.refferal_module_demo1.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import teka.backend.refferal_module_demo1.core.services.CoreFakeDataService;

@RestController
@RequestMapping("/api")
public class FakeDataController {
    @Autowired
    private CoreFakeDataService coreFakeDataService;

    @GetMapping
    public String home() {

        coreFakeDataService.generateFakeData();

        return "data generated";
    }
}
