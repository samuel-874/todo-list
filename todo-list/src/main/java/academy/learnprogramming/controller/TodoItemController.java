package academy.learnprogramming.controller;

import academy.learnprogramming.model.TodoData;
import academy.learnprogramming.model.TodoItem;
import academy.learnprogramming.util.AttributeNames;
import academy.learnprogramming.util.Mappings;
import academy.learnprogramming.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Slf4j
@Controller
public class TodoItemController {
    //==field==
//    private final TodoItemService todoItemService;
//
//    //==constructor==
//    @Autowired
//    public TodoItemController(TodoItemService todoItemService) {
//        this.todoItemService = todoItemService;
//    }


    //==Model Attribute section ==
    @ModelAttribute
    public TodoData todoData(){
        return new TodoData();

    }

    //==handler methods==
    // http://localhost:8080/todo-list/items
    @GetMapping(Mappings.ITEMS)
    public String items(){
        return ViewNames.ITEMS_LIST;
    }
    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(Model model){
        TodoItem todoItem= new TodoItem("","", LocalDate.now());
        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.ADD_ITEM;
    }
    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem){
        log.info("todoItem from from ={}", todoItem);
      //  TodoItemServiceImpl.addItem(todoItem);
    return "redirect:/" + Mappings.ITEMS;
    }
    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam int id){
        log.info("Delete item with id={}", id);
       // TodoItemServiceImpl.removeItem(id);
        return "redirect:/" + Mappings.ITEMS;
    }
}
