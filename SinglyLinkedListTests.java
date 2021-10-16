public class SinglyLinkedListTests {
    public static void main(String args[]) {
        try {
            SinglyLinkedList test1 = new SinglyLinkedList(5);
            System.out.println(test1.toString());

            test1.add(6);
            System.out.println(test1.toString());

            test1.add(7);
            System.out.println(test1.toString());

            test1.add(8);
            System.out.println(test1.toString());

            test1.add(1, 5);
            System.out.println(test1.toString());

            test1.add(0, 4);
            System.out.println(test1.toString());

            SinglyLinkedList test2 = new SinglyLinkedList();
            System.out.println(test2.toString());

            test2.add(0, 1);
            System.out.println(test2.toString());

            test2.add(0, 0);
            System.out.println(test2.toString());
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
