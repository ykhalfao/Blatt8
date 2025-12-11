package h2;
public class SimpleList {
    Node head;
    Node previous;

        public SimpleList (){
            this.head = new Node(Integer.MIN_VALUE);
        }

        public Node getFirst(){
            if(head.next == null){
                return null;
            } else {
                 return head.next;
            }
        }

        public Node getLast() {

            if(head.next == null){
                return null;        //Liste Leer => kein letztes Objekt
            }

            Node current = head.next;
            while (current.next != null){
                current = current.next;
                return current;
            }
                return current;
        }

        public void append(int newValue){
            if(head.next == null){
                head.next = new Node(newValue);
            }
            Node current = head.next;
            while (current.next != null){
                current = current.next;
                current.next = new Node(newValue);
            }
        }

        public Node findFirst(int value) {
        Node current = head.next;
                    while (current != null) {
                        if (current.value == value){
                            return current;
                        } else
                        previous = current;
                        current = current.next;
                        }
            return null;
        }

        public boolean insertAfter(int preValue, int newValue){
            if (findFirst(preValue) == null){
                return false;
            }
            Node preInsert = findFirst(preValue);
            Node nextPreInsert = preInsert.next;
            Node insert = new Node(newValue);
            insert.next = nextPreInsert;
            return true;
        }

        public boolean delete(int value){
            if (findFirst(value) == null){
                return false;
            }
            findFirst(value);
            Node preDelete = findFirst(value);
            this.previous.next = preDelete.next;
            return true;
        }

}

