public class StaticStack<E> {
    // Índice do topo da pilha, inicializado como -1 indicando que a pilha está vazia
    private int top = -1;
    
    // Array para armazenar os elementos da pilha. Utiliza um array genérico.
    private final E[] data;

    // Construtor da classe que inicializa a pilha com um tamanho específico.
    @SuppressWarnings("unchecked")
    public StaticStack(int size) {
        // Cria o array de objetos genéricos com o tamanho especificado.
        // A supressão de aviso é necessária porque Java não suporta a criação direta de arrays genéricos.
        data = (E[]) new Object[size];
    }

    // Adiciona um elemento ao topo da pilha.
    public void push(E item) {
        // Verifica se a pilha está cheia.
        if (isFull()) {
            // Se estiver cheia, exibe uma mensagem de erro.
            System.err.println("A pilha está cheia. Não é possível adicionar: " + item);
        } else {
            // Caso contrário, adiciona o item ao topo da pilha e incrementa o índice do topo.
            data[++top] = item;
        }
    }

    // Remove e retorna o elemento do topo da pilha.
    public E pop() {
        // Verifica se a pilha está vazia.
        if (isEmpty()) {
            // Se estiver vazia, exibe uma mensagem de erro e retorna null para indicar erro.
            System.err.println("A pilha está vazia. Não é possível remover elementos.");
            return null;
        } else {
            // Caso contrário, retorna o elemento do topo da pilha e decrementa o índice do topo.
            return data[top--];
        }
    }

    // Limpa a pilha, removendo todos os elementos.
    public void clear() {
        // Reseta o índice do topo para -1, indicando que a pilha está vazia.
        top = -1;
    }

    // Verifica se a pilha está cheia.
    public boolean isFull() {
        // A pilha está cheia se o índice do topo for igual ao último índice do array.
        return top == data.length - 1;
    }

    // Verifica se a pilha está vazia.
    public boolean isEmpty() {
        // A pilha está vazia se o índice do topo for -1.
        return top == -1;
    }
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
