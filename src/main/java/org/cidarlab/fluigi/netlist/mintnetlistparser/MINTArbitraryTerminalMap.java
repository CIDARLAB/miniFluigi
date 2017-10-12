package org.cidarlab.fluigi.netlist.mintnetlistparser;

import org.cidarlab.fluigi.model.Component;

import java.util.HashMap;

public class MINTArbitraryTerminalMap {

    HashMap<String, TargetNode> targetNodes; //Contains the forest of trees where the information is stored

    public MINTArbitraryTerminalMap(){
        targetNodes = new HashMap<>();
    }

    /**
     * By passing a query (a list of strings to identify a single component), a component and a terminal, for a given
     * query mistakes can be identified ?????. The general assumption is that none of these values are null
     * TODO: REWORK this phrasing
     * @param alias
     * @param component
     * @param queryterminallabel
     */
    public void addRecord(String alias, Component component, String queryterminallabel, String targetterminallabel){
        if(targetNodes.containsKey(alias)){
            //Update the existing entry based on the rest of the values
            TargetNode nodetomodify =  targetNodes.get(alias);

            //Add the new child for the given target record
            if(null != queryterminallabel && null != targetterminallabel){
                //create entries in the children
                nodetomodify.addChild(
                        new TargetNode(
                                queryterminallabel,
                                new TargetRecord(component, targetterminallabel)
                        ));
            }

        }else {
            //Create Entries for arbitrary terminal specification
            TargetNode nodetoadd;
            if(null != queryterminallabel && null != targetterminallabel){
                nodetoadd = new TargetNode(alias, new TargetRecord(component));
                //create entries in the children
                nodetoadd.addChild(
                    new TargetNode(
                        queryterminallabel,
                        new TargetRecord(component, targetterminallabel)
                ));

                //Now add this tree to the forest
                targetNodes.put(alias, nodetoadd);

            }else if(null == queryterminallabel && null == targetterminallabel){
                nodetoadd = new TargetNode(alias, new TargetRecord(component));

                //Now add this tree to the forest
                targetNodes.put(alias, nodetoadd);

            }else {
                throw new UnsupportedOperationException("Did not think this case existed in the algorithm");
            }
        }
    }

    public TargetRecord queryRecord(String componentreference, String terminallabel){
        TargetRecord ret = null;
        if(null == componentreference){
            throw new UnsupportedOperationException("This should not be null create error for this scenario");
        }else if(!targetNodes.containsKey(componentreference)){
            throw new UnsupportedOperationException("Could not find any reference to the given component reference:" + componentreference);
        }else if(null == terminallabel){
            //Return the record where just the query would work
            //Return the record
            ret = targetNodes.get(componentreference).getRecord();
            if(null == ret){
                throw new UnsupportedOperationException("Could not find record for the given component reference, " +
                        "this particular connection expects the user to include a terminal reference for a legal " +
                        "connection");
            }
        }else{
            //Seriously traverse the nodes and return the final record
            //First find the node with the component reference ...
            TargetNode node = targetNodes.get(componentreference);
            //then find the child node based on the terminal reference
            TargetNode childnode = node.getChild(terminallabel);
            ret = childnode.getRecord();
        }
        return ret;
    }


    private class TargetNode {
        final String id;
        final TargetRecord record;
        HashMap<String, TargetNode> children;

        public TargetNode(String nodeid, TargetRecord targetRecord){
            this.id = nodeid;
            this.record = targetRecord;
        }

        public void addChild(TargetNode childnode){
            if(null == this.children){
                this.children = new HashMap();
            }

            this.children.put(childnode.getId(), childnode);
        }

        public String getId() {
            return id;
        }

        public TargetRecord getRecord() {
            return record;
        }

        public TargetNode getChild(String childreference) {
            if(null == childreference){
                throw new UnsupportedOperationException("need to implement null handling");
            }else if (!this.children.containsKey(childreference)){
                throw new UnsupportedOperationException("Need to implement error when child reference is not found");
            }else{
                return this.children.get(childreference);
            }
        }
    }

    public static class TargetRecord {
        private final String componentID;
        private final String terminalLabel;

        public TargetRecord(Component component, String terminal) {
            this.componentID = component.getId();
            this.terminalLabel = terminal;
        }

        public TargetRecord(Component component){
            this.componentID = component.getId();
            this.terminalLabel = null;
        }

        public String getComponentID() {
            return componentID;
        }

        public String getTerminalLabel() {
            return terminalLabel;
        }
    }
}
