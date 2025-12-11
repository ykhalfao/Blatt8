package h2;

public class H2_main {
    public static void main(String[] args) {


        System.out.println("--- SimpleList Funktionstests ---");
        SimpleList list = new SimpleList();

        // 1. Test: Leere Liste
        System.out.println("\n--- 1. Initialer Test ---");
        printList(list);
        System.out.println("GetFirst (erwartet null): " + (list.getFirst() == null ? "OK" : "FEHLER"));
        System.out.println("GetLast (erwartet null): " + (list.getLast() == null ? "OK" : "FEHLER"));

        // 2. Test: Append
        System.out.println("\n--- 2. Append Test ---");
        list.append(10);
        list.append(20);
        list.append(30);
        printList(list); // Erwartet: 10 -> 20 -> 30

        // 3. Test: GetFirst / GetLast
        System.out.println("\n--- 3. GetFirst/GetLast Test ---");
        System.out.println("GetFirst (erwartet 10): " + (list.getFirst().value == 10 ? "OK" : "FEHLER"));
        System.out.println("GetLast (erwartet 30): " + (list.getLast().value == 30 ? "OK" : "FEHLER"));

        // 4. Test: findFirst
        System.out.println("\n--- 4. findFirst Test ---");
        Node foundNode = list.findFirst(20);
        System.out.println("findFirst(20) (erwartet 20): " + (foundNode != null && foundNode.value == 20 ? "OK" : "FEHLER"));
        System.out.println("findFirst(99) (erwartet null): " + (list.findFirst(99) == null ? "OK" : "FEHLER"));

        // 5. Test: insertAfter
        System.out.println("\n--- 5. insertAfter Test ---");
        list.insertAfter(10, 15); // Fügt 15 nach 10 ein
        list.insertAfter(30, 40); // Fügt 40 nach 30 (am Ende) ein
        boolean notFoundInsert = list.insertAfter(500, 501); // Sollte fehlschlagen
        printList(list); // Erwartet: 10 -> 15 -> 20 -> 30 -> 40
        System.out.println("insertAfter(500) (erwartet false): " + (!notFoundInsert ? "OK" : "FEHLER"));
        System.out.println("GetLast (erwartet 40): " + (list.getLast().value == 40 ? "OK" : "FEHLER"));


        // 6. Test: delete
        System.out.println("\n--- 6. Delete Test ---");

        // Lösche aus der Mitte
        boolean deleteMiddle = list.delete(20);
        printList(list); // Erwartet: 10 -> 15 -> 30 -> 40
        System.out.println("Delete(20) (Mitte, erwartet true): " + (deleteMiddle ? "OK" : "FEHLER"));

        // Lösche den ersten Wert (nach Head)
        boolean deleteFirst = list.delete(10);
        printList(list); // Erwartet: 15 -> 30 -> 40
        System.out.println("Delete(10) (Anfang, erwartet true): " + (deleteFirst ? "OK" : "FEHLER"));

        // Lösche den letzten Wert
        boolean deleteLast = list.delete(40);
        printList(list); // Erwartet: 15 -> 30
        System.out.println("Delete(40) (Ende, erwartet true): " + (deleteLast ? "OK" : "FEHLER"));

        // Wert nicht gefunden
        boolean deleteNotFound = list.delete(999);
        printList(list); // Erwartet: 15 -> 30
        System.out.println("Delete(999) (Nicht gefunden, erwartet false): " + (!deleteNotFound ? "OK" : "FEHLER"));

        // Liste leeren
        list.delete(15);
        list.delete(30);
        System.out.println("\nListe nach Leerung:");
        printList(list); // Erwartet: [] (Leer)

        boolean deleteEmpty = list.delete(5);
        System.out.println("Delete(5) auf leerer Liste (erwartet false): " + (!deleteEmpty ? "OK" : "FEHLER"));
    }
    public static void printList(SimpleList list) {
        Node current = list.head.next;
        System.out.print("Liste: ");
        if (current == null) {
            System.out.println("[] (Leer)");
            return;
        }

        while (current != null) {
            System.out.print(current.value);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println(" (Ende)");
    }
}

