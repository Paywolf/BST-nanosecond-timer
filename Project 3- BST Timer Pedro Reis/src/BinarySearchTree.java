public class BinarySearchTree {
    private BinaryNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int data) {
        BinaryNode newNode = new BinaryNode(data);
        if (root == null) {
            root = newNode;
        } else {
            BinaryNode node = root;
            BinaryNode parent = null;
            while (node != null) {
                parent = node;
                if (data < node.getData()) {
                    node = node.getLeft();
                } else {
                    node = node.getRight();
                }
            }
            if (data < parent.getData()) {
                parent.setLeft(newNode);
            } else {
                parent.setRight(newNode);
            }
        }
    }

    public boolean delete(int data) {
        if (root == null) {
            return false;
        }
        BinaryNode node = root;
        BinaryNode parent = null;
        while (node != null && node.getData() != data) {
            parent = node;
            if (data < node.getData()) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }
        if (isCase1(node)) {
            deleteCase1(parent, node);
        } else if (isCase2(node)) {
            deleteCase2(parent, node);
        } else {
            parent = node;
            BinaryNode tmp = node.getLeft();
            while (tmp.getRight() != null) {
                parent = tmp;
                tmp = tmp.getRight();
            }
            int nodeData = node.getData();
            node.setData(tmp.getData());
            tmp.setData(nodeData);
            if (isCase1(tmp)) {
                deleteCase1(parent, tmp);
            } else {
                deleteCase2(parent, tmp);
            }
        }

        return true;
    }

    public void deleteCase1(BinaryNode parent, BinaryNode node) {
        if (parent == null) {
            root = null;
            return;
        }
        if (parent.getLeft() == node) {
            parent.setLeft(null);
        } else {
            parent.setRight(null);
        }
    }

    private void deleteCase2(BinaryNode parent, BinaryNode node) {
        BinaryNode child = node.getLeft() != null ? node.getLeft() : node.getRight();
        if (parent == null) {
            root = child;
            return;
        }
        if (parent.getLeft() == node) {
            parent.setLeft(child);
        } else {
            parent.setRight(child);
        }
    }

    private boolean isCase1(BinaryNode node) {
        return node.getLeft() == null && node.getRight() == null;
    }

    private boolean isCase2(BinaryNode node) {
        return (node.getLeft() != null && node.getRight() == null) ||
                (node.getLeft() == null && node.getRight() != null);
    }
}