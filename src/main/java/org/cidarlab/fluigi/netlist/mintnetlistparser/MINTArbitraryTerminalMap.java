package org.cidarlab.fluigi.netlist.mintnetlistparser;

import org.cidarlab.fluigi.netlist.Component;

import java.util.List;

public class MINTArbitraryTerminalMap {

    /**
     * By passing a query (a list of strings to identify a single component), a component and a terminal, for a given
     * query mistakes can be identified ????? TODO: REWORK this phrasing
     * @param alias
     * @param component
     * @param queryterminallabel
     */
    public void addRecord(String alias, Component component, String queryterminallabel, String targetterminallabel){
        throw new UnsupportedOperationException("Need to implement mechanism to add this");
    }

    public TargetRecord queryRecord(String componentreference, String terminallabel){
        throw new UnsupportedOperationException("Need to implement mechaism to get get component for alias and terminal label");
    }




}
