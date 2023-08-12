package creation.impl;

import creation.api.CreateDTOMenu3ForSE;
import dto.api.DTOMenu3ForSE;
import dto.impl.DTOMenu3ForSEImpl;
import system.engine.api.SystemEngineAccess;

import java.util.List;

public class CreateDTOMenu3ForSEImpl implements CreateDTOMenu3ForSE {
    @Override
    public DTOMenu3ForSE getDataForMenu3(List<Object> environmentVarInitValues) {
        return new DTOMenu3ForSEImpl(environmentVarInitValues);
    }
}
