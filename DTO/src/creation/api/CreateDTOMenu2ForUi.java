package creation.api;

import dto.api.DTOMenu2ForUi;
import system.engine.api.SystemEngineAccess;

public interface CreateDTOMenu2ForUi {
        DTOMenu2ForUi getDataForMenu2(SystemEngineAccess systemEngineAccess);

}
