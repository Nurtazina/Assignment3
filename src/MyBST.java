public class MyBST <T extends Comparable<T>,V>
{

    private class MyNode
    {
        private T key;
        private V value;
        private MyNode left, right;
        public MyNode(T key,V value)
        {
            this.key = key;
            this.value = value;
        }

    }

    private MyNode root;
    public void put(T key, V value)
    {
        if (root == null)
        {
            root = new MyNode(key,value);
        }
        else
        {
            MyNode current = root;
            boolean added =  false;
            while(added == false)
            {
                if (key.compareTo(current.key) < 0 )
                {
                    if ( current.left == null )
                    {
                        current.left = new MyNode(key,value);

                        added = true;
                    }
                    else
                    {
                        current = current.left;

                    }

                }
                else if ( key.compareTo(current.key) > 0 )
                {
                    if ( current.right == null )
                    {
                        current.right = new MyNode(key,value);

                        added = true;
                    }
                    else
                    {
                        current = current.right;

                    }

                }
            }
        }
    }

    public V get(T key)
    {
        boolean found = false;
        MyNode current = root;
        if(current.key == key)
        {
            return current.value;
        }
        else
        {
            while(found == false)
            {
                if(current.key.compareTo(key)>0)
                {
                    current = current.left;
                }
                else if(current.key.compareTo(key)<0)
                {
                    current = current.right;
                }
                else
                {
                    found = true;
                }
            }
        }
        return current.value;
    }

    public void delete(T key)
    {
        if(root.key == key)
        {
            MyNode templeft = root.left;
            root = deleteNode(root.right,key);
            root.left = templeft;
        }
        else
        {
            deleteNode(root, key);
        }

    }

    private MyNode deleteNode(MyNode root, T key)
    {

        if(root == null) return root;

        if(root.key.compareTo(key)>0)
        {
            root.left = deleteNode(root.left,key);

        }
        else if(root.key.compareTo(key)<0)
        {
            root.right = deleteNode(root.right,key);

        }
        else
        {

            if(root.left==null && root.right==null)
            {
                return null;
            }
            else if(root.left == null)
            {

                return root.right;
            }
            else if(root.right == null)
            {
                return root.left;
            }
            else
            {
                T minkey = min(root.right);
                root.key = minkey;
                root.right = deleteNode(root.right,minkey);
            }
        }

        return root;
    }
    public V getMin()
    {
        MyNode current = root;
        while(current.left != null)
        {
            current = current.left;
        }
        return current.value;
    }

    public V getMax()
    {
        MyNode current = root;
        while(current.right!= null)
        {
            current = current.right;
        }
        return current.value;
    }

    private T min(MyNode node)
    {
        if(node.left!=null)
        {
            return min(node.left);
        }
        return node.key;
    }

    public void display()
    {
        inorderDisplay(root);
    }

    private void inorderDisplay(MyNode node)
    {
        if(node == null)
        {
            return;
        }
        inorderDisplay(node.left);
        System.out.print(node.value + " ");
        inorderDisplay(node.right);
    }

}
