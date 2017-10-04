package org.cidarlab.fluigi.netlist.mintnetlistparser;

import org.cidarlab.fluigi.netlist.Enumerations;
import org.cidarlab.fluigi.netlist.constraints.Constraint;
import org.cidarlab.fluigi.netlist.constraints.GridConstraint;
import org.cidarlab.fluigi.netlist.constraints.OrientationConstraint;
import org.cidarlab.fluigi.netlist.mintgrammar.mintgrammarParser;

public class PartialMINTConstraintParser extends PartialMINTNetlistParser {

    protected Enumerations.HorizontalDirection constraintContextHorizontalDirection = null;
    protected Enumerations.VerticalDirection constraintContextVerticalDirection = null;
    protected Enumerations.Orientation constriantContextOrientaiton = null;
    protected Integer constraintContextLength = null;


    public PartialMINTConstraintParser() {
        super();
    }

    @Override
    public void enterFlowStat(mintgrammarParser.FlowStatContext ctx) {
        super.enterFlowStat(ctx);
        constraintContextComponents.clear();
        clearConstraintFlags();
    }


    @Override
    public void enterControlStat(mintgrammarParser.ControlStatContext ctx) {
        super.enterControlStat(ctx);
        constraintContextComponents.clear();
        clearConstraintFlags();
    }

    @Override
    public void enterIntegrationStat(mintgrammarParser.IntegrationStatContext ctx) {
        super.enterIntegrationStat(ctx);
        constraintContextComponents.clear();
        clearConstraintFlags();
    }

    @Override
    public void exitPrimitiveWithOrientationConstraintStat(mintgrammarParser.PrimitiveWithOrientationConstraintStatContext ctx) {
        super.exitPrimitiveWithOrientationConstraintStat(ctx);

        // Finally set the rotation value for the component
        /*
        1. Figure out what the final rotation/orientation is
        2. Apply it to all the components
         */

        float rotation = 0;

        if(null == constriantContextOrientaiton){
            throw new UnsupportedOperationException("Need to implement error throwing mechanism for bad constraints");
        }

        if(Enumerations.Orientation.VERTICAL == constriantContextOrientaiton){
            if(null == constraintContextVerticalDirection){
                //Check if there's a default parameter for the techentity
                String direction = currententity.getDefaultParamValue("direction");
                if(null == direction) {
                    throw new UnsupportedOperationException("No default direction found for the primitive, give unsupported constraint error");
                }
                switch (direction){
                    case "UP":
                        rotation = 180;
                        break;
                    case "DOWN":
                        rotation = 0;
                        break;
                    default:
                        throw new UnsupportedOperationException("Need to implement error throwing mech for error in tech file");
                }
            }else {

                switch (constraintContextVerticalDirection) {
                    case UP:
                        rotation = 180;
                        break;
                    case DOWN:
                        rotation = 0;
                        break;
                }
            }

        }else{
            if(null == constraintContextHorizontalDirection){
                String direction = currententity.getDefaultParamValue("direction");
                if(null == direction) {
                    throw new UnsupportedOperationException("No default direction found for the primitive, give unsupported constraint error");
                }
                switch (direction){
                    case "RIGHT":
                        rotation = 90;
                        break;
                    case "LEFT":
                        rotation = 270;
                        break;
                    default:
                        throw new UnsupportedOperationException("Need to implement error throwing mech for error in tech file");
                }
            }else {

                switch (constraintContextHorizontalDirection) {
                    case LEFT:
                        rotation = 270;
                        break;
                    case RIGHT:
                        rotation = 90;
                        break;
                }
            }

        }

        OrientationConstraint constraint = new OrientationConstraint(rotation, constraintContextComponents);
        this.device.addConstraint(constraint);
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void exitGridStat(mintgrammarParser.GridStatContext ctx) {
        super.exitGridStat(ctx);

        int horizontalspacing = 0;
        int verticalspacing = 0;

        if(paramsHashmap.containsKey("horizontalSpacing")){
            horizontalspacing = Integer.parseInt(paramsHashmap.get("horizontalSpacing"));
        }

        if(paramsHashmap.containsKey("verticalSpacing")){
            verticalspacing = Integer.parseInt(paramsHashmap.get("verticalSpacing"));
        }

        if(paramsHashmap.containsKey("horizontalValves")){
            if(("YES").equals(paramsHashmap.get("horizontalValves"))){
                throw new UnsupportedOperationException("Need to implement code to increase spacing for a valve");
            }
        }

        if(paramsHashmap.containsKey("verticalValves")){
            if(("YES").equals(paramsHashmap.get("verticalValves"))){
                throw new UnsupportedOperationException("Need to implement code to increase spacing for a valve");
            }
        }

        Constraint constraint = new GridConstraint(horizontalspacing, verticalspacing, constraintContextComponents);

        device.addConstraint(constraint);
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void exitSpanStat(mintgrammarParser.SpanStatContext ctx) {
        super.exitSpanStat(ctx);
        //TODO: We need to check if the span is of Type Tree/Fan and then generate the respective cells
        throw new UnsupportedOperationException();

    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void exitBankStat(mintgrammarParser.BankStatContext ctx) {
        super.exitBankStat(ctx);
        //TODO: Implement the constraint for bank
        throw new UnsupportedOperationException();

    }

    //------------------- Constraint Params ---------------------


    @Override
    public void enterIntParam(mintgrammarParser.IntParamContext ctx) {
        super.enterIntParam(ctx);

        //Capture the length constraint

        String paramkey = ctx.param_element().getText();
        String value = ctx.value().getText();

        if(paramkey.equals("length")){
            constraintContextLength = Integer.parseInt(value);
        }
    }

    @Override
    public void exitOrientation(mintgrammarParser.OrientationContext ctx) {
        super.exitOrientation(ctx);

        //Set the orientation flag that is used later on

        switch (ctx.getText()){
            case "V":
                constriantContextOrientaiton = Enumerations.Orientation.VERTICAL;
                break;
            case "H":
                constriantContextOrientaiton = Enumerations.Orientation.HORIZONTAL;
                break;
        }

    }

    @Override
    public void enterVerticalDirectionParam(mintgrammarParser.VerticalDirectionParamContext ctx) {
        super.enterVerticalDirectionParam(ctx);

        //Set the current vertical direction flag

        switch (ctx.getText()){
            case "UP":
                constraintContextVerticalDirection = Enumerations.VerticalDirection.UP;
                break;
            case "DOWN":
                constraintContextVerticalDirection = Enumerations.VerticalDirection.DOWN;
                break;
        }


    }

    @Override
    public void enterHorizontalDirectionParam(mintgrammarParser.HorizontalDirectionParamContext ctx) {
        super.enterHorizontalDirectionParam(ctx);

        //Set the current horizontal direction flag

        switch (ctx.getText()){
            case "LEFT":
                constraintContextHorizontalDirection = Enumerations.HorizontalDirection.LEFT;
                break;
            case "RIGHT":
                constraintContextHorizontalDirection = Enumerations.HorizontalDirection.RIGHT;
                break;
        }

    }



    //------------------ Private Helper Methods -------------------

    /**
     * Clears all of the flags that are being set by the constriant params
     */
    private void clearConstraintFlags() {
        constriantContextOrientaiton = null;
        constraintContextHorizontalDirection = null;
        constraintContextVerticalDirection = null;
        constraintContextLength = null;
    }

}
