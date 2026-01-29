# Resolução Simulado - 29/01/26

### 1. Programação Orientada a Objetos é uma forma de fazer código transformando elementos do mundo real em objetos, trazendo como benefícios um código mais organizado e de fácil entendimento.

---

### 2. Encapsulamento é fazer com que os atributos de uma classe estejam disponíveis apenas dentro dela própria.

---

### 3. O princípio de encapsulamento está sendo violado, porque os atributos estão publicos.

---

### 4. Porque os atributos da classe ficam protegidos, sendo acessíveis para leitura e escrita apenas pela própria classe.

---

### 5. Usar a palavra reservada `private` na definição dos atributos

---

### 6. Spring Boot é um framework JAVA que traz uma série de ferramentas pré-configuradas com o objetivo e a vantagem de tornar o processo de configuração inicial de um projeto muito mais leve e rápida, além de simplificar vários processos que sem o uso do Spring seriam mais verbosos.

---

### 7. @RestController

---

### 8. Definir a rota raíz da aplicação

---

### 9. O controller está acessando o repository diretamente, quando quem deveria fazer esse acesso é o service.

---

### 10. Todos são métodos HTTP, que são equivalentes as letras do CRUD: Get - POST = Create, GET = Read, PUT = Update e DELETE = Delete.

---

### 11. Jpa é o que define os métodos para persistencia de dados, o papel do hibernate é escrever código SQL por debaixo dos panos.

---

### 12. @Entity

---

### 13. Elas trabalham em conjunto na definição e atribuição automática de um ID para um objeto que está sendo salvo pela aplicação num banco de dados.

---

### 14. Fazer a ponte entre a aplicação e o banco de dados

---

### 15. Porque o JPA escreve SQL "por debaixo dos panos", não necessitando que o desenvolvedor escreva SQL manualmente, mas sim usando as funções fornecidas pelo JPA

---

### 16. DTO é um transportador de dados, ele resolve o problema do controller ter acesso direto à API ou banco de dados, tornando o transporte de dados mais seguro.

---

### 17. Porque o controller está acessando o repository diretamente, quando este acesso deveria ser feito pelo service utilizando DTO

---

### 18. a camada service é onde fica a lógica do acesso ao repository, por isso ela é responsável por responder as requisições feitas através do controller

---

### 19. A regra de negócio deve estar contida no service, porque é nele que está a lógica de acesso ao repository.

---

### 20. Porque o controller é a entrada da aplicação, se tiver responsabilidades que não deveria ter, tornaria a aplicação mais frágil.

---

### 21. É o princípio que diz que cada classe deve ter uma única responsabilidade.

---

### 22. a classe está com mais de uma responsabilidade, logo está violando o principio de responsabilidade única (Single Responsibility Principle - SRP)

---

### 23. É o principio que fala que as classes devem ser abertas para crescer mas fechadas para mudar

---

### 24. É o principio que diz que uma subclasse pode ou deve subistituir uma classe sem que prejudique o sistema.

---

### 25. É o principio que diz que nenhuma classe deve ter métodos que não utiliza.

---

### 26. O principio ISP, pois diz que uma classe não deve ter métodos que não utiliza, e acredito que o ProdutoService não deveria exportar PDF ou enviar email, mas apenas ter responsabilidades relacionadas ao produto, no exemplo, listar e salvar.

---

### 27. 

---

### 28.

---

### 29. A aplicação é iniciada pelo Spring > Controller faz requisições > Service aplica as regras de negócio > Mapper converte a Entity em DTO > Service acessa repository > banco/api devolve a resposta da requisição > Mapper converte resposta DTO para Entity > Service entrega a resposta para o Controller > Controller responde ao usuário da aplicação.

---

### 30. Porque fazem toda uma separação de responsabilidades, tornando o código mais legível, e abertos a mudanças sem grandes impactos no desenvolvimento.

---
