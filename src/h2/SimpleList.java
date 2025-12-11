package h2;
public class SimpleList {
    Node head;

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
            }
                return current;
        }

        public void append(int newValue){
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
                current.next = new Node(newValue);
        }

        public Node findFirst(int value) {
        Node current = head.next;
                    while (current != null) {
                        if (current.value == value){
                            return current;
                        }
                        current = current.next;
                        }
            return null;
        }

        public boolean insertAfter(int preValue, int newValue){
            Node preInsert = findFirst(preValue);
            if (preInsert == null){
                return false;
            }
            Node insert = new Node(newValue);
            insert.next = preInsert.next;
            preInsert.next = insert;
            return true;
        }

        public boolean delete(int value){
            Node current = head;

            while(current.next != null){
                if (current.next.value == value){
                    Node toDelete = current.next;
                    current.next = toDelete.next;
                    toDelete.next = null;

                    return true;
                }
                current = current.next;
            }
            return false;
        }

}

