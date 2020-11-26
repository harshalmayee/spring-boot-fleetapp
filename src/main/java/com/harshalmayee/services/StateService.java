package com.harshalmayee.services;

import com.harshalmayee.models.Country;
import com.harshalmayee.models.State;

import java.util.List;

public interface StateService {

    public List<State> getAllStates();

    public void addNewState(State state);

    public State getStateById(int id);

    void delete(int id);
}
