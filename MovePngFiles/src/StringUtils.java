public class StringUtils {
    public static String removeLastPathComponent(String originPath) {
        String path = originPath;
        if (path == null || path.length() == 0) {
            return null;
        }
        if (!path.contains("/") || path.equals("/")) {
            return path;
        }

        String newPath = null;
        if (path.endsWith("/")) {
            newPath = path.substring(0, path.length()-1);
        } else {
            newPath = path;
        }
        int lastIndex = newPath.lastIndexOf("/");
        newPath = newPath.substring(0, lastIndex) + "/";
        return newPath;
    }

    public static String appendPathComponent(String originPath, String appendComponent) {
        String path = originPath;
        if (path == null
                || path.length() == 0
                || appendComponent == null
                || appendComponent.length() == 0) {
            return null;
        }

        String newPath = path;
        if (!newPath.endsWith("/")) {
            newPath = newPath + "/";
        }
        if (appendComponent.startsWith("/")) {
            appendComponent = appendComponent.substring(1);
        }
        return newPath + appendComponent;
    }

    public static void main(String[] args) {
        String p1 = "/Users/A/B/C/icon_slices";
        String p2 = "Users/A/B/C/icon_slices";
        String p3 = "Users/A/B/C/icon_slices/";
        String p4 = "/Users/A/B/C/icon_slices/";

        System.out.println(removeLastPathComponent(p1));
        System.out.println(removeLastPathComponent(p2));
        System.out.println(removeLastPathComponent(p3));
        System.out.println(removeLastPathComponent(p4));

        System.out.println(appendPathComponent(p1, "/hello"));
        System.out.println(appendPathComponent(p2, "hello"));
        System.out.println(appendPathComponent(p3, "/hello"));
        System.out.println(appendPathComponent(p4, "hello"));
    }
}
