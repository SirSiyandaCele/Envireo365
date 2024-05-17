package com.enviro.assessment.grad001.SiyandaCele.controller;

import com.enviro.assessment.grad001.SiyandaCele.Repository.WasteCategoryRepo;
import com.enviro.assessment.grad001.SiyandaCele.model.WasteCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Controller
@RestController
@RequestMapping("/wastecategory")
public class WasteCategoryController {

    @Autowired
    private WasteCategoryRepo wasteCategoryRepo;

    @GetMapping("/getAllWasteCategories")
    public ResponseEntity<List<WasteCategory>> getWasteCategoryDetails(){
        try{
            List<WasteCategory> categorieslist = new ArrayList<>();
            wasteCategoryRepo.findAll().forEach(categorieslist::add);

            if(categorieslist.isEmpty()){
                return  new ResponseEntity<>(categorieslist, HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getWasteCategoryById/{id}")
    public ResponseEntity<WasteCategory> getWasteCategoryById(@PathVariable long wasteID){
        Optional<WasteCategory> wasteCategoryData = wasteCategoryRepo.findById(wasteID);

        if(wasteCategoryData.isPresent()){
            return new ResponseEntity<>(wasteCategoryData.get(),HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND); //No data for searched category id
    }

    @PostMapping("/addWasteCategory")
    public ResponseEntity<WasteCategory> createWasteCategoryDetails(@RequestBody WasteCategory wasteCategory){ //put only the wasteGategory name
        WasteCategory wasteCategoryData = wasteCategoryRepo.save(wasteCategory); //get an automatic id for the waste gategory[Remember the strategy used in the WasteCategory class for the id varible

        return new ResponseEntity<> (wasteCategoryData, HttpStatus.OK);
    }

    @PutMapping("/updateWasteCategoryById/{id}")
    public ResponseEntity<WasteCategory> updateWasteCategoryDetails(@PathVariable long id, @RequestBody WasteCategory newWasteCategory){
        Optional<WasteCategory> currentWasteCategoryData =  wasteCategoryRepo.findById(id); //find about the given id

        if (currentWasteCategoryData.isPresent()){ //if there is information for the given id(the id exists), then we can edit it.
            WasteCategory updatedWasteCategoryData = currentWasteCategoryData.get();
            updatedWasteCategoryData.setName(newWasteCategory.getName());

            WasteCategory wasteCategoryObj = wasteCategoryRepo.save(updatedWasteCategoryData);
            return new ResponseEntity<>(wasteCategoryObj, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deteteWasteCategoryById/{id}")
    public ResponseEntity<HttpStatus> deleteWasteCategoryDetailsById(@PathVariable long id){
        wasteCategoryRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
