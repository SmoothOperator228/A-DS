public class Tree {
    private class Node{
        private int val;
        Node parent;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", parent=" + parent +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    private Node root = new Node(0);
    private int elements = 0;
    private long sum = 0;

    public boolean isEmpty(){
        if(elements == 0){
            return true;
        }
        return false;
    }

    public void add(int val){
        if(isEmpty()){
            root.setVal(val);
        }
        else{
            Node node = new Node(val);
            Node currentNode = root;

            while(true){
                if(val > currentNode.getVal()){
                    if(currentNode.right == null){
                        currentNode.right = node;
                        node.parent = currentNode;
                        break;
                    }
                    else{
                        currentNode = currentNode.right;
                    }
                }
                else if(val < currentNode.getVal()){
                    if(currentNode.left == null){
                        currentNode.left = node;
                        node.parent = currentNode;
                        break;
                    }
                    else {
                        currentNode = currentNode.left;
                    }
                }
            }
        }
        elements++;
    }

    public void remove(int val) throws IndexOutOfBoundsException{
        if(isEmpty()){
            throw new IndexOutOfBoundsException("Дерево порожнє, нема чого видаляти");
        }
        if(elements == 1){
            if(val == root.getVal()){
                root.setVal(0);
            }
            else{
                return;
            }
        }
        else{
            Node currentNode = new Node(0);
            while(true){
                if(val == currentNode.getVal()){
                    if(currentNode.right == null && currentNode.left == null){ //видаляємо листок (немає наслідників)
                        if(currentNode.parent.right.getVal() == currentNode.getVal()){
                            currentNode.parent.right = null;
                        }
                        if(currentNode.parent.left.getVal() == currentNode.getVal()){
                            currentNode.parent.left = null;
                        }
                    }
                    else if(currentNode.left == null || currentNode.right == null){ //видаляємо вузол з 1 наслідником
                        if(currentNode.left == null){
                            if(currentNode.parent.right.getVal() == currentNode.getVal()){
                                currentNode.right.parent = currentNode.parent;
                                currentNode.parent.right = currentNode.right;
                            }
                            if(currentNode.parent.left.getVal() == currentNode.getVal()){
                                currentNode.right.parent = currentNode.parent;
                                currentNode.parent.left = currentNode.right;
                            }
                        }
                        else{
                            if(currentNode.parent.right.getVal() == currentNode.getVal()){
                                currentNode.left.parent = currentNode.parent;
                                currentNode.parent.right = currentNode.left;
                            }
                            if(currentNode.parent.left.getVal() == currentNode.getVal()){
                                currentNode.left.parent = currentNode.parent;
                                currentNode.parent.left = currentNode.left;
                            }
                        }
                    }
                    else{
                        Node successor = new Node(0);
                        successor = next(currentNode.getVal());
                        currentNode.setVal(successor.getVal());
                        if(successor.parent.left.getVal() == successor.getVal()){
                            successor.parent.left = successor.right;
                            if(successor.right != null){
                                successor.right.parent = successor.parent;
                            }
                        }
                        else{
                            successor.parent.right = successor.right;
                            if(successor.right != null){
                                successor.right.parent = successor.parent;
                            }
                        }
                    }
                    return;
                }
                else if(val > currentNode.getVal()){
                    currentNode = currentNode.right;
                }
                else if(val < currentNode.getVal()){
                    currentNode = currentNode.left;
                }
            }
        }
    }

    private Node next(int val){
        Node currentNode = new Node(0);
        while(true){
            if(currentNode.getVal() == val){
                if (currentNode.right != null)
                    return minimum(currentNode.right);
                while (currentNode.parent != null && currentNode ==currentNode.parent.right) {
                    currentNode = currentNode.parent;
                    currentNode.parent = currentNode.parent.parent;
                }
                return currentNode.parent;
            }
            else if(val > currentNode.getVal()){
                currentNode = currentNode.right;
            }
            else if(val < currentNode.getVal()){
                currentNode = currentNode.left;
            }
        }
    }

    private Node minimum(Node x) {
        if (x.left == null)
            return x;
        return minimum(x.left);
    }

    public Node elementFind(int val) {
        Node currentNode = root;
        while (true) {
            if (currentNode.getVal() == val) {
                return currentNode;
            }
            if(val > currentNode.getVal()){
                currentNode = currentNode.right;
            }
            else if(val < currentNode.getVal()){
                currentNode = currentNode.left;
            }
        }
    }

    public long getSum(){
        countSum(root);
        return sum;
    }

    private void countSum(Node node){
        sum += (long)node.getVal();
        if (node.right!=null) {
            countSum(node.right);
        }
        if (node.left!=null) {
            countSum(node.left);
        }
    }


}
