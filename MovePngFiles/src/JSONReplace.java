public class JSONReplace {
    public static void main(String[] args) {
        String json = "{\"assets\":[{\"id\":\"image_0\",\"w\":7,\"h\":263,\"u\":\"images/\",\"p\":\"img_0.png\"},{\"id\":\"image_1\",\"w\":768,\"h\":535,\"u\":\"images/\",\"p\":\"img_1.png\"},{\"id\":\"comp_0\",\"layers\":[{\"ddd\":0,\"ind\":0,\"ty\":2,\"nm\":\"图层 2/水滴1.psd\",\"c";
        // "img_\d+.png"
        String afterStr = json.replaceAll("\"img_(\\d+).png\"", "\"xxx_img_$1.png\"");
        System.out.println(afterStr);
    }
}
