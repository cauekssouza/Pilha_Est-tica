public class StaticStack<E> {
    private int top = -1;
    private final E[] data;

    @SuppressWarnings("unchecked")
    public StaticStack(int size) {
        data = (E[]) new Object[size]; // Array de objetos genéricos
    }

    public void push(E item) {
        if (isFull()) {
            System.err.println("A pilha está cheia. Não é possível adicionar: " + item);
        } else {
            data[++top] = item;
        }
    }

    public E pop() {
        if (isEmpty()) {
            System.err.println("A pilha está vazia. Não é possível remover elementos.");
            return null;
        } else {
            return data[top--];
        }
    }

    public void clear() {
        top = -1;
    }

    public boolean isFull() {
        return top == data.length - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        StaticStack<Filme> pilhaFilmes = new StaticStack<>(3);

        // Criando alguns filmes
        Filme filme1 = new Filme("Deadpool e Wolverine", "Shawn Levy", 2024);
        Filme filme2 = new Filme("Divertida Mente 2", "Kelsey Mann", 2024);
        Filme filme3 = new Filme("Meu Malvado Favorito 4", "Chris Renaud", 2024);
        Filme filme4 = new Filme("Wicked", "Jon M. Chu", 2024);

        // Empilhando os filmes
        pilhaFilmes.push(filme1);
        pilhaFilmes.push(filme2);
        pilhaFilmes.push(filme3);

        // Tentando empilhar além do limite (a pilha está cheia)
        pilhaFilmes.push(filme4); // Deve exibir uma mensagem de erro

        // Verificando e desempilhando os filmes
        System.out.println("Elemento no Topo: " + pilhaFilmes.pop()); // Espera-se que seja filme3
        System.out.println("Desempilhando: " + pilhaFilmes.pop()); // Espera-se que seja filme2
        System.out.println("Desempilhando: " + pilhaFilmes.pop()); // Espera-se que seja filme1

        // Verificando se a pilha está vazia
        System.out.println("A pilha está vazia? " + pilhaFilmes.isEmpty()); // Espera-se que seja true
    }
}
