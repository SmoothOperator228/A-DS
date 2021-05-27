import com.sun.org.apache.regexp.internal.RE;

import java.util.NoSuchElementException;

public class RBTree {
    Node root;
    Node NIL;
    class Node{
        private int val;
        Node parent;
        Node left;
        Node right;
        Color color;
    }

    public RBTree(){
        NIL = new Node();
        NIL.color = Color.BLACK;
        NIL.right = null;
        NIL.left = null;
        root = NIL;
    }

    public void insert(int val) {
        Node node = new Node();
        node.parent = null;
        node.val = val;
        node.left = NIL;
        node.right = NIL;
        node.color = Color.RED;

        Node y = null;
        Node x = this.root;

        while (x != NIL) {
            y = x;
            if (node.val < x.val) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        node.parent = y;
        if (y == null) {
            root = node;
        } else if (node.val < y.val) {
            y.left = node;
        } else {
            y.right = node;
        }

        if (node.parent == null) {
            node.color = Color.BLACK;
            return;
        }

        if (node.parent.parent == null) {
            return;
        }

        balanceInsert(node);
    }

    private void balanceInsert(Node k) {
        Node u;
        while (k.parent.color == Color.RED) {
            if (k.parent == k.parent.parent.right) {
                u = k.parent.parent.left; // uncle
                if (u.color == Color.RED) {
                    u.color = Color.BLACK;
                    k.parent.color = Color.BLACK;
                    k.parent.parent.color = Color.RED;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.left) {
                        k = k.parent;
                        rightRotate(k);
                    }
                    k.parent.color = Color.BLACK;
                    k.parent.parent.color = Color.RED;
                    leftRotate(k.parent.parent);
                }
            } else {
                u = k.parent.parent.right; // uncle
                if (u.color == Color.RED) {
                    u.color = Color.BLACK;
                    k.parent.color = Color.BLACK;
                    k.parent.parent.color = Color.RED;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) {
                        k = k.parent;
                        leftRotate(k);
                    }
                    k.parent.color = Color.BLACK;
                    k.parent.parent.color = Color.RED;
                    rightRotate(k.parent.parent);
                }
            }
            if (k == root) {
                break;
            }
        }
        root.color = Color.BLACK;
    }

    public void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != NIL) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    public void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != NIL) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    public void deleteNode(int val) {
        deleter(this.root, val);
    }


    private void deleter(Node node, int val) {
        Node z = NIL;
        Node x, y;
        while (node != NIL) {
            if (node.val == val) {
                z = node;
            }

            if (node.val <= val) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        if (z == NIL) {
            throw new NoSuchElementException();
        }
        y = z;
        Color yOriginalColor = y.color;
        if (z.left == NIL) {
            x = z.right;
            Transplant(z, z.right);
        } else if (z.right == NIL) {
            x = z.left;
            Transplant(z, z.left);
        } else {
            y = minimum(z.right);
            yOriginalColor = y.color;
            x = y.right;
            if (y.parent == z) {
                x.parent = y;
            } else {
                Transplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            Transplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }
        if (yOriginalColor == Color.BLACK) {
            balanceDelete(x);
        }
    }

    private void balanceDelete(Node x) {
        Node s;
        while (x != root && x.color == Color.BLACK) {
            if (x == x.parent.left) {
                s = x.parent.right;
                if (s.color == Color.RED) {
                    s.color = Color.BLACK;
                    x.parent.color = Color.RED;
                    leftRotate(x.parent);
                    s = x.parent.right;
                }

                if (s.left.color == Color.BLACK && s.right.color == Color.BLACK) {
                    s.color = Color.RED;
                    x = x.parent;
                } else {
                    if (s.right.color == Color.BLACK) {
                        s.left.color = Color.BLACK;
                        s.color = Color.RED;
                        rightRotate(s);
                        s = x.parent.right;
                    }
                    s.color = x.parent.color;
                    x.parent.color = Color.BLACK;
                    s.right.color = Color.BLACK;
                    leftRotate(x.parent);
                    x = root;
                }
            } else {
                s = x.parent.left;
                if (s.color == Color.RED) {
                    s.color = Color.BLACK;
                    x.parent.color = Color.RED;
                    rightRotate(x.parent);
                    s = x.parent.left;
                }

                if (s.right.color == Color.BLACK && s.right.color == Color.BLACK) {
                    s.color = Color.RED;
                    x = x.parent;
                } else {
                    if (s.left.color == Color.BLACK) {
                        s.right.color = Color.BLACK;
                        s.color = Color.RED;
                        leftRotate(s);
                        s = x.parent.left;
                    }
                    s.color = x.parent.color;
                    x.parent.color = Color.BLACK;
                    s.left.color = Color.BLACK;
                    rightRotate(x.parent);
                    x = root;
                }
            }
        }
        x.color = Color.BLACK;
    }

    private void Transplant(Node u, Node v) {
        if (u.parent == null) {
            root = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        v.parent = u.parent;
    }

    public Node searchTree(int k) {
        return searcher(this.root, k);
    }

    private Node searcher(Node node, int key) {
        if (node == NIL || key == node.val) {
            return node;
        }
        if (key < node.val) {
            return searcher(node.left, key);
        }
        return searcher(node.right, key);
    }

    public void print(){
        inOrder(root);
        System.out.println(" ");
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.printf("%s ", node.val);
        inOrder(node.right);
    }

    public Node minimum(Node node) {
        while (node.left != NIL) {
            node = node.left;
        }
        return node;
    }

    public int getSum()
    {
        return sumCounter(root);
    }

    private int sumCounter(Node node)
    {
        int counter;
        if (node == null) return 0;
        counter = sumCounter(node.left) + node.val + sumCounter(node.right);
        return counter;
    }

    public Node getRoot() {
        return this.root;
    }
}
