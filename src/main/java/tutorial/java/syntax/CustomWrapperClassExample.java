package tutorial.java.syntax;

class Maximum {
    private int maxi = 0;
    private int size = 0;

    public void insert(int x)
    {
        this.size++;
        if (x <= this.maxi)
            return;
        this.maxi = x;
    }

    public int top() { return this.maxi; }

    public int elementNumber() { return this.size; }
};

public class CustomWrapperClassExample {

    public static void main(String[] args)
    {
        Maximum x = new Maximum();
        x.insert(12);
        x.insert(3);
        x.insert(23);

        System.out.println("Maximum element: " + x.top());
        System.out.println("Number of elements inserted: "
                + x.elementNumber());
    }

}
