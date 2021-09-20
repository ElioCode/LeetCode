import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode297 {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            return preSerialize(root, "");
        }

        private String preSerialize(TreeNode root, String s) {
            if (root == null) {
                s += "None,";
                return s;
            } else {
                s += String.valueOf(root.val) + ",";
                s = preSerialize(root.left, s);
                s = preSerialize(root.right, s);
            }
            return s;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] arr = data.split(",");
            List<String> list = new ArrayList<>(Arrays.asList(arr));
            return preDeserialize(list);
        }

        private TreeNode preDeserialize(List<String> list) {
            if (list.get(0).equals("None")) {
                list.remove(0);
                return null;
            }else{
                TreeNode node = new TreeNode(Integer.valueOf(list.get(0)));
                list.remove(0);
                node.left = preDeserialize(list);
                node.right = preDeserialize(list);
                return node;
            }
        }


    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
