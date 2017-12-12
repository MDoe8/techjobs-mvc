

package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;


@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }
    @RequestMapping(value = "results")
    public String search(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {
        if (searchType.equals("all")) {
    //        ArrayList<HashMap<String, String>> results = JobData.findByValue(searchTerm);
      //      model.addAttribute("columns", "ListController.columnChoices");
        //    model.addAttribute("results", results);
          //  return "search";
            System.out.println("hi");
        }
        ArrayList<HashMap<String, String>> results = JobData.findByColumnAndValue(searchType, searchTerm);
        model.addAttribute("columns", ListController.columnChoices);
        model.addAttribute("results", results);
        return "search";
    }

    //The method should take in two parameters, specifying the type of search and the search term.
    // In order for the parameters to be properly passed in by Spring Boot, you'll need to name
    // them appropriately, based on the corresponding form field names.
    // TODO #1 - Create handler to process search request and display results

}
