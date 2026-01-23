import java.time.LocalDate;

class Pessoa {
    private String nome;
    private LocalDate dataNascimento;
    private float altura;

    public Pessoa(String nome, LocalDate dataNascimento, float altura) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.altura = altura;
    }

    // Getters
    public void getNome() {
        System.out.println("Nome: " + nome);
    }
    public void getDataNascimento() {
        System.out.println("Data de Nasc.: " + dataNascimento);
    }
    public void getAltura() {
        System.out.println("Altura: " + altura);
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public void setAltura(float altura) {
        this.altura = altura;
    }

    // Métodos
    public void imprimirDadosPessoa() {
        System.out.print("Nome: " + this.nome);
        System.out.print("\nData de nascimento: " + this.dataNascimento);
        System.out.println("\nAltura: " + this.altura);
    }
    public void getIdade() {
        if (this.dataNascimento.getYear() >= LocalDate.now().getYear()) {
            System.out.println("Data de nascimento inválida");
        } else {
            int idade = LocalDate.now().getYear() - this.dataNascimento.getYear();
            System.out.println("Idade: " + idade);
        }
    }

}

class Jogador {
    private String nome;
    private String posicao;
    private LocalDate dataNascimento;
    private String nacionalidade;
    private float altura;
    private float peso;
    
    public Jogador(String nome, String posicao, LocalDate dataNascimento, String nacionalidade, float altura, float peso) {
        this.nome = nome;
        this.posicao = posicao;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
        this.altura = altura;
        this.peso = peso;
    }

    // Getters
    public void getNome() {
        System.out.println("Nome: " + this.nome);
    }
    public void getPosicao() {
        System.out.println("Posicao: " + this.posicao);
    }
    public void getDataNascimento() {
        System.out.println("Data de nascimento: " + this.dataNascimento);
    }
    public void getNacionalidade() {
        System.out.println("Nacionalidade: " + this.nacionalidade);
    }
    public void getAltura() {
        System.out.println("Altura: " + this.altura);
    }
    public void getPeso() {
        System.out.println("Peso: " + this.peso);
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
    public void setAltura(float altura) {
        this.altura = altura;
    }
    public void setPeso(float peso) {
        this.peso = peso;
    }

    // Métodos
    public void imprimirDadosJogador() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Data de nascimento: " + this.dataNascimento);
        System.out.println("Idade: " + calcularIdade());
        System.out.println("Posição: " + this.posicao);
        System.out.println("Nacionalidade: " + this.nacionalidade);
        System.out.println("Altura: " + this.altura);
        System.out.println("Peso: " + this.peso);
    }
    public int calcularIdade() {
        int idade = 0;
        if (this.dataNascimento.getYear() >= LocalDate.now().getYear()) {
            System.out.println("Data de nascimento inválida.");
        } else {
            idade = LocalDate.now().getYear() - this.dataNascimento.getYear();
        }
        return idade;
    }
    
    public void tempoParaAposentadoria() {
        if (this.posicao.equals("goleiro") ||  this.posicao.equals("defensor")) {
            System.out.println(this.nome + " deve se aposentar em aproximadamente " + (40 - calcularIdade()) + " anos");
        } else if (this.posicao.equals("meio-campo")) {
            System.out.println(this.nome + " deve se aposentar em aproximadamente " + (38 - calcularIdade()) + " anos");
        } else {
            System.out.println(this.nome + " deve se aposentar em aproximadamente " + (35 - calcularIdade()) + " anos");
        }
    }
    
}

class Elevador {
    int andarAtual;
    int totalAndares;
    int qtdPessoas;
    int capacidade;

    public Elevador(int totalAndares, int capacidade) {
        this.andarAtual = 0;
        this.totalAndares = totalAndares;
        this.qtdPessoas = 0;
        this.capacidade = capacidade;
    }

    // Getters
    public void getAndarAtual() {
        System.out.println("Andar atual: " + this.andarAtual);
    }
    public void getTotalAndares() {
        System.out.println("Total andares: " + this.totalAndares);
    }
    public void getQtdPessoas() {
        System.out.println("Qtd pessoas: " + this.qtdPessoas);
    }
    public void getCapacidade() {
        System.out.println("Capacidade: " + this.capacidade + " pessoas");
    }

    // Setters
    public void setAndarAtual(int andarAtual) {
        this.andarAtual = andarAtual;
    }
    public void setTotalAndares(int totalAndares) {
        this.totalAndares = totalAndares;
    }
    public void setQtdPessoas(int qtdPessoas) {
        this.qtdPessoas = qtdPessoas;
    }
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    // Métodos
    public void infoElevador(){
        System.out.println("==========");
        getAndarAtual();
        getCapacidade();
        getQtdPessoas();
        getTotalAndares();
        System.out.println("==========");
    }

    public void entrar() {
        if (qtdPessoas == capacidade) {
            System.out.println("Elevador lotado! Não é possível mais entrar.");
        } else {
            setQtdPessoas(qtdPessoas + 1);
        }
    }

    public void sair() {
        if (qtdPessoas == 0) {
            System.out.println("O elevador já está vazio.");
        } else {
            setQtdPessoas(qtdPessoas - 1);
        }
    }

    public void moverElevador(int andar) {
        if (andar > totalAndares) {
            System.out.println("Andar inválido!");
        } else if (andar == totalAndares && andarAtual == totalAndares) {
            System.out.println("Elevador já está no último andar.");
        } else if (andar == 0 && andarAtual == 0) {
            System.out.println("Elevador já está no térreo.");
        } else {
            if (andar >= 0 || andar <= totalAndares) {
                setAndarAtual(andar);
                System.out.println("Movendo elevador...");
                if (andarAtual == 0) {
                    System.out.println("Você chegou ao térreo.");
                } else if (andarAtual == totalAndares) {
                    System.out.println("Você chegou ao último andar.");
                } else {
                    System.out.println("Você chegou ao " + andarAtual + "º andar.");
                }
            }
        }
    }

}

void main() {
    /*
    Testes classe Pessoa:
    LocalDate dataNascimento = LocalDate.of(1994,9,12);
    Pessoa pessoa = new Pessoa("Joseph",  dataNascimento, 1.75f);
    pessoa.imprimirDadosPessoa();
    pessoa.getNome();
    pessoa.getDataNascimento();
    pessoa.getAltura();
    pessoa.getIdade();
    */

    /*
    Testes classe Jogador:
    Jogador jogador = new Jogador("Joseph", "atacante", LocalDate.of(1994,9,12), "brasileiro", 1.75f, 86);
    jogador.imprimirDadosJogador();
    jogador.tempoParaAposentadoria();
     */

    // Testes classe Elevador:
    Elevador elevador = new Elevador(10, 7);
    elevador.infoElevador();
    elevador.entrar();
    elevador.infoElevador();
    elevador.moverElevador(10);
    elevador.sair();
    elevador.infoElevador();
}