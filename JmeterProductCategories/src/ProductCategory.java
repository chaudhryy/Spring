import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ProductCategory {
    private static JAXBContext context = getJAXBContext();

    private static JAXBContext getJAXBContext() {

        try {
            JAXBContext context = JAXBContext.newInstance(ProductCategoryResponse.class);
            return  context;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public static void main(String[] args) {
        ProductCategory category = new ProductCategory();
        category.createCSV("C:\\Users\\t827090\\Documents\\t827090\\Jmeter\\PRODUCT_CATEGORIES-15-011-2021 141158.zip");
    }
    public String createCSV(String zipFile){
        System.out.println("ZIP FILE YASH - " + zipFile);
            File xmlFile = unzip(zipFile);

        try {
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ProductCategoryResponse response = (ProductCategoryResponse) unmarshaller.unmarshal(xmlFile);
            List<String[]> dataLines = new LinkedList<>();
            dataLines.add(new String[]
                    { "NAME","ACTIVE","CODE","CREATEDDATEANDTIME","ENTERPRISE","LEVEL","MODIFIEDDATEANDTIME","PARENTPRODUCTCATEGORYCODE","RECORDID"});
            for(ProductCategoryResponse.SPKECORESPRODUCTCATEGORYENTITY entity : response.spkecoresproductcategoryentity){
                String isActive = isActive(entity.getACTIVE());
                dataLines.add(new String[]
                        { entity.getNAME(),
                                 isActive,
                                entity.getCODE(),
                                getZeusDateAsString(entity.getCREATEDDATEANDTIME()),
                                entity.getENTERPRISE(),
                                entity.getLEVEL(),
                                getZeusDateAsString(entity.getMODIFIEDDATEANDTIME()),
                                entity.getPARENTPRODUCTCATEGORYCODE(),
                                entity.getRECORDID()
                        });

            }
           String csvFileName = xmlFile.getAbsolutePath().replace(".xml",".csv");
            File csvOutputFile = new File(csvFileName);
            try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
                dataLines.stream()
                        .map(this::convertToCSV)
                        .forEach(pw::println);
            }
            return csvFileName;
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String isActive(String active) {
        return (active!= null &&
                active.equalsIgnoreCase("YES")) ?Long.valueOf(1)+"":Long.valueOf(1)+"";
    }

    private File unzip(String fileZip) {
        String newDir = fileZip.replace(".zip","");
        File xmlFile = null;
        File destDir = new File(newDir);
        byte[] buffer = new byte[1024];
        ZipInputStream zis = null;
        try {
            zis = new ZipInputStream(new FileInputStream(fileZip));
            ZipEntry zipEntry = zis.getNextEntry();
            while (zipEntry != null) {
                File newFile = newFile(destDir, zipEntry);
                if (zipEntry.isDirectory()) {
                    if (!newFile.isDirectory() && !newFile.mkdirs()) {
                        throw new IOException("Failed to create directory " + newFile);
                    }
                } else {
                    // fix for Windows-created archives
                    File parent = newFile.getParentFile();
                    if (!parent.isDirectory() && !parent.mkdirs()) {
                        throw new IOException("Failed to create directory " + parent);
                    }

                    // write file content
                    FileOutputStream fos = new FileOutputStream(newFile);
                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
                    fos.close();
                }
               if(zipEntry.getName() != null && zipEntry.getName().endsWith(".xml")){
                   xmlFile = newFile;
               }
                zipEntry = zis.getNextEntry();

            }
            zis.closeEntry();
            zis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return  xmlFile;
    }
    public static File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {
        File destFile = new File(destinationDir, zipEntry.getName());

        String destDirPath = destinationDir.getCanonicalPath();
        String destFilePath = destFile.getCanonicalPath();

        if (!destFilePath.startsWith(destDirPath + File.separator)) {
            throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
        }

        return destFile;
    }
    public String convertToCSV(String[] data) {
        return Stream.of(data)
                .collect(Collectors.joining(","));
    }

    private String getZeusDateAsString(XMLGregorianCalendar createddateandtime) {
        if (createddateandtime != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
            return dateFormat.format(createddateandtime.toGregorianCalendar().getTime());
        }
        return "";
    }
}


