package ui.dto.creation;

import dto.api.DTOMenu3ForSE;
import dto.impl.DTOMenu3ForSEImpl;

import java.util.List;

public class CreateDTOMenu3ForSE {

    public DTOMenu3ForSE getDataForMenu3(List<Object> environmentVarInitValues) {
        return new DTOMenu3ForSEImpl(environmentVarInitValues);
    }
}
