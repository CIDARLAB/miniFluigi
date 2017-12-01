![Fluigi Logo](http://52.34.11.70/wp-content/uploads/2013/08/research-fluigi-1.png

# Fluigi

Fluigi is an end to end microflidic design tool. It's primary function is to be able to generate Microfluidic systems from MINT descriptions.

## Setup

### Initialization File

The initialization file is a `.ini` file that contains all the place and route parameters that need to be used by the 
tool. If the parameter file is missing then the tool defaults to the build in settings.

### Technology Library

The technology files are a requirement for the MINT parser to generate the architecture from MINT files. 
The default location of the technology library folder is `../mint/technology/`. The technology files are `.json` files that 
represent the technologies mentioned in the MINT design.

The actively developed MINT component library can be obtained from:
 ```
 git clone https://github.com/CIDARLAB/mint.git
 cd mint
 git checkout REFRESH
 ``` 

### Feature Library

The feature files are a requirement for Fluigi to generate the artwork files used in the respective manufacturing 
processes. The default location of the feature library folder is `../mint/features/`. The feature files are `.json` files
that contain the macro information used for drawing individual components in the MINT design.

## Usage

### MINT / JSON Input
To run the program, use:
```
java [-Xmx????m] -jar fluigi filename [-i parameterFile] [-o outputformats] [-d|h]
```

The complete list of flags are as follows:

```
-i  --init      Give the initialization (*.ini) file, Defaults to built in parameters
-o  --out       Specify the output directory, Defaults to the output folder
-h  --help      Show help information
-d  --debug     This enables all the debug printing
-c  --check     Overrides the application to just do the DRC
-r  --route     Overrides the application to just route
-p  --place     Overrides the application to just place the device
-x  --convert   This enables the MINT conversion mode
```

The Java flag `[-Xmx????m]` will ensure that `????` Megabytes of RAM is allocated for the Java virtual machine. This might be necessary in scenarios where the designs are large.


