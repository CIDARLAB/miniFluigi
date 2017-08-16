/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.fluigi.netlist;

import java.util.*;

/**
 *
 * @author krishna
 */
public class DesignTree implements Iterable<Device> {

    Leaf rootLeaf =  null; //This will be the first device that will have to parsed to build the

    Device rootDevice = null;

    HashMap<String, Device> deviceArchetypes;

    public DesignTree(){
        deviceArchetypes = new HashMap<>();

        //TODO: Import all the placed and routed devices found in the librarymanager which would be the final global location for storing the devices

    }

    public void addDevice(Device device) {
        if(null == rootDevice){
            rootDevice = device;
        }
        deviceArchetypes.put(device.getName(), device);
    }

    Device currentDevice;

    public void generateDesignTree(){
        /*
        Start with the root node
        foreach component : rootDevice
            if component type is present in the deviceArchetypes
                create a leaf node with the component name and the devicetype
            endif
        endfor
         */
        rootLeaf = new Leaf("BIG_FAT_ROOT_DEVICE", rootDevice);
        currentDevice = rootDevice;

        recursivelyCreateDesignTree(rootLeaf);

    }

    private void recursivelyCreateDesignTree(Leaf leaf) {
        currentDevice = leaf.getArchiteypedevice();
        for(Component importedcomponent : currentDevice.getImports()){
            //check if importedcomponent exists in the device archetypes
            if(archetypeExists(importedcomponent.getTechnology())) {
                //if it exists then create a new leaf with the instance name and the archetypical device
                currentDevice = getArchetype(importedcomponent.getTechnology());
                Leaf newleaf = new Leaf(currentDevice.getName(),currentDevice);
                leaf.addChild(newleaf);
            }else{
                //TODO: Establish how much we use the library manager for doing stuff. Ideally the library manager would be unified interface that even looks at twig based systems.
                throw new UnsupportedOperationException("Implement Error where the device is not found in the archetypes!");
            }

            //recursively create leafs
            for(Leaf childleaf : leaf.getChildren()){
                recursivelyCreateDesignTree(childleaf);
            }
        }

    }

    private Device getArchetype(String archetypename) {
        return deviceArchetypes.get(archetypename);
    }

    private boolean archetypeExists(String archetypename) {
        return deviceArchetypes.containsKey(archetypename);
    }

    @Override
    public Iterator<Device> iterator() {
        return new DesignTreeIterator(this);
    }

    public Leaf getRootLeaf() {
        return rootLeaf;
    }

    public class Leaf{
        private String instancename;
        private Device architeypedevice;
        private ArrayList<Leaf> children;

        public Leaf(){
            children = new ArrayList<>();
        }

        public Leaf(String instancename, Device archetypedevice){
            this.children = new ArrayList<>();

            this.instancename = instancename;
            this.architeypedevice = archetypedevice;
        }

        public void addChild(Leaf newleaf) {
            this.children.add(newleaf);
        }

        public List<Leaf> getChildren() {
            return children;
        }

        public String getInstancename() {
            return instancename;
        }

        public Device getArchiteypedevice() {
            return architeypedevice;
        }

    }


    public class DesignTreeIterator implements Iterator<Device> {

        ListIterator<Leaf> coreiterator;

        ArrayList devicelist;

        public DesignTreeIterator(DesignTree designTree) {
            devicelist = new ArrayList();

            Leaf rootleaf = designTree.getRootLeaf();

            recursiveBreadthFirstTraversal(rootleaf);

            coreiterator = devicelist.listIterator();

        }

        private void recursiveBreadthFirstTraversal(Leaf leaf) {

            if(0 != leaf.getChildren().size()){
                for(Leaf child : leaf.getChildren()){
                    recursiveBreadthFirstTraversal(child);
                }
            }

            devicelist.add(leaf);
        }

        @Override
        public boolean hasNext() {
            return coreiterator.hasNext();
        }

        @Override
        public Device next() {
            return coreiterator.next().getArchiteypedevice();
        }
    }
}
