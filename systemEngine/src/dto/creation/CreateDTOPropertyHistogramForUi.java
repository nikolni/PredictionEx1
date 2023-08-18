package dto.creation;

import dto.api.DTOPropertyHistogramForUi;
import dto.impl.DTOPropertyHistogramForUiImpl;
import system.engine.world.api.WorldInstance;
import system.engine.world.execution.instance.enitty.api.EntityInstance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreateDTOPropertyHistogramForUi {

    public DTOPropertyHistogramForUi getData(WorldInstance worldInstance, String entityName, String propertyName){

        //Stream stream = worldInstance.getEntityInstanceManager().getInstancesBeforeKill().stream().
             //   filter(e -> e.getEntityDefinition().getUniqueName().equals(entityName));

        //Map<Object, Long> propertyHistogram = new HashMap<>();

        Map<Object, Long> propertyHistogram = worldInstance.getEntityInstanceManager().getInstancesBeforeKill().stream().
               filter(e -> e.getEntityDefinition().getUniqueName().equals(entityName)).
                collect(Collectors.groupingBy(e -> e.getPropertyByName(propertyName).getValue(), Collectors.counting()));

        return new DTOPropertyHistogramForUiImpl(propertyHistogram, propertyName);

    }
}
