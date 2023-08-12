package creation.api;

import dto.api.DTOMenu3ForSE;
import system.engine.api.SystemEngineAccess;

import java.util.List;

public interface CreateDTOMenu3ForSE {
    DTOMenu3ForSE getDataForMenu3(List<Object> environmentVarInitValues);
}
