package sample;

        import java.io.File;
        import java.io.IOException;
        import java.nio.file.Files;
        import java.nio.file.Paths;
        import java.nio.file.StandardCopyOption;
        import java.util.Objects;

public class FileHandlerCustom {
    static private final String regex = "\\\\";

    public  static  String desktopPath = javax.swing.filechooser.FileSystemView.getFileSystemView().getHomeDirectory().getPath().replaceAll(regex,"/");


    public static void rearrange(String path) throws IOException {

        try{
            Files.createDirectories(Paths.get(path+"/DesktopManager/"));

            File[] files = new File(path).listFiles();

            if (files!=null) {
                showFiles(files,path);
            }
            if (files!=null) {
                showEmptyFolders(files);
            }
            if (files!=null) {
                showEmptyFolders(files);
            }
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }

    }

    public static void rearrangedesktop() throws IOException {
        rearrange(desktopPath);
    }

    public static String getFileExtension(String fullName) {
        String fileName = new File(fullName).getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }

    public static void showFiles(File[] files, String path) {
        if (files!=null)
            for (File file : files) {

                if (!file.isDirectory()) {
                    if (!getFileExtension(file.getName()).equals("lnk")){
                        moveFile(file, path);
                    }
                }
            }

    }

    public static void showEmptyFolders(File[] files) {
        if (files!=null)
            for (File file : files) {

                if (file.isDirectory()) {


                    File[] filesIn = file.listFiles();
                    if (filesIn != null && filesIn.length <= 0){
                        boolean b = file.delete();
                    }
                    showEmptyFolders(file.listFiles()); // Calls same method again.

                }

            }

    }

    public static void moveFile(File file, String path){

        try {
            Files.createDirectories(Paths.get(path+"/DesktopManager/"+"/"+getFileExtension(file.getPath())+"/"));

            Files.move(Paths.get(file.getPath()), Paths.get(path+"/DesktopManager/"+"/"+getFileExtension(file.getPath())+"/"+file.getName()), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File Moved to"+file.getPath());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
