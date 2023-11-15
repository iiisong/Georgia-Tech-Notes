public class StringOperations {
    public static void main(String[] args) {
        String name = "Isaac Song";

        System.out.println("name: " + name);

        String newName = "A" + name.substring(1, name.length() -1) + "Z";

        System.out.println("newName: " + newName);

        String url = "www.gatech.edu";

        System.out.println("url: " + url);

        String newURL = url.substring(4, url.length() - 4) + "1331";

        System.out.println("altered url: " + newURL);
    }
}   
