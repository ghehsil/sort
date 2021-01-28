package tree;

import com.google.common.collect.Sets;
import lombok.Data;

import java.util.Random;
import java.util.Set;

public class deleteTreeNode {

    static Node root = null;

    public static void main(String[] args) {
        //测试用例
        int[] integers = new int[]{8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15};
        //int[] integers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //int[] integers = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        //int[] deleteIntegers = new int[]{1, 3, 5, 7, 9, 11, 13, 15};

        //set去重
        Set<Integer> set = Sets.newHashSet();

        //构建树
        for (int integer : integers) {
            addrootNode(integer);
        }

        //打印
        System.out.print("树的中序遍历：");
        printroot(root);
        System.out.println();

        Random random = new Random();
        //删除节点数
        int ran = random.nextInt(integers.length) + 1;
        System.out.println("删除节点数：" + ran);

        for (int i = 0; i < ran; i++) {
            //删除哪个节点
            int ran1 = random.nextInt(integers.length) + 1;
            //去重
            if (set.contains(ran1)) {
                i--;
                continue;
            }
            set.add(ran1);
            //打印
            System.out.println("删除节点：" + ran1);
            //删除
            deleterootNode(ran1);
        }

        /*for (int i = 0; i < deleteIntegers.length; i++) {
            //删除
            deleterootNode(deleteIntegers[i]);
        }*/

        //打印
        System.out.print("树的中序遍历：");
        printroot(root);
        System.out.println();

        //打印树的高度
        System.out.println("树高：" + calculateHigh(root));
    }

    static void addrootNode(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        Node node = root;
        while (node != null) {
            if (node.getData() > data) {
                if (node.getLeft() == null) {
                    node.setLeft(new Node(data));
                    return;
                }
                node = node.getLeft();
            } else {
                if (node.getRight() == null) {
                    node.setRight(new Node(data));
                    return;
                }
                node = node.getRight();
            }
        }
    }

    static void deleterootNode(int data) {
        //要删除的节点的父节点
        Node parentNode = null;
        //要删除的节点 先赋值成root 用于比较
        Node node = root;
        boolean flag = false;
        boolean minFlag = false;
        //是不是根节点
        boolean isRoot = false;

        //找到要删除的节点和他的父节点
        while (node != null && node.getData() != data) {
            parentNode = node;
            if (node.getData() > data) {
                node = node.getLeft();
                flag = true;
            } else {
                node = node.getRight();
                flag = false;
            }
        }

        //没有找到data
        if (node == null) {
            return;
        }

        //是根节点(root.getData() == data)
        if (parentNode == null) {
            isRoot = true;
        }

        //要删除的节点有左子节点和右子节点
        if (node.getLeft() != null && node.getRight() != null) {
            //node的右子树的最小节点的父节点
            Node parentMinNode = node;
            //node的右子树的最小节点
            Node minNode = node.getRight();
            //找到右子树的最小节点
            while (minNode.getLeft() != null) {
                parentMinNode = minNode;
                minNode = minNode.getLeft();
                minFlag = true;
            }

            //删除要删除的节点
            if (isRoot) {
                root = minNode;
            } else {
                if (flag) {
                    parentNode.setLeft(minNode);
                } else {
                    parentNode.setRight(minNode);
                }
            }

            //更新替补节点
            if (minFlag) {
                if (minNode.getRight() == null) {
                    parentMinNode.setLeft(null);
                } else {
                    parentMinNode.setLeft(minNode.getRight());
                }
            } else {
                parentMinNode.setRight(null);
            }

            //更新删除节点
            minNode.setLeft(node.getLeft());
            minNode.setRight(node.getRight());

            //更新游离节点(可不写)
            node.setLeft(null);
            node.setRight(null);
        } else if (node.getLeft() != null) {
            if (isRoot) {
                root = node.getLeft();
            } else {
                if (flag) {
                    parentNode.setLeft(node.getLeft());
                } else {
                    parentNode.setRight(node.getLeft());
                }
            }
        } else if (node.getRight() != null) {
            if (isRoot) {
                root = node.getRight();
            } else {
                if (flag) {
                    parentNode.setLeft(node.getRight());
                } else {
                    parentNode.setRight(node.getRight());
                }
            }
        } else {
            //删除
            if (isRoot) {
                root = null;
            } else {
                if (flag) {
                    parentNode.setLeft(null);
                } else {
                    parentNode.setRight(null);
                }
            }
        }
    }

    static void printroot(Node node) {
        if (node == null) {
            return;
        }
        printroot(node.getLeft());
        System.out.print(node.getData() + "  ");
        printroot(node.getRight());
    }

    static int calculateHigh(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.getLeft() == null && node.getRight() == null) {
            return 1;
        } else if (node.getLeft() == null) {
            return calculateHigh(node.getRight()) + 1;
        } else if (node.getRight() == null) {
            return calculateHigh(node.getLeft()) + 1;
        } else {
            return Math.max(calculateHigh(node.getLeft()), calculateHigh(node.getRight())) + 1;
        }
    }

}

@Data
class Node {
    private int data;
    private Node left;
    private Node right;

    public Node(int data) {
        this.data = data;
    }
}
