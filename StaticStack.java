public class StaticStack<E> {
    // Índice do topo da pilha, inicializado como -1 para indicar que a pilha está vazia
    private int top = -1;
    
    // Array para armazenar os elementos da pilha, onde E é um tipo genérico
    private final E[] data;

    // Construtor que inicializa a pilha com um tamanho específico
    @SuppressWarnings("unchecked")
    public StaticStack(int size) {
        // Cria um array de objetos genéricos com o tamanho especificado
        // A conversão de (E[]) new Object[size] é necessária devido às limitações de criação de arrays genéricos em Java
        data = (E[]) new Object[size];
    }

    // Adiciona um elemento ao topo da pilha
    public void push(E item) {
        // Verifica se a pilha está cheia
        if (isFull()) {
            // Se estiver cheia, exibe uma mensagem de erro indicando que o item não pode ser adicionado
            System.err.println("A pilha está cheia. Não é possível adicionar: " + item);
        } else {
            // Caso contrário, adiciona o item ao topo da pilha e incrementa o índice do topo
            data[++top] = item;
        }
    }

    // Remove e retorna o elemento do topo da pilha
    public E pop() {
        // Verifica se a pilha está vazia
        if (isEmpty()) {
            // Se estiver vazia, exibe uma mensagem de erro e retorna null para indicar que não há elementos para remover
            System.err.println("A pilha está vazia. Não é possível remover elementos.");
            return null;
        } else {
            // Caso contrário, retorna o elemento do topo da pilha e decrementa o índice do topo
            return data[top--];
        }
    }

    // Limpa a pilha, removendo todos os elementos
    public void clear() {
        // Reseta o índice do topo para -1, indicando que a pilha está vazia
        top = -1;
    }

    // Verifica se a pilha está cheia
    public boolean isFull() {
        // A pilha está cheia se o índice do topo for igual ao último índice do array
        return top == data.length - 1;
    }

    // Verifica se a pilha está vazia
    public boolean isEmpty() {
        // A pilha está vazia se o índice do topo for -1
        return top == -1;
    }

    // Método principal para testar a funcionalidade da pilha
    public static void main(String[] args) {
        // Cria uma pilha de objetos do tipo Filme com capacidade para 3 elementos
        StaticStack<Filme> pilhaFilmes = new StaticStack<>(3);

        // Cria alguns objetos Filme
        Filme filme1 = new Filme("Deadpool e Wolverine", "Shawn Levy", 2024);
        Filme filme2 = new Filme("Divertida Mente 2", "Kelsey Mann", 2024);
        Filme filme3 = new Filme("Meu Malvado Favorito 4", "Chris Renaud", 2024);
        Filme filme4 = new Filme("Wicked", "Jon M. Chu", 2024);

        // Adiciona os filmes à pilha
        pilhaFilmes.push(filme1);
        pilhaFilmes.push(filme2);
        pilhaFilmes.push(filme3);

        // Tenta adicionar um quarto filme à pilha, que está cheia
        pilhaFilmes.push(filme4); // Deve exibir uma mensagem de erro porque a pilha já está cheia

        // Remove e exibe os filmes do topo da pilha
        System.out.println("Elemento no Topo: " + pilhaFilmes.pop()); // Espera-se que seja filme3
        System.out.println("Desempilhando: " + pilhaFilmes.pop()); // Espera-se que seja filme2
        System.out.println("Desempilhando: " + pilhaFilmes.pop()); // Espera-se que seja filme1

        // Verifica se a pilha está vazia
        System.out.println("A pilha está vazia? " + pilhaFilmes.isEmpty()); // Espera-se que seja true
    }
}
