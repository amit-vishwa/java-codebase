package tutorial.java.string;

public class StringBufferClassExample {

    public static void main(String[] args)
    {
        // append() example
        StringBuffer sb = new StringBuffer("Hello ");
        sb.append("Java"); // now original string is changed
        System.out.println(sb);

        // insert() example
        StringBuffer sb1 = new StringBuffer("Hello ");
        sb1.insert(5, "Java"); // now original string is changed
        System.out.println(sb1);

        // replace() example
        StringBuffer sb2 = new StringBuffer("Hello");
        sb2.replace(1, 3, "Java"); // now original string is changed
        System.out.println(sb2);

        // delete() example
        StringBuffer sb3 = new StringBuffer("Hello");
        sb3.delete(1, 3); // now original string is changed
        System.out.println(sb3);
        sb3.deleteCharAt(1);
        System.out.println(sb3);

        // reverse() example
        StringBuffer sb4 = new StringBuffer("Hello");
        System.out.println(sb4.reverse());

        // capacity() example
        StringBuffer sb5 = new StringBuffer();
        System.out.println(sb5.capacity()); // default 16
        sb5.append("Hello");
        System.out.println(sb5.capacity()); // now 16
        sb5.append("java is my favourite language");
        System.out.println(sb5.capacity()); // Now (16*2)+2=34     i.e (oldcapacity*2)+2

        // length() example
        System.out.println(sb5.length());

    }

}
