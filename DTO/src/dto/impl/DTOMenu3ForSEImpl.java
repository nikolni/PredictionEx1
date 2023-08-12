package dto.impl;

import dto.api.DTOMenu3ForSE;

import java.util.List;

public class DTOMenu3ForSEImpl implements DTOMenu3ForSE {

    private List<Object> environmentVarInitValues;

    public DTOMenu3ForSEImpl(List<Object> environmentVarInitValues){
        this.environmentVarInitValues = environmentVarInitValues;
    }

    @Override
    public List<Object> getEnvironmentVarInitValues() {
        return environmentVarInitValues;
    }
}
