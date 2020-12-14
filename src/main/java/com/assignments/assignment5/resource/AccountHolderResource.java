package com.assignments.assignment5.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignments.assignment5.models.AccountHolder;
import com.assignments.assignment5.repository.AccountHolderRepository;

@RestController
@RequestMapping("/test")
public class AccountHolderResource {

	@Autowired
	AccountHolderRepository accountHolderRepository;
	
//    @GetMapping("/AccountHolders")
//    public List<AccountHolder> getAll() {
//        return accountHolderRepository.findAll();
//    }
//    
    @PostMapping("/addAccountHolder")
    public AccountHolder addAccountHolder(@RequestBody AccountHolder accountHolder) {
    	accountHolderRepository.save(accountHolder);
    	return accountHolder;
    }

//    @GetMapping("/{firstName}")
//    public List<AccountHolder> getUser(@PathVariable("name") final String firstName) {
//        return accountHolderRepository.findByFirstName(firstName);
//
//    }

    @GetMapping("/id/{id}")
    public AccountHolder getId(@PathVariable("id") final Integer id) {
        return accountHolderRepository.findById(id).orElse(null);
    }

    @GetMapping("/update/{id}/{firstName}")
    public AccountHolder update(@PathVariable("id") final Integer id, @PathVariable("firstName")
                         final String firstName) {


    	AccountHolder accountHolder = getId(id);
    	accountHolder.setFirstName(firstName);

        return accountHolderRepository.save(accountHolder);
    }
}
