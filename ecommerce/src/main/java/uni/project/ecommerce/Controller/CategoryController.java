package uni.project.ecommerce.Controller;

import org.springframework.web.bind.annotation.*;
import uni.project.ecommerce.DTO.CategoryDTO;
import uni.project.ecommerce.Model.Category;
import uni.project.ecommerce.Repository.CategoryRepository;
import uni.project.ecommerce.Service.CategoryService;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",allowCredentials = "true")
@RequestMapping(value = "/api/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @PostMapping(value = "/")
    public String saveCategory(@RequestBody CategoryDTO categoryDTO){
        return categoryService.save(categoryDTO);
    }
    @GetMapping(value="/")
    public Set<Category> getCategory(){
        return categoryService.findAll();
    }
    @GetMapping(value = "/{id}")
    public Category getCategoryById(@PathVariable("id") Long id){
        return categoryService.findById(id);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteCategoryById(@PathVariable("id") Long id){
        categoryService.deleteById(id);
        return "Deleted";
    }
    @PutMapping("/{id}")
    public String updateCategory(@PathVariable("id") Long id , @RequestBody CategoryDTO categoryDTO ){
        return categoryService.update(id ,categoryDTO);
    }
}
