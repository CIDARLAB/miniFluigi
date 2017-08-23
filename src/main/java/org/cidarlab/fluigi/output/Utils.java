package org.cidarlab.fluigi.output;

import java.io.File;

/**
 * Created by krishna on 8/23/17.
 */
public class Utils {
    public static void generateFolder(String folderpath){
        File folder = new File(folderpath);
        if(!(folder.exists() && folder.isDirectory())){
            folder.mkdirs();
        }
    }
}
