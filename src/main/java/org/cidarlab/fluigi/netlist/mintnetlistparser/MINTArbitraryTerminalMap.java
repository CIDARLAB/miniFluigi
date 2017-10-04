package org.cidarlab.fluigi.netlist.mintnetlistparser;

import org.cidarlab.fluigi.netlist.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
                nodetoadd = new TargetNode(alias, null);
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
        throw new UnsupportedOperationException("Need to implement mechanism to get get component for alias and terminal label");
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
    }
}
