package dto.impl;

import dto.api.DTOSimulationDataForUi;

public class DTOSimulationDataForUiImpl implements DTOSimulationDataForUi {
    private int simulationID;
    private String terminationReason;


    public DTOSimulationDataForUiImpl(int simulationID, String terminationReason){
        this.simulationID = simulationID;
        this.terminationReason = terminationReason;
    }

    @Override
    public int getSimulationID() {
        return simulationID;
    }

    @Override
    public String getTerminationReason() {
        return terminationReason;
    }
}
