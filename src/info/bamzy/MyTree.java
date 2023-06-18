package info.bamzy;
class MyTree<T> {
    MyTree(T x) {
        value = x;
        parentSum = 0;

    }
    T value;
    public int parentSum;
    MyTree<T> left;
    MyTree<T> right;
}