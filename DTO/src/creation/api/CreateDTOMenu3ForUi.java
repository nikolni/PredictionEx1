package creation.api;

import dto.api.DTOMenu3ForUi;
import system.engine.api.SystemEngineAccess;

public interface CreateDTOMenu3ForUi {
    DTOMenu3ForUi getDataForMenu3(SystemEngineAccess systemEngineAccess);
}
