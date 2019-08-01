package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    TodoRepository todoRepository;

    @RequestMapping("/")
    public String listTodos(Model model){
        model.addAttribute("todos", todoRepository.findAll());
        return "list";

    }
/*    @RequestMapping("/")
    public String listjobs(Model model){
        model.addAttribute("jobs", jobRepository.findAll());
        return "list";
    }
    */

    @GetMapping("/add")
    public String todoForm(Model model){
        model.addAttribute("todo", new Todo());
        return "todoform";

    }

/*
    @GetMapping("/add")
    public String jobForm(Model model){
        model.addAttribute("job", new Job());
        return "jobform";
    }
*/

    @PostMapping("/process")
    public String processTodo(@Valid Todo todo, BindingResult result){
        if (result.hasErrors()){
            return "todoform";
        }
        todoRepository.save(todo);
        return "redirect:/";
    }
   /* @PostMapping("/process")
    public String processForm(@Valid Job job, BindingResult result){
        if (result.hasErrors()){
            return "jobform";
        }
        jobRepository.save(job);
        return "redirect:/";
    }*/


}


