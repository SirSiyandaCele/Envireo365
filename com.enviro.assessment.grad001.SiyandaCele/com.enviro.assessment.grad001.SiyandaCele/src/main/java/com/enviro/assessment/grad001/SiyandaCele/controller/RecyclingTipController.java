package com.enviro.assessment.grad001.SiyandaCele.controller;

import com.enviro.assessment.grad001.SiyandaCele.Repository.RecyclingTipRepo;
import com.enviro.assessment.grad001.SiyandaCele.model.RecyclingTip;
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
@RequestMapping("/recyclcingtip")
public class RecyclingTipController {

    @Autowired
    private RecyclingTipRepo recyclingTipRepo;

    @GetMapping("/getAllRecyclingTips")
    public ResponseEntity<List<RecyclingTip>> getRecyclingTipDetails(){
        try{
            List<RecyclingTip> Tipslist = new ArrayList<>();
            recyclingTipRepo.findAll().forEach(Tipslist::add);

            if(Tipslist.isEmpty()){
                return  new ResponseEntity<>(Tipslist, HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getRecyclingTipById/{id}")
    public ResponseEntity<RecyclingTip> getRecyclingTipById(@PathVariable long wasteID){
        Optional<RecyclingTip> TipData = recyclingTipRepo.findById(wasteID);

        if(TipData.isPresent()){
            return new ResponseEntity<>(TipData.get(),HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND); //No data for searched category id
    }

    @PostMapping("/addRecyclingTip")
    public ResponseEntity<RecyclingTip> createRecyclingTipDetails(@RequestBody RecyclingTip recyclingTip){ //put only the wasteGategory name
        RecyclingTip TipData = recyclingTipRepo.save(recyclingTip); //get an automatic id for the waste gategory[Remember the strategy used in the WasteCategory class for the id varible

        return new ResponseEntity<> (TipData, HttpStatus.OK);
    }

    @PutMapping("/updateRecyclingTipById/{id}")
    public ResponseEntity<RecyclingTip> updateRecyclingTipDetails(@PathVariable long id, @RequestBody RecyclingTip newRecyclingTip){
        Optional<RecyclingTip> currentTipData =  recyclingTipRepo.findById(id); //find about the given id

        if (currentTipData.isPresent()){ //if there is information for the given id(the id exists), then we can edit it.
            RecyclingTip updatedTipData = currentTipData.get();
            updatedTipData.setName(newRecyclingTip.getName());
            updatedTipData.setName(newRecyclingTip.getTip());

            RecyclingTip recyclingTipObj = recyclingTipRepo.save(updatedTipData);
            return new ResponseEntity<>(recyclingTipObj, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteRecyclingTipById/{id}")
    public ResponseEntity<HttpStatus> deleteRecyclingTipDetailsById(@PathVariable long id){
        recyclingTipRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

