package com.mst;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.apache.batik.svggen.SVGGraphics2D;
import org.freehep.graphicsbase.util.export.ExportFileType;
import org.freehep.graphicsio.ImageConstants;
import org.freehep.graphicsio.emf.EMFConverter;
import org.freehep.graphicsio.emf.EMFInputStream;
import org.freehep.graphicsio.emf.EMFPanel;
import org.freehep.graphicsio.emf.EMFRenderer;

public  class EmfToSvg extends EMFConverter {  
    public static void main(String[] args) {  
        String[] file = new String[2];  
        file[0] = "D:\\input.emf";  
          
        if (file == null || file.length == 0 || file[0] == null || file[0].length() == 0) {  
            System.out.println("usage: EMF2SVG imput.emf [output.svg]");  
            return;  
        }  
        export(ImageConstants.SVG, file[0], file.length > 1 ? file[1] : null);  
    }  
      
    protected static void export(String type, String srcFileName, String destFileName) {  
        try {  
            List exportFileTypes = ExportFileType.getExportFileTypes(type);  
            if (exportFileTypes == null || exportFileTypes.size() == 0) {  
                System.out.println(  
                    type + " library is not available. check your classpath!");  
                return;  
            }  
  
            ExportFileType exportFileType = (ExportFileType) exportFileTypes.get(0);  
  
            // read the EMF file  
            EMFRenderer emfRenderer = new EMFRenderer(  
                new EMFInputStream(  
                    new FileInputStream(srcFileName)));  
  
            // create the destFileName,  
            // replace or add the extension to the destFileName  
            if (destFileName == null || destFileName.length() == 0) {  
                // index of the beginning of the extension  
                int lastPointIndex = srcFileName.lastIndexOf(".");  
  
                // to be sure that the point separates an extension  
                // and is not part of a directory name  
                int lastSeparator1Index = srcFileName.lastIndexOf("/");  
                int lastSeparator2Index = srcFileName.lastIndexOf("\\");  
  
                if (lastSeparator1Index > lastPointIndex ||  
                    lastSeparator2Index > lastPointIndex) {  
                    destFileName = srcFileName + ".";  
                } else if (lastPointIndex > -1) {  
                    destFileName = srcFileName.substring(  
                        0, lastPointIndex + 1);  
                }  
  
                // add the extension  
                destFileName += type.toLowerCase();  
            }  
  
            // TODO there is no possibility to use Constants of base class!  
            /* create SVG properties*/  
            Properties p = new Properties();  
            p.put(SVGGraphics2D.EMBED_FONTS, Boolean.toString(false));  
            p.put(SVGGraphics2D.CLIP, Boolean.toString(true));  
            p.put(SVGGraphics2D.COMPRESS, Boolean.toString(false));  
            p.put(SVGGraphics2D.TEXT_AS_SHAPES, Boolean.toString(false));  
            p.put(SVGGraphics2D.FOR, "Freehep EMF2SVG");  
            p.put(SVGGraphics2D.TITLE, srcFileName);  
  
            EMFPanel emfPanel = new EMFPanel();  
            emfPanel.setRenderer(emfRenderer);  
  
            // TODO why uses this classes components?!  
            exportFileType.exportToFile(  
               new File(destFileName),  
               emfPanel,  
               emfPanel,  
               p,  
               "Freehep EMF converter");  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
