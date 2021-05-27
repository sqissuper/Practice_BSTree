package test;

/**
 * ClassName:TextDemo6
 * Package:test
 * Description:
 *
 * @Author:HP
 * @date:2021/5/26 15:16
 */
public class TextDemo6 {
    static class BSTree {
        public int val;
        public BSTree left;
        public BSTree right;

        public BSTree(int val) {
            this.val = val;
        }
        public BSTree() {
        }

        public BSTree root;

        public BSTree search(int key) {
            if(root == null) return null;
            BSTree cur = root;
            while(cur != null) {
                if(cur.val > key) {
                    cur = cur.left;
                } else if(cur.val < key) {
                    cur = cur.right;
                } else {
                    break;
                }
            }
            return cur;
        }

        public boolean insert(int key) {
            BSTree node = new BSTree(key);
            if(root == null) {
                root = node;
                return true;
            }
            BSTree cur = root;
            BSTree p = null;
            while(cur != null) {
                if(key < cur.val) {
                    p = cur;
                    cur = cur.left;
                } else if(key > cur.val) {
                    p = cur;
                    cur = cur.right;
                } else {
                    return false;
                }
            }
            if(key < p.val) {
                p.left = node;
            } else if(key > p.val) {
                p.right = node;
            }
            return true;
        }

        public void remove (int key) {
            if(root == null) return;
            BSTree cur = root;
            BSTree p = null;
            while(cur != null) {
                if(cur.val < key) {
                    p = cur;
                    cur = cur.right;
                } else if (key < cur.val) {
                    p = cur;
                    cur = cur.left;
                } else {
                    removeNode(p,cur);
                    return;
                }
            }
        }

        private void removeNode(BSTree p,BSTree cur) {
            if(cur.left == null) {
                if(cur == p) {
                    p = p.right;
                } else if (cur == p.left){
                    p.left = cur.right;
                }else if(cur == p.right) {
                    p.right = cur.right;
                }

            } else if (cur.right == null) {
                if(cur == p) {
                    p = p.left;
                } else if (cur == p.left){
                    p.left = cur.left;
                }else if(cur == p.right) {
                    p.right = cur.left;
                }
            } else {
                BSTree tp = cur;
                BSTree target = cur.right;
                while(target.left != null) {
                    tp = target;
                    target = target.left;
                }
                cur.val = target.val;

                if(target == tp.left) {
                    tp.left = target.right;
                } else {
                    tp.right = target.right;
                }
            }
        }
    }



    public static void show (TextDemo6.BSTree root) {
        if(root == null) return;
        System.out.println(root.val);
        show(root.left);
        show(root.right);
    }

    public static void main(String[] args) {
        BSTree bs = new BSTree();
        bs.insert(2);
        bs.insert(6);
        bs.insert(4);
        bs.insert(9);
        bs.insert(1);
        TextDemo6.show(bs.root);
        bs.remove(9);
        TextDemo6.show(bs.root);


    }
}
