package com.harshalmayee.services.impl;

import com.harshalmayee.models.Country;
import com.harshalmayee.models.State;
import com.harshalmayee.repositories.StateRepository;
import com.harshalmayee.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateServiceImpl implements StateService {

    @Autowired
    private StateRepository stateRepository;

    @Override
    public List<State> getAllStates() {
        return stateRepository.findAll();
    }

    @Override
    public void addNewState(State state) {
        stateRepository.save(state);
    }

    @Override
    public State getStateById(int id) {
        Optional<State> optional=stateRepository.findById(id);
        State state=null;
        if(optional.isPresent()){
            state=optional.get();
        }else{
            throw new RuntimeException("State Not Found :"+id);
        }
        return state;
    }

    @Override
    public void delete(int id) {
        stateRepository.deleteById(id);
    }
}
