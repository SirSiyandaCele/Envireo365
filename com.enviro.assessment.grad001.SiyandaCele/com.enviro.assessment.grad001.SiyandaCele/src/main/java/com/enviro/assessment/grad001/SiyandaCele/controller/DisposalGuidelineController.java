package com.enviro.assessment.grad001.SiyandaCele.controller;

import com.enviro.assessment.grad001.SiyandaCele.Repository.DisposalGuidelineRepo;
import com.enviro.assessment.grad001.SiyandaCele.model.DisposalGuideline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@Controller
@RequestMapping("/disposalguideline")
public class DisposalGuidelineController {

    @Autowired
    private DisposalGuidelineRepo disposalGuidelineRepo;

    @GetMapping("/getAllDisposalGuidelines")
    public ResponseEntity<List<DisposalGuideline>> getAllDisposalGuidelineDetails(){
        try{
            List<DisposalGuideline> disposalGuidelineList = new ArrayList<>();
            disposalGuidelineRepo.findAll().forEach(disposalGuidelineList::add);

            if(disposalGuidelineList.isEmpty()){
                return  new ResponseEntity<>(disposalGuidelineList, HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getDisposalGuidelineById/{id}")
    public ResponseEntity<DisposalGuideline> getDisposalGuidelineById(@PathVariable long wasteID){
        Optional<DisposalGuideline> guidelineData = disposalGuidelineRepo.findById(wasteID);

        if(guidelineData.isPresent()){
            return new ResponseEntity<>(guidelineData.get(),HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND); //No data for searched category id
    }

    @PostMapping("/addDisposalGuideline")
    public ResponseEntity<DisposalGuideline> createDisposalGuidelineDetails(@RequestBody DisposalGuideline disposalGuideline){ //put only the wasteGategory name
        DisposalGuideline guidelineData = disposalGuidelineRepo.save(disposalGuideline); //get an automatic id for the waste gategory[Remember the strategy used in the WasteCategory class for the id varible

        return new ResponseEntity<> (guidelineData, HttpStatus.OK);
    }

    @PutMapping("/updateDisposalGuidelineById/{id}")
    public ResponseEntity<DisposalGuideline> updateDisposalGuidelineDetails(@PathVariable long id, @RequestBody DisposalGuideline newDisposalGuideline){
        Optional<DisposalGuideline> currentGuidelineData =  disposalGuidelineRepo.findById(id); //find about the given id

        if (currentGuidelineData.isPresent()){ //if there is information for the given id(the id exists), then we can edit it.
            DisposalGuideline updatedGuidelineData = currentGuidelineData.get();
            updatedGuidelineData.setName(newDisposalGuideline.getName());
            updatedGuidelineData.setName(newDisposalGuideline.getDescription());

            DisposalGuideline disposalGuidelineObj = disposalGuidelineRepo.save(updatedGuidelineData);
            return new ResponseEntity<>(disposalGuidelineObj, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deteteDisposalGuidelinesById/{id}")
    public ResponseEntity<HttpStatus> deleteDisposalGuidelinesById(@PathVariable long id){
        disposalGuidelineRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}