public class BinaryNode {
    private int data;
    private BinaryNode left;
    private BinaryNode right;

    public BinaryNode(int data, BinaryNode left, BinaryNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public BinaryNode(int data) {
        this(data, null, null);
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return this.data;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getLeft() {
        return this.left;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }

    public BinaryNode getRight() {
        return this.right;
    }
}