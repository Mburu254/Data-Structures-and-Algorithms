import javax.xml.soap.Node;

/**
 * Created by paulo on 10/8/15.
 */
public class LinkedList<E> {

    private LinkNode<E> first;
    private int size;

    public LinkedList() {
        this.first = null;
        this.size = 0;
    }

    public void insertAfter(E element) {
        if (first == null) {
            first = new LinkNode<E>(element, first);
        } else {
            LinkNode<E> current = first;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            LinkNode<E> newNode = new LinkNode<E>(element, null);
            current.setNext(newNode);
            size++;
        }
    }

    public void insertBefore(E element) {
        first = new LinkNode<E>(element, first);
        size++;
    }

    public void remove(E element) {
        if (first == null) {
            System.out.println("empty list");

        } else {
            LinkNode<E> current = first;
            LinkNode<E> previous = first;
            while (current.getData() != element) {
                previous = current;
                current = current.getNext();
            }
            if (current == first) {
                first = first.getNext();
            }
            previous.setNext(current.getNext());
        }
        size--;
    }

    public LinkNode<E> get(E element) {
        LinkNode<E> current = first;
        if (first == null) {
            System.out.println("empty list");
            return null;
        } else {
            while (current.getData() != element) {
                if (current.getNext() == null) {
                    System.out.println("not found");
                    return null;
                }
            }
        }
        return current;
    }

    private static class LinkNode<T> {
        T element;
        LinkNode<T> next;

        private LinkNode(T element, LinkNode<T> next) {
            this.element = element;
            this.next = next;
        }

        public T getData() {
            return element;
        }

        public void setData(T data) {
            this.element = data;
        }

        public LinkNode<T> getNext() {
            return next;
        }

        public void setNext(LinkNode<T> node) {
            this.next = node;
        }

        public String toString() {
            return ("Data: " + element);

        }

    }

    public static void main(String[] args) {
        LinkedList<String> demo = new LinkedList<String>();
        demo.insertAfter("1a");
        demo.insertAfter("2b");
        demo.insertAfter("3c");
        demo.remove("1a");

    }

}