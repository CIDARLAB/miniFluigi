package org.cidarlab.fluigi.netlist.mintnetlistparser;

import org.cidarlab.fluigi.netlist.Component;
import org.cidarlab.fluigi.netlist.Connection;
import org.cidarlab.fluigi.netlist.TechEntity;
import org.cidarlab.fluigi.netlist.mintgrammar.mintgrammarParser;

import java.util.HashMap;

public class PartialMINTParamsParser extends PartialMINTDeviceArchitectureParser {
    HashMap<String, String> paramsHashmap;
    TechEntity currententity;

    public PartialMINTParamsParser() {
        super();
        paramsHashmap = new HashMap<>();
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void enterParamsStat(mintgrammarParser.ParamsStatContext ctx) {
        paramsHashmap.clear();
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void enterIntParam(mintgrammarParser.IntParamContext ctx) {
        String paramkey = ctx.param_element().getText();
        String value = ctx.value().getText();
        paramsHashmap.put(paramkey,value);
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void enterBoolParam(mintgrammarParser.BoolParamContext ctx) {
        String paramkey = ctx.param_element().getText();
        String value = ctx.boolvalue().getText();
        paramsHashmap.put(paramkey,value);
    }

    protected void verifyAndAddParams(Component component) {
        for(String key: paramsHashmap.keySet()){
            TechEntity.ParamVerificationResult verification = currententity.verifyParam(key, paramsHashmap.get(key));
            switch (verification){
                case VALID:
                    component.addParam(key, paramsHashmap.get(key));
                    break;
                case INVALID_NAME:
                    System.out.println("Warning ! - Component \"" + currententity.getMINTName()
                            + "\" does not support the parameter \"" + key + "\"");

                    //TODO: Create Unified error generation mechanism and add above stuff
                    break;
                case INVALID_TYPE:
                    //TODO: Add the error thing
                    throw new UnsupportedOperationException("Component: Create error mechanism for invalid type");
                case INVALID_VALUE:
                    throw new UnsupportedOperationException("Component: Create error mechanism for invalid value");
            }
        }
    }

    protected void verifyAndAddConnectionParams(Connection connection) {
        for(String key : paramsHashmap.keySet()){
            TechEntity entity = techLibrary.getMINTEntity("CHANNEL");
            if(null == entity){
                throw new UnsupportedOperationException("Connection: Could not find the channel entity file");
            }
            TechEntity.ParamVerificationResult verification = entity.verifyParam(key, paramsHashmap.get(key));
            switch (verification){
                case VALID:
                    connection.addParam(key, paramsHashmap.get(key));
                    break;
                case INVALID_NAME:
                    //TODO: Add the error thing
                    throw new UnsupportedOperationException("Connection: Create error mechanism for invalid names");
                case INVALID_TYPE:
                    //TODO: Add the error thing
                    throw new UnsupportedOperationException("Connection: Create error mechanism for invalid type");
                case INVALID_VALUE:
                    throw new UnsupportedOperationException("Connection: Create error mechanism for invalid value");
            }


        }
    }
}
