package at.fhv.msc.java;

import java.util.zip.ZipOutputStream;
import java.io.FilenameFilter;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipEntry;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class SimpleZip {
	
	public static void pack(String extension, String archiveName) {
		File directory = new File(".");
		
		File[] files = directory.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(extension);
			}	
		});

		try (ZipOutputStream out = new ZipOutputStream(new FileOutputStream(archiveName + ".zip"));) {
			for (File file : files) {
				try (FileInputStream in = new FileInputStream(file)) {
					out.putNextEntry(new ZipEntry(file.getName()));
					byte[] buffer = new byte[1024];
					int length;
					while ((length = in.read(buffer)) > 0) {
						out.write(buffer, 0, length);
					}
					
					out.closeEntry();
				}
			}
			
			System.out.println("Files packed into .zip file.");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} 
	}
	
	public static void unpack(String archiveName) {
		try (ZipInputStream in = new ZipInputStream(new FileInputStream(archiveName));) {
			File zipFile = new File(archiveName);
            File destDir = new File(zipFile.getParentFile(), zipFile.getName().replaceAll("\\.zip$", ""));
            destDir.mkdir();

            ZipEntry entry;
            byte[] buffer = new byte[1024];
            int length;
            
            while ((entry = in.getNextEntry()) != null) {
                String entryName = entry.getName();
                File entryFile = new File(destDir, entryName);

                try (FileOutputStream out = new FileOutputStream(entryFile)) {
                    while ((length = in.read(buffer)) > 0) {
                        out.write(buffer, 0, length);
                    }
                }

                in.closeEntry();
            }
            
            System.out.println("Files unpacked from .zip file.");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] input) {
		
		String option = input[0];

        if (option.equals("-p")) {
            pack(input[1], input[2]);
        } else if (option.equals("-u")) {
            unpack(input[1]);
        } else {
            System.out.println("Invalid option. Either pack a file with '-p' or unpack with '-u'");
        }
	}
}
