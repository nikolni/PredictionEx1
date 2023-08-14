package dto.impl;

import dto.api.DTOMenu3ForUiTC;

public class DTOMenu3ForUiTCImpl implements DTOMenu3ForUiTC {
    private int simulationID;
    private String terminationReason;


    public DTOMenu3ForUiTCImpl(int simulationID, String terminationReason){
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
