public class HashTable<T,Y> implements Comparable<T> {
    HashNode<T,Y>[] hashNodes;
    int size = 4;
    public HashTable(){
        hashNodes = new HashNode[size];
    }
    public HashTable(int size){
        hashNodes = new HashNode[size];
    }
    public int hash(T key){
        return Math.abs(key.hashCode() % size);
    }
    public void put(T key, Y value){
        int index = hash(key);
        HashNode<T,Y> newNode = new HashNode<>(key,value);
        if(hashNodes[index]==null){
            hashNodes[index] = newNode;
        }else{
            HashNode<T,Y> current = hashNodes[index];
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }
    public Y get(T key){
        int index = hash(key);
        HashNode<T,Y> current = hashNodes[index];
        while(current != null){
            if(current.key == key){
                return current.value;
            }
            current = current.next;
        }
        return null;
    }
    public Y remove(T key){
        Y removed;
        int index = hash(key);
        HashNode<T,Y> current = hashNodes[index];
        if(current.key == key){
            removed = current.value;
            hashNodes[index] = current.next;
        }else{
            while(current.next.key != key){
                current = current.next;
            }
            removed = current.next.value;
            current.next = current.next.next;
        }
        return removed;
    }

    public boolean contains(Y value){
        for(int i = 0; i < size; i++){
            HashNode<T,Y> current = hashNodes[i];
            while(current != null){
                if(current.value == value){
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }


    private class HashNode<T,Y> {
        private T key;
        private Y value;
        HashNode<T,Y> next;
        public HashNode(T key,Y value){
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public int compareTo(T o) {
        return 0;
    }
}
