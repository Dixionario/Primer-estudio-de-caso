public class Pila {
    private Nodo tope;

    public Pila() {
        this.tope = null;
    }

    public void push(char c) {
        Nodo nuevo = new Nodo(c);
        nuevo.siguiente = tope;
        tope = nuevo;
    }

    public char pop() {
        if (isEmpty()) {
            throw new RuntimeException("La pila está vacía.");
        }
        char dato = tope.dato;
        tope = tope.siguiente;
        return dato;
    }

    public boolean isEmpty() {
        return tope == null;
    }

    // Método estático para verificar balanceo de paréntesis
    public static boolean estanBalanceados(String expresion) {
        Pila pila = new Pila();

        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                pila.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (pila.isEmpty()) {
                    return false;
                }

                char tope = pila.pop();
                if ((c == ')' && tope != '(') ||
                        (c == ']' && tope != '[') ||
                        (c == '}' && tope != '{')) {
                    return false;
                }
            }
        }

        return pila.isEmpty();
    }

    // Método auxiliar para depuración o visualización
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        Nodo actual = tope;
        while (actual != null) {
            sb.append(actual.dato);
            if (actual.siguiente != null) sb.append(", ");
            actual = actual.siguiente;
        }
        sb.append("]");
        return sb.toString();
    }
}