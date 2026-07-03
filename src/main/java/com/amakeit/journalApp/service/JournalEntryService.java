package com.amakeit.journalApp.service;

import com.amakeit.journalApp.entity.JournalEntry;
import com.amakeit.journalApp.entity.User;
import com.amakeit.journalApp.repository.JournalEntryRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class JournalEntryService {

//    aur ye sare methods jaise - save , saveAll , findById , deleteById ye sb inbuild hote h mongoRepository me.
    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;
//    bhai ye post me use ho rha h aur jb tum controller bnaoge na to ek service me aake aise funx bnane hi prte h -
//    - ye save kr rha h humare entry ko.


    @Transactional
    public void saveEntry(JournalEntry journalEntry , String userName) {
        try{
            User user = userService.findByUserName(userName);
            journalEntry.setDate(LocalDateTime.now());
            JournalEntry saved = journalEntryRepository.save(journalEntry);
            user.getJournalEntries().add(saved);
            userService.saveUser(user);
        }catch (Exception e){
            System.out.println(e);
            throw new RuntimeException("Error saving entry" , e);
        }
    }
    public void saveEntry(JournalEntry journalEntry) {
        journalEntryRepository.save(journalEntry);
    }
//    ye get method me use ho rha h controllerV2 class me.
    public List<JournalEntry> getAll() {
        return journalEntryRepository.findAll();
    }
//    ye bhi get method me use ho rha h.
    public Optional<JournalEntry> findById(ObjectId id) {
        return journalEntryRepository.findById(id);
    }
//   ye bhi controllerV2 class me use ho rha h id delete krne ke liye.

    @Transactional
    public boolean deleteById(ObjectId id , String userName) {
        boolean removed = false;
        try {
            User user = userService.findByUserName(userName);
             removed = user.getJournalEntries().removeIf(x -> x.getId().equals(id));
            if(removed){
                userService.saveUser(user);
                journalEntryRepository.deleteById(id);
            }
        } catch (Exception e){
            System.out.println(e);
            throw new RuntimeException("Error deleting entry" , e);
        }
        return removed;
    }
}



// controller ----> service -----> repository  (Working flow of Project)